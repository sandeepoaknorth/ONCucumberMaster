package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import utils.DriverFactory;

public class ContactUsSteps extends DriverFactory {

	@Given("^The user is on Repayment Page$")
	public void the_user_is_on_RepaymentPage() throws Exception {
//		Reporter.addStepLog("Accessing Loan Section.");
		quickAccessPage.clickCustomer();
		customerMainPage.clickaccountActionView("Active");
		manageLoanPage.selectLoanSection();
//		Reporter.addStepLog("Clicking on Repayment Button.");
		manageLoanPage.clickRepayment();
	}

	@When("^He clicks on Advance Payment button$")
	public void he_clicks_on_AdvancePaymentbutton() throws Exception {
		repaymentPage.clickRepaymentModeButton();
	}

	@Then("^Check for Name_Account ID_Approved Amount_Cancel-Button_Remarks$")
	public void check_for_Name_Account_ID_ApprovedAmount_CancelButton_Remarks() throws Exception {
		repaymentPage.checkCommonFields_group1();
	}

	@And("^Clicks on Repayment Dropdown$")
	public void clicks_on_Repayment_Dropdown() throws Exception {
		repaymentPage.clickRepaymentDropDown();
	}

	@Then("^Check for Advance Repayment DropDown values$")
	public void check_for_Advance_Repayment_DropDown_values() throws Exception {
		repaymentPage.checkAdvancedRepaymentDropDown();
		Assert.fail();
	}

	@And("^Selects any Repayment Method$")
	public void selects_any_Repayment_Method() throws Exception {
		repaymentPage.clickAdvancedRepaymentDropDown("            Deduct from Cash collateral          ");
	}

	@Then("^Check for all common fields$")
	public void check_for_all_common_fields() throws Exception {
		repaymentPage.checkCommonFields_group2();
	}

	@And("^Selects any date$")
	public void selects_any_date() throws Exception {
		repaymentPage.selectDate("Past");
	}

	@Then("^Check for Show Dues and Submit button$")
	public void check_for_Show_Dues_and_Submit_button() throws Exception {
		softAssert.assertEquals(repaymentPage.getShowDuesButton().isEnabled(), true,
				"Show Dues Button is not enabled in Advance Repayment Modal after selecting date.");
		softAssert.assertEquals(repaymentPage.getSubmitRepaymentModalButton().isEnabled(), false,
				"Submit Button is enabled in Advance Repayment Modal before clicking Show Dues.");
		softAssert.assertAll();
	}

}
