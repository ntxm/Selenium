package com.class02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookCreateAcc {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		//driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Lola");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Lorina");
		driver.findElement(By.xpath("//input[@id='u_0_k']")).sendKeys("LolaLorina@qwe.org");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("LolaLorina@qwe.org");
		driver.findElement(By.xpath("//input[@id='u_0_p']")).sendKeys("123weeeq");
		
		//dropdown menu block --- Birthday
		Select dropdownMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		dropdownMonth.selectByVisibleText("Nov");
		
		Select dropdownDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		dropdownDay.selectByVisibleText("12");
		
		Select dropdownYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		dropdownYear.selectByVisibleText("1989");
		
		//radio button block --- Gender
		WebElement radio1 = driver.findElement(By.id("u_0_b"));
		radio1.click();
		
		//dropdown meny Preffered Pronoun --- Gender -- Custom
		Select dropdownPronoun = new Select(driver.findElement(By.xpath("//select[@name='preferred_pronoun']")));
		dropdownPronoun.selectByIndex(3);
		driver.findElement(By.xpath("//input[@name='custom_gender']")).sendKeys("Unknown");
		
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		
		Thread.sleep(5000);
		
		driver.close();
		
		
		
		
		
		
		
		

		
		
	}

}
