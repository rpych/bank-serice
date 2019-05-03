package ice_bank.bank_system;

import clientOperations.AccountPrx;
import clientOperations.ClientAccountFactoryPrx;
import clientOperations.ClientAccountFactoryPrxHelper;
import clientOperations.PremiumAccountPrx;
import clientOperations.PremiumAccountPrxHelper;
import clientOperations.UserAccountNotFoundException;
import clientOperations.currency;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//import clientOperations.
//import clientOperations.
//import clientOperations.
import Ice.AsyncResult;

public class ClientApp 
{
	static int status = 0;
    static Ice.Communicator communicator;
	Ice.ObjectPrx base;
	ClientAccountFactoryPrx clientAccountFactory;
	AccountPrx clientProxy;
	PremiumAccountPrx premiumClientProxy;
	private String accessKey;
	
	public ClientApp(String[] args, String settings) {
		int status = 0;
	    communicator = Ice.Util.initialize(args);
		base = communicator.stringToProxy(settings);
	}
	
	
	public void runClientService() throws IOException, UserAccountNotFoundException {
		String choice = "";
		java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		while(!choice.equals("e")) {
			System.out.print("\nWelcome bank service! Please choose what you want to do:\n"
					+ "r - register into service \n"
					+ "l - log into service \n"
					+ "e - exit from service \n"
					+ ">>");
			choice = in.readLine();
			
			switch(choice.toLowerCase()) {
				case "r":
					registerIntoSerice();
					break;
				case "l":
					logIntoAccount();
					break;	
			}
		}
	}
	
	public void registerIntoSerice() throws IOException {
		clientAccountFactory = ClientAccountFactoryPrxHelper.checkedCast(base);
		if (clientAccountFactory == null) throw new Error("Invalid proxy");
		
		String choice = "";
		java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		System.out.print("\nEnter your personal data in proper manner:\n"
				+ "name#surname#PESEL#monthly income\n"
				+ ">>>");
		
		choice = in.readLine();
		String[] data = choice.split("#");
		
		clientProxy = clientAccountFactory.registerIntoBankService(data[0], data[1], data[2], Double.parseDouble(data[3]));
		
		accessKey = clientProxy.getAccessKey();
		boolean r = clientProxy.ice_isA("::clientOperations::PremiumAccount");
		System.out.println("Acces key = " + accessKey );
		serveClientAccount();
	}
	
	public void serveClientAccount() throws IOException {
		if(clientProxy != null && clientProxy.ice_isA("::clientOperations::PremiumAccount")) {
			premiumClientProxy = PremiumAccountPrxHelper.checkedCast(clientProxy);
			servePremiumAccount();
		}
		else {
			serveStandardAcount();
		}
		
	}
	
	public void serveStandardAcount() throws IOException {
		String choice = "";
		java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		while(!choice.equals("e")) {
			System.out.print("\nTo check your account details enter \"d\"\n"
					+ "to quit from your account enter \"e\"\n"
					+ ">>>>");
			choice = in.readLine();
			if(choice.toLowerCase().equals("d")) {
				String info = clientProxy.getAccountInfo();
				System.out.println(info);
			}
		}
	}
	
	public void servePremiumAccount() throws IOException {
		String choice = "";
		java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		while(!choice.equals("e")) {
			System.out.print("\nTo check your account details enter \"d\"\n"
					+ "to apply for credit enter \"a\" \n"
					+ "to quit from your account enter \"e\"\n"
					+ ">>>>");
			choice = in.readLine();
			switch(choice.toLowerCase()) {
				case "d":
					String info = premiumClientProxy.getAccountInfo();
					System.out.println(info);
					break;
				case "a":
					applyForCredit();
					break;	
			}
		}
	}
	
	public void applyForCredit() throws IOException {
		String choice = "";
		java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		System.out.print("\nEnter credit data in proper manner to check operation is possible:\n"
				+ "amount#currency#period in years\n"
				+ ">>>>>");
		choice = in.readLine();
		String[] data = choice.split("#");
		currency curr = currency.valueOf(data[1]);
		boolean result =  premiumClientProxy.isClientAllowedToGetCredit(Integer.parseInt(data[0]), curr, Float.parseFloat(data[2]));
		if(!result) {
			System.out.println("Yo cannot obtain credit with these proposed conditions!");
			return;
		}
		double ncost = premiumClientProxy.getCreditCostInNativeCurrency(Integer.parseInt(data[0]), curr, Float.parseFloat(data[2]));
		double fcost = premiumClientProxy.getCreditCostInForeignCurrency(Integer.parseInt(data[0]), curr, Float.parseFloat(data[2]));
		System.out.println("Yearly credit costs in native currency = " + ncost + " and foreign currency = " + fcost);
	}
	
	public void logIntoAccount() throws IOException, UserAccountNotFoundException {
		clientAccountFactory = ClientAccountFactoryPrxHelper.checkedCast(base);
		if (clientAccountFactory == null) throw new Error("Invalid proxy");
		
		String choice = "";
		java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		System.out.print("\nEnter your PESEL and KEY to log into service:\n"
				+ "PESEL#KEY\n"
					+ ">>>");
		
		choice = in.readLine();
		String[] data = choice.split("#");
		Map<String, String> ctx = new HashMap<String, String>();
		ctx.put(data[0] , data[1]);
		clientProxy = clientAccountFactory.getClientAccount(data[0], ctx);
		
		serveClientAccount();
	}
	
	
    public static void main( String[] args )
    {
    	String settings = "config1/bank1:tcp -h localhost -p 10001:udp -h localhost -p 10001";
    	ClientApp client = new ClientApp(args, settings);
    	try {
			
			client.runClientService();
			 
		}catch (UserAccountNotFoundException e) {
			e.printStackTrace();
		}
    	catch (IOException e1) {
			e1.printStackTrace();
		}

		if (communicator != null) {
			
			try {
				communicator.destroy();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				status = 1;
			}
		}
		System.exit(status);
	}
}
