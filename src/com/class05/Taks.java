package com.class05;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class Taks extends CommonMethods {
	
	public static final String SYNTAX_PRACTICE_URL = "http://jiravm.centralus.cloudapp.azure.com:8081/";

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		
		driver.findElement(By.linkText("Others")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Iframe")).click();
		
		driver.switchTo().frame(1);
		boolean isDisplayed = driver.findElement(By.xpath("//img[@alt='Syntax Technologies']")).isDisplayed();
		System.out.println("Is logo Syntax displayed: " + isDisplayed);
		
		Thread.sleep(2000);
		driver.close();
	}

}
