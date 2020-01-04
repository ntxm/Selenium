package com.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class ExplicitWaitDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Constants.SYNTAX_URL);
		
		driver.findElement(By.linkText("Others")).click();
		//Thread.sleep(1000);
		driver.findElement(By.linkText("Dynamic Data Loading")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='save']")).click();
		
		//WebDriver wait or explicit wait --> wait for specific element to appear on the
		//it will wait until expected condition is met or the specified time
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[starts-with(text(), 'First Name')]")));
		
		boolean displayesd = driver.findElement(By.xpath("//p[starts-with(text(), 'First Name')]")).isDisplayed();
		if(displayesd) {
			System.out.println("Pass");
		}else {
			System.err.println("Failed");
		}
	}

}
