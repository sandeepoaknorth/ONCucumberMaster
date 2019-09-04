package stepDefinitions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class RateResetUndo extends DriverFactory {
	@Given("^User is in Loan Wall screen for the Customer (.+) and Account (.+)$")
	public void user_is_in_loan_wall_screen_for_the_customer_and_account(String customer, String accountnumber)
			throws Throwable {
		quickAccessPage.clickCustomer();
		commonComponentsPage.clickOnTableElement(commonComponentsPage.getTableData(), customer, 6);
		manageLoanPage.selectLoanSection(accountnumber);
	}

	@When("^User clicks \"([^\"]*)\" button for Rate Reset event$")
	public void user_clicks_something_button_for_rate_reset_event(String strArg1) throws Throwable {
		int n = transactionPage.getEventType().size();
		WebElement button;
		if (strArg1.equalsIgnoreCase("Undo")) {
			button = transactionPage.getUndoButton();
		} else {
			button = transactionPage.getRedoButton();
		}
		for (int i = n - 1; i >= 0; i--) {
			System.out.println(transactionPage.getEventType().get(i).getText());
			if (transactionPage.getEventType().get(i).getText().equalsIgnoreCase("Rate Reset")) {
				button.click();
				commonComponentsPage.zoomInZoomOut("0.9");
				transactionPage.comments();
				break;
			} else {
				button.click();
				commonComponentsPage.zoomInZoomOut("0.9");
				transactionPage.comments();
				user_clicks_on_transaction_section();
			}
		}
	}

	@Then("^Even gets reversed$")
	public void even_gets_reversed() throws Throwable {
		Thread.sleep(3000);
		user_clicks_on_transaction_section();
		if (transactionPage.getRedoButton().isDisplayed()) {
			System.out.println("Rate Reset Undo happened successfully!");
		} else {
			Assert.fail("Rate Reset Undo not happened successfully!");
		}
	}

	@And("^User clicks on Transaction section$")
	public void user_clicks_on_transaction_section() throws Throwable {
		transactionPage.jsClick(manageLoanPage.getTransactionButton());
	}
}
