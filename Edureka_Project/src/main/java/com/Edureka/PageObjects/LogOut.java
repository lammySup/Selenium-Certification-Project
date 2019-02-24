package com.Edureka.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Edureka.Utility.Log;

public class LogOut extends BaseClass {

	private static WebElement element;

	public LogOut(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static WebElement Logout_button() {
		element = null;
		try {
			element = driver.findElement(By
					.xpath("//a[@data-button-name='Logout']"));
			Log.info("Logout Button is Found");
		} catch (Exception e) {
			Log.error("Logout Button is Found");
			Log.error(e.toString());
		}
		return element;
	}

}