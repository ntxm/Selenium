package com.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

/*
 * TC 1: Form Submission1.
 * Open chrome browser
 * 2.Go to “http://166.62.36.207/syntaxpractice/”
 * 3.Click on “Input Forms” link
 * 4.Click on “Input Form Submit” link
 * 5.Using different locator submit the form and click on “Send” button
 * 6.Quit the browser
 */

public class FormSubmission extends CommonMethods {
	
	public static final String LINK = "http://166.62.36.207/syntaxpractice/";

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", LINK);
		//navigate
		driver.findElement(By.linkText("Input Forms")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Input Form Submit")).click();
		Thread.sleep(2000);
		
		//form
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Arianna");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Querto");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("arianna.querto@host.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("(123)345-7890");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("45 Morteno Road, apt #4516");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Santa Barbara");
		
		//Dropdown menu
		WebElement ddMenu = driver.findElement(By.xpath("//select[@name='state']"));
		Select select = new Select(ddMenu);
		select.selectByVisibleText("California");
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("90210");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("https://www.a-quero.com");
		
		//radioButton 
		WebElement radioButton = driver.findElement(By.xpath("//div[@class='col-md-6 text-left']//div[2]//label[1]//input[1]"));
	
		boolean isButtonSelected = radioButton.isSelected();
		
		
		if(!isButtonSelected) {
			radioButton.click();
		}else {
			System.out.println("Button selected");
		}
		
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("hushfshvh sushhgh ruhgvjg f gvbbrbvbbsgoeoeq vfkj rbg jr wh");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@onclick='resetForm();']")).submit();
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
