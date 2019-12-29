package com.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class DropDownRecap extends CommonMethods {
	
	public static final String SYNTAX_PRACTICE_URL = "http://166.62.36.207/syntaxpractice/index.html";

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome",SYNTAX_PRACTICE_URL);
		
		driver.findElement(By.linkText("Input Forms")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Select Dropdown List")).click();
		
		WebElement dd = driver.findElement(By.id("select-demo"));
		
		Select select = new Select(dd);
		select.selectByIndex(3);
		Thread.sleep(2000);
		select.selectByVisibleText("Friday");
		Thread.sleep(2000);
		select.selectByValue("Sunday");
		
		//how to get the count of a dropdown items?
		List<WebElement> options = select.getOptions();
		
		//this will give you the number if items present in dropdowm menu
		System.out.println(options.size());
		
		//storing the list of option in iterator so we can loop through
		Iterator<WebElement> it = options.iterator();
		while(it.hasNext()) { //loop through iterator if it has next element
			it.next().click();
			Thread.sleep(1000);
		}
		
		System.out.println("Does this dd support multiple selection: " + select.isMultiple());
		
	}

}
