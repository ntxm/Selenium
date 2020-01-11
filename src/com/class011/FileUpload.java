package com.class011;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class FileUpload extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		//navigate to the page
		CommonMethods.setUp("chrome", Constants.WELCOME_TO_THE_INTERNET);
		driver.findElement(By.linkText("File Upload")).click();
		
		//find "choose file" button
		//to upload file we can use sendKeys method and prodive full path to the file
		driver.findElement(By.id("file-upload")).sendKeys("/Users/natalia/Downloads/123.png");
		
		//click on upload button
		Thread.sleep(2000);
		driver.findElement(By.id("file-submit")).click();
		
		//verify if file is uploaded
		WebElement uploaded = driver.findElement(By.xpath("//div[@id='uploaded-files']/preceding-sibling::h3"));
		if(uploaded.isDisplayed()) {
			System.out.println("File successfully uploaded");
		}else {
			System.out.println("File is not uploaded");
		}
	
		
		Thread.sleep(3000);
		driver.quit();
	}

}
