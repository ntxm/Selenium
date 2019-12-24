package com.class01;

import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		//it will navigate to a given url
		driver.navigate().to("https://www.amazon.com");
		//it will navigate back
		driver.navigate().back();
		//it will navigate one step forward
		driver.navigate().forward();
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		
		
		driver.close();
		

	}

}
