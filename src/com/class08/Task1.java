package com.class08;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;
import com.utils.Constants;

/*
 * TC 1: Table headers and rows verification

	Open chrome browser
	Go to “http://166.62.36.207/syntaxpractice/”
	Click on “Table” link
	Click on “ITable Data Search” link
	Verify second table consist of 4 rows and 5 columns
	Print name of all column headers 
	Print data of all rows
	Quit Browser
 * 
 */

public class Task1 extends CommonMethods {

	public static void main(String[] args) {
		
		CommonMethods.setUp("chrome", Constants.SYNTAX_URL);
		
		//navigate to the table we need
			driver.findElement(By.linkText("Table")).click();
			driver.findElement(By.linkText("Table Data Search")).click();
			
			List<WebElement> columns = driver.findElements(By.xpath("//table[@class='table']/thead[@class='thead-inverse']/tr/th"));
			System.out.println("Number of Columns: " + columns.size());
			
			List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
			System.out.println("Number of rows: " + rows.size());
			
			System.out.println();
			System.out.println("===== HEADER TITLES =====");
			
			Iterator<WebElement> it = columns.iterator();
			while(it.hasNext()) {
				String title = it.next().getText();
				System.out.println(title);
			}
			
			System.out.println();
			System.out.println("===== Printing data =====");
			
			for(WebElement row: rows) {
				System.out.println(row.getText());
			}
			
			System.out.println();
			System.out.println("===== Printing data cell by cell using advanced for loop =====");
			List<WebElement> cells = driver.findElements(By.xpath("//table[@class='table']/tbody/tr/td"));
			for(WebElement cell: cells) {
				String cellData = cell.getText();
				System.out.println(cellData);
			}
			
			
			System.out.println();
			System.out.println("===== Printing data cell by cell using for loop =====");
			for(int i=1; i<= rows.size(); i++) { //this loop controlling rows
				for(int j = 1; j<= columns.size(); j++) {//this loop controlling columns
					String text = driver.findElement(By.xpath("//table[@class='table']/tbody/tr["+ i +"]/td[" + j + "]")).getText();
					System.out.println(text);
				}
			}
				
			
			//Check actual end expected 
			System.out.println();
			System.out.println("======TEST RESULT=====");
			if(columns.size() == 5 && rows.size() == 4) {
				System.out.println("Test passed! Columns and rows as expected");
			}else {
				System.err.println("Test failed: Columns: " + columns.size());
				System.err.println("Test failed: Rows: " + rows.size());
				System.out.println("Expected columns: 4 and expected rows: 5");
			}
			
			
			
			driver.close();
	}

}
