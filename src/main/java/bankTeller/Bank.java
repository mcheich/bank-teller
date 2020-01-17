package bankTeller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bank {
	
	private Map<String ,Account> accounts = new HashMap<String, Account>();

	/**
	 * Add Account to accounts Map.
	 * Calls the constructor of the account Class
	 * @param accountNumber
	 * @param AccounType
	 * @param balance
	 */
	public void openNewAccount(String accountNumber, String accountType, double balance) {
		
		Account accountToAdd = new Account(accountNumber, accountType, balance);
		accounts.put(accountToAdd.getAccountNumber(), accountToAdd);
		
	}
	
/**
 * Returns a Collection of all the accounts in the bank. 
 * @return Collection<Account> All the accounts in the bank
 */
	public Collection<Account> getAllAccounts() {
		return accounts.values();
	}
	
/**
 * Removes an account from accounts map.
 * @param accountNumber
 */
	public void closeAccount(String accountNumber) {
		accounts.remove(accountNumber);
		
	}

	/**
	 * Retrieves a single account object from the bank.
	 * @param accountNumber
	 * @return Account object
	 */
public Account getAccount(String accountNumber) {
	
	return accounts.get(accountNumber);
}

/**
 * Adds an Account object to the bank.
 * ????? MIKE NOTE: Not sure if the naming I use for this method is OK.
 * @param account
 */
public void putAccount(Account account) {
	
	accounts.put(account.getAccountNumber(), account);

}

}
