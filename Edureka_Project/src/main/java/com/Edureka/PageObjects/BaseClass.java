package com.Edureka.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseClass {
	public static WebDriver driver;
	public static boolean bResult;
	public Actions action;

	public BaseClass(WebDriver driver) {
		BaseClass.driver = driver;
		BaseClass.bResult = true;
	}

}
