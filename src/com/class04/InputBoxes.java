package com.class04;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class InputBoxes extends CommonMethods {
	
	public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Input Forms")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Simple Form Demo")).click();
		Thread.sleep(1000);
		
		//get list of text fileds
		List<WebElement> inputFields = driver.findElements(By.xpath("//input[@class='form-control']"));
		System.out.println(inputFields.size());
		
		// Enter "Hello" to each text box
		for(WebElement el: inputFields) {
			el.sendKeys("Hello");
		}
		
		Thread.sleep(3000);	
		driver.close();
		
	}

}
