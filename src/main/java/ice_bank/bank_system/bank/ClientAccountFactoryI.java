package ice_bank.bank_system.bank;
import java.util.HashMap;
import java.util.Map;

import Ice.Current;
import Ice.Identity;
import clientOperations.AccountPrx;
import clientOperations.AccountPrxHelper;
import clientOperations.PremiumAccountPrxHelper;
import clientOperations.UserAccountNotFoundException;
import clientOperations._ClientAccountFactoryDisp;

public class ClientAccountFactoryI extends _ClientAccountFactoryDisp {

	Map<String, AccountPrx> clientsAccounts = new HashMap<String, AccountPrx>(); //proxies of clients
	double minPremiumIncomeValue;
	
	
	
	public ClientAccountFactoryI(double minPremiumIncomeValue) {
		super();
		this.minPremiumIncomeValue = minPremiumIncomeValue;
	}

	public AccountPrx registerIntoBankService(String name, String surname, String PESEL, double income,
			Current __current) {
		if(income > minPremiumIncomeValue ) {
			return PremiumAccountPrxHelper.uncheckedCast(__current.adapter.add(new PremiumAccountI(name, surname, PESEL, income, (int) (income + 50000)),
					new Identity(PESEL, "premium")));
		}
		else {
			return AccountPrxHelper.uncheckedCast(__current.adapter.add(new StandardAccountI(name, surname, PESEL, income),
					new Identity(PESEL, "standard")));
		}
	}

	public AccountPrx getClientAccount(String PESEL, Current __current) throws UserAccountNotFoundException {
		String accessKey = __current.ctx.get(PESEL);
		return clientsAccounts.get(PESEL);
	}

	

}
