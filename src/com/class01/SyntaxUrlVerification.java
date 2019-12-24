package com.class01;

import org.openqa.selenium.chrome.ChromeDriver;

public class SyntaxUrlVerification {

	public static void main(String[] args) {
		
System.setProperty("webdriver.chrome.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.syntaxtechs.com/");
		driver.navigate().to("https://www.google.com/");
		driver.navigate().back();
		driver.navigate().refresh();
		
		String currentURL = driver.getCurrentUrl();
		if(currentURL.contains("syntax")) {
			System.out.println("Syntax found. Test passed");
		}else {
			System.out.println("Syntax not found. Test failed");
		}
		
		
		driver.close();
		

	}

}
