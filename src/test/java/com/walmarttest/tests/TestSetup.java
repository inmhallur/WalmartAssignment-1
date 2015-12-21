package com.walmarttest.tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestSetup {
	private WebDriver driver;
	//Location of chromedriver
	static String driverPath = "C:\\Software\\chromedriver_win32\\chromedriver.exe";

	public WebDriver getDriver() {
		return driver;
	}

	//Based on the Browser type selecting appropriate browser for running the test.
	private void setDriver(String browserType, String appURL, String deviceType) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		case "mobile":
			driver = initMobileDriver(appURL, deviceType);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Chrome as browser of choice..");
			driver = initChromeDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome browser..");
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}
	
	private static WebDriver initMobileDriver(String appURL, String deviceType) {
		System.out.println("Launching Browser in device: "+deviceType);
		System.setProperty("webdriver.chrome.driver", driverPath);
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", deviceType);
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		WebDriver driver = new ChromeDriver(capabilities);
		driver.get(appURL);
		return driver;
	}

	@Parameters({ "browserType", "appURL", "deviceType" })
	@BeforeMethod
	public void initializeSetup(String browserType, String appURL, String deviceType) {
		try {
			setDriver(browserType, appURL, deviceType);

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
