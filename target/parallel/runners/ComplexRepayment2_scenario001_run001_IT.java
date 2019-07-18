

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import pageObjects.BasePage;

import java.io.File;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

@RunWith(Cucumber.class)

@CucumberOptions(
        glue = "stepDefinitions",
        features = {"target/parallel/features/ComplexRepayment2_scenario001_run001_IT.feature"},
		monochrome = true,
		tags = {"@Sanity, @Regression, @Smoke"}, 
		plugin = { "pretty", "html:target/cucumber", "json:target/cucumber-report/ComplexRepayment2_scenario001_run001_IT.json",
        				"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" }
        )

public class ComplexRepayment2_scenario001_run001_IT {
//	@AfterClass
//	public static void writeExtentReport() throws IOException {
//		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "\\src\\main\\java\\utils\\ReportsConfig.xml"));
//		BasePage.copyLatestExtentReport();
//	}
}

// Generated by Cucable from src/test/java/runners/CucableRunner.java
