package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilites.Helper;

public class Testbase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;

	public static String downloadFilepath = System.getProperty("user.dir") + "\\Downloads";
	public static ChromeOptions chromeoptions() {
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromepre = new HashMap<String, Object>();
		chromepre.put("profile.default_content_settings.popups", 0);
		chromepre.put("download.default_directory", downloadFilepath);
		options.setExperimentalOption("prefs", chromepre);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.addArguments("disable-infobars");
		options.addArguments("disable-extensions");
		options.addArguments("--disable-notifications");
		return options;
	}

	public static FirefoxOptions firefoxoptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", downloadFilepath);
		options.addPreference("browser.download.defaultFolder", downloadFilepath);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
		options.addPreference("browser.download.manager.showWhenStarting", false);
		return options;
	}

	@BeforeSuite
	@Parameters({"browser"})
	public void StartDriver(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(chromeoptions());
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver(firefoxoptions());
			
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com");
	}

	@AfterMethod
	public void screenshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Taking ScreenShot.....");
			// object
			Helper.caputerScreenshot(driver, result.getName());
		}
	}

	// new
	public String genRand() {
		String str = "abcdefghijklmnopqrstuvxyz";
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			int index = (int) (str.length() * Math.random());
			builder.append(str.charAt(index));
		}
		return builder.toString();
	}

	@AfterSuite
	public void StopDriver() {
		driver.quit();
	}

}
