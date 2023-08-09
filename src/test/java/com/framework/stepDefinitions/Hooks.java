package com.framework.stepDefinitions;

import org.openqa.selenium.WebDriver;

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
		appUrl = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
		isAPI = FileReaderManager.getInstance().getConfigReader().getIsAPI();
	}

	@Before(order = 1)
	public void setUp() throws InterruptedException {
		if (!isAPI) {
			factory = new DriverFactory();
			driver = factory.createDriver();
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
