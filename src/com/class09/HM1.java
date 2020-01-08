package com.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

/*
 * TC 1: Delete Employee

	Open chrome browser
	Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
	Login into the application
	Add Employee
	Verify Employee has been added
	Go to Employee List
	Delete added Employee
	Quit the browser

 */
public class HM1 extends CommonMethods {
	
	public static void main(String[] args) throws InterruptedException {
	
CommonMethods.setUp("chrome", Constants.HRM_URL);
		
		//Login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(2000);
		//navigate to "add employee" page
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Add Employee")).click();
		
		//wait. loading page
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Add Employee']")));
		
		String fName = "Aeron";
		String lName = "Booker";
				
		//create new employee
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(fName);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lName);
		
		//"Create Login Details" checkbox
		WebElement chkBox = driver.findElement(By.id("chkLogin"));
		//Check checkbox condition
		boolean isCheckboxSelected = chkBox.isSelected();
		if(!isCheckboxSelected) {
			chkBox.click();
		}else {
			System.out.println("Checkbox already selected");
		}
		
		//create new account for user
		//Login --> FirstName + LastName
		//Password --> FirstName + LastName + employee ID + @@@
		String loginFirstName = driver.findElement(By.xpath("//input[@id='firstName']")).getAttribute("value");
		String loginLastName = driver.findElement(By.xpath("//input[@id='lastName']")).getAttribute("value");
		String passwordEmployeeID = driver.findElement(By.xpath("//input[@id='employeeId']")).getAttribute("value");
		
		//fill the fields
		driver.findElement(By.id("user_name")).sendKeys(loginFirstName + loginLastName);
		driver.findElement(By.id("user_password")).sendKeys(loginFirstName + loginLastName + passwordEmployeeID + "@@@");
		driver.findElement(By.id("re_password")).sendKeys(loginFirstName + loginLastName + passwordEmployeeID + "@@@");
		
		//dropdown menu
		WebElement dropdown = driver.findElement(By.id("status"));
		Select dd = new Select(dropdown);
		dd.selectByVisibleText("Enabled");
		
		//save new employee
		driver.findElement(By.id("btnSave")).click();
		
		
		//wait. Page loading. Redirect to the employee page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_txtEmpFirstName")));
		
		
		//==========================================
		//========EMPLOYEE VERIFICATION=============
		//==========================================
		
		//verify that employee was created successfully with correct values
		boolean checkEmployeeInfo = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).isDisplayed();
		String actualName = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		
		if(checkEmployeeInfo && actualName.equals(loginFirstName + " " + loginLastName)) {
			System.out.println("Test passed! User successfully created. Value as excpected: " + actualName + " ID: " + passwordEmployeeID);
		}else {
			System.err.println("Test failed! User successfully created. Value NOT as excpected: " + actualName + " ID: " + passwordEmployeeID);
		}
		
		//navigate to Employee List
		driver.findElement(By.linkText("Employee List")).click();
		
		//==========================================
		//==============DELETE EMPLOYEE=============
		//==========================================
		
		//pages  --> new block
		boolean found = false;
		
		//inside while block
		while(!found) {
			
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']//tbody/tr"));
		System.out.println(rows.size());
		
		for(int i = 0; i < rows.size(); i++) {
			String findID = rows.get(i).getText();
			Thread.sleep(1000);
			
			if(findID.contains(passwordEmployeeID)) {
				found = true; // new row
				driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr[" + (i+1) + "]/td[1]")).click();
				driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
				System.out.println("User " + loginFirstName + " " + loginLastName + " successfully deleted!");
				break;
			}
		}
		driver.findElement(By.xpath("//a[text()='Next']")).click();
	}// end while
		
		
		driver.close();
		
}	
}
