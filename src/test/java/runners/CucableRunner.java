package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import utils.DriverFactory;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@RunWith(Cucumber.class)

@CucumberOptions(
        glue = "stepDefinitions",
        features = {"target/parallel/features/[CUCABLE:FEATURE].feature"},
		monochrome = true,
		tags = {"~@ignore"}, 
		plugin = { "pretty", "html:target/cucumber", "json:target/cucumber-report/[CUCABLE:RUNNER].json",
        				"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" }
        )

public class CucableRunner{

}