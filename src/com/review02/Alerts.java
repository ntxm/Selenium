package com.review02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Alerts extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Constants.TOOLS_QA);
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("DEMO SITES")).click();
		driver.findElement(By.linkText("Handling Alerts using Selenium WebDriver")).click();
		Thread.sleep(2000);
		
		//========================================
		//=============SIMPLE ALERT===============
		//========================================
				
	
		driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Accepted");
		
		Thread.sleep(2000);
		
		//========================================
		//=============POP UP ALERT===============
		//========================================
		
		
		WebElement popUpAlert = driver.findElement(By.xpath("//button[text()='Confirm Pop up']"));
		//scroll to the element
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", popUpAlert);
		//click
		popUpAlert.click();

		wait.until(ExpectedConditions.alertIsPresent());
		alert.dismiss();
		System.out.println("Dismissed");
		
		Thread.sleep(2000);
		
		//========================================
		//=============Prompt Pop Up==============
		//========================================

	
		WebElement promptPopUpAlert = driver.findElement(By.xpath("//button[text()='Prompt Pop up']"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", promptPopUpAlert);
		promptPopUpAlert.click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		alert.sendKeys("Yes");
		alert.accept();
		System.out.println("Sent!");

		Thread.sleep(3000);
		driver.quit();
	
	}

}
