package com.class05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class AlertDemo2 extends CommonMethods{

	public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";

	public static void main(String[] args) throws InterruptedException {
		
		//The method is opening syntax Practice website using chrome browser
		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		
		Thread.sleep(2000);
		//find the element Alerts and Modals and clicking on it
		driver.findElement(By.xpath("//a[@href='#' and text()='Alerts & Modals']")).click();
		
		//finding Javascript Alerts and clicking on it
		driver.findElement(By.linkText("Javascript Alerts")).click();
		
		//finding the second alert button and click on it
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		Thread.sleep(2000);
		
		//handle the alert.
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);

		System.out.println("Text of Second Alert: "+alert.getText());
		
		//to dismiss or cancel the alert. any negative action it will perform it
		alert.dismiss();
		
		driver.close();
	}
}