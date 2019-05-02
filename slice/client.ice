module clientOperations
{
  
  enum currency { PLN, EUR, CHF, USD, GBP };
		
  exception UserAccountNotFoundException
  {
  	string reason = "User Account Not Found";
  };

  interface Account
  {
    string getAccountInfo();
    bool isPremiumAccount(string PESEL);
    string getAccessKey();
  };
  
  interface PremiumAccount extends Account
  {
  	bool isClientAllowedToGetCredit(int amount, currency curr, float period);
   	double getCreditCostInNativeCurrency(int amount, currency curr, float period); 
   	double getCreditCostInForeignCurrency(int amount, currency curr, float period); 
  };
  
  interface ClientAccountFactory
  {
  	Account* registerIntoBankService(string name, string surname, string PESEL, double income);
  	Account* getClientAccount(string PESEL) throws UserAccountNotFoundException;
  };

};