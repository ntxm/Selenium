package com.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * TC 3: Verify element is enabled
	Open chrome browser
	Go to “https://the-internet.herokuapp.com/”
	Click on “Click on the “Dynamic Controls” link
	Click on enable button
	Enter “Hello” and verify text is entered successfully
	Close the browser
 */
import com.utils.CommonMethods;

public class ExplicitWaitTask3 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", "https://the-internet.herokuapp.com");
		driver.findElement(By.linkText("Dynamic Controls")).click();
		driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
				
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello");
		driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
		
		String text = driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
		
		if(text.equals("Hello")) {
			System.out.println("Test passed. Entered: " + text);
		}else {
			System.err.println("Test failed. Entered: " + text);
		}
		
		Thread.sleep(3000);
		
		driver.close();
		
		
	}

}
