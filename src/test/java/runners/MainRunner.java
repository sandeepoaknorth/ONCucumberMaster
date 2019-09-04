package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(glue = "stepDefinitions", features = {
		"target/parallel/features/[CUCABLE:FEATURE].feature" }, monochrome = true, tags = { "~@ignore" }, plugin = {
				"pretty", "html:target/cucumber", "json:target/cucumber-report/[CUCABLE:RUNNER].json",
				"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" })

public class MainRunner extends AbstractTestNGCucumberTests {
//	@AfterClass
//	public static void writeExtentReport() throws IOException {
//		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "\\src\\main\\java\\utils\\ReportsConfig.xml"));
//		BasePage.copyLatestExtentReport();
//	}
}