package com.Edureka.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Edureka.Utility.Log;

public class Home_Page extends BaseClass {
	
	private static WebElement element = null;

	public Home_Page(WebDriver driver) {
		super(driver);
	}

	public static WebElement SearchBar() throws Exception {
		try {
			//element = driver.findElement(By.id("homeSearhBar"));
			element = driver.findElement(By.xpath("//input[@placeholder='Enter Course, Category or keyword']"));
			Log.info("Search Criteria is found on Home Screen");
		} catch (Exception e) {
			Log.error("Search Button is not found");
			throw (e);
		}
		return element;
	}

	public static WebElement SearchCourse() throws Exception {
		try {
			element = driver
					.findElement(By
							.xpath("//h3[contains(text(),'Robotic Process Automation Training  using UiPath')]"));
			Log.info("Searched course is found");
		} catch (Exception e) {
			Log.error("Searched course is not found");
			throw (e);
		}
		return element;
	}

	public static WebElement EnrollButton() throws Exception {

		try {
			element = driver.findElement(By
					.xpath("//*[@id=\"Batches\"]/div/div[2]/div[2]/a/button"));
			Log.info("Enroll button is found");
		} catch (Exception e) {
			Log.error("Enroll button is not found");
			throw (e);
		}
		return element;
	}

}
