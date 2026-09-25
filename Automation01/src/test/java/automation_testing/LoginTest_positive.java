package automation_testing;
import org.testng.annotations.Test;
import testngframework.Baseclass;
import testngframework.Login_page;

public class LoginTest_positive extends Baseclass {

	@Test
	public void verifySuccessfulLogin() throws InterruptedException {
		Login_page loginPage = new Login_page(driver);
		loginPage.login(username, password);
		Thread.sleep(5000);
	}
}
