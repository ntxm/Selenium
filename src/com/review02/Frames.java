package com.review02;

import org.openqa.selenium.By;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Frames extends CommonMethods {

	public static void main(String[] args) {
		
		CommonMethods.setUp("chrome", Constants.WELCOME_TO_THE_INTERNET);
		
		driver.findElement(By.linkText("Frames")).click();
		driver.findElement(By.linkText("iFrame")).click();
		
		switchToFrame("mce_0_ifr");
		driver.findElement(By.xpath("//body[@id='tinymce']/p")).clear();
		driver.findElement(By.xpath("//body[@id='tinymce']/p")).sendKeys("New text is here");
		

	}

}
