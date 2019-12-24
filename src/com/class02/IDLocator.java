package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IDLocator {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys("admin");
		
		driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");
		
		driver.findElement(By.className("button")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Welcome Admin")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		
		driver.close();

	}

}
