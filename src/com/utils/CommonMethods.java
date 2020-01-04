package com.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods {
	
	/**
	 * Use this methods to open the browser and targer url
	 * @param browser The desire 
	 * @param url The desire url
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
		}else {
			System.err.println("Browser not supported");
		}
		
	}
	
	
	
	
	
	/**
	 * This methods accept and dismiss the alert
	 * @throws will throw NoAlertPresentException if alert is not present
	 * 
	 */
	
	
	public static void acceptAlert() {
		
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}catch(NoAlertPresentException e) {
			System.err.println("Alert is not present");
		}
	}
	
	
	
	public static void dismissAlert() {
		
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}catch(NoAlertPresentException e) {
			System.err.println("Alert is not present");
		}
		
	}	
		
	
	
	
		/**
		 * This method get a text from alert
		 * @return text of the alert
		 * @throws will throw NoAlertPresentException if alert is not present
		 */
		
		public static String getAlertText() {
				
			String text = null;
			
			try {
				Alert alert = driver.switchTo().alert();
				text = alert.getText();
			}catch(NoAlertPresentException e) {
				System.err.println("Alert is not present");
			}
			return text;
		}
		
		
		
		
		/**
		 * This methods with switch to the frame
		 * @param nameOrId
		 */
		public static void switchToFrame(String nameOrId) {
			
			try {
				driver.switchTo().frame(nameOrId);
			}catch(NoSuchFrameException e) {
				System.err.println("Frame is not present");
			}
			
		}
		
		
		
		/**
		 * This methods with switch to the frame
		 * @param WebElement
		 */
		
		public static void switchToFrame(WebElement element) {
			
			try {
				driver.switchTo().frame(element);
			}catch(NoSuchFrameException e) {
				System.err.println("Frame is not present");
			}
			
		}
		
		
		
		
		/**
		 * This methods with switch to the frame
		 * @param index
		 */
		
		public static void switchToFrame(int index) {
			
			try {
				driver.switchTo().frame(index);
			}catch(NoSuchFrameException e) {
				System.err.println("Frame is not present");
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
