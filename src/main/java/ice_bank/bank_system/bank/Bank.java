package ice_bank.bank_system.bank;

import Ice.Identity;


public class Bank {
	
	
	public void runBankService(String[] args, String objectAdapter, String connectionSettings, String[] identity)
	{
		int status = 0;
		Ice.Communicator communicator = null;

		try
		{
			communicator = Ice.Util.initialize(args);

			Ice.ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints(objectAdapter, connectionSettings);

			ClientAccountFactoryI clientConfigServant = new ClientAccountFactoryI(10000);
		
			adapter.add(clientConfigServant, new Identity(identity[0], identity[1])); //bank , config
	
	        adapter.activate();
			
			System.out.println("Entering event processing loop...");
			
			communicator.waitForShutdown(); 		
			
		}
		catch (Exception e)
		{
			System.err.println(e);
			status = 1;
		}
		if (communicator != null)
		{
			try
			{
				communicator.destroy();
			}
			catch (Exception e)
			{
				System.err.println(e);
				status = 1;
			}
		}
		System.exit(status);
	}


	public static void main(String[] args)
	{
		Bank app = new Bank();
		String[] identity = {"bank1" , "config1"};
		app.runBankService(args, "Adapter2", "tcp -h localhost -p 10001:udp -h localhost -p 10001", identity);
	}
}
