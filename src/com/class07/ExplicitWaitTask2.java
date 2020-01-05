package com.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;

public class ExplicitWaitTask2 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		//open browser, go to the right page
		CommonMethods.setUp("chrome", "http://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Dynamic Controls")).click();
		
		//find checkbox and click
		WebElement checkBox = driver.findElement(By.xpath("//input[@label='blah']"));
		//check condition
		boolean isSelected = checkBox.isSelected();
		
		//if not selected --> select, if selected --> print message
		if(!isSelected) { 
			checkBox.click();
		}else {
			System.out.println("Checkbox selected");
		}
		
		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		
		driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		
		boolean isDisplayed = driver.findElement(By.id("message")).isDisplayed();
		
		if(isDisplayed) {
			String text  = driver.findElement(By.id("message")).getText();
				if(text.equals("It's back!")) {
					System.out.println("Pass! Right text displayed: " + text);
				}else {
					System.err.println("Failed. Wrong text displayed");
				}
		}else {
			System.err.println("Failed. Text is not displayed!");
		}
		
		
	}
}	