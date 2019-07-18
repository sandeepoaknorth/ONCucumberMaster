package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class DriverFactory {
	public static WebDriver driver;
	public static pageObjects.pageActions.ContactUs_Page contactUsPage;
	public static pageObjects.pageActions.Products_Page productsPage;
	public static pageObjects.pageActions.Customermainpage customerMainPage;
	public static pageObjects.pageActions.Loginpage loginPage;
	public static pageObjects.pageActions.ManageLoanpage manageLoanPage;
	public static pageObjects.pageActions.Quickaccesspage quickAccessPage;
	public static pageObjects.pageActions.RepaymentPage repaymentPage;
	protected Properties prop = new Properties();
	protected SoftAssert softAssert = new SoftAssert();
	String browserName;
	protected DriverFactory() {
		try {
			FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\config.properties");
			FileInputStream loan = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\LoanAccountRepayment.properties");
			try {
				prop.load(fi);
				prop.load(loan);
			} catch (IOException e) {
				e.printStackTrace();
			}
			browserName = prop.getProperty("browser");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public WebDriver getDriver() {
		try {
			switch (browserName) {

			case "firefox":
				// code
				if (null == driver) {
					System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();
				}
				break;

			case "chrome":
				// code
				if (null == driver) {
					System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
					// CHROME OPTIONS
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				break;

			case "ie":
				// code
				if (null == driver) {
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					System.setProperty("webdriver.ie.driver", Constant.IE_DRIVER_DIRECTORY);
					capabilities.setCapability("ignoreZoomSetting", true);
					driver = new InternetExplorerDriver(capabilities);
					driver.manage().window().maximize();
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			contactUsPage = PageFactory.initElements(driver, pageObjects.pageActions.ContactUs_Page.class);
			productsPage = PageFactory.initElements(driver, pageObjects.pageActions.Products_Page.class);
			customerMainPage = PageFactory.initElements(driver, pageObjects.pageActions.Customermainpage.class);
			manageLoanPage = PageFactory.initElements(driver, pageObjects.pageActions.ManageLoanpage.class);
			repaymentPage = PageFactory.initElements(driver, pageObjects.pageActions.RepaymentPage.class);
			loginPage = PageFactory.initElements(driver, pageObjects.pageActions.Loginpage.class);
			quickAccessPage = PageFactory.initElements(driver, pageObjects.pageActions.Quickaccesspage.class);
		}
		return driver;
	}
}
