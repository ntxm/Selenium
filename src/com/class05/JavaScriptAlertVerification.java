package com.class05;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class JavaScriptAlertVerification extends CommonMethods {

	public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		//find the element Alerts and Modals and clicking on it
		driver.findElement(By.linkText("Alerts & Modals")).click();
		
		Thread.sleep(2000);
		//finding Javascript Alerts and clicking on it
		driver.findElement(By.linkText("Javascript Alerts")).click();
		
		//finding the button and click on it --> FIRST ALERT
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		//finding the button and click on it --> SECOND ALERT
		driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']")).click();
		
		Thread.sleep(2000);
		System.out.println(alert.getText());
		alert.dismiss();
		
		//finding the button and click on it --> THIRD ALERT
		driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']")).click();
		
		Thread.sleep(2000);
		alert.sendKeys("Hello");
		System.out.println(alert.getText());
		alert.accept();
		
		Thread.sleep(2000);
		driver.close();
		
		
	}	

}
