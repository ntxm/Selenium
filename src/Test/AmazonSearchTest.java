package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonSearchTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//full screen
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com");
		
		//check logo 
		boolean logoPresented = driver.findElement(By.xpath("//a[@class='nav-logo-link']")).isDisplayed();
		if(logoPresented) {
			System.out.println("Logo presented");
		}else {
			System.out.println("Check logo. Something went wrong");
		}
		
		//find product
		driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys("perrier sparkling water");
		driver.findElement(By.xpath("//input[@value = 'Go']")).click();
		Thread.sleep(1000);
		
		//Sort search button
		driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']")).click();
		driver.findElement(By.xpath("//a[@id='s-result-sort-select_1']")).click();
		Thread.sleep(1000);
		
		//CheckBox --> search filters
	 	WebElement checkBox = driver.findElement(By.xpath("//li[@id='p_85/2470955011']//i[@class='a-icon a-icon-checkbox']"));
	    checkBox.click();
	 
		WebElement checkBox1 = driver.findElement(By.xpath("//li[@id='p_89/Perrier']//i[@class='a-icon a-icon-checkbox']"));
		checkBox1.click();
		Thread.sleep(1000);
		
		//Add to Cart first position
		driver.findElement(By.xpath("//span[@class='celwidget slot=SEARCH_RESULTS template=SEARCH_RESULTS widgetId=search-results index=0']//img[@class='s-image']")).click();
		
		//Drop-down menu --> change quantity
		//driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']")).click();
		
		
		Thread.sleep(5000);
		driver.close();
		

	}

}
