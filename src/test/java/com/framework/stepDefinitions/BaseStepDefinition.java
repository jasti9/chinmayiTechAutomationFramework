package com.framework.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.framework.utils.DriverFactory;
import com.framework.utils.FileReaderManager;

public class BaseStepDefinition {
	
	WebDriver driver = DriverFactory.getDriver();
	String userName = new FileReaderManager("configs/Config.properties").getConfigReader().getUserName();
	String password =  new FileReaderManager("configs/Config.properties").getConfigReader().getPassword();

}
