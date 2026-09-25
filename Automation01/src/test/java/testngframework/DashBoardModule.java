package testngframework;

import org.openqa.selenium.By;

public class DashBoardModule extends Baseclass {
	
	//*DashBoard main page link xpath only use xpath *//
	
	By dashboardLink = By.xpath("//a[@title='Dashboard']");
	By myPortalLink = By.xpath("//h3[text()='My Portal']");
	
	
	
	
	
	 public void clickDashboard() { driver.findElement(dashboardLink).click(); }
	 public void clickmyPortalLink() { driver.findElement(myPortalLink).click(); }

	
	

}
