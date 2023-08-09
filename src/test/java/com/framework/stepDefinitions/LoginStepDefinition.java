package com.framework.stepDefinitions;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;

public class LoginStepDefinition extends BaseStepDefinition{
	
	Logger log = Logger.getLogger(LoginStepDefinition.class);

	@Given("user launch the application")
	public void user_launch_the_application() {
	driver.findElement(By.name("username")).sendKeys(userName);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	System.out.println("Logged into the application!!");  
	log.info("Logged into application");
	log.warn("Sample message to log");
	}

}
