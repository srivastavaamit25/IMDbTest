package com.axatrikx;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverHelper {

    public WebDriver initDriver(String browser) {
        WebDriver driver;
        
        if ("Chrome".equalsIgnoreCase(browser)) {            
        	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Framework\\webdriver-testng-master\\target\\classes\\chromedriver.exe");
        	ChromeOptions options = new ChromeOptions();
        	options.addArguments("no-sandbox");
        	options.addArguments("test-type");
        	options.addArguments("disable-extensions");
        	options.addArguments("--start-maximized");
        	options.addArguments("--js-flags=--expose-gc");  
        	options.addArguments("--enable-precise-memory-info"); 
        	options.addArguments("--disable-popup-blocking");
        	options.addArguments("--disable-default-apps");
        	options.addArguments("test-type=browser");
        	options.addArguments("disable-infobars");
        	driver = new ChromeDriver(options);
        } else {
        	System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Selenium\\Downloads\\geckodriver-v0.14.0-win32\\geckodriver.exe");
        	//Now initialize marionette driver to launch firefox	 
       	 DesiredCapabilities capabilities = DesiredCapabilities.firefox();
       	// capabilities.setCapability("marionette", true);
       //setting the environment
        // driver = new MarionetteDriver(capabilities);
            // We will use Firefox as default
            driver = new FirefoxDriver();
        }
        // maximize
        driver.manage().window().maximize();
        return driver;
    }
    
    // other methods
}
