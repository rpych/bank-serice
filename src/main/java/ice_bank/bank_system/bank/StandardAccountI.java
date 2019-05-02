package ice_bank.bank_system.bank;
import java.util.Random;
import java.util.UUID;

import Ice.Current;
import clientOperations._AccountDisp;

public class StandardAccountI extends _AccountDisp {

	String name;
	String surname;
	String PESEL;
	double income;
	boolean isPremiumClientAccount = false;
	
	
	public StandardAccountI() {}
	
	

	public StandardAccountI(String name, String surname, String pESEL, double income) {
		super();
		this.name = name;
		this.surname = surname;
		PESEL = pESEL;
		this.income = income;
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
