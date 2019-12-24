package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("Arnold");
		driver.findElement(By.name("lastName")).sendKeys("Dron");
		driver.findElement(By.name("phone")).sendKeys("123-432-1223");
		driver.findElement(By.name("userName")).sendKeys("Dron@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("123 Drive road");
		driver.findElement(By.name("address2")).sendKeys("Apt 1A");
		driver.findElement(By.name("city")).sendKeys("New York");
		driver.findElement(By.name("state")).sendKeys("New York");
		driver.findElement(By.name("postalCode")).sendKeys("11204");
		driver.findElement(By.id("email")).sendKeys("Dron@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123qwe");
		driver.findElement(By.name("confirmPassword")).sendKeys("123qwe");
		Thread.sleep(2000);
		driver.findElement(By.name("register")).click();
		Thread.sleep(4000);
		driver.close();

	}

}
