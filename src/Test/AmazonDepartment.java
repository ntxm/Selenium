package Test;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class AmazonDepartment extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", "https://www.amazon.com/");
		driver.manage().window().maximize();
		
		WebElement searchDropDowmMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select departments  = new Select(searchDropDowmMenu);
		
		List<WebElement> allDepartments = departments.getOptions();
		System.out.println("Departments total: " + allDepartments.size());
		
		System.out.println("******* ALL DEPARTMENTS *******");
		for(WebElement elem: allDepartments) {
			System.out.println(elem.getText());
		}
		
		departments.selectByIndex(10);
		Thread.sleep(3000);
		departments.selectByIndex(26);
		Thread.sleep(3000);
		departments.selectByIndex(49);
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
