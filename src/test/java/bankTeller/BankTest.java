package bankTeller;
import static org.junit.Assert.*;

import org.junit.Test;

public class BankTest {

	@Test
	public void openNewAccountAddsAccount() {
		//Arrange
		Bank bank = new Bank();
		//Act
		bank.addAccount("1234","checking",100.01);
	}

}
