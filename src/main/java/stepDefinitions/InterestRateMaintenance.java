package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;
import utils.JavaOnlyMethods;

public class InterestRateMaintenance extends DriverFactory {
	@Given("^User is in Interest Rate Maintenance screen$")
    public void user_is_in_interest_rate_maintenance_screen() {
        quickAccessPage.clickInterestRateMaintenance();
    }

    @When("^User enters future date and provides other valuews$")
    public void user_enters_future_date_and_provides_other_valuews() throws Throwable {
    	interestRateMaintenancePage.getBusinessDate().sendKeys(commonComponentsPage.selectDate("Future"));
		commonComponentsPage.getCurrency().click();
		commonComponentsPage.getDropDown().get(0).click();
		interestRateMaintenancePage.getReferenceRate().click();
		System.out.println(commonComponentsPage.getDropDown().size());
		commonComponentsPage.getDropDown().get(0).click();
		JavaOnlyMethods j = new JavaOnlyMethods();
		interestRateMaintenancePage.getValueInput().sendKeys(""+j.getRandomNum(100)+"");
    }

    @When("^User provides an invalid value$")
    public void user_provides_an_invalid_value() throws Throwable {
        interestRateMaintenancePage.getValueInput().sendKeys("10000");
        commonComponentsPage.getBody().click();
        Thread.sleep(2000);
    }

    @Then("^User should see all UI elements of Interest Rate Maintenance page$")
    public void user_should_see_all_ui_elements_of_something_page() {
    	System.out.println(prop.getProperty("rateMaintenanceHeader"));
        interestRateMaintenancePage.assertString(interestRateMaintenancePage.getRateMaintenanceHeaderVerbiage(), prop.getProperty("rateMaintenanceHeader"));
        interestRateMaintenancePage.assertString(interestRateMaintenancePage.getBusinessDateVerbiage(), prop.getProperty("businessDate"));
        interestRateMaintenancePage.assertString(interestRateMaintenancePage.getReferenceRateVerbiage(), prop.getProperty("referenceRate"));
        interestRateMaintenancePage.assertString(interestRateMaintenancePage.getValueInputVerbiage(), prop.getProperty("valueInput"));
        interestRateMaintenancePage.assertString(interestRateMaintenancePage.getHistoricRateHeaderVerbiage(), prop.getProperty("historicRateHeader"));
        interestRateMaintenancePage.assertString(interestRateMaintenancePage.getFiltorVerbiage(), prop.getProperty("filtor"));
        interestRateMaintenancePage.checkDropDown(interestRateMaintenancePage.getTableColumnVerbiages(), prop.getProperty("tableColumn1"),
        		prop.getProperty("tableColumn2"), prop.getProperty("tableColumn3"), prop.getProperty("tableColumn4"));
    }

    @Then("^System should throw a notification error for \"([^\"]*)\"$")
    public void system_should_throw_an_error_for_something(String strArg1) throws Throwable {
        commonComponentsPage.validateNotificErrorMessage(prop.getProperty(strArg1));
    }

    @Then("^System should throw an error \"([^\"]*)\"$")
    public void system_should_throw_an_error_something(String strArg1) throws Throwable {
        commonComponentsPage.validateErrorMessage(prop.getProperty(strArg1));
    }

    @When("^User provides all mandatory details like (.+), (.+), (.+), (.+), (.+)$")
    public void user_provides_all_mandatory_details_like_(String businessdate, String currency, String referencerate, String value, String testscenario) throws Throwable {
    	System.out.println("Running scenario: "+testscenario);
    	String datee;
    	if(businessdate.equalsIgnoreCase("past")) {
    		datee = commonComponentsPage.selectDate(businessdate);
        	interestRateMaintenancePage.getBusinessDate().sendKeys(datee);
    	} else {
    		commonComponentsPage.getDatePicker().click();
    		commonComponentsPage.selectDate();
    		datee = interestRateMaintenancePage.getBusinessDate().getText();
    	}
    	commonComponentsPage.getCurrency().click();
    	commonComponentsPage.selectDropDown(currency);
    	interestRateMaintenancePage.getReferenceRate().click();
    	commonComponentsPage.selectDropDown(referencerate);
    	interestRateMaintenancePage.getValueInput().sendKeys(value);
    }

    @Then("^Provided interest details (.+), (.+), (.+)should be added and visible under Historic Dates table$")
    public void provided_interest_details_should_be_added_and_visible_under_historic_dates_table(String businessdate, String referencerate, String value) throws Throwable {
		double f = Double.parseDouble(value);
		value = String.format("%.5f", f);
		String datee = interestRateMaintenancePage.getBusinessDate().getText();
        commonComponentsPage.validateTableEntry(datee, referencerate, value);
    }

    @And("^Clicks on Update$")
    public void clicks_on_update() throws Throwable {
    	interestRateMaintenancePage.clickUpdate();
    }
    
    @And("^User waits for (\\d+) seconds$")
    public void user_waits_for_something_seconds(int num) throws Throwable {
    	Thread.sleep(num*1000);
    }
}
