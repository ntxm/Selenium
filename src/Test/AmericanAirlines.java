package Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/*
 * C 1: Table headers and rows verification
 *
 *	Open chrome browser
 * 	Go to “https://www.aa.com/homePage.do”
 *	Enter From and To
 *	Select departure as May 14 of 2020
 *	Select arrival as November 8 of 2020
 * Verify “Choose flights” text is displayed
 *	Take s screenshot of the results
 *	Close browser
 */

import com.utils.CommonMethods;

public class AmericanAirlines extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", "https://aa.com");
		
		
		//From and To Destination
		driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.originAirport']")).clear();
		driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.originAirport']")).sendKeys("New York");
		driver.findElement(By.xpath("//input[@id='reservationFlightSearchForm.destinationAirport']")).sendKeys("LAX");
		
		//==============PICK DATES================
		
		String excpectedMonthDeparture = "May";
		String expectedDayDeparture = "14";
		String excpectedMonthArrival = "November";
		String expectedDayArrival = "8";
		boolean correctMonth = false;
		driver.findElement(By.xpath("//input[@id='aa-leavingOn']")).click();
		
		
		//============DEPARTURE====================
		
		
		//looking for expected month for departure
		do {
		String monthFrom = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).getText();
		if(monthFrom.equals(excpectedMonthDeparture)) {
			correctMonth = true;
			break;
		}else {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
		}
		}while(!correctMonth);
		
		//looking for expected date for departure
		List<WebElement> dates = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		
		for(WebElement date: dates) {
			String actualDate = date.getText();
				if(actualDate.equals(expectedDayDeparture)) {
					date.click();
					break;
				}
		}
		
		Thread.sleep(1000);
		
		//============ARRIVAL====================
		
		driver.findElement(By.xpath("//input[@id='aa-returningFrom']")).click();
		correctMonth = false;
		
		//looking for expected month for arrival
		do {
			String actualMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).getText();
				if(actualMonth.equals(excpectedMonthArrival)) {
					correctMonth = true;
					break;
				}else {
					driver.findElement(By.xpath("//a[@title='Next']")).click();
				}
			
		}while(!correctMonth);
		
		//looking for expected day for arrival
		
		List<WebElement> datesArrival = driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		
		for(WebElement date: datesArrival) {
			String actualDate = date.getText();
				if(actualDate.equals(expectedDayArrival)) {
					date.click();
				}
		}
		
		Thread.sleep(1000);
		
		//screenshot
		TakesScreenshot scr = (TakesScreenshot)driver;
		File screenshot = scr.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenshot, new File("screenshots/AmericanAirlines/Search.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
				
	}
}
