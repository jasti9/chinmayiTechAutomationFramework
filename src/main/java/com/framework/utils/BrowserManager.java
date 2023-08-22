package com.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.framework.enums.DriverType;
import com.framework.enums.EnvironmentType;

/**
 * Launch Browser based on the DriverType available in Configuration file
 */
public class BrowserManager {
	
	private WebDriver driver;
	private DriverType driverType = DriverFactory.getDriverType();
	private EnvironmentType environmentType = DriverFactory.getEnvironmentType();
	
	public WebDriver openBrowser() {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX:
			DriverManager.setWebDriver(new FirefoxDriver());
			break;
		case CHROME:
			DriverManager.setWebDriver(new ChromeDriver());
			break;
		case EDGE:
			DriverManager.setWebDriver(new EdgeDriver());
			break;
		case INTERNETEXPLORER:
			DriverManager.setWebDriver(new InternetExplorerDriver());
			break;
		}
		DriverManager.getDriver().manage().window().maximize();
		return DriverManager.getDriver();

	}


}
