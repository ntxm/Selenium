package com.class07;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class CalendarDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Constants.HRM_URL);
		
		//Login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		
		//navigate to right page
		driver.findElement(By.linkText("Leave")).click();
		driver.findElement(By.linkText("Leave List")).click();
		
		//step 1: click on calendar
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();
		Thread.sleep(2000);
		List<WebElement> cells = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		
		for(WebElement cell: cells) {
			if(cell.getText().equals("16")) {
				cell.click();
				break;
			}
		}
		
		Thread.sleep(3000);
		driver.close();
		

	}

}
