package com.class05;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class FramesDemo extends CommonMethods {
	
	public static final String SYNTAX_PRACTICE_URL = "http://jiravm.centralus.cloudapp.azure.com:8081/";
		
		public static void main(String[] args) throws InterruptedException {
			
			CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
			//driver.manage().window().maximize();
			
			driver.findElement(By.linkText("Others")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Iframe")).click();
			Thread.sleep(2000);
			
			
			String text = driver.findElement(By.xpath("//h2[text()='IFrame practice']")).getText();
			System.out.println("This text is from main window: " + text);
			
			driver.switchTo().frame("FrameOne");
			Thread.sleep(2000);
			
			String insideFrameText = driver.findElement(By.xpath("//h4[text()='Practice Selenium Automation Testing Online']")).getText();
			System.out.println("This text is from inside frame one: " + insideFrameText);
			
			//switch to main window
			driver.switchTo().defaultContent();
			boolean isDisplayed = driver.findElement(By.xpath("//h2[text()='IFrame practice']")).isDisplayed();
			System.out.println("Is text displayed: " + isDisplayed);

	}

}
