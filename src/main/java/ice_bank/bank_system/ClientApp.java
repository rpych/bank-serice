package ice_bank.bank_system;

import clientOperations.AccountPrx;
import clientOperations.ClientAccountFactoryPrx;
import clientOperations.ClientAccountFactoryPrxHelper;
//import clientOperations.
//import clientOperations.
//import clientOperations.
import Ice.AsyncResult;

public class ClientApp 
{
    public static void main( String[] args )
    {
    	int status = 0;
		Ice.Communicator communicator = null;

		try {
			// 1. Inicjalizacja ICE
			communicator = Ice.Util.initialize(args);

			// 2. Uzyskanie referencji obiektu na podstawie linii w pliku konfiguracyjnym
			//Ice.ObjectPrx base = communicator.propertyToProxy("Calc1.Proxy");
			// 2. To samo co powy�ej, ale mniej �adnie
			Ice.ObjectPrx base = communicator.stringToProxy("config/bank:tcp -h localhost -p 10000:udp -h localhost -p 10000");

			// 3. Rzutowanie, zaw�anie
			ClientAccountFactoryPrx obj = ClientAccountFactoryPrxHelper.checkedCast(base);
			if (obj == null) throw new Error("Invalid proxy");
			
			
			
			ClientAccountFactoryPrx objOneway = (ClientAccountFactoryPrx)obj.ice_oneway();
			ClientAccountFactoryPrx objBatchOneway = (ClientAccountFactoryPrx)obj.ice_batchOneway();
			ClientAccountFactoryPrx objDatagram = (ClientAccountFactoryPrx)obj.ice_datagram();
			ClientAccountFactoryPrx objBatchDatagram = (ClientAccountFactoryPrx)obj.ice_batchDatagram();

			// 4. Wywolanie zdalnych operacji
			
			String line = null;
			java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
			AsyncResult ar = null;
			do
			{
				try
				{
					System.out.print("==> ");
					System.out.flush();
					line = in.readLine();
					if (line == null)
					{
						break;
					}
					if (line.equals("register"))
					{
						AccountPrx clientProxy = obj.registerIntoBankService("Rafal", "Pych", "5678", 2000);
						String accessKey =  clientProxy.getAccessKey();
						String info = clientProxy.getAccountInfo();
						boolean isPremium = clientProxy.isPremiumAccount("1234"); //to improve
						System.out.println("KEY = " + accessKey + " for info:\n " + info);
					}
					if (line.equals("sign"))
					{
						
						//AccountPrx clientProxy = obj.isUserSignedInBankAccount();
						System.out.println("isSigned = " + true);
					}
	                /*else if(line.equals("o"))
	                {
	                    objOneway.add(7,8);
	                }
	                else if(line.equals("O"))
	                {
	                    objBatchOneway.add(7, 8);
	                }
	                else if(line.equals("d"))
	                {
	                    objDatagram.add(7, 8);
	                }
	                else if(line.equals("D"))
	                {
	                    objBatchDatagram.add(7, 8);
	                }*/
					else if (line.equals("x"))
					{
						// Nothing to do
					}
				}
				catch (java.io.IOException ex)
				{
					System.err.println(ex);
				}
			}
			while (!line.equals("x"));


		} catch (Ice.LocalException e) {
			e.printStackTrace();
			status = 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			status = 1;
		}
		if (communicator != null) {
			// Clean up
			//
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
