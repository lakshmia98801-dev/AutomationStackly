package testngframework;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Recruitment extends Baseclass {

	public Recruitment(WebDriver driver) {
		this.driver = driver;
	}

	// xpath
	By recruitment = By.xpath("//h3[text()='Recruitment']");
	By dashboardLink = By.xpath("//a[@data-testid='nav-item-dashboard']");
	By newJobLink = By.xpath("//button[text()=' New Job']");
	By dialogBody = By.xpath(
			"//div[contains(@class,'flex-1') and contains(@class,'overflow-y-auto') and contains(@class,'overscroll-contain')]");
	By draftLink = By.xpath("//span[text()='Draft']");

	public void clickRecruitment() {
		waitFor().until(ExpectedConditions.elementToBeClickable(recruitment)).click();
	}

	public void clickDashboard() {
		waitFor().until(ExpectedConditions.elementToBeClickable(dashboardLink)).click();
	}

	// ONE method for all side-menu options: pass the name shown on screen
	public void clickOption(String optionName) {
		By option = By.xpath("//button[@role='tab' and normalize-space(.)='" + optionName + "']");
		waitFor().until(ExpectedConditions.elementToBeClickable(option)).click();

		// confirm the tab really became active
		waitFor().until(ExpectedConditions.attributeToBe(option, "aria-selected", "true"));
	}

	public void clickNewJobLink() {
		waitFor().until(ExpectedConditions.elementToBeClickable(newJobLink)).click();
	}

	// Scroll down by a number of pixels
	public void scrollDown(int pixels) {
		WebElement body = new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.visibilityOfElementLocated(dialogBody));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollBy({top: arguments[1], behavior: 'smooth'});",
				body, pixels);
	}

	// Scroll up by a number of pixels
	public void scrollUp(int pixels) {
		WebElement body = new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.visibilityOfElementLocated(dialogBody));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollBy({top: -arguments[1], behavior: 'smooth'});",
				body, pixels);
	}

	// Jump to the very bottom
	public void scrollToBottom() {
		WebElement body = new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.visibilityOfElementLocated(dialogBody));
		((JavascriptExecutor) driver)
				.executeScript("arguments[0].scrollTo({top: arguments[0].scrollHeight, behavior: 'smooth'});", body);
	}

	// Jump to the very top
	public void scrollToTop() {
		WebElement body = new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.visibilityOfElementLocated(dialogBody));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollTo({top: 0, behavior: 'smooth'});", body);
	}

	public void clickDraftLink() {
		waitFor().until(ExpectedConditions.elementToBeClickable(draftLink)).click();
	}

	// ONE method for all dropdowns: pass the field label and the option text
	public void selectDropdown(String fieldLabel, String optionName) {
		By dropdown = By.xpath(
				"//label[normalize-space(.)='" + fieldLabel + "']" + "/following-sibling::button[@role='combobox']");
		By option = By.xpath("//*[@role='option'][normalize-space(.)='" + optionName + "']");

		// open the dropdown only if it is not already open
		WebElement box = waitFor().until(ExpectedConditions.elementToBeClickable(dropdown));
		if (!"true".equals(box.getAttribute("aria-expanded"))) {
			box.click();
		}

		// click the option (the list opens in a portal, so the locator is not scoped to
		// the form)
		waitFor().until(ExpectedConditions.elementToBeClickable(option)).click();

		// confirm the selected value is now shown in the dropdown
		waitFor().until(ExpectedConditions.textToBePresentInElementLocated(dropdown, optionName));
	}
	
	public void fillField(String labelText, String value) {
	    By byLabel = By.xpath(
	        "//label[starts-with(normalize-space(.), '" + labelText + "')]/following::input[1]");
	    By byPlaceholder = By.xpath("//input[contains(@placeholder, '" + labelText + "')]");

	    WebElement input;
	    try {
	        input = waitFor().until(ExpectedConditions.visibilityOfElementLocated(byLabel));
	    } catch (TimeoutException e) {
	        input = waitFor().until(ExpectedConditions.visibilityOfElementLocated(byPlaceholder));
	    }

	    waitFor().until(ExpectedConditions.elementToBeClickable(input));

	    // select all + delete, then type (clear() doesn't always update React state)
	    input.click();
	    input.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
	    input.sendKeys(value);
	}
}
