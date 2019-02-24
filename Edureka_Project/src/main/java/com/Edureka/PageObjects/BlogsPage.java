package com.Edureka.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Edureka.Utility.Log;

public class BlogsPage extends BaseClass {

	private static WebElement element;

	public BlogsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static WebElement Blog_button() throws Exception {
		element = null;
		try {
			element = driver.findElement(By
					.xpath("//a[@data-button-name='Blog all']"));
			Log.info("Blog Link is found and Opening in New Tab");
		} catch (Exception e) {
			Log.error("Blog button is not found");
			throw (e);
		}
		return element;
	}

	public static WebElement search_blog() {
		element = null;
		try {
			element = driver.findElement(By.id("search-inp"));
			Log.info("Search button is found");
		} catch (Exception e) {
			Log.error("Search button is not found");
			Log.error(e.toString());
		}
		return element;
	}

}
