package HRMSystemTest;
/*
 *  Open chrome browser
 *	Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
 *	Login into the application
 *	Add Employee
 *	Log out 
 *	Quit the browser
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
		//Password --> FirstName + LastName + employee ID
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
		
		
		//wait. Page loading
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_txtEmpFirstName")));
				
		
		//logout
		driver.findElement(By.linkText("Welcome Admin")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(1000);
		driver.quit();
	
	}

}


