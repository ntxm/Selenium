package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;


public class RadioButtonPractice extends CommonMethods {
	
	public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";


	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", SYNTAX_PRACTICE_URL);
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Input Forms")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		Thread.sleep(2000);
		
		WebElement radioButton = driver.findElement(By.xpath("//input[@name='optradio' and @value='Female']"));
		Thread.sleep(2000);
		
		boolean isSelected = radioButton.isSelected();
		System.out.println("Is Female button selected: " + isSelected);
		
		if(!isSelected) {
			driver.findElement(By.xpath("//input[@name='optradio' and @value='Female']")).click();
		}else {
			System.out.println("Correct radio button is selected!");
		}
	
		
		isSelected = radioButton.isSelected();
		System.out.println("Is Female button selected: " + isSelected);
		Thread.sleep(2000);
		
		System.out.println("=======PART2=======");
		
		WebElement radioButtonGender = driver.findElement(By.xpath("//input[@name='gender' and @value='Male']"));
		
		boolean isGenderSelected = radioButtonGender.isSelected();
		
		if(!isGenderSelected) {
			radioButtonGender.click();
		}else {
			System.out.println("Button selected");
		}
		
		Thread.sleep(2000);
		
		WebElement radioButtonAge = driver.findElement(By.xpath("//input[@name='ageGroup' and @value='5 - 15']"));
		boolean isButtonAge = radioButtonAge.isSelected();
		
		if(!isButtonAge) {
			radioButtonAge.click();
		}else{
			System.out.println("Button selected");
		}
		
		
		driver.findElement(By.xpath("//button[contains(text(),'Get values')]")).click();
		
		Thread.sleep(3000);
		driver.close();
		
		
	}

}
