/**
 * 
 */
package bankTeller;

import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author Michael Cheich
 *
 */
public class BankingApp {

	/**
	 * :MIKEQ: It feels wring making global objects... but if I don't do this, how
	 * will the methods I make in this BankingApp refer to the object?
	 * 
	 * Create Bank Object with global scope
	 */
	static Bank bank = new Bank();

	/**
	 * :MIKEQ: this whole static thing is getting me...
	 */
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		int option = 3;
		// Add 2 accounts to bank
		bank.openNewAccount("1234", "Checking", 100.10);
		bank.openNewAccount("5678", "Savings", 99999.99);

		welcomeMessage();

		do {

			switch (option) {

			case 1:
				makeDeposit();
				break;
			case 2:
				makeWithdrawl();
				break;
			case 3:
				showAccounts();
				break;
			case 4:
				closeAccount();
				break;
			}

			showOptions();
			option = input.nextInt();

		} while (option != 0);
		
		//Exit Message
		System.out.println("Thanks for Banking with Family Bank! Good Bye!");
		System.exit(0);
		
		input.close();
	}

	/**
	 * Allows user to close account if balance is greater than 0.
	 */
	private static void closeAccount() {

		// User prompt
		System.out.println("** You want to close an account. **\n");
		showAccounts();

		// Get Account Number
		System.out.println("** Type the account number to choose an account to close. **");
		String accountNumber = input.next();
		System.out.println("** You have selected account " + bank.getAccount(accountNumber).getAccountNumber()
				+ " to close. **\n ** Is this correct?  Enter 0 for No, and 1 for Yes. **");
		int selection = input.nextInt();

		if (selection == 1) {

			if (bank.getAccount(accountNumber).checkAccountBalance() > 0) {
				System.out.println("** This account still has funds and may not be closed. ** \n"
						+ "** Please withdrawl all funds first, or choose a differt option. **\n");
			} else {
				bank.closeAccount(accountNumber);
				System.out.println("** Your account has been closed. **");
				showAccounts();
			}
		}

	}

	/**
	 * Allows user to make withdraw from account.
	 */
	private static void makeWithdrawl() {
		// User prompt
		System.out.println("** You want to withdrawl some money. **\n");
		showAccounts();

		// Get Account Number
		System.out.println("** Type the account number to choose an account to withdrawl from. **");
		String accountNumber = input.next();
		System.out.println("You have selected account " + bank.getAccount(accountNumber).getAccountNumber());

		// Get withdrawal amount
		System.out.println("Enter the withdrawl amount:");
		double amountToWithdrawl = input.nextDouble();

		/*
		 * :MIKEQ: I also put logic in the account class to stop overdraft. Not sure
		 * which class should drive the user messaging. Seems like a duplication of
		 * logic. Maybe I could have the account class.withral return a boolean for
		 * success of not...
		 * 
		 * Check that withdrawal does not exceed balance
		 */
		if (amountToWithdrawl > bank.getAccount(accountNumber).checkAccountBalance()) {
			System.out.println("Withdral amount exceeds balance. No withdrawl made.");
		} else {
			bank.getAccount(accountNumber).withdrawl(amountToWithdrawl);
			System.out.println("You withdrawled $" + String.format("%.2f", amountToWithdrawl));
		}

		// Show new balance
		System.out.println("Your current balance is $"
				+ String.format("%.2f", bank.getAccount(accountNumber).checkAccountBalance()));

	}

	/**
	 * Allows user to make account deposit
	 */
	private static void makeDeposit() {

		// User prompt
		System.out.println("** You want to deposit some money. **\n");
		showAccounts();

		// Get Account Number
		System.out.println("** Type the account number to choose an account to deposit to. **");
		String accountNumber = input.next();
		System.out.println("You have selected account " + bank.getAccount(accountNumber).getAccountNumber());

		// Get deposit amount
		System.out.println("Enter the deposit amount:");
		double amountToDeposit = input.nextDouble();

		// Deposit money
		bank.getAccount(accountNumber).deposit(amountToDeposit);
		;
		System.out.println("You deposited $" + String.format("%.2f", amountToDeposit));

		// Show new balance
		System.out.println(
				"Your new balance is $" + String.format("%.2f", bank.getAccount(accountNumber).checkAccountBalance()));
	}

	/**
	 * Show a list on console.
	 */
	private static void showOptions() {
		System.out.println(
				"** What would you like to do? **\n\n" + "Press 1 to deposit\n" + "Press 2 to withdrawal\n"
						+ "Press 3 to check account balances\n" + "Press 4 to close an account\n" + "Press 0 to exit\n");
	}

	/**
	 * Show list of account in Bank
	 */
	private static void showAccounts() {

		System.out.println("** Here are your accounts at Family Bank **\n");
		for (Account account : bank.getAllAccounts()) {
			System.out
					.println("(" + account.getAccountNumber() + ") " + String.format("%-10s", account.getAccountType())
							+ " $" + String.format("%10.2f", account.checkAccountBalance()));
		}
		System.out.println();
		// System.out.println(bank.getAllAccounts());
		// for( Entry<String, Account> entry: bank.getAllAccounts().entrySet());
	}

	/**
	 * 
	 * Display welcome message to user
	 */
	private static void welcomeMessage() {
		System.out.println("###############################");
		System.out.println("# Welcome to the Family Bank! #");
		System.out.println("###############################\n");
	}

}
