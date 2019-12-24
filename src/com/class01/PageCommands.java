package com.class01;

import org.openqa.selenium.chrome.ChromeDriver;

public class PageCommands {

	public static void main(String[] args) throws InterruptedException {
		
		
System.setProperty("webdriver.chrome.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		
		final String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("I am on the rigth page");
		}else {
			System.err.println("The actual and expected title did not match");
		}
		
		System.out.println("********************");
		
		String expectedUrl = "https://www.google.com/";
		String actualUrl = driver.getCurrentUrl();
		Thread.sleep(3000);
		
		System.out.println("Actual URL: " + actualUrl);
		
		
		if(expectedUrl.equals(actualUrl)) {
			System.out.println("Both URL matched");
		}else {
			System.err.println("Actual and expected not matched");
		}
		
		driver.close();
		
	}

}
