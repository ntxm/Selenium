package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

/*
 * TC 1: HRMS Application Login: 1.Open chrome browser2.
 * Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
 * 3.Enter valid username and password
 * 4.Click on login button
 * 5.Then verify Syntax Logo is displayed.
 */

public class HRMLogin extends CommonMethods {
	
	public static final String LINK = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	
	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", LINK);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(1000);
		
		WebElement isLogoDisplayed = driver.findElement(By.xpath("//div[@id='branding']//img[@alt='OrangeHRM']"));
		
		System.out.println("Logo displayed? ---> " + isLogoDisplayed.isDisplayed());
		
		Thread.sleep(2000);
		driver.close();
	}

}
