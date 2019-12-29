package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;


public class TestWindow extends CommonMethods {
	

	
	public static void main(String[] args) {
		
		CommonMethods.setUp("chrome", Constants.HRM_URL);
		//driver.manage().window().fullscreen(); --> for Mac
		driver.manage().window().maximize(); //for Windows, but works for Mac as well like bigger window
		
		WebElement loginBtn = driver.findElement(By.cssSelector("input#btnLogin"));
		System.out.println(loginBtn.isEnabled());
		
	}

}
