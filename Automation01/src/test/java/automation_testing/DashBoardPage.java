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
		DashBoardModule dashboard = new DashBoardModule(driver);

		// click on dashboard option check its clickable or not
		dashboard.clickDashboard();
		dashboard.clickPortalLink();

		Thread.sleep(2000);
		dashboard.clickDashboard();
		Thread.sleep(2000);
		dashboard.clickusersAndRoles();

		Thread.sleep(2000);
		dashboard.clickDashboard();
		Thread.sleep(2000);
		dashboard.clickHumanResources();

		Thread.sleep(2000);
		dashboard.clickDashboard();
		Thread.sleep(2000);
		dashboard.clickPayroll();

		Thread.sleep(2000);
		dashboard.clickDashboard();
		Thread.sleep(2000);
		dashboard.clickFinanceAndAccounts();

		Thread.sleep(2000);
		dashboard.clickDashboard();
		Thread.sleep(2000);
		dashboard.clickproducts();

		Thread.sleep(2000);
		dashboard.clickDashboard();
		Thread.sleep(2000);
		dashboard.clickInventoryAndStock();

		Thread.sleep(2000);
		dashboard.clickDashboard();
		Thread.sleep(2000);
		dashboard.clickcrm();

		Thread.sleep(2000);
		dashboard.clickDashboard();
		Thread.sleep(2000);
		dashboard.clickOperations();

		Thread.sleep(2000);
		dashboard.clickDashboard();
		Thread.sleep(2000);
		dashboard.clickRecruitment();

		Thread.sleep(2000);
		dashboard.clickDashboard();
		Thread.sleep(2000);
		dashboard.clickqualityManagement();

		Thread.sleep(2000);
		dashboard.clickDashboard();
		Thread.sleep(2000);
		dashboard.clickcustomerService();

		Thread.sleep(2000);
		dashboard.clickDashboard();
		Thread.sleep(2000);
		dashboard.clickMISReport();

		Thread.sleep(2000);
		dashboard.clickDashboard();
		Thread.sleep(2000);
		dashboard.clickAuditLog();

	}

}
