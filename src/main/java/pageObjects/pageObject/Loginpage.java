package pageObjects.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class Loginpage extends BasePage {

	@FindBy(xpath = "//div[@class='mat-select-value']")
	private WebElement welcome;

	@FindBy(xpath = "//input[@formcontrolname='tenant']")
	private WebElement tenant;

	@FindBy(xpath = "//input[@formcontrolname='username']")
	private WebElement username;

	@FindBy(xpath = "//input[@formcontrolname='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@class='mat-raised-button mat-primary']")
	private WebElement signin;

	public WebElement getWelcome() {
		return welcome;
	}

	public WebElement getTenant() {
		return tenant;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignin() {
		return signin;
	}

}
