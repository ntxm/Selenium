package HRMSystemTest;
/*
 *  TC 1: Create, Verify and Delete Employee
 *	Open chrome browser
 *	Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
 *	Login into the application
 *	Add Employee
 *	Verify Employee has been added
 *	Go to Employee List
 *	Delete added Employee
 *	Quit the browser
 */

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.CommonMethods;
import com.utils.Constants;

public class AddEmployee  extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Constants.HRM_URL);
		
		//Login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(1000);
		//navigate to "add employee" page
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("Add Employee")).click();
		
		//wait. loading page
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Add Employee']")));
		
		//create new employee
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Aeron");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Booker");
		
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
		
		//verify that employee was created successfully with correct values
		boolean checkEmployeeInfo = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).isDisplayed();
		String actualName = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		
		if(checkEmployeeInfo && actualName.equals(loginFirstName + " " + loginLastName)) {
			System.out.println("Test passed! User successfully created. Value as excpected: " + actualName);
		}else {
			System.err.println("Test failed! User successfully created. Value NOT as excpected: " + actualName);
		}
		
		//navigate to Employee List
		driver.findElement(By.linkText("Employee List")).click();
		
		
		//find Employee into the table
		// break needed

		boolean isFound = false;
		
		//while employee not found, do this loop:
		while(!isFound) {
			
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']//tbody/tr"));
			System.out.println("Total rows: " + rows.size());
			
		for(int i = 0; i < rows.size(); i++) {
			String rowData = rows.get(i).getText();
			Thread.sleep(1000);
			System.out.println(rowData);
			
			if(rowData.contains(passwordEmployeeID)) {
				isFound = true;
				driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+ (i+1) + "]/td[1]")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("btnDelete")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("dialogDeleteBtn")).click();
				System.out.println("Found! Employee " + loginFirstName + " " + loginLastName + " ID: " + passwordEmployeeID + " successfully deleted!");
				break;
			} //end if
				
		}//end for
		
		try {
			driver.findElement(By.xpath("//a[text()='Next']")).click();
		}catch(Exception ex) {
			System.out.println("Step skipped because only one page of table");
		}
		
		}//end while	
		
	
		
		//logout
		Thread.sleep(2000);
		driver.findElement(By.linkText("Welcome Admin")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(1000);
		driver.quit();
	
	}

}


