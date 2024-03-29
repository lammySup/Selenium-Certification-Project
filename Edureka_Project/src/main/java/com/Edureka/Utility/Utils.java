package com.Edureka.Utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	public static WebDriver driver = null;
	public static int i =1;
	
	public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception {
		String sBrowserName;
		try {
			sBrowserName = ExcelUtils.getCellData(iTestCaseRow,Constant.Col_Browser);
			if (sBrowserName.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				driver = new ChromeDriver(options);
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				Log.info("New driver instantiated");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Log.info("Implicit wait applied on the driver for 20 seconds");
				driver.get(Constant.URL);
				Log.info("Web application launched successfully");
			}
		} catch (Exception e) {
			Log.error("Class Utils | Method OpenBrowser | Exception desc : "
					+ e.getMessage());
		}
		return driver;
	}

	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {
			Log.error("Class Utils | Method getTestCaseName | Exception desc : "
					+ e.getMessage());
			throw (e);
		}
	}

	public static void mouseHoverAction(WebElement mainElement,
			String subElement) {

		Actions action = new Actions(driver);
		action.moveToElement(mainElement).perform();
		if (subElement.equals("Accessories")) {
			action.moveToElement(driver.findElement(By.linkText("Accessories")));
			Log.info("Accessories link is found under Product Category");
		}
		if (subElement.equals("iMacs")) {
			action.moveToElement(driver.findElement(By.linkText("iMacs")));
			Log.info("iMacs link is found under Product Category");
		}
		if (subElement.equals("iPads")) {
			action.moveToElement(driver.findElement(By.linkText("iPads")));
			Log.info("iPads link is found under Product Category");
		}
		if (subElement.equals("iPhones")) {
			action.moveToElement(driver.findElement(By.linkText("iPhones")));
			Log.info("iPhones link is found under Product Category");
		}
		action.click();
		action.perform();
		Log.info("Click action is performed on the selected Product Type");
	}

	public static void waitForElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void takeScreenshot(WebDriver driver, String sTestCaseName)
			throws Exception {
		try {
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot
					+ sTestCaseName+String.valueOf(i) + ".jpg"));
			i++;
		} catch (Exception e) {
			Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "
					+ e.getMessage());
			throw new Exception();
		}
	}

}
