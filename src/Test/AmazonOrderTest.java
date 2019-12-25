package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonOrderTest {

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
		Thread.sleep(3000);
		
		//drop-down menu
		driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']")).click();
		driver.findElement(By.xpath("//a[@id='s-result-sort-select_1']")).click();
		Thread.sleep(2000);
		
		//Select dropdownMenu = new Select(driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']")));
		//dropdownMenu.deselectByVisibleText("Price: Low to High");
		
		
		//CheckBox --> search filters
			
		WebElement checkBox = driver.findElement(By.xpath("//i[@class = 'a-icon a-icon-checkbox']"));
		//WebElement checkBox = driver.findElement(By.id("//div[@id='primeRefinements']"));
		checkBox.click();
		Thread.sleep(5000);
		driver.close();
		

	}

}
