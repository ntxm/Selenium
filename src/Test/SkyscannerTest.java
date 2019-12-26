package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SkyscannerTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://skyscanner.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//radio button one way trip
		WebElement radioButtonTrip = driver.findElement(By.xpath("//input[@aria-label='One way']"));
		radioButtonTrip.click();
		Thread.sleep(1000);
		
		//From - To form
		driver.findElement(By.xpath("//input[@id='fsc-origin-search']")).sendKeys("New York");
		driver.findElement(By.xpath("//input[@id='fsc-destination-search']")).sendKeys("Miami");
		
		//depart date
		driver.findElement(By.xpath("//button[@id='depart-fsc-datepicker-button']")).click();
		driver.findElement(By.xpath("//select[@name='months']")).click();
		Thread.sleep(1000);
		Select dropdownMenuMonth = new Select(driver.findElement(By.xpath("//select[@name='months']")));
		dropdownMenuMonth.selectByValue("2020-03");
		driver.findElement(By.xpath("//span[contains(text(),'27')]")).click();
		
		//Cabin Class and Travelers
		driver.findElement(By.xpath("//button[@id='CabinClassTravellersSelector_fsc-class-travellers-trigger__1qSiF']")).click();
		driver.findElement(By.xpath("//button[@title='Increase number of adults']")).click();
		driver.findElement(By.xpath("//button[@class='BpkLink_bpk-link__1Wmr3']")).click();
		
		//find flights
		driver.findElement(By.xpath("//button[@aria-label='Search flights']")).click();
		
		//if window "Create a new Price Alert" open 
		try {
		driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
		}catch(Exception ex) {
			System.out.println("No window.Just continue...");
		}
		
		//searching flights. time to wait
		Thread.sleep(10000);
		
		//Find the cheapest flight
		driver.findElement(By.xpath("//div[@class='FlightsDayView_results__1kZSn']//button[2]")).click();
		driver.findElement(By.xpath("//div[@class='FlightsDayView_results__1kZSn']//div[2]//div[1]//a[1]//div[1]//div[3]//div[1]//button[1]")).click();
		driver.findElement(By.xpath("//div[@id='modal-container']//div[3]//div[1]//div[2]//a[1]")).click();
		
		
		Thread.sleep(5000);
		driver.close();
		
	}

}
