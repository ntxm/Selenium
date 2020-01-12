package com.class011;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
 * TC 1: Upload file and Take Screenshot
 *	Navigate to “http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload”
 *	Upload file
 *	Verify file got successfully uploaded and take screenshot
 *
 */
import com.utils.CommonMethods;

public class HW1 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		//navigate
		CommonMethods.setUp("chrome", "http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload");
		
		//upload a file
		driver.findElement(By.id("gwt-debug-cwFileUpload")).sendKeys("/Users/Natalia/Downloads/123.png");
		driver.findElement(By.className("gwt-Button")).click();
		
		//verify if file uploaded
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		
		if(alertText.equals("File uploaded!")) {
			System.out.println(alertText);
			System.out.println("Test pass");
		}else {
			System.out.println(alertText);
			System.out.println("Test fail");
		}
		
		Thread.sleep(3000);
		driver.quit();
		

	}

}
