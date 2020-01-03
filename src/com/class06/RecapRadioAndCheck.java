package com.class06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class RecapRadioAndCheck extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", "http://166.62.36.207/syntaxpractice/basic-checkbox-demo.html");
		
		//find all checkboxes
		List<WebElement> chkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(chkBox.size());
		
		//select each checkbox
		for(WebElement el: chkBox) {
			boolean isSelected = el.isSelected();
			if(!isSelected) {
				el.click();
				Thread.sleep(1000);
			}
			
		}
		
		//unselect all checkbox
		for(WebElement el: chkBox) {
			boolean isSelected = el.isSelected();
			if(isSelected) {
				el.click();
				Thread.sleep(1000);
			}
			
		}
		
		driver.close();
		
		
	}

}
