package ice_bank.bank_system.bank;
import java.util.UUID;

import Ice.Current;
import clientOperations._PremiumAccountDisp;
import clientOperations.currency;

public class PremiumAccountI extends _PremiumAccountDisp{

	String name;
	String surname;
	String PESEL;
	double income;
	boolean isPremiumClientAccount = false;
	int creditMaxBoundary;

	
	
	public PremiumAccountI(String name, String surname, String pESEL, double income,
			int creditMaxBoundary) {
		super();
		this.name = name;
		this.surname = surname;
		PESEL = pESEL;
		this.income = income;
		this.isPremiumClientAccount = true;
		this.creditMaxBoundary = creditMaxBoundary;
	}

	public boolean isClientAllowedToGetCredit(int amount, currency curr, float period, Current __current) {
		return amount < creditMaxBoundary;
	}

	public double getCreditCostInNativeCurrency(int amount, currency curr, float period, Current __current) {
		return creditMaxBoundary;
	}

	public double getCreditCostInForeignCurrency(int amount, currency curr, float period, Current __current) {
		return creditMaxBoundary / 2;
	}

	public String getAccountInfo(Current __current) {
		String info = "Personal data: " + 
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

}
