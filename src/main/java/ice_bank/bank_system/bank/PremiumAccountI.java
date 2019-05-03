package ice_bank.bank_system.bank;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import Ice.Current;
import clientOperations._PremiumAccountDisp;
import clientOperations.currency;
import ice_bank.stock_exchange.BankStockExchangeService;
import stock.currencyData;
import stock.stockRequest;

public class PremiumAccountI extends _PremiumAccountDisp{

	String name;
	String surname;
	String PESEL;
	double income;
	int creditMaxBoundary;
	Map<currency, Double> availableCurrencies = new HashMap<currency, Double>();
	StockExchangeThread stockExchangeThreadThread;

	
	
	public PremiumAccountI(String name, String surname, String pESEL, double income,
			int creditMaxBoundary, Map<currency, Double> availableCurrencies) {
		super();
		this.name = name;
		this.surname = surname;
		PESEL = pESEL;
		this.income = income;
		this.creditMaxBoundary = creditMaxBoundary;
		this.availableCurrencies = availableCurrencies;
		this.stockExchangeThreadThread = new StockExchangeThread();
		this.stockExchangeThreadThread.start();
	}

	public boolean isClientAllowedToGetCredit(int amount, currency curr, float period, Current __current) {
		return amount < creditMaxBoundary;
	}

	public double getCreditCostInNativeCurrency(int amount, currency curr, float period, Current __current) {
		return amount;
	}

	public double getCreditCostInForeignCurrency(int amount, currency curr, float period, Current __current) {
			return amount / availableCurrencies.get(curr);
	}

	public String getAccountInfo(Current __current) {
		String info = "Personal data of PREMIUM account owner: name = " + 
				name + " " + surname + ", PESEL = " + PESEL + ", your current income = "
				+ income;
			return info;
	}

	public boolean isPremiumAccount(String PESEL, Current __current) {
		return true;
	}

	public String getAccessKey(Current __current) {
		String key = UUID.randomUUID().toString();
		return key;
	}
	
	
	public class StockExchangeThread  extends Thread {
		
		private BankStockExchangeService stockService;
		
		public StockExchangeThread() {
			stockService = new BankStockExchangeService("localhost", 50051);
		}
		
		public void run() {
			while(true) {	
				synchronized(availableCurrencies) {	
				for(Map.Entry<currency, Double> entry: availableCurrencies.entrySet()) {
					int c = entry.getKey().value() + 1;
					Double val = entry.getValue();
					currencyData data = currencyData.newBuilder().setCurr(stock.currency.valueOf(c)).setValue(val).build();
					stockRequest currencies = stockRequest.newBuilder().addCurrencies(data).build();
					Double result = stockService.runStockExchangeService(currencies);
					availableCurrencies.put(entry.getKey(), result);
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			 }
		}
	  }
	}
	

}
