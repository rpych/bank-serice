package ice_bank.bank_system.bank;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Ice.Current;
import Ice.Identity;
import clientOperations.AccountPrx;
import clientOperations.AccountPrxHelper;
import clientOperations.PremiumAccountPrxHelper;
import clientOperations.UserAccountNotFoundException;
import clientOperations._ClientAccountFactoryDisp;
import clientOperations.currency;

public class ClientAccountFactoryI extends _ClientAccountFactoryDisp {

	Map<String, AccountPrx> clientsAccounts = new HashMap<String, AccountPrx>(); //proxies of clients
	double minPremiumIncomeValue;
	public static Map<currency, Double> availableCurrencies = new HashMap<currency, Double>();
	static {
		availableCurrencies.put(currency.PLN, 0.0);
		availableCurrencies.put(currency.EUR, 0.0);
		availableCurrencies.put(currency.CHF, 0.0);
		availableCurrencies.put(currency.USD, 0.0);
		availableCurrencies.put(currency.GBP, 0.0);
	}
	
	
	public ClientAccountFactoryI(double minPremiumIncomeValue) {
		super();
		this.minPremiumIncomeValue = minPremiumIncomeValue;
	}

	public AccountPrx registerIntoBankService(String name, String surname, String PESEL, double income,
			Current __current) {
		AccountPrx proxy;
		if(income > minPremiumIncomeValue ) {
			proxy = PremiumAccountPrxHelper.uncheckedCast(__current.adapter.add(new PremiumAccountI(name, surname, PESEL, income, (int) (income + 50000), availableCurrencies),
					new Identity(PESEL, "premium")));
		}
		else {
			proxy = AccountPrxHelper.uncheckedCast(__current.adapter.add(new StandardAccountI(name, surname, PESEL, income, availableCurrencies),
					new Identity(PESEL, "standard")));
		}
		clientsAccounts.put(PESEL, proxy);
		return proxy;
	}

	public AccountPrx getClientAccount(String PESEL, Current __current) throws UserAccountNotFoundException {
		String accessKey = __current.ctx.get(PESEL);
		return clientsAccounts.get(PESEL);
	}

}
