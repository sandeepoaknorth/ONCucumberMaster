package pageObjects.pageActions;

import java.text.ParseException;
import utils.Datepicker;

public class RepaymentPage extends pageObjects.pageObject.RepaymentPage {

	public void clickRepaymentModeButton() {
		scriptClick(getAdvanceRepaymentModalButton());
	}

	public void clickSubmitRepaymentButton() {
		click(getSubmitRepaymentModalButton());
	}

	public void clickCancelRepaymentButton() {
		click(getCancelModalButton());
	}

	public void clickCancel() {
		scriptClick(getCancelModalButton());
	}

	public void clickCloseRepaymentButton() {
		click(getCloseModalButton());
	}

	public void clickRepaymentDropDown() {
		try {
			click(getRepaymentMethod());
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			click(getRepaymentMethod());
		}
	}

	public void checkCommonFields_group1() {
		softAssert.assertEquals(getCustomerName().getText(), prop.getProperty("customer_name"),
				"Customer name doesn't match with the name on Loan wall.");

		softAssert.assertEquals(getAccountId().getText(), prop.getProperty("customer_id"),
				"Customer ID doesn't match with that on the Loan wall.");

		softAssert.assertEquals(getNormalRepaymentModalButton().isDisplayed(), true,
				"Normal Repayment Button is not visible in Advance Repayment Modal for Repayment Method: "
						+ getRepaymentMethod().getText());

		softAssert.assertEquals(getCancelModalButton().isDisplayed(), true,
				"Cancel Repayment Button is not visible in Advance Repayment Modal for Repayment Method: "
						+ getRepaymentMethod().getText());

		softAssert.assertEquals(getRemarks().isDisplayed(), true,
				"Remarks text field is not visible in Advance Repayment Modal for Repayment Method: "
						+ getRepaymentMethod().getText());
		softAssert.assertAll();
	}

	public void checkCommonFields_group2() throws InterruptedException {
		softAssert.assertEquals(getDateLabel().getText(), prop.getProperty("date_label"),
				"Date label verbiage is not correct.");

		softAssert.assertEquals(getRepaymentAmountLabel().getText(), prop.getProperty("repayment_amount_label"),
				"Repayment Amount label verbiage is not correct.");

		softAssert.assertEquals(getFinalRepaymentAmountLabel().getText(),
				prop.getProperty("final_repayment_amount_label"),
				"Final Repayment Amount label verbiage is not correct.");

		softAssert.assertEquals(getTotalApportionedAmountLabel().getText(),
				prop.getProperty("total_apportioned_amount_label"),
				"Total Apportioned Amount label verbiage is not correct.");

		softAssert.assertEquals(getTotalDuesLabel().getText(), prop.getProperty("total_dues_label"),
				"Total Dues label verbiage is not correct.");

		softAssert.assertEquals(getRepaymentDate().isDisplayed(), true,
				"Repayment date field is not visible in Advance Repayment Modal for Repayment Method: "
						+ getRepaymentMethod().getText());

		softAssert.assertEquals(getRepaymentAmount().isDisplayed(), true,
				"Repayment amount field is not visible in Advance Repayment Modal for Repayment Method: "
						+ getRepaymentMethod().getText());

		softAssert.assertEquals(getShowDuesButton().isEnabled(), false,
				"Show Dues button is enabled in Advance Repayment Modal for Repayment Method before selecting date: "
						+ getRepaymentMethod().getText());

		softAssert.assertEquals(getSubmitRepaymentModalButton().isEnabled(), false,
				"Show Dues button is enabled in Advance Repayment Modal for Repayment Method before selecting date: "
						+ getRepaymentMethod().getText());

		scriptClick(getApportioningMethod());
		for (int i = 0; i < getApportioningMethodDropDownValues().size(); i++) {
			softAssert.assertEquals(getApportioningMethodDropDownValues().get(i).getText(),
					prop.getProperty("apportioning_method" + (i + 1)),
					"Apportioning method " + prop.getProperty("apportioning_method" + (i + 1))
							+ " verbiage is not correct in Advance Repayment Section.");
			softAssert.assertAll();
		}
		softAssert.assertAll();
	}

	public void checkAdvancedRepaymentDropDown() throws InterruptedException {
		System.out.println(prop.getProperty("advance_repayment_method_option1"));
		checkDropDown(getRepaymentmethoddropdown(), prop.getProperty("advance_repayment_method_option1"),
				prop.getProperty("advance_repayment_method_option2"),
				prop.getProperty("advance_repayment_method_option3"),
				prop.getProperty("advance_repayment_method_option4"),
				prop.getProperty("advance_repayment_method_option5"));
	}

	public void clickAdvancedRepaymentDropDown(String repayment_method) throws InterruptedException {
		int size = getRepaymentmethoddropdown().size();
		scriptClick(getRepaymentmethoddropdown().get(0));
//		for(int i=0; i<size; i++) {
//			if(getRepaymentmethoddropdown().get(i).getText().equalsIgnoreCase(repayment_method)) {
//				getRepaymentmethoddropdown().get(i).click();
//				break;
//			}
	}

	public void selectDate(String PastPresentToday) {
		Datepicker datePicker = new Datepicker();
		String randomDate;
		try {
			randomDate = datePicker.selectDate(PastPresentToday);
			getRepaymentDate().sendKeys(randomDate);
		} catch (ParseException e) {
			selectDate(PastPresentToday);
		}
	}

}
