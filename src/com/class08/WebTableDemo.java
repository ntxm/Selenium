package com.class08;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

public class WebTableDemo extends CommonMethods {

	public static void main(String[] args) {
		
		CommonMethods.setUp("chrome", Constants.SYNTAX_URL);
		
		//navigate to the table we need
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();
		
		//Find how many rows of data table has
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr"));
		System.out.println("Number of rows in the table: " + rows.size());
		
		//Number of columns
		List<WebElement> columns = driver.findElements(By.xpath("//table[@class='table table-hover']/thead[@class='thead-inverse']/tr/th"));
		System.out.println("Number of columns in the table: " + columns.size());
		
		System.out.println("--------- Printing Columns Headers ----------");
		
		for(WebElement col: columns) {
			System.out.println(col.getText());
		}
		
		
		System.out.println("--------- Printing Rows Data ----------");
		
		Iterator<WebElement> it = rows.iterator();
		while(it.hasNext()) {
			String data = it.next().getText();
			System.out.println(data);
		}
	}

}
