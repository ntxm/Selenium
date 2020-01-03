package com.class06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utils.CommonMethods;

public class RecapDropdownMenu extends CommonMethods {
	
		public static void main(String[] args) throws InterruptedException {
			
			CommonMethods.setUp("chrome", "https://ebay.com");
			driver.manage().window().maximize();
			
			WebElement ddMenu = driver.findElement(By.xpath("//select[@id='gh-cat']"));
			Select dropdown = new Select(ddMenu);
			
			List<WebElement> linksDepartments = dropdown.getOptions();
			System.out.println(linksDepartments.size());
			
			for(WebElement el: linksDepartments) {
				el.click();
				System.out.println(el.getText());
				Thread.sleep(1000);
			}
			
			
			driver.close();
			
		}
	
		
		
		

}
