package pageObjects.pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BasePage;

public class Customermainpage extends BasePage {
	@FindBy(xpath="//mat-icon[text()='add']/../..") private WebElement addicon;
	
	@FindBy(xpath="//fims-data-table//table//tbody") private WebElement webtablebody;
	
	@FindBy(xpath="//fims-data-table//table//thead") private WebElement webtablehead;
	
	@FindBy(xpath="//tbody/tr/td[5]") private List<WebElement> accountStatus;
	
	@FindBy (xpath="//div[contains(@id,'mat-tab-label-0-')]") private WebElement loanSection;

	public WebElement getLoanSection() {
		return loanSection;
	}

	public WebElement getAddicon() {
		return addicon;
	}

	public WebElement getWebtablebody() {
		return webtablebody;
	}

	public WebElement getWebtablehead() {
		return webtablehead;
	}

	public List<WebElement> getAccountStatus() {
		return visibilityOf(accountStatus);
	}
	
	public WebElement getAccountView(String accountStatus){
		int accountStatusSize = getAccountStatus().size();
		WebElement getAccountActionView = null;
		for(int i=0; i<=accountStatusSize; i++) {
			System.out.println(getAccountStatus().get(i).getText());
			if(getAccountStatus().get(i).getText().equalsIgnoreCase(accountStatus)) {
				getAccountActionView = getDriver().findElement(By.xpath("(//tbody/tr/td[5])["+ (i+1) +"]/following-sibling::td[2]"));
				break;
			}
		}
		return getAccountActionView;
	}

	
	
	
}
