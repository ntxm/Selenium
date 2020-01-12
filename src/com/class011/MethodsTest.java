package com.class011;

import com.utils.CommonMethods;

public class MethodsTest extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", "https://expedia.com/");
		
		scrollDown(1000);
		Thread.sleep(3000);
		
		scrollUp(500);
		Thread.sleep(3000);
		
		driver.quit();
	}

}
