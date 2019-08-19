package pageObjects.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import pageObjects.BasePage;

import java.util.List;

public class RepaymentPage extends BasePage {

	@FindBy(xpath = "//h3[contains(@class,'repaymentheading')]")
	private WebElement repaymentModalHeading;

	@FindBy(xpath = "//div[contains(@class,'fl-left')]")
	private WebElement customerName;

	@FindBy(xpath = "//span[contains(.,'Account :')]")
	private WebElement accountId;

	@FindBy(xpath = "//span[contains(.,'Approved Amount :')]")
	private WebElement approvedAmount;

	@FindBy(xpath = "//button[contains(.,'Show Dues')]")
	private WebElement advanceRepaymentShowDuesButton;

	@FindBy(xpath = "//i[contains(.,'clear')]") 
	private WebElement closeModalButton;
	
	@FindBy(xpath = "//button[contains(.,'Close')]")
	private WebElement postRepaymentCloseModalButton;

	@FindBy(xpath = "//button[contains(.,'Cancel')]/span")
	private WebElement cancelModalButton;

	@FindBy(xpath = "//span[contains(.,'Cancel')]")
	private WebElement cancel;

	@FindBy(xpath = "//input[contains(@id,'mat-input')]")
	private WebElement remarks;

	@FindBy(xpath = "//button[contains(.,'Submit')]")
	private WebElement submitRepaymentModalButton;

	@FindBy(xpath = "//button[contains(.,'Advance')]")
	private WebElement advanceRepaymentModalButton;
	
	@FindBy(xpath = "//button[contains(.,'Normal')]")
	private WebElement normalRepaymentModalButton;
	
	@FindBy(xpath = "//p[@class='notifier__notification-message ng-star-inserted']")
	private WebElement notifierMessage;
	
	@FindBy(xpath = "//li//notifier-notification")
	private WebElement notifier;

	// Basic Repayment

	
	@FindBy(xpath = "//div[contains(@class,'mat-select-arrow-wrapper')]")
	private WebElement repaymentMethodDrop;

	@FindBy(xpath = "//div[contains(@class,'mat-select-value')]")
	private WebElement repaymentMethod;
	
	@FindBy(xpath = "//label[contains(@class,'mb-5 date-picker-label')]/strong")
	private WebElement dateLabel;
	
	@FindBy(xpath = "(//input[contains(@id,'mat-input')]/following-sibling::span/label)[1]")
	private WebElement repaymentAmountLabel;

	@FindBy(xpath = "//div[@class='mat-select-content ng-trigger ng-trigger-fadeInContent']//mat-option//span")
	private List<WebElement> repaymentmethoddropdown;

	@FindBy(xpath = "//input[@aria-label='Date input field']")
	private WebElement repaymentDate;
	
	@FindBy(xpath = "//button[contains(@class, 'headertodaybtn')]")
	private WebElement todayDate;
	
	@FindBy(xpath = "//span[contains(@class, 'icon-mydpcalendar')]")
	private WebElement calanderSelector;

	@FindBy(xpath = "//div[@class='mat-input-wrapper mat-form-field-wrapper'][contains(.,'Repayment Amount')]")
	private WebElement repaymentAmount;

	@FindBy(xpath = "//input[@formcontrolname=\"customerRepayAmount\"]")
	private WebElement repaymentAmountinput;

	@FindBy(xpath = "//input[@formcontrolname=\"finalRepayAmount\"]")
	private WebElement advancedrepaymentAmountinput;

	
	@FindBy(xpath = "//mat-grid-list//mat-grid-tile//figure[contains(.,'Principal Due :')]")
	private WebElement principalDue;

	
	@FindBy(xpath = "//mat-grid-list//mat-grid-tile//figure[contains(.,'Interest Due :')]")
	private WebElement interestDue;

	
	@FindBy(xpath = "//mat-grid-list//mat-grid-tile//figure[contains(.,'Final Repayment :')]")
	private WebElement finalRepayment;

	
	@FindBy(xpath = "//mat-grid-list//mat-grid-tile//figure[contains(.,'Total Principal Paid :')]")
	private WebElement totalPrincipalPaid;

	
	@FindBy(xpath = "//mat-grid-list//mat-grid-tile//figure[contains(.,' Total Interest Paid :')]")
	private WebElement totalInterestPaid;

	// Advance Repayment
	@FindBy(xpath = "//mat-select[contains(@name,'repaymentMethod')]//div[contains(@class,'mat-select-arrow-wrapper')]")
	private WebElement advanceRepaymentMethodDrop;
	
	@FindBy(xpath = "//mat-select[contains(@name,'repaymentMethod')]//div[contains(@class,'mat-select-value')]")
	private WebElement advanceRepaymentMethod;
	
	@FindBy(xpath = "//mat-grid-list[2]//h4[1]//span[1]")
	private WebElement repaymentMethodFeesHeldLabel;
	
	@FindBy(xpath = "//mat-grid-list[2]//h4[1]//span[2]")
	private WebElement repaymentMethodFeesHeldValue;

	@FindBy(xpath = "//input[contains(@formcontrolname,'retainedInterestUtilizationAmount')]")
	private WebElement retainedInterestUtilization;
	
	@FindBy(xpath = "//input[contains(@formcontrolname,'cashCollateralUtilizationAmount')]")
	private WebElement cashCollateralUtilized;
	
	@FindBy(xpath = "//input[contains(@formcontrolname,'excessPaymentUtilizationAmount')]")
	private WebElement advanceUtilized;
	
	@FindBy(xpath = "//mat-grid-list[1]//h4[1]//span[1]")
	private WebElement finalRepaymentAmountLabel;
	
	@FindBy(xpath = "//mat-grid-list[1]//h4[1]//span[2]")
	private WebElement finalRepaymentAmountValue;
	
	@FindBy(xpath = "//mat-grid-list[1]//h4[2]//span[1]")
	private WebElement totalApportionedAmountLabel;
	
	@FindBy(xpath = "//mat-grid-list[1]//h4[2]//span[2]")
	private WebElement totalApportionedAmountValue;
	
	@FindBy(xpath = "//mat-grid-list[1]//h4[3]//span[1]")
	private WebElement totalDuesLabel;
	
	@FindBy(xpath = "//mat-grid-list[1]//h4[3]//span[2]")
	private WebElement totalDuesValue;
	
	@FindBy(xpath = "//mat-select[contains(@placeholder,'Apportion')]//div[contains(@class,'mat-select-arrow-wrapper')]")
	private WebElement apportioningMethodDrop;
	
	@FindBy(xpath = "//*[contains(@id,'cdk-overlay')]/div/div/mat-option")
	private List<WebElement> apportioningMethodDropDownValues;
	
	@FindBy(xpath = "//mat-select[contains(@placeholder,'Apportion')]//div[contains(@class,'mat-select-value')]")
	private WebElement apportioningMethod;
	
	@FindBy(xpath = "//mat-grid-tile[1]//h4/span")
	private WebElement excessOrShortfallLabel;
	
	@FindBy(xpath = "//mat-grid-tile[1]//h4")
	private WebElement excessOrShortfallValue;
	
	@FindBy(xpath = "//mat-grid-tile[3]//h4")
	private WebElement applidExcessValue;
	
	@FindBy(xpath = "//mat-grid-tile[1]//i")
	private WebElement excessOrShortfallText;

	@FindBy(xpath = "//mat-select[contains(@name,'applyExcessTo')]//div[contains(@class,'mat-select-value')]")
	private WebElement applyExcessOrShortFall;
	
	@FindBy(xpath = "//span[@class='mat-option-text']")
	private WebElement applyExcessOrShortFallDrop;
	
	@FindBy(xpath = "//mat-dialog-container//form//h4[1]//div[2]")
	private WebElement principalDueAmountInApportion;
	
	@FindBy(xpath = "//mat-dialog-container//form//h4[2]//div[2]")
	private WebElement interestDueAmountInApportion;
	
	@FindBy(xpath = "//mat-dialog-container//form//h4[3]//div[2]")
	private WebElement overdueAmountInApportion;

	@FindBy(xpath = "//mat-dialog-container//form//input[@name='principalPaid']")
	private WebElement principalApportioned;

	
	@FindBy(xpath = "//mat-dialog-container//form//input[@name='interestPaid']")
	private WebElement interestApportioned;

	
	@FindBy(xpath = "//mat-dialog-container//form//input[@name='overdueInterestPayment']")
	private WebElement overdueInterestApportioned;

	
	@FindBy(xpath = "//mat-dialog-container//form//button//span[contains(.,'SAVE')]")
	private WebElement saveButtonModal2;

	
	@FindBy(xpath = "//mat-dialog-container//form//button//span[contains(.,'CANCEL')]")
	private WebElement cancelButtonModal2;

	// Repayment Side Tab
	@FindBy(xpath = "//h3[contains(@class,'model-header-title')]")
	private WebElement repaymentSideTabHeading;

	@FindBy(xpath = "//p[@class='italic-message ng-star-inserted']")
	private WebElement noRecordFoundMessage;

	@FindBy(xpath = "//button[@class=\"btnpicker btnpickerenabled\"]")
	private WebElement calendarbutton;

	@FindBy(xpath = "//mat-select[@placeholder='Repayment Method']//div//div//div")
	private WebElement repaymentmethodarrow;

	@FindBy(xpath = "//p[contains(text(),\"due\")]")
	private WebElement warning;

	// Repayment Inquiry - Added
	@FindBy(xpath = "(//figure[contains(@class,'mat-figure')])[3]")
	private WebElement finalRepayAmountInInquiry;

	@FindBy(xpath = "(//figure[contains(@class,'mat-figure')])[4]")
	private WebElement createdOnInInquiry;

	@FindBy(xpath = "(//figure[contains(@class,'mat-figure')])[5]")
	private WebElement repaymentAmountInInquiry;

	@FindBy(xpath = "(//figure[contains(@class,'mat-figure')])[6]")
	private WebElement interestPaidInInquiry;

	@FindBy(xpath = "(//figure[contains(@class,'mat-figure')])[7]")
	private WebElement principalPaidInInquiry;

	@FindBy(xpath = "(//figure[contains(@class,'mat-figure')])[8]")
	private WebElement goodwillAmountInInquiry;

	// Transaction Inquiry - Added
	@FindBy(xpath = "(//figure[contains(@class,'mat-figure')])[8]")
	private WebElement creditAmountInTransactionInquiry;

	@FindBy(xpath = "(//figure[contains(@class,'mat-figure')])[9]")
	private WebElement debitAmountInTransactionInquiry;

	public WebElement getRepaymentModalHeading() {
		return visibilityOf(repaymentModalHeading);
	}
	
	public WebElement getDateLabel() {
		return dateLabel;
	}

	public WebElement getRepaymentAmountLabel() {
		return repaymentAmountLabel;
	}

	public WebElement getCustomerName() {
		return visibilityOf(customerName);
	}

	public WebElement getAccountId() {
		return visibilityOf(accountId);
	}

	public WebElement getApprovedAmount() {
		return visibilityOf(approvedAmount);
	}

	public WebElement getCloseModalButton() {
		return visibilityOf(closeModalButton);
	}

	public WebElement getCancelModalButton() {
		return visibilityOf(cancelModalButton);
	}

	public WebElement getSubmitRepaymentModalButton() {
		return submitRepaymentModalButton;
	}

	public WebElement getAdvanceRepaymentModalButton() {
		return visibilityOf(advanceRepaymentModalButton);
	}

	public WebElement getRepaymentDate() {
		return visibilityOf(repaymentDate);
	}
	
	public WebElement getTodayDate() {
		return visibilityOf(todayDate);
	}

	public WebElement getCalendarSelector() {
		return calanderSelector;
	}

	public WebElement getRepaymentAmount() {
		return visibilityOf(repaymentAmount);
	}

	public WebElement getRepaymentSideTabHeading() {
		return visibilityOf(repaymentSideTabHeading);
	}

	public WebElement getNoRecordFoundMessage() {
		return visibilityOf(noRecordFoundMessage);
	}

	public void setRepaymentAmount(String input) {
		visibilityOf(repaymentAmount).sendKeys(input);
	}

	public void setRepaymentDate(String input) {
		visibilityOf(repaymentDate).sendKeys(input);
	}



	public void clickcalendar() {
		click(calendarbutton);
	}

	public void clickwarning() {
		click(warning);
	}

	public String getrepaymentdatetext() {
		return visibilityOf(repaymentDate).getAttribute("value");
	}

	public void setRepaymentAmounts(String input) {
		visibilityOf(repaymentAmountinput).sendKeys(input);
		repaymentAmountinput.sendKeys(Keys.ENTER);
	}

	public String getRepaymentAmounts() {
		return visibilityOf(repaymentAmountinput).getAttribute("value");
	}

	public void setadvancedRepaymentAmounts(String input) {
		visibilityOf(advancedrepaymentAmountinput).sendKeys(input);
		advancedrepaymentAmountinput.sendKeys(Keys.ENTER);
	}

	public void setRetainedInterestUtilization(String input) {
		visibilityOf(retainedInterestUtilization).sendKeys(input);
		retainedInterestUtilization.sendKeys(Keys.ENTER);
	}

	public void setCashCollateralUtilized(String input) {
		visibilityOf(cashCollateralUtilized).sendKeys(input);
		cashCollateralUtilized.sendKeys(Keys.ENTER);
	}

	public void setAdvanceUtilized(String input) {
		visibilityOf(advanceUtilized).sendKeys(input);
		advanceUtilized.sendKeys(Keys.ENTER);
	}

	public String getadvancedRepaymentAmounts() {
		return visibilityOf(advancedrepaymentAmountinput).getAttribute("value");
	}

	public WebElement getRemarks() {
		return remarks;
	}

	public void setRepaymentmethod(String input) throws InterruptedException {
		click(repaymentmethodarrow);
		checkDropDown(repaymentmethoddropdown, input);
	}

	public void scrollup(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");

	}

	public void clickSaveButtonModal2() {
		visibilityOf(saveButtonModal2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		click(saveButtonModal2);
	}

	public void clickCancelButtonModal2() {
		visibilityOf(cancelButtonModal2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		click(cancelButtonModal2);
	}

	public void clickPostRepaymentCloseButton() {
		visibilityOf(postRepaymentCloseModalButton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		click(postRepaymentCloseModalButton);
	}

	public void clickCloseModaltButton() {
		visibilityOf(closeModalButton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		click(closeModalButton);
	}

	public void clickNormalRepaymentButton() {
		visibilityOf(normalRepaymentModalButton);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		click(normalRepaymentModalButton);
	}

	public WebElement getShowDuesButton() {
		return visibilityOf(advanceRepaymentShowDuesButton);
	}

	public WebElement getPostRepaymentCloseModalButton() {
		return visibilityOf(postRepaymentCloseModalButton);
	}

	public WebElement getNormalRepaymentModalButton() {
		return visibilityOf(normalRepaymentModalButton);
	}

	public WebElement getNotifierMessage() {
		return visibilityOf(notifierMessage);
	}

	public WebElement getNotifier() {
		return  visibilityOf(notifier);
	}

	public WebElement getApportioningMethod() {
		return visibilityOf(apportioningMethod);
	}

	public List<WebElement> getApportioningMethodDropDownValues() throws InterruptedException {
		return visibilityOf(apportioningMethodDropDownValues);
	}

	public List<WebElement> getRepaymentmethoddropdown() throws InterruptedException {
		return visibilityOf(repaymentmethoddropdown);
	}

	public void setRepaymentMethod(String input) throws InterruptedException {
		click(repaymentMethod);
		checkDropDown(repaymentmethoddropdown, input);
	}

	public void setAdvanceRepaymentMethod(String input) throws InterruptedException {
		click(advanceRepaymentMethod);
		checkDropDown(repaymentmethoddropdown, input);
	}

	public void setApportioningMethod(String input) throws InterruptedException {
		click(apportioningMethod);
		checkDropDown(repaymentmethoddropdown, input);
	}

	public WebElement getApplyExcessOrShortFallDrop() {
		return applyExcessOrShortFallDrop;
	}

	public WebElement getRepaymentMethod() {
		return visibilityOf(repaymentMethod);
	}

	public WebElement getRepaymentMethodFeesHeldLabel() {
		return visibilityOf(repaymentMethodFeesHeldLabel);
	}

	public WebElement getRepaymentMethodFeesHeldValue() {
		return visibilityOf(repaymentMethodFeesHeldValue);
	}

	public WebElement getRetainedInterestUtilization() {
		return visibilityOf(retainedInterestUtilization);
	}

	public WebElement getCashCollateralUtilized() {
		return visibilityOf(cashCollateralUtilized);
	}

	public WebElement getAdvanceUtilized() {
		return visibilityOf(advanceUtilized);
	}

	public WebElement getFinalRepaymentAmountLabel() {
		return visibilityOf(finalRepaymentAmountLabel);
	}

	public WebElement getFinalRepaymentAmountValue() {
		return visibilityOf(finalRepaymentAmountValue);
	}

	public WebElement getTotalApportionedAmountLabel() {
		return visibilityOf(totalApportionedAmountLabel);
	}

	public WebElement getTotalApportionedAmountValue() {
		return visibilityOf(totalApportionedAmountValue);
	}

	public WebElement getTotalDuesLabel() {
		return visibilityOf(totalDuesLabel);
	}

	public WebElement getTotalDuesValue() {
		return visibilityOf(totalDuesValue);
	}

	public WebElement getPrincipalDueAmountInApportion() {
		return visibilityOf(principalDueAmountInApportion);
	}

	public WebElement getInterestDueAmountInApportion() {
		return visibilityOf(interestDueAmountInApportion);
	}

	public WebElement getOverdueAmountInApportion() {
		return visibilityOf(overdueAmountInApportion);
	}

	public WebElement getPrincipalApportioned() {
		return visibilityOf(principalApportioned);
	}

	public WebElement getInterestApportioned() {
		return visibilityOf(interestApportioned);
	}

	public WebElement getOverdueInterestApportioned() {
		return visibilityOf(overdueInterestApportioned);
	}

	public WebElement getExcessOrShortfallText() {
		return visibilityOf(excessOrShortfallText);
	}

	public WebElement getExcessOrShortfall() {
		return visibilityOf(applyExcessOrShortFall);
	}

	public String getExcessOrShortfallLabel() {
		return visibilityOf(excessOrShortfallLabel).getText();
	}

	public String getExcessOrShortfallValue() {
		return visibilityOf(excessOrShortfallValue).getText().split(":")[1].split(" ")[1].split(" ")[0];
	}

	public WebElement getApplidExcessValueWebElement() {
		return visibilityOf(applidExcessValue);
	}

	public String getApplidExcessValue() {
		return visibilityOf(applidExcessValue).getText().split(":")[1].trim();
	}

	public WebElement getPrincipalDue() {
		return visibilityOf(principalDue);
	}

	public WebElement getInterestDue() {
		return visibilityOf(interestDue);
	}

	public WebElement getFinalRepayment() {
		return visibilityOf(finalRepayment);
	}

	public WebElement getTotalPrincipalPaid() {
		return visibilityOf(totalPrincipalPaid);
	}

	public WebElement getTotalInterestPaid() {
		return visibilityOf(totalInterestPaid);
	}

	public WebElement getFinalRepayAmountInInquiry() {
		return visibilityOf(finalRepayAmountInInquiry);
	}

	public WebElement getCreatedOnInInquiry() {
		return visibilityOf(createdOnInInquiry);
	}

	public WebElement getRepaymentAmountInInquiry() {
		return visibilityOf(repaymentAmountInInquiry);
	}

	public WebElement getInterestPaidInInquiry() {
		return visibilityOf(interestPaidInInquiry);
	}

	public WebElement getPrincipalPaidInInquiry() {
		return visibilityOf(principalPaidInInquiry);
	}

	public WebElement getGoodwillAmountInInquiry() {
		return visibilityOf(goodwillAmountInInquiry);
	}

	public WebElement getCreditAmountInTransactionInquiry() {
		return visibilityOf(creditAmountInTransactionInquiry);
	}

	public WebElement getDebitAmountInTransactionInquiry() {
		return visibilityOf(debitAmountInTransactionInquiry);
	}

	public WebElement getSaveButtonModal2() {
		return visibilityOf(saveButtonModal2);
	}

	public WebElement getCancelButtonModal2() {
		return visibilityOf(cancelButtonModal2);
	}

}
