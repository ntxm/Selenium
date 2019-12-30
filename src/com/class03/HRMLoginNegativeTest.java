package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

/*TC 2: HRMS Application Negative Login: 
 * 1.Open chrome browser2.
 * Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
 * 3.Enter valid username
 * 4.Leave password field empty
 * 5.Verify error message with text “Password cannot be empty” is displayed.
 * 
 */

public class HRMLoginNegativeTest extends CommonMethods {
	
	public static final String HRM_LINK = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", HRM_LINK);
		driver.manage().window().fullscreen();
		
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		
		//is error message displayed?
		boolean msg = driver.findElement(By.xpath("//span[@id='spanMessage']")).isDisplayed();
		System.out.println("Error message displayed: " + msg);
		
		String message = driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
		
		if(message.equals("Password cannot be empty")) {
			System.out.println("Error message is correct!");
		}else {
			System.out.println("Error message is incorrect!");
		}
		
		
		Thread.sleep(2000);
		driver.close();
				
	}

}
