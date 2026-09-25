package automation_testing;

import org.testng.annotations.Test;

import testngframework.Baseclass;
import testngframework.DashBoardModule;
import testngframework.Login_page;

public class DashBoardPage extends Baseclass {
	@Test
	public void verifySuccessfulLogin() throws InterruptedException {
		Login_page loginPage = new Login_page(driver);
		loginPage.login(username, password);
		Thread.sleep(5000);

		// Create object of DashBoardModule and use its methods
		DashBoardModule dashboard = new DashBoardModule();
		dashboard.clickDashboard();
		Thread.sleep(5000); // wait for dashboard to load

		dashboard.clickmyPortalLink();
		Thread.sleep(2000); // wait for profile page to load
	}

}
