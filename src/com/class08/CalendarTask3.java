package com.class08;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

/*
 * TC 1: Leave List Search Validation
 *	Open chrome browser
 *	Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
 *	Login into the application
 *	Select Leave List
 *	Select from December 1, 2019 until January 31, 2020
 *	Check only Pending approval
 *	Click on Search
 *	Validate “No Records Found” is displayed
 *	Quit the browser
 * 
 */

public class CalendarTask3 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Constants.HRM_URL);
		
		//Login
				driver.findElement(By.id("txtUsername")).sendKeys("Admin");
				driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
				driver.findElement(By.id("btnLogin")).click();
		
		//page loading		
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("panel_resizable_0_0")));
				
		//navigate to the page
				driver.findElement(By.linkText("Leave")).click();
				driver.findElement(By.linkText("Leave List")).click();
				Thread.sleep(1000);
				
		//FROM DATE. Click on the calendar icon and pick a date
				driver.findElement(By.xpath("//li[1]//img[@class='ui-datepicker-trigger']")).click();
		//Select Month December		
				WebElement dropdownMonthFrom = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
				Select ddMenuFrom = new Select(dropdownMonthFrom);
				ddMenuFrom.selectByVisibleText("Dec");
				
		//Select Year 2019
				WebElement dropdownYearFrom = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
				Select ddMenuYearFrom = new Select(dropdownYearFrom);
				ddMenuYearFrom.selectByVisibleText("2019");
				
		//Select date 1st				
				
			List<WebElement> dates =driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
			for(WebElement date: dates) {
				if(date.getText().equals("1")) {
					date.click();
				}
			}
				
		
				

				
		//TO DATE. Click on the calendar icon and pick a date
				driver.findElement(By.xpath("//li[2]//img[@class='ui-datepicker-trigger']")).click();
				Thread.sleep(1000);
		
		//Select Month January		
				WebElement dropdownMonthTo = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
				Select ddMenuTo = new Select(dropdownMonthTo);
				ddMenuTo.selectByVisibleText("Jan");
				
		//Select Year 2020
				WebElement dropdownYearTo = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
				Select ddMenuYearTo = new Select(dropdownYearTo);
				ddMenuYearTo.selectByVisibleText("2020");
				
		//Select date 31st				
				
				List <WebElement> datesTo = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
				for(WebElement dateTo: datesTo) {
					if(dateTo.getText().equals("31")) {
						dateTo.click();
					}
				}
		
		//Check only Pending approval
				List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
				
				for(int i = 0; i < checkboxes.size(); i++) {
					boolean isCheckboxSelected = checkboxes.get(i).isSelected();
					String value = checkboxes.get(i).getAttribute("value");
					System.out.println(isCheckboxSelected + " <---> value: " + value);
						
						if(isCheckboxSelected) {
							if(value.equals("1")) {
								System.out.println("Checkbox \"Pending Approval\" selected");
						}
						
						}
				}
				
		//Click on Search		
				driver.findElement(By.id("btnSearch")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));
				
		//Validate “No Records Found” is displayed
				String expectedResult = "No Records Found";
				String result = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr")).getText();
				if(result.contains(expectedResult)) {
					System.out.println("No Records Found");
					System.out.println("Test Passed!");
				}
				
				Thread.sleep(6000);
				driver.quit();
				

	}

}
