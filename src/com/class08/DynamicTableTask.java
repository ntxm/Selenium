package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

/*
 * 
 * TC 1: Table headers and rows verification
 *
 *	Open chrome browser
 *	Go to “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx”
 *	Login to the application
 *	Verify customer “Susan McLaren” is present in the table
 *	Click on customer details
 *	Update last name and credit card
 *	save
 */
public class DynamicTableTask extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		
		CommonMethods.setUp("chrome", Constants.WEBORDERS_URL);
		
		//login
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		System.out.println("Total rows: " + rows.size());
		
		//find Susan McLaren
		String expectedName = "Susan McLaren";
		
	
		try {
		for(int i = 0; i < rows.size(); i++) {
			String ActualName = rows.get(i).getText();
			Thread.sleep(1000);
			
			if(ActualName.contains(expectedName)) {
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + (i+1) + "]/td[13]")).click();
			}
		}
	}catch(Exception ex){
		System.err.println("Something went wrong!");
		
	}	
		
		//loading page
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
		
		//change the information 
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Susan Arnold-Garret");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("8809099812348499");
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_orderGrid")));
		
		//verify is name changed
		List<WebElement> rowsUpdated = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		

		for(int i = 0; i < rowsUpdated.size(); i++) {
			Thread.sleep(1000);
			String newName = rowsUpdated.get(i).getText();
			Thread.sleep(1000);
			System.out.println(newName);
				
			if(newName.contains("Susan Arnold-Garret") && newName.contains("8809099812348499")) {
				System.out.println("Test Passed! Information has been changed!");
				break;
			}
		}	
		
		Thread.sleep(4000);
		driver.close();
	}

}
