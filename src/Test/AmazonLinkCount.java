package Test;

/*
 * TC 1: Amazon link count: 
 * 1.Open chrome browser
 * 2.Go to “https://www.amazon.com/”
 * 3.Get all links
 * 4.Get number of links that has text
 * 5.Print to console only the links that has text
 */
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonMethods;

public class AmazonLinkCount extends CommonMethods {

	public static void main(String[] args) {
		
		
		String text = "";
		int count = 0;
		
		CommonMethods.setUp("chrome", "https://www.amazon.com/");
		driver.manage().window().maximize();
		
		//get all links from main page
		List<WebElement> listLinks = driver.findElements(By.tagName("a"));
		
		System.out.println("***** ===== Links with text ====== *****");
		for(WebElement link: listLinks) {
			
			text = link.getText();
			if(text.isEmpty()) {
				count++;
			}else {
				System.out.println(link.getText());
			}
		}
		
		System.out.println("Total links: " + listLinks.size());
		System.out.println("Total empty links: " + count);
		System.out.println("Total links with text: " + (listLinks.size() - count));
		
		
		driver.close();
	}

}
