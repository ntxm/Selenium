package com.class01;

import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		Thread.sleep(4000);
		
		//browse navigation commands
		
		//it will navigate to a given url
		driver.navigate().to("https://www.amazon.com");
		//it will navigate back
		driver.navigate().back();
		//it will navigate one step forward
		driver.navigate().forward();
		//it will refresh the page
		driver.navigate().refresh();
		
		
		driver.close();

	}

}
