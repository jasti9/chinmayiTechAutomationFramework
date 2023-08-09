package com.framework.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.framework.utils.DriverFactory;
import com.framework.utils.FileReaderManager;

public class BaseStepDefinition {
	
	WebDriver driver = DriverFactory.getDriver();
	String userName = FileReaderManager.getInstance().getConfigReader().getUserName();
	String password = FileReaderManager.getInstance().getConfigReader().getPassword();

}
