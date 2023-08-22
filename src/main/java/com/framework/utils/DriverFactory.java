package com.framework.utils;

import org.openqa.selenium.WebDriver;

import com.framework.enums.DriverType;
import com.framework.enums.EnvironmentType;

public class DriverFactory {

	private static DriverType driverType;
	private static EnvironmentType environmentType;

	public static synchronized WebDriver getDriver() {
		return DriverManager.getDriver();
	}
	
	public static void setDriverType(DriverType driverType) {
		DriverFactory.driverType = driverType;
	}

	public static void setEnvironmentType(EnvironmentType environmentType) {
		DriverFactory.environmentType = environmentType;
	}
	
	public static DriverType getDriverType() {
		return DriverFactory.driverType;
	}
	
	public static EnvironmentType getEnvironmentType() {
		return DriverFactory.environmentType;
	}


}
