package testngframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Login_page ---------- Page Object for the STACKLY OneERP login screen. Holds
 * ONLY locators + actions for this page — no assertions here, assertions belong
 * in the test class.
 *
 * Update the By locators below to match your actual login page's HTML (use
 * browser DevTools -> Inspect to grab id/name/xpath).
 */
public class Login_page {

	private WebDriver driver;
	private WebDriverWait wait;

	private By usernameField = By.xpath("//input[@id='email']");
	private By passwordField = By.xpath("//input[@id='password']");
	private By loginButton = By.xpath("//span[text()='Sign In']");
	private By errorMessage = By.xpath("//span[text()='Invalid email or password. Please check your credentials.']");

	public Login_page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private WebElement getUsernameField() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
	}

	public void enterUsername(String username) {
		getUsernameField().clear();
		getUsernameField().sendKeys(username);
	}

	public void enterPassword(String password) {
		WebElement pwd = driver.findElement(passwordField);
		pwd.clear();
		pwd.sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	/**
	 * Convenience method: does the full login flow in one call. Test classes
	 * typically call just this.
	 * @throws InterruptedException 
	 */
	public void login(String username, String password) throws InterruptedException {
		enterUsername(username);
		enterPassword(password);
		Thread.sleep(5000);
		clickLogin();
	}

	public boolean isErrorDisplayed() {
		try {
			return driver.findElement(errorMessage).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String getErrorText() {
		return driver.findElement(errorMessage).getText();
	}
}