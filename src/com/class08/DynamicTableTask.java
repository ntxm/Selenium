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
		
		List<WebElement> cells = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td"));
		System.out.println("Total cells: " + cells.size());
		
		//find Susan McLaren
		String expectedName = "Susan McLaren";
		
	
		try {
		for(int i = 0; i < rows.size(); i++) {
			String ActualName = rows.get(i).getText();
			System.out.println(ActualName);
			if(ActualName.contains(expectedName)) {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" + (i+1) + "]/td[13]")).click();
			}
		}
	}catch(Exception ex){
		System.out.println("Something went wrong!");
		System.out.println(ex.getMessage());
	}	
		
		//loading page
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
		
		//change the information 
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Susan Arnold-Garret");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("8809099812348499");
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_orderGrid")));
		
		//verify is name changed
		
		
	try {
		for(int i = 0; i < rows.size(); i++) {
			String newName = rows.get(i).getText();
			String newCard = rows.get(i).getText();
			System.out.println(newName + " " + newCard );
				
			if(newName.contains("Susan Arnold-Garret") && newCard.contains("8809099812348499")) {
				System.out.println("Passes! Information has been changed!");
			}else {
				System.err.println("Information didn't match");
			}
		}
	}catch(Exception ex) {
		System.out.println("Something wrong");
		System.out.println(ex.getMessage());
	}	
		
		Thread.sleep(4000);
		driver.close();
	}

}