package com.class010;

import org.openqa.selenium.By;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Task1  extends CommonMethods {

		
		public static void main(String[] args) {
			
			CommonMethods.setUp("chrome", Constants.HRM_URL);
			String username = "Admin";
			String password = "Hum@nhrm123";
			
			//Login
			driver.findElement(By.id("txtUsername")).sendKeys(username);
			driver.findElement(By.id("txtPassword")).sendKeys(password);
			driver.findElement(By.id("btnLogin")).click();

			
	}

}
