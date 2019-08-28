package pageObjects.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

import java.util.ArrayList;
import java.util.List;

public class IndexRatePage extends BasePage {

	@FindBy(xpath = "//span[@class='truncate']")
	private WebElement indexRateHeaderVerbiage;

	@FindBy(xpath = "//input[@id='rateName']")
	private WebElement indexName;

	@FindBy(xpath = "//input[@id='rateName']/parent::div/span/label")
	private WebElement indexNameVerbiage;

	@FindBy(xpath = "(//div[@class = 'mat-select-value'])[1]")
	private WebElement currency;

	@FindBy(xpath = "(//div[@class = 'mat-select-value'])[2]")
	private WebElement tenorFrequency;

	@FindBy(xpath = "(//div[@class = 'mat-select-value'])[2]/span")
	private WebElement tenorFrequencyVerbiage;

	@FindBy(xpath = "//input[@placeholder='Tenor value']")
	private WebElement tenorValue;

	@FindBy(xpath = "(//input[@placeholder='Tenor value'])/parent::div/span/label")
	private WebElement tenorValueVerbiage;

	@FindBy(xpath = "//mat-slide-toggle/label/span")
	private WebElement toggleButtonVerbiage;

	@FindBy(xpath = "//mat-slide-toggle")
	private WebElement toggleButton;

	@FindBy(xpath = "//mat-card[@class='mat-card']/h2")
	private WebElement tableHeaderVerbiage;

	@FindBy(xpath = "(//figure[@class='mat-figure']/mat-form-field)[3]")
	private WebElement filterByIndex;

	@FindBy(xpath = "(//figure[@class='mat-figure']/mat-form-field)[4]")
	private WebElement filterByCurrency;

	@FindBy(xpath = "//span[@class='td-data-table-heading']/span")
	private List<WebElement> tableColumnHeaderVerbiages;

	@FindBy(xpath = "//mat-icon[contains(text(),'refresh')]")
	private WebElement refreshButton;

	@FindBy(xpath = "//mat-icon[contains(text(),'done')]")
	private WebElement updateButton;

	@FindBy(xpath = "//mat-icon[contains(text(),'clear')]")
	private WebElement cancelbutton;

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

	public WebElement getIndexRateHeaderVerbiage() {
		return visibilityOf(indexRateHeaderVerbiage);
	}

	public WebElement getIndexName() {
		return clickabilityOf(indexName);
	}

	public WebElement getIndexNameVerbiage() {
		return visibilityOf(indexNameVerbiage);
	}

	public WebElement getCurrency() {
		return clickabilityOf(currency);
	}

	public WebElement getTenorFrequency() {
		return clickabilityOf(tenorFrequency);
	}

	public WebElement getTenorFrequencyVerbiage() {
		return visibilityOf(tenorFrequencyVerbiage);
	}

	public WebElement getTenorValue() {
		return clickabilityOf(tenorValue);
	}

	public WebElement getTenorValueVerbiage() {
		return visibilityOf(tenorValueVerbiage);
	}

	public WebElement getToggleButtonVerbiage() {
		return visibilityOf(toggleButtonVerbiage);
	}

	public WebElement getToggleButton() throws InterruptedException {
		return visibilityOf(toggleButton);
	}

	public WebElement getTableHeaderVerbiage() {
		return visibilityOf(tableHeaderVerbiage);
	}

	public WebElement getFilterByIndex() {
		return clickabilityOf(filterByIndex);
	}

	public WebElement getFilterByCurrency() {
		return clickabilityOf(filterByCurrency);
	}

	public List<WebElement> getTableColumnHeaderVerbiages() throws InterruptedException {
		return visibilityOf(tableColumnHeaderVerbiages);
	}

	public WebElement getRefreshButton() {
		return clickabilityOf(refreshButton);
	}

	public WebElement getUpdateButton() {
		return clickabilityOf(updateButton);
	}

	public WebElement getCancelbutton() {
		return clickabilityOf(cancelbutton);
	}
}
