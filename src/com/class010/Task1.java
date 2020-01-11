package com.class010;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;


public class Task1  extends CommonMethods {

		
		public static void main(String[] args) throws InterruptedException {
			
			//navigate to the page
			CommonMethods.setUp("chrome", "https://jqueryui.com/");
			driver.findElement(By.linkText("Droppable")).click();
			
			//switch to frame
			WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
			driver.switchTo().frame(frame);
			
			//find the elements
			WebElement dragElement = driver.findElement(By.id("draggable"));
			WebElement dropElement = driver.findElement(By.id("droppable"));
			Thread.sleep(2000);
			//drag and drop
			Actions act = new Actions(driver);
			act.dragAndDrop(dragElement, dropElement).perform();
			
			//check if element dropped
			String ifDropped = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
			if(ifDropped.equals("Dropped!")) {
				System.out.println("Test passed!");
				System.out.println("Element successfylly dropped.");
			}else {
				System.out.println("Test failed!");
				System.out.println("Element not dropped.");
			}
			
			Thread.sleep(3000);
			driver.quit();
	}

}
