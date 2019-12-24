package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		
		
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		
		//form[starts-with(@action, '/humanresource')];
		//h1[]
		//h1[]
		//
	}

}
