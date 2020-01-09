package com.class09;
/*
 * Verify user is able to login with valid credentials
 * 
 */

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utils.CommonMethods;
import com.utils.Constants;

public class ScreenShotDemo extends CommonMethods {

	public static void main(String[] args) {
		
		CommonMethods.setUp("chrome", Constants.HRM_URL);
		String username = "Admin";
		String password = "Hum@nhrm123";
		
		//Login
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		
		//validation that Admin is logged in
		String welcomeText = driver.findElement(By.id("welcome")).getText();
		if(welcomeText.contains(username)) {
			System.out.println("Test Pass");
		}else {
			System.out.println("Test Fail");
		}
		
		//how to take a screenshot
		//We can use screenshot interface
		//step1: downcast webdriver to the type of takeScreenshot
		TakesScreenshot screen = (TakesScreenshot)driver;
		//call method getScreenshotAs and specify output type
		File screenshot01 = screen.getScreenshotAs(OutputType.FILE);
		try {
			//copy file to the specified destination and give name and extension
			FileUtils.copyFile(screenshot01, new File("screenshots/HRMS/AdminLogin.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		driver.quit();
		
	}

}
