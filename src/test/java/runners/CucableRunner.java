package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(glue = "stepDefinitions", features = {
		"target/parallel/features/[CUCABLE:FEATURE].feature" }, monochrome = true, tags = { "~@ignore" }, plugin = {
				"pretty", "html:target/cucumber", "json:target/cucumber-report/[CUCABLE:RUNNER].json",
				"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" })

public class CucableRunner {

}