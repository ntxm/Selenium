package com.class07;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class PageLoadingImplicitWait extends CommonMethods {

	public static void main(String[] args) {
	
		CommonMethods.setUp("chrome", "https://google.com/");
		//page load waits until all elements on the page gets fully loaded
		//if element wont load within 30 second you will get TimeOutException
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//tell WebDriver to wait for the element before throwing NoSuchElementException
		//we need to implict wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("wrongName")).sendKeys("iPhone");

	}

}
