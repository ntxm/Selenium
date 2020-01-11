package com.class011;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

/*
 * naviagte to HRMS
 * enter suer name and password
 * click on login button using JSExecutor
 */

public class JSExecutor extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Constants.HRM_URL);
		
		//Login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		
		//--------------------------------------
		//Click button "Login" using JSExecutor 
		//--------------------------------------
		
		//1) indentify the element
		WebElement button = driver.findElement(By.id("btnLogin"));
		//2) downcasting driver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//3) click button using JSExecutor
		js.executeScript("arguments[0].click()", button);
		
		Thread.sleep(3000);
		
		//--------------------------------------
		//Scroll down using JSExecutor 
		//--------------------------------------
		
		js.executeScript("window.scrollBy(0, 2500)");
		
		//scroll to specific element
		// js.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(4000);
		driver.quit();

	}

}
