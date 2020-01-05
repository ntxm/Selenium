package com.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

/*
 * Login into WebOrders
 * click checkbox next to Bob Feather
 */
public class DynamicTableDemo extends CommonMethods {

	public static void main(String[] args) {
		
		CommonMethods.setUp("chrome", Constants.WEBORDERS_URL);
		
		//login
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody/tr"));
		System.out.println("Rows: " + rows.size());
		
		//Search Bob Feather
		String expectedValue="Bob Feather";
		
		for(int i = 0; i < rows.size(); i++) {
			
			String actualValue = rows.get(i).getText();
			 if(actualValue.contains(expectedValue)) {
			 WebElement chkBox = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody/tr[" + (i+1) + "]/td[1]"));
			 chkBox.click();
		   }else {
			   System.out.println("Bob Feather not found");
		   }
		}
		
		
		//List<WebElement> columns = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tbody/tr/td"));


	}

}
