package testngframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * Pascal's --------- Every test class extends this. It is responsible for:
 * 1.Reading environment/credential config from a properties file (never
 * hardcode usernames/passwords directly in code) 2. Launching and quitting the
 * browser for each test method 3. Exposing the WebDriver instance + credentials
 * to child classes
 **/

public class Baseclass extends Create_company_workspace {

	protected WebDriver driver;
	protected Properties config;

	// Exposed so Page classes / test classes can read them
	protected String appUrl;
	protected String username;
	protected String password;

	/**
	 * Loads config/credentials from config.properties Keep this file OUT of version
	 * control (add to .gitignore)
	 *
	 * Example config.properties: url=https://your-stackly-oneerp-env.com/login
	 * username=qa_user@stackly.com password=YourTestPassword123 browser=chrome
	 */
	protected void loadConfig() {
		config = new Properties();
		try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
			config.load(fis);
			appUrl = config.getProperty("url");
			username = config.getProperty("username");
			password = config.getProperty("password");
		} catch (IOException e) {
			throw new RuntimeException(
					"Could not load config.properties. " + "Check the path: src/test/resources/config.properties", e);
		}
	}

	@BeforeMethod
	@Parameters("browser")
	public void setUp() {
		loadConfig();

		// Basic Chrome setup — extend this with a switch/if for Firefox/Edge if needed

		ChromeOptions options = new ChromeOptions();

		// options.addArguments("--headless=new"); // uncomment for CI/headless runs

		options.addArguments("--start-maximized");
		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();

		driver.get(appUrl);
	}

	@BeforeMethod
	public void startVideo() throws Exception {
		VideoRecorderUtil.startRecording("TestRecording");
	}

	@AfterMethod
	public void stopVideo() throws Exception {
		VideoRecorderUtil.stopRecording();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}