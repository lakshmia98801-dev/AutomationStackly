package testngframework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardModule extends Baseclass {

    WebDriverWait wait;

	public DashBoardModule(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	// *DashBoard main page link xpath only use xpath *//

	By dashboardLink = By.xpath("//a[@data-testid='nav-item-dashboard']");
	By myPortalLink = By.xpath("//a[@data-testid='nav-item-employee']");
	By portallink = By.xpath("//a[@data-testid='module-tile-employee']");
	By usersAndRoles = By.xpath("//a[@data-testid='module-tile-users']");
	By humanResources = By.xpath("//h3[text()='Human Resources']");
	By payroll = By.xpath("//h3[text()='Payroll']");
	By financeAndAccounts = By.xpath("//h3[text()='Finance & Accounts']");
	By products = By.xpath("//P[text()='Products, services, pricing, HSN/SAC & UoM']");
	By inventoryAndStock = By.xpath("//h3[text()='Inventory & Stock']");
	By crm = By.xpath("//h3[text()='CRM']");
	By operations = By.xpath("//h3[text()='Operations']");
	By recruitment = By.xpath("//h3[text()='Recruitment']");
	By qualityManagement = By.xpath("//h3[text()='Quality Management']");
	By customerService = By.xpath("//h3[text()='Customer Service']");
	By mISReport = By.xpath("//h3[text()='MIS Reports']");
	By integrations = By.xpath("//h3[text()='Integrations']");
	By auditLog = By.xpath("//h3[text()='Audit Log']");

	// * DashBoard function *//
	public void clickDashboard() {
		waitFor().until(ExpectedConditions.elementToBeClickable(dashboardLink)).click();
	}

	public void clickmyPortalLink() {
		waitFor().until(ExpectedConditions.elementToBeClickable(myPortalLink)).click();
	}

	public void clickPortalLink() {
		waitFor().until(ExpectedConditions.elementToBeClickable(portallink)).click();
	}

	public void clickusersAndRoles() {
		waitFor().until(ExpectedConditions.elementToBeClickable(usersAndRoles)).click();
	}

	public void clickHumanResources() {
		waitFor().until(ExpectedConditions.elementToBeClickable(humanResources)).click();
	}

	public void clickPayroll() {
		waitFor().until(ExpectedConditions.elementToBeClickable(payroll)).click();
	}

	public void clickFinanceAndAccounts() {
		waitFor().until(ExpectedConditions.elementToBeClickable(financeAndAccounts)).click();
	}

	public void clickproducts() {
		waitFor().until(ExpectedConditions.elementToBeClickable(products)).click();
	}

	public void clickInventoryAndStock() {
		waitFor().until(ExpectedConditions.elementToBeClickable(inventoryAndStock)).click();
	}

	public void clickcrm() {
		waitFor().until(ExpectedConditions.elementToBeClickable(crm)).click();
	}

	public void clickOperations() {
		waitFor().until(ExpectedConditions.elementToBeClickable(operations)).click();
	}

	public void clickRecruitment() {
		waitFor().until(ExpectedConditions.elementToBeClickable(recruitment)).click();
	}

	public void clickqualityManagement() {
		waitFor().until(ExpectedConditions.elementToBeClickable(qualityManagement)).click();
	}

	public void clickcustomerService() {
		waitFor().until(ExpectedConditions.elementToBeClickable(customerService)).click();
	}

	public void clickMISReport() {
		waitFor().until(ExpectedConditions.elementToBeClickable(mISReport)).click();
	}

	public void clickIntegrations() {
		waitFor().until(ExpectedConditions.elementToBeClickable(integrations)).click();
	}

	public void clickAuditLog() {
		waitFor().until(ExpectedConditions.elementToBeClickable(auditLog)).click();
	}
}
