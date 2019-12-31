package com.review01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class Locating extends CommonMethods {
	
	public static final String LINK = "https://the-internet.herokuapp.com/";
	
	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", LINK);
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Checkboxes")).click();
		Thread.sleep(2000);
		
		WebElement chkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
		chkBox1.click();
		
		if(chkBox1.isSelected()) {
			System.out.println("Checkbox 1 was selected");
		}else {
			System.err.println("Error!");
		}
		
		WebElement chkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
		boolean isSelected = chkBox2.isSelected();
		System.out.println("Checkbox 2 is selected: " + isSelected);
		
		if(!isSelected) {
			chkBox2.click();
		}else {
			System.out.println("Checkbox 2 already selected");
		}
		
		
		Thread.sleep(2000);
		driver.close();
	}

}
