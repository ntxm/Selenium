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
		
		Thread.sleep(2000);
		//navigate to "add employee" page
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		
		Thread.sleep(2000);
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
		System.out.println(passwordEmployeeID);
		//need o fix
		for(int i = 1; i < 100; i++) {
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']//tbody/tr"));
			System.out.println(rows.size());
				
				for(int j = 0; j < rows.size(); j++) {
			String findID = rows.get(j).getText();
			Thread.sleep(1000);
			System.out.println(findID);
			
			if(findID.contains(passwordEmployeeID)) {
				System.out.println("Found!");
				WebElement checkBox = driver.findElement(By.xpath("//table[@id='resultTable']//tbody/tr[" + (j+1) + "]/td[1]"));
				checkBox.click();
				driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
				System.out.println("User " + loginFirstName + " " + loginLastName + " successfully deleted!");
				break;
			} //end if
		
				}// j loop ended
				
				driver.findElement(By.xpath("//a[text()='Next']")).click();
				Thread.sleep(3000);
		} // i loop ended	
		
		
		//logout
//		driver.findElement(By.linkText("Welcome Admin")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("Logout")).click();
//		Thread.sleep(1000);
//		driver.quit();
	
	}

}


