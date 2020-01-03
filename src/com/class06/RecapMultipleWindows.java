package com.class06;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class RecapMultipleWindows extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", "http://166.62.36.207/syntaxpractice/window-popup-modal-demo.html");
		
		String mainWindow = driver.getWindowHandle();
		
		driver.findElement(By.linkText("Follow On Instagram")).click();
		
		Set<String> windowsID = driver.getWindowHandles();
		System.out.println(windowsID.size());
		
		Iterator<String> it = windowsID.iterator();
		String parent = it.next();
		String child = it.next();
		
		Thread.sleep(1000);
		
		driver.switchTo().window(child);
		String childTitle = driver.getTitle();
		System.out.println("Window 2: ID --> " + child + " --> " + childTitle);
		
		driver.switchTo().window(parent);
		String parentTitle = driver.getTitle();
		System.out.println("Window 1: ID --> " + parent + " --> " + parentTitle);
		
		
		while(it.hasNext()) {
			child = it.next();
			if(!child.equals(mainWindow)) {
				driver.switchTo().window(child);
				System.out.println(driver.getTitle());
				driver.close();
				driver.switchTo().window(mainWindow);
			}
		}
		
		driver.close();
	}

}
