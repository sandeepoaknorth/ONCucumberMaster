

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        glue = "stepDefinitions",
        features = {"target/parallel/features/InterestRateMaintenance_Dynamic_scenario001_run001_IT.feature"},
		monochrome = true,
		tags = {"~@ignore"}, 
		plugin = { "pretty", "html:target/cucumber", "json:target/cucumber-report/InterestRateMaintenance_Dynamic_scenario001_run001_IT.json",
        				"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" }
        )

public class InterestRateMaintenance_Dynamic_scenario001_run001_IT {
//	@AfterClass
//	public static void writeExtentReport() throws IOException {
//		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "\\src\\main\\java\\utils\\ReportsConfig.xml"));
//		BasePage.copyLatestExtentReport();
//	}
}

// Generated by Cucable from src/test/java/runners/CucableRunner.java