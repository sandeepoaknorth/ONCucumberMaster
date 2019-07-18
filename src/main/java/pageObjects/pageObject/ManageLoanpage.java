package pageObjects.pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pageObjects.BasePage;

public class ManageLoanpage extends BasePage {
	
	@FindBy (xpath = "//div[@class = 'loanwallCardContainer']/div[3]/h4")
	private WebElement accountStatus;
	
	@FindBy (xpath = "(//button[contains(@class, 'mat-fab')])[2]")
	private WebElement loanMenuButton;
	
	@FindBy(xpath = "//span//strong[contains(.,'R')]")
	private WebElement RepaymentButton;

	public List<WebElement> getLoanSection() {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@id,'mat-tab-label')]")));
	}

	public WebElement getAccountStatus() {
		return visibilityOf(accountStatus);
	}

	public WebElement getRepaymentButton() {
		return RepaymentButton;
	}

	public WebElement getLoanMenuButton() {
		return loanMenuButton;
	}
	
	

}
