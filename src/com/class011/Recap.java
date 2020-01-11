package com.class011;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;

/*
 * navigate to google
 */
public class Recap extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", "https://google.com/");
		driver.findElement(By.name("q")).sendKeys("Water", Keys.TAB);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		driver.navigate().back();
		
		//second way -- use Actions class
		driver.findElement(By.name("q")).sendKeys("Sparkling Water", Keys.ESCAPE);
		Actions act = new Actions(driver);
		
		//identify the element
		WebElement button = driver.findElement(By.name("btnK"));
		Thread.sleep(2000);
		act.moveToElement(button).click().perform();
		
		Thread.sleep(4000);
		driver.quit();
	}

}
