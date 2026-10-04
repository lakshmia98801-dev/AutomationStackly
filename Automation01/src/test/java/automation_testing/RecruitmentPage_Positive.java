package automation_testing;

import org.testng.annotations.Test;

import testngframework.Baseclass;
import testngframework.DashBoardModule;
import testngframework.Login_page;
import testngframework.Recruitment;

public class RecruitmentPage_Positive extends Baseclass {
	@Test
	public void verifySuccessfulLogin() throws InterruptedException {
		Login_page loginPage = new Login_page(driver);
		loginPage.login(username, password);
		Thread.sleep(5000);

		// Create object of Recruitment module and use its methods
		Recruitment recruitment = new Recruitment(driver);

		// click on recruitment option
		recruitment.clickDashboard();
		recruitment.clickRecruitment();
		recruitment.clickNewJobLink();

		// The scrollbar is scrollable or not
		Thread.sleep(5000);
		recruitment.scrollDown(3000);
		Thread.sleep(5000);
		recruitment.scrollUp(2000);
		Thread.sleep(5000);
		recruitment.scrollToBottom();
		Thread.sleep(5000);
		recruitment.scrollToTop();

		Thread.sleep(5000);
		recruitment.selectDropdown("Status", "On Hold");
		Thread.sleep(5000);
		recruitment.selectDropdown("Department", "Human Resources");
		Thread.sleep(5000);
		recruitment.selectDropdown("Designation", "Senior Manager");
		Thread.sleep(5000);
		recruitment.selectDropdown("Branch / Office", "Head Office");
		Thread.sleep(5000);
		recruitment.selectDropdown("Employment Type", "Full Time");

		recruitment.fillField("Job Title", "Senior QA Engineer");
		recruitment.fillField("Location", "Chennai");
		recruitment.fillField("Headcount", "3");
		recruitment.fillField("Experience (Min yrs)", "2");
	}

}
