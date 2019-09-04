package pageObjects.pageObject;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

public class CommonComponents extends BasePage {

	/**********************************************************************************
	 ** CALENDAR
	 **********************************************************************************/
	@FindBy(xpath = "//span[contains(text(),'Today')]")
	private WebElement today;

	public WebElement getToday() {
		return clickabilityOf(today);
	}

	@FindBy(xpath = "//button[@class='btnpicker btnpickerenabled']")
	private WebElement datePicker;

	public WebElement getDatePicker() {
		return clickabilityOf(datePicker);
	}

	/**********************************************************************************/
	/**********************************************************************************/

	/**********************************************************************************
	 ** CURRENCY DROP DOWN
	 **********************************************************************************/
	@FindBy(xpath = "//span[contains(text(), 'Currency')]/../../..")
	private WebElement currency;

	public WebElement getCurrency() {
		return clickabilityOf(currency);
	}

	@FindBy(xpath = "//mat-option[contains(@class, 'mat-option ng-star-inserted')]/span")
	private List<WebElement> dropDown;

	public List<WebElement> getDropDown() {
		return visibilityOf(dropDown);
	}

	/**********************************************************************************/
	/**********************************************************************************/

	/**********************************************************************************
	 ** ERROR NOTIFICATION
	 **********************************************************************************/
	@FindBy(xpath = "//p[@class='notifier__notification-message ng-star-inserted']")
	private WebElement notificErrorMessage;

	@FindBy(xpath = "//mat-error[@class='mat-error ng-star-inserted']")
	private WebElement errorMessage;

	public WebElement getNotificErrorMessage() {
		return visibilityOf(notificErrorMessage);
	}

	public WebElement getErrorMessage() {
		return visibilityOf(errorMessage);
	}

	/**********************************************************************************/
	/**********************************************************************************/

	/**********************************************************************************
	 ** WEB TABLE
	 **********************************************************************************/
	@FindBy(xpath = "//table[@class='table-material-look td-data-table']//tbody")
	private WebElement tableBody;

	public WebElement getTableBody() {
		return visibilityOf(tableBody);
	}

	@FindBy(xpath = "//table//tbody//tr")
	private List<WebElement> tableRows;

	public List<WebElement> getTableRows() throws InterruptedException {
		return visibilityOf(tableRows);
	}

	@FindBy(xpath = "//table[@class='table-material-look td-data-table']//tbody//td")
	private List<WebElement> tableData;

	public List<WebElement> getTableData() throws InterruptedException {
		return visibilityOf(tableData);
	}

	@FindBy(xpath = "//mat-icon[contains(text(),'navigate_next')]/../..")
	private WebElement paginationNext;

	public WebElement getPaginationNext() {
		return paginationNext;
	}

	@FindBy(xpath = "//div[@class='td-paging-bar']/span[3]")
	private WebElement paginationTotal;

	public WebElement getPaginationTotalRows() {
		return visibilityOf(paginationTotal);
	}

	@FindBy(xpath = "//div[@class='td-paging-bar']/mat-select/div/div/span/span")
	private WebElement paginationPerPage;

	public WebElement getPaginationRowsPerPage() {
		return visibilityOf(paginationPerPage);
	}

	/**********************************************************************************/
	/**********************************************************************************/

	/**********************************************************************************
	 ** BODY
	 **********************************************************************************/
	@FindBy(tagName = "html")
	private WebElement html;

	public WebElement getHtml() {
		return html;
	}

	@FindBy(xpath = "//body")
	private WebElement body;

	public WebElement getBody() {
		return body;
	}
	/**********************************************************************************/
	/**********************************************************************************/

	/**********************************************************************************
	 ** 
	 **********************************************************************************/

}
