package com.class01;

import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonVerification {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		
		String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more"; 
		String actualTitle = driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Titles mutched. Test passed!");
		}else {
			System.err.println("Titles unmutched. Test failed");
		}
		
		
		driver.close();

	}

}
