package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class DriverFactory {
	public static WebDriver driver;
	public static pageObjects.pageActions.Customermainpage customerMainPage;
	public static pageObjects.pageActions.Loginpage loginPage;
	public static pageObjects.pageActions.ManageLoanpage manageLoanPage;
	public static pageObjects.pageActions.Quickaccesspage quickAccessPage;
	public static pageObjects.pageActions.RepaymentPage repaymentPage;
	public static pageObjects.pageActions.InterestRateMaintenancePage interestRateMaintenancePage;
	public static pageObjects.pageActions.IndexRatePage indexRatePage;
	public static pageObjects.pageActions.CommonComponents commonComponentsPage;
	public static pageObjects.pageActions.TransactionPage transactionPage;
	protected Properties prop = new Properties();
	protected SoftAssert softAssert = new SoftAssert();
	String browserName;

	protected DriverFactory() {
		try {
			FileInputStream fi = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\properties\\Config.properties");
			FileInputStream loan = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\properties\\LoanAccountRepayment.properties");
			FileInputStream commonComponents = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\properties\\CommonComponents.properties");
			FileInputStream indexRate = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\properties\\IndexRate.properties");
			FileInputStream interestRateMaintenance = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\properties\\InterestRateMaintenance.properties");
			try {
				prop.load(fi);
				prop.load(loan);
				prop.load(commonComponents);
				prop.load(indexRate);
				prop.load(interestRateMaintenance);
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
				
			case "remote":
				if (null == driver) {
					driver= new RemoteWebDriver(new URL("http://172.10.1.168:4444/wd/hub"), new ChromeOptions());
				}
				break;
			}
		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			customerMainPage = PageFactory.initElements(driver, pageObjects.pageActions.Customermainpage.class);
			manageLoanPage = PageFactory.initElements(driver, pageObjects.pageActions.ManageLoanpage.class);
			repaymentPage = PageFactory.initElements(driver, pageObjects.pageActions.RepaymentPage.class);
			loginPage = PageFactory.initElements(driver, pageObjects.pageActions.Loginpage.class);
			quickAccessPage = PageFactory.initElements(driver, pageObjects.pageActions.Quickaccesspage.class);
			interestRateMaintenancePage = PageFactory.initElements(driver,
					pageObjects.pageActions.InterestRateMaintenancePage.class);
			indexRatePage = PageFactory.initElements(driver, pageObjects.pageActions.IndexRatePage.class);
			commonComponentsPage = PageFactory.initElements(driver, pageObjects.pageActions.CommonComponents.class);
			transactionPage = PageFactory.initElements(driver, pageObjects.pageActions.TransactionPage.class);
		}
		return driver;
	}
}
