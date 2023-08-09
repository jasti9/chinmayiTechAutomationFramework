package com.framework.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.framework.enums.DriverType;
import com.framework.enums.EnvironmentType;


@SuppressWarnings("static-access")
public class DriverFactory {
	
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	
	public DriverFactory()
    {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();	
    }
	
	public static synchronized WebDriver getDriver() {
		return DriverManager.getDriver();
	}
	
	public WebDriver createDriver() {
		   switch (environmentType) {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case REMOTE : driver = createRemoteDriver();
	        	break;
		   }
		   return driver;
	}
	
	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}
	
	private WebDriver createLocalDriver() {
        switch (driverType) {	    
        case FIREFOX : 
        	DriverManager.setWebDriver(new FirefoxDriver());
	    	break;
        case CHROME : 
        	DriverManager.setWebDriver(new ChromeDriver());
    		break;
        case EDGE : 
        	DriverManager.setWebDriver(new EdgeDriver());
    		break;
        case INTERNETEXPLORER : 
        	DriverManager.setWebDriver(new InternetExplorerDriver());
    		break;	
        }
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait()));
        return DriverManager.getDriver();
        
	}	

}
