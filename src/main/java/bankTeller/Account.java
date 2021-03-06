package bankTeller;

public class Account {

	private String accountNumber;
	private String accountType;
	private double balance;

	/**
	 * Account Class Constructor
	 * 
	 * @param accountNumber
	 * @param accountType
	 * @param balance
	 */
	public Account(String accountNumber, String accountType, double balance) {

		this.setAccountNumber(accountNumber);
		this.setAccountType(accountType);
		this.setBalance(balance);
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * :MIKEQ: Initially I had this named getBalance which is had auto-generated by
	 * eclipse when the field was created. The project guide said to create a
	 * function called checkAccountBalance() which I can't see any difference from
	 * the accessor/getter method, so I just refactored the name.
	 * 
	 * @return the balance
	 * 
	 */
	public double checkAccountBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Increase balance by specified amount.
	 * 
	 * @param moneyToDeposit
	 */

	public void deposit(double moneyToDeposit) {

		this.balance += moneyToDeposit;

	}

	/**
	 * Decrease balance by specified amount.
	 * 
	 * @param moneyToWithdral
	 */
	public String withdrawl(double moneyToWithdral) {

		if (this.balance >= moneyToWithdral) {
			this.balance -= moneyToWithdral;
		}
		
		String overDraftMessage = "Withdral amount exceeds balance, change withdrawl amount.";
		
		return overDraftMessage;
	}

}
