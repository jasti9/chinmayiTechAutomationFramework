package com.framework.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.framework.enums.DriverType;
import com.framework.enums.EnvironmentType;
import com.framework.utils.BrowserManager;
import com.framework.utils.DriverFactory;
import com.framework.utils.FileReaderManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private WebDriver driver;
	String userName;
	String password;
	String appUrl;
	boolean isAPI;
	private DriverFactory factory;

	@Before(order = 0)
	public void readConfig() {
		appUrl = new FileReaderManager("configs/Config.properties").getConfigReader().getApplicationUrl();
		isAPI = new FileReaderManager("configs/Config.properties").getConfigReader().getIsAPI();
	}

	@Before(order = 1)
	public void setUp() throws InterruptedException {
		if (!isAPI) {
			DriverType driverType = new FileReaderManager("configs/Config.properties").getConfigReader().getBrowser();
			EnvironmentType envType = new FileReaderManager("configs/Config.properties").getConfigReader().getEnvironment();
			DriverFactory.setDriverType(driverType);
			DriverFactory.setEnvironmentType(envType);
			
			BrowserManager browser = new BrowserManager();
			driver = browser.openBrowser();
			driver.get(appUrl);
			Thread.sleep(8000);
		}
	}

	@After(order = 0)
	public void quitBrowser() {
		if (!isAPI)
			driver.close();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (!isAPI) {
			if (scenario.isFailed()) {
				// Screenshot code comes here
				String screenShotName = scenario.getName().replaceAll(" ", "_");
				System.out.println(screenShotName);

			}
		}

	}

}
