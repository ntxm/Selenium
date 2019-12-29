package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods {
	
	/**
	 * @param browser The desire 
	 */
	
	public static WebDriver driver;
	
	public static void setUp(String browser, String url) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/chromedriver");
			driver = new ChromeDriver();
			driver.get(url);
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/geckodriver");
			driver = new FirefoxDriver();
			driver.get(url);
			
		}
		
	}
	
//		public static WebDriver setUp(String browser) {
//		
//		if(browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/chromedriver");
//			driver = new ChromeDriver();
//			
//		}else if(browser.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/geckodriver");
//			driver = new FirefoxDriver();
//		}
//		
//		return driver;
//	}

}
