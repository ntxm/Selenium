package com.class05;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.utils.CommonMethods;

/*
 * TC 1: Windows Handling
 * 1.Open chrome browser
 * 2.Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
 * 3.Click on “Alerts & Modals” link
 * 4.Click on “Window Popup Modal” link
 * 5.Click on the “ Follow On Instagram” button
 * 6.Verify title of the page is “Syntax Technologies (@syntaxtechs) • Instagram photos and videos” 
 * 7.Click on the “Like us On Facebook ” button
 * 8.Verify title of the page is “Go to Facebook Home” 
 * 9.Quit the browser
 */

public class WindowsHandling  extends CommonMethods {
	
	public static final String LINK = "http://jiravm.centralus.cloudapp.azure.com:8081/index.html";

	public static void main(String[] args) throws InterruptedException {
		
		//navigate to the right page
		CommonMethods.setUp("chrome", LINK);
		driver.findElement(By.linkText("Alerts & Modals")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Window Popup Modal")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Follow @syntaxtech on Instagram']")).click();
		Thread.sleep(2000);
		
		//get all windows
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows.size());
		
		//get window IDs
		Iterator<String> it = allWindows.iterator();
		String win1 = it.next();
		String win2 = it.next();
		
		//print window IDs
		System.out.println("ID Window 1: " + win1);
		System.out.println("ID Window 2: " + win2);
		
		//switch to second window and get title
		driver.switchTo().window(win2);
		String actualTitle = driver.getTitle();
		
		//check if title is correct
		if(actualTitle.equals("Syntax Technologies (@syntaxtechs) • Instagram photos and videos")) {
			System.out.println("Title is correct: " + actualTitle);
		}else {
			System.out.println("Title is incorrect: " + actualTitle);
		}
		
		Thread.sleep(2000);
		//part2  ===> Facebook button
		
		//switch to the first window
		driver.switchTo().window(win1);
		driver.findElement(By.xpath("//a[@title='Follow @syntaxtech on Facebook']")).click();
		Thread.sleep(2000);
		
		driver.switchTo().window(win2);
		String title = driver.getTitle();
		
		if(title.equals("Go to Facebook Home")) {
			System.out.println("Title is correct: " + title);
		}else {
			System.out.println("Title is incorrect: " + title);
		}
		
		
		driver.quit();
	}
		

}
