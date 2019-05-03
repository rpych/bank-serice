package ice_bank.bank_system.bank;

import Ice.Identity;


public class Bank {
	
	
	public void runBankService(String[] args)
	{
		int status = 0;
		Ice.Communicator communicator = null;

		try
		{
			// 1. Inicjalizacja ICE - utworzenie communicatora
			communicator = Ice.Util.initialize(args);

			// 2. Konfiguracja adaptera
			// METODA 1 (polecana produkcyjnie): Konfiguracja adaptera Adapter1 jest w pliku konfiguracyjnym podanym jako parametr uruchomienia serwera
			//Ice.ObjectAdapter adapter = communicator.createObjectAdapter("Adapter1");  
			
			// METODA 2 (niepolecana, dopuszczalna testowo): Konfiguracja adaptera Adapter1 jest w kodzie �r�d�owym
			Ice.ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Adapter1", "tcp -h localhost -p 10000:udp -h localhost -p 10000");

			// 3. Stworzenie serwanta/serwant�w
			ClientAccountFactoryI clientConfigServant = new ClientAccountFactoryI(10000);
			//StandardAccountI accountServant = new StandardAccountI();
			
						    
			// 4. Dodanie wpis�w do tablicy ASM
			adapter.add(clientConfigServant, new Identity("bank", "config"));
	        //adapter.add(accountServant, new Identity("0987", "standard"));

	        
			// 5. Aktywacja adaptera i przej�cie w p�tl� przetwarzania ��da�
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
			// Clean up
			//
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
		app.runBankService(args);
	}
}
