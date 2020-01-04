package com.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class ExplicitWaitDemo2 extends CommonMethods {
	
	/*
	 * Navigate to google
	 * Search for wegmans
	 * click on link "Wegmans Groceries Delivered | Powered By Instacart‎"
	 * Once we redirected to the site click Login
	 */

	public static void main(String[] args) throws InterruptedException{
		
		CommonMethods.setUp("chrome", "https://google.com/");
		//send wegmans text and hit enter
		driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("wegmans", Keys.ENTER);
		//click on first link on result page		
		driver.findElement(By.xpath("//h3[starts-with(text(), 'Wegmans Grocery Delivery')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Shop at Wegmans']")));
		
		
		//click on login button
		driver.findElement(By.xpath("//button[text()='Shop at Wegmans']")).click();
		
		
		Thread.sleep(3000);
		driver.close();
	}

}
