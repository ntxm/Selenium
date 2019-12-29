package com.class04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestFirefox {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/natalia/eclipse-workspace/Selenium/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com/");

	}

}
