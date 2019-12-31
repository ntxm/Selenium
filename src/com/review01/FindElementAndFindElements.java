package com.review01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class FindElementAndFindElements extends CommonMethods {
	
	public static final String LINK = "https://the-internet.herokuapp.com/";
	public static void main(String[] args) {
		
		CommonMethods.setUp("chrome", LINK);
		
		driver.findElement(By.linkText("Checkboxes")).click();
		driver.navigate().back();
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
		for(WebElement element: allLinks) {
			System.out.println(element.getText() + " = " + element.getAttribute("href"));
			
		}
		
		driver.close();
		
	}

}
