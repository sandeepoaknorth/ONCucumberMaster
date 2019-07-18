package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pageObjects.BasePage;
import utils.DriverFactory;

public class MasterHooks extends DriverFactory {
	
	@Before
	public void setup() {
		driver = getDriver();
		driver.get("http://cbdoc.oaknorth.ai/");
		driver.findElement(By.xpath("//input[@formcontrolname='tenant']")).sendKeys((prop.getProperty("tenant")));
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys((prop.getProperty("usernmae")));
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys((prop.getProperty("pwd")));
		driver.findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
	}
	
	@After
	public void tearDownAndScreenshotOnFailure(Scenario scenario) {
		try {
			if(driver != null && scenario.isFailed()) {
				scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
//				BasePage.captureScreenshot();
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}
			if(driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			System.out.println("Methods failed: tearDownAndScreenshotOnFailure, Exception: " + e.getMessage());
		}
}
}
