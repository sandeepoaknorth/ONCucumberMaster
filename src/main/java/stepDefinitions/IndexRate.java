package stepDefinitions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;
import utils.JavaOnlyMethods;

public class IndexRate extends DriverFactory {
	@Given("^User is in Index Rate Setup screen$")
	public void user_is_in_index_rate_setup_screen() throws Throwable {
		quickAccessPage.clickIndexRate();
	}

	@When("^User provides valid Index Rate Setup inputs (.+), (.+), (.+), (.+), (.+), (.+)$")
	public void user_provides_valid_index_rate_setup_inputs_(String indextype, String name, String currency,
			String tenorvalue, String tenorfrequency, String testscenario) throws Throwable {
		indexRatePage.getIndexName().sendKeys(name);
		commonComponentsPage.getCurrency().click();
		commonComponentsPage.selectDropDown(currency);
		if (indextype.equalsIgnoreCase("fixed")) {
			indexRatePage.fixedTenorYes();
			indexRatePage.getTenorValue().sendKeys(tenorvalue);
			indexRatePage.getTenorFrequency().click();
			commonComponentsPage.selectDropDown(tenorfrequency);
		}
	}

	@When("^User provides (.+) or (.+)$")
	public void user_provides_or(String str, String name) throws Throwable {
		indexRatePage.getToggleButton().click();
		String currency = str;
		String index = name;
		if (str.equalsIgnoreCase("null")) {
			currency = "";
		} else if (name.equalsIgnoreCase("null")) {
			index = "";
		}
		indexRatePage.actionSendKeys(indexRatePage.getFilterByCurrency(), currency);
		indexRatePage.actionSendKeys(indexRatePage.getFilterByIndex(), index);
	}

	@When("^User clicks on soft_delete button for any Index$")
	public void user_clicks_on_softdelete_button_for_any_index() throws Throwable {
		throw new PendingException();
	}

	@Then("^Index details (.+), (.+), (.+), (.+), (.+) appears under Interest Rate Index List table$")
	public void index_details_appears_under_interest_rate_index_list_table(String rateIndex, String name,
			String currency, String tenorvalue, String tenorfrequency) throws Throwable {
		String currencyCode = currency.substring(currency.length() - 3);
		if (rateIndex.equalsIgnoreCase("Variable")) {
			tenorvalue = "NA";
		}
		commonComponentsPage.validateTableEntry(name, currencyCode, tenorvalue);
	}

	@Then("^Indexes should be filtered out based (.+) or (.+)$")
	public void indexes_should_be_filtered_out_based_or(String str, String name) throws Throwable {
		String currency = str;
		String index = name;
		if (str.equalsIgnoreCase("null")) {
			currency = "";
		}
		if (name.equalsIgnoreCase("null")) {
			index = "";
		}
		Thread.sleep(1000);
		int totalRows = Integer.parseInt(commonComponentsPage.getPaginationTotalRows().getText());
		int rowsPerPage = Integer.parseInt(commonComponentsPage.getPaginationRowsPerPage().getText());
		int page = totalRows / rowsPerPage;
		int count = 0;
		try {
			for (int j = 0; j <= page; j++) {
				int rows = commonComponentsPage.getTableRows().size();
				for (int i = 0; i < rows; i++) {
					List<WebElement> rowElement = commonComponentsPage.getTableRows().get(i)
							.findElements(By.tagName("td"));
					if (rowElement.get(0).findElement(By.tagName("div")).getText().toLowerCase()
							.contains(index.toLowerCase())
							&& rowElement.get(1).findElement(By.tagName("div")).getText().toLowerCase()
									.contains(currency.toLowerCase())) {
						System.out.println("Index: " + rowElement.get(0).findElement(By.tagName("div")).getText()
								+ " Currency: " + rowElement.get(1).findElement(By.tagName("div")).getText());
						count++;
					}
				}
				if (j < page) {
					indexRatePage.jsPageScrollIntoView(commonComponentsPage.getPaginationNext());
					indexRatePage.scriptClick(commonComponentsPage.getPaginationNext());
					Thread.sleep(1000);
				}
			}
			System.out.println("Total entries found : " + count);
		} catch (Exception e) {
			System.out.println("Invalid Entry/ Entry not found." + e);
		}
	}

	@And("^Clicks on Update button$")
	public void clicks_on_update_button() throws Throwable {
		interestRateMaintenancePage.clickUpdate();
	}

	@And("^Index should appear in Loan creation page$")
	public void index_something_appear_in_loan_creation_page() throws Throwable {
		throw new PendingException();
	}

	@And("^Index should not appear in rate maintenance if currency is selected$")
	public void index_should_not_appear_in_rate_maintenance_if_currency_is_selected() throws Throwable {
		throw new PendingException();
	}

	@When("^User provides valid Index Rate Setup inputs$")
	public void user_provides_valid_index_rate_setup_inputs() throws Throwable {
		JavaOnlyMethods j = new JavaOnlyMethods();
		indexRatePage.fixedTenorYes();
		indexRatePage.getIndexName().sendKeys(j.getAlphaNumericString(10));
		commonComponentsPage.getCurrency().click();
		int randomCurrency = j.getRandomNum(commonComponentsPage.getDropDown().size());
		commonComponentsPage.getDropDown().get(randomCurrency - 1).click();
		indexRatePage.getTenorValue().sendKeys("" + j.getRandomNum(100) + "");
		indexRatePage.clickFrequency();
		int randomFrequency = j.getRandomNum(commonComponentsPage.getDropDown().size());
		commonComponentsPage.getDropDown().get(randomFrequency).click();
	}

	@Then("^User should see all UI elements of Index Rate Setup screen$")
	public void user_should_see_all_ui_elements_something() throws Throwable {
		indexRatePage.fixedTenorYes();
		indexRatePage.assertString(indexRatePage.getIndexRateHeaderVerbiage(),
				prop.getProperty("indexRateHeaderVerbiage"));
		indexRatePage.assertString(indexRatePage.getIndexNameVerbiage(), prop.getProperty("indexNameVerbiage"));
		indexRatePage.assertString(indexRatePage.getTenorValueVerbiage(), prop.getProperty("tenorValueVerbiage"));
		indexRatePage.assertString(indexRatePage.getTenorFrequencyVerbiage(),
				prop.getProperty("tenorFrequencyVerbiage"));
		indexRatePage.assertString(indexRatePage.getToggleButtonVerbiage(), prop.getProperty("toggleButtonVerbiage"));
		indexRatePage.assertString(indexRatePage.getTableHeaderVerbiage(), prop.getProperty("tableHeaderVerbiage"));
		indexRatePage.checkDropDown(indexRatePage.getTableColumnHeaderVerbiages(),
				prop.getProperty("tableColumnHeaderVerbiage1"), prop.getProperty("tableColumnHeaderVerbiage2"),
				prop.getProperty("tableColumnHeaderVerbiage3"), prop.getProperty("tableColumnHeaderVerbiage4"));
	}

	@Then("^Provided inputs should be cleaned$")
	public void provided_inputs_should_be_cleaned() throws Throwable {
		softAssert.assertEquals(indexRatePage.getIndexName().getText(), "");
		softAssert.assertEquals(indexRatePage.getTenorValue().getText(), "");
		softAssert.assertAll();
	}

	@And("^User should see all the supported currencies$")
	public void user_should_see_all_the_supported_currencies() throws Throwable {
		commonComponentsPage.getBody().click();
		commonComponentsPage.getCurrency().click();
		commonComponentsPage.checkDropDown("currency");
	}

	@And("^User should see all the supported frequencies$")
	public void user_should_see_all_the_supported_frequencies() throws Throwable {
		commonComponentsPage.getBody().click();
		indexRatePage.clickFrequency();
		commonComponentsPage.checkDropDown("tenorFrequency");
	}

	@And("^Clicks on Reset button$")
	public void clicks_on_reset_button() throws Throwable {
		indexRatePage.clickRefresh();
	}
}
