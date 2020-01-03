package com.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class RecapAlert extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", "http://166.62.36.207/syntaxpractice/index.html");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Alerts & Modals")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Javascript Alerts")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
		Thread.sleep(1000);
		
		Alert alert = driver.switchTo().alert();
		
		String textAlert = alert.getText();
		System.out.println(textAlert);
		
		alert.accept();
	}

}
