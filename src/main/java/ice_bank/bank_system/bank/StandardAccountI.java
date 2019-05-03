package ice_bank.bank_system.bank;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import Ice.Current;
import clientOperations._AccountDisp;
import clientOperations._PremiumAccountDisp;
import clientOperations.currency;

public class StandardAccountI extends _AccountDisp {

	String name;
	String surname;
	String PESEL;
	double income;
	Map<currency, Double> availableCurrencies = new HashMap<currency, Double>();
	
	
	public StandardAccountI() {}
	
	

	public StandardAccountI(String name, String surname, String pESEL, double income, Map<currency, Double> availableCurrencies) {
		super();
		this.name = name;
		this.surname = surname;
		PESEL = pESEL;
		this.income = income;
		this.availableCurrencies = availableCurrencies;
	}



	public String getAccountInfo(Current __current) {
		String info = "Personal data: " + 
			name + " " + surname + ", PESEL = " + PESEL + ", your current income = "
			+ income;
		return info;
	}

	public boolean isPremiumAccount(String PESEL, Current __current) {
		return false;
	}

	public String getAccessKey(Current __current) {
		String key = UUID.randomUUID().toString();
		return key;
	}

	

	

}
