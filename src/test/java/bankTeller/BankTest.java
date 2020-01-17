package bankTeller;
import static org.junit.Assert.*;

import org.junit.Test;

public class BankTest {

	@Test
	public void openNewAccountAddsAccount() {
		//Arrange
		Bank bank = new Bank();
		//Act
		bank.openNewAccount("1234","checking",100.01);
		//Assert
		assertEquals(1, bank.getAllAccounts().size());
	}
	
	@Test
	public void closeAccountRemovesAccount() {
		//Arrange
		Bank bank = new Bank();
		//Act
		bank.openNewAccount("1234", "checking", 100.01);
		bank.openNewAccount("5678", "savings", 10000);
		bank.closeAccount("1234");
		//Assert
		assertEquals(1, bank.getAllAccounts().size());
	}
	
	@Test
	public void getAccountReturnsCorrectAccountObject() {
		//Arrange
		Bank bank = new Bank();
		Account account = new Account("9999", "investment", 100000); 
		//Act
		bank.openNewAccount("1234", "checking", 100.01);
		bank.openNewAccount("5678", "savings", 10000);
		bank.putAccount(account);
		Account result = bank.getAccount("9999");
		//Assert
		assertEquals(result, account);
	}
	
	@Test
	public void depositAdds100p11ToAccountBalance() {
		//Arrange
		Bank bank = new Bank();
		//Act
		bank.openNewAccount("1234", "checking", 100.01);
		bank.openNewAccount("5678", "savings", 10000);
		bank.getAccount("1234").deposit(100.11);
		//Assert
		assertEquals(200.12, bank.getAccount("1234").checkAccountBalance(), 0.001); //last value is precision
	}
	
	@Test
	public void withdrawlremoves100p50FromAccountBalance() {
		//Arrange
		Bank bank = new Bank();
		//Act
		bank.openNewAccount("1234", "checking", 100.99);
		bank.openNewAccount("5678", "savings", 10000);
		bank.getAccount("1234").withdrawl(100.50);
		//Assert
		assertEquals(0.49, bank.getAccount("1234").checkAccountBalance(), 0.001); //last value is precision
	}
	
	@Test
	public void withdrawlremovesDoesNotAllowOverDraft() {
		//Arrange
		Bank bank = new Bank();
		//Act
		bank.openNewAccount("1234", "checking", 100.99);
		bank.openNewAccount("5678", "savings", 10000);
		bank.getAccount("1234").withdrawl(1000);
		//Assert
		assertEquals(100.99, bank.getAccount("1234").checkAccountBalance(), 0.001); //last value is precision
	}
	
	@Test
	public void OverDraftAttemptReturnsOverDraftMessage() {
		//Arrange
		Bank bank = new Bank();
		//Act
		bank.openNewAccount("1234", "checking", 100.99);
		bank.openNewAccount("5678", "savings", 10000);
		//Assert
		assertEquals("Withdral amount exceeds balance, change withdrawl amount.", bank.getAccount("1234").withdrawl(1000));
	}
	

}
