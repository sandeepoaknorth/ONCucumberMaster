package pageObjects.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

import java.util.ArrayList;
import java.util.List;

public class Quickaccesspage extends BasePage{

	@FindBy(xpath="//h3[text()='Quick access']/..")
	private WebElement quickaccess;

	@FindBy(xpath="//fims-app//mat-toolbar//span//mat-icon[text()='menu']")
	private WebElement menu;

	@FindBy(xpath="//h3[text()='Loan products']/..")
	private WebElement loanproducts;


	@FindBy(xpath="//h3[text()='Interest Rate Maintenance']/..")
	private WebElement intrstratemaintenance;

	@FindBy(xpath="//h3[text()='Customer']/..")
	private WebElement customer;

	@FindBy(xpath="//h3[text()='Fee Set up']/..")
	private WebElement feesetup;

	@FindBy(xpath="//h3[text()='Accounting']/..")
	private WebElement accounting;

	@FindBy(xpath="//mat-icon[text()='account_circle']/../..")
	private WebElement account;

	@FindBy(xpath="//span[text()='Sign Out']/..")
	private WebElement signout;

	@FindBy(xpath="//h3[text()='Batch Jobs']/..")
	private WebElement batchjobs;

	@FindBy(xpath = "//mat-icon[contains(text(),'account_circle')]")
	private WebElement accountcirle;

	@FindBy(xpath = "//span[contains(text(),'User Preference')]")
	private WebElement UserPreferenceButton;

	@FindBy(xpath ="//mat-label[contains(text(),'Date Format')]")
	private WebElement dateformattitle;

	@FindBy(xpath ="//mat-label[contains(text(),'Thousand Separator')]")
	private WebElement thousandseperatortitle;

	@FindBy(xpath ="//mat-label[contains(text(),'Decimal Separator')]")
	private WebElement decimalseperatortitle;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"dateFormat\"]/div/div[2]")
	private WebElement DateArrow;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"thousandSeparator\"]/div/div[2]")
	private WebElement ThousandArrow;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"decimalSeparator\"]/div/div[2]")
	private WebElement DecimalArrow;

	@FindBy(xpath = "//div[@class='mat-select-content ng-trigger ng-trigger-fadeInContent']//mat-option//span")
	private List<WebElement> genericdroplist;

	@FindBy(xpath = "//span[contains(text(),'Save Preferences')]")
	private WebElement savePreferencesButton;

	public WebElement getQuickaccess() {
		return quickaccess;
	}

	public WebElement getMenu() {
		return menu;
	}

	public WebElement getLoanproducts() {
		return loanproducts;
	}

	public WebElement getIntrstratemaintenance() {
		return intrstratemaintenance;
	}

	public WebElement getCustomer() {
		return visibilityOf(customer);
	}

	public WebElement getFeesetup() {
		return feesetup;
	}

	public WebElement getAccounting() {
		return accounting;
	}

	public WebElement getAccount() {
		return account;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getBatchjobs() {
		return batchjobs;
	}

	public WebElement getAccountcirle() {
		return accountcirle;
	}

	public WebElement getUserPreferenceButton() {
		return UserPreferenceButton;
	}

	public WebElement getDateformattitle() {
		return dateformattitle;
	}

	public WebElement getThousandseperatortitle() {
		return thousandseperatortitle;
	}

	public WebElement getDecimalseperatortitle() {
		return decimalseperatortitle;
	}

	public WebElement getDateArrow() {
		return DateArrow;
	}

	public WebElement getThousandArrow() {
		return ThousandArrow;
	}

	public WebElement getDecimalArrow() {
		return DecimalArrow;
	}

	public List<WebElement> getGenericdroplist() {
		return genericdroplist;
	}

	public WebElement getSavePreferencesButton() {
		return savePreferencesButton;
	}
	
	
	

}

