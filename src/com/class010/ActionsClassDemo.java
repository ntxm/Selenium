package com.class010;
/*
 * Navigate to HRMS app
 * enter uID and pwd
 * click on login using mouse
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utils.CommonMethods;
import com.utils.Constants;

public class ActionsClassDemo extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Constants.HRM_URL);
		
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("Admin");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("Hum@nhrm123");
		
		//to perform mouse or keyboard operation we need to have an Object on the Action class
		Actions act = new Actions(driver);
		
		//identify an element on which to perform mouse click
		WebElement loginBtn = driver.findElement(By.cssSelector("input#btnLogin"));
		Thread.sleep(3000);
		//do right click
		act.moveToElement(loginBtn).contextClick().perform();
		Thread.sleep(3000);
		//clicking on the mouse and to complete the action we need to call perform();
		act.moveToElement(loginBtn).click().perform();
		Thread.sleep(3000);
		//to perform double click
		//act.moveToElement(loginBtn).doubleClick().perform();
		
		//hover over element
		WebElement pimLink = driver.findElement(By.linkText("PIM"));
		act.moveToElement(pimLink).perform();
		
		//click on the AddEmployee link
		WebElement addEmp = driver.findElement(By.linkText("Add Employee"));
		//act.moveToElement(addEmp).click().perform(); --> 1st way
		act.click(addEmp).perform();
		
		//act.keyUp(Keys.SHIFT).sendKeys("hello") --> if you perform this on txt box
		//if will hold shift key and type hello in upper case
		
		
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}
