package com.class05;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

public class MultiWindowsDemo extends CommonMethods {
	
	
		
		public static void main(String[] args) throws InterruptedException {
			
			CommonMethods.setUp("chrome", "https://accounts.google.com/signup");
			Thread.sleep(2000);
			System.out.println("Title of the main Window: " + driver.getTitle());
			
			
			driver.findElement(By.linkText("Help")).click();
			
			Set<String> allWindowsID = driver.getWindowHandles();
			System.out.println("How many Windows current opened: " + allWindowsID.size());
			
			Iterator<String> it = allWindowsID.iterator();
			String parentW = it.next();
			String childW = it.next();
			
			System.out.println("Child ID: " + childW);
			System.out.println("Parent ID: " + parentW);
			
			driver.switchTo().window(childW);
			System.out.println("Title of Child Windows: " + driver.getTitle());
			
			
			
			Thread.sleep(3000);
			driver.close();
			driver.quit();
		}
}