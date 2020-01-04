package com.class07;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class TestAlertFunction extends CommonMethods {

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
		
	
		System.out.println(CommonMethods.getAlertText());
		acceptAlert();
		
		Thread.sleep(2000);
		driver.quit();

	}

}
