package pageObjects.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

import java.util.ArrayList;
import java.util.List;

public class InterestRateMaintenancePage extends BasePage {

	@FindBy(xpath = "//strong[contains(text(),'Business Date')]")
	private WebElement businessDateVerbiage;
	
	@FindBy(xpath = "//input[@aria-label='Date input field']")
	private WebElement businessDate;

	@FindBy(xpath = "//label[text() = 'Reference Rate']")
	private WebElement referenceRateVerbiage;
	
	@FindBy(xpath = "//label[text() = 'Reference Rate']/../..")
	private WebElement referenceRate;

	@FindBy(xpath = "//label[text()='Value']")
	private WebElement valueInputVerbiage;
	
	@FindBy(xpath = "//input[@placeholder='Value']")
	private WebElement valueInput;

	@FindBy(xpath = "//span[@class='truncate']")
	private WebElement rateMaintenanceHeaderVerbiage;

	@FindBy(xpath = "//h2[contains(text(),'Historical Rates')]")
	private WebElement historicRateHeaderVerbiage;

	@FindBy(xpath = "//mat-icon[contains(text(),'refresh')]")
	private WebElement refreshButton;

	@FindBy(xpath = "//button[contains(@class,'floatUpdate ')]")
	private WebElement updateButton;

	@FindBy(xpath = "//mat-icon[contains(text(),'clear')]")
	private WebElement cancelbutton;

	@FindBy(xpath = "//label[text()='Filter']")
	private WebElement filtorVerbiage;

	@FindBy(xpath = "//span[@class='td-data-table-heading']/span")
	private List<WebElement> tableColumnVerbiages;
	
	@FindBy(xpath = "//table[@class='table-material-look td-data-table']//tbody//tr")
	private List<WebElement> tableRows;
	
	@FindBy(xpath = "//table[@class='table-material-look td-data-table']//tbody//td")
	private List<WebElement> tableData;
	
	public List<WebElement> getTableRows() throws InterruptedException {
		return visibilityOf(tableRows);
	}
	
	public List<WebElement> getTableData() throws InterruptedException {
		return visibilityOf(tableData);
	}
	
	public WebElement getBusinessDateVerbiage() {
		return businessDateVerbiage;
	}
	
	public WebElement getBusinessDate() {
		return businessDate;
	}

	public WebElement getReferenceRate() {
		return referenceRate;
	}
	
	public WebElement getReferenceRateVerbiage() {
		return referenceRateVerbiage;
	}

	public WebElement getValueInput() {
		return valueInput;
	}
	
	public WebElement getValueInputVerbiage() {
		return valueInputVerbiage;
	}

	public WebElement getRateMaintenanceHeaderVerbiage() {
		return visibilityOf(rateMaintenanceHeaderVerbiage);
	}

	public WebElement getHistoricRateHeaderVerbiage() {
		return historicRateHeaderVerbiage;
	}

	public WebElement getRefreshButton() {
		return refreshButton;
	}

	public WebElement getUpdateButton() {
		return clickabilityOf(updateButton);
	}

	public WebElement getCancelbutton() {
		return clickabilityOf(cancelbutton);
	}

	public WebElement getFiltorVerbiage() {
		return filtorVerbiage;
	}

	public List<WebElement> getTableColumnVerbiages() {
		return tableColumnVerbiages;
	}

}
