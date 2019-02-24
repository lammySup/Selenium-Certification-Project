package com.Edureka.AppModules;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.Edureka.PageObjects.BaseClass;
import com.Edureka.PageObjects.Home_Page;
import com.Edureka.Utility.Constant;
import com.Edureka.Utility.ExcelUtils;
import com.Edureka.Utility.Log;
import com.Edureka.Utility.Utils;

public class SignIn_Action extends BaseClass {

	public SignIn_Action(WebDriver driver) {
		super(driver);
	}

	public static void Execute(int iTestCaseRow) throws Exception {

		Actions actions = new Actions(driver);
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 20);
		 * wait.until(ExpectedConditions
		 * .elementToBeClickable(By.id("modalbanner"))); WebElement
		 * LClose_Button = driver.findElement(By.id("modalbanner"));
		 * actions.moveToElement(LClose_Button).click().perform();
		 */

		// Clicking on the My Account link on the Home Page
		Log.info("Click action is performed on My Account link");

		// Storing the UserName in to a String variable and Getting the UserName
		// from Test Data Excel sheet
		// iTestcaseRow is the row number of our Testcase name in the Test Data
		// sheet
		// Constant.Col_UserName is the column number for UserName column in the
		// Test Data sheet
		actions.moveToElement(driver.findElement(By.linkText("Log In")))
				.click().build().perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String sUserName = ExcelUtils.getCellData(iTestCaseRow,
				Constant.Col_UserName);
		String sPassword = ExcelUtils.getCellData(iTestCaseRow,
				Constant.Col_Password);
		// Here we are sending the UserName string to the UserName Textbox on
		// the LogIN Page

		actions.moveToElement(driver.findElement(By.id("si_popup_email")))
				.sendKeys(sUserName).sendKeys(Keys.TAB).build().perform();

		// Printing the logs for what we have just performed
		Log.info(sUserName + " is entered in UserName text box");

		actions.moveToElement(driver.findElement(By.id("si_popup_passwd")))
				.sendKeys(sPassword).build().perform();
		actions.moveToElement(
				driver.findElement(By
						.xpath("//button[contains(text(),'Login')]"))).click()
				.build().perform();

		Log.info("Click action is performed on Login button");

		// Now it will wait 10 secs separately before jumping out to next step
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Utils.waitForElement(Home_Page.SearchBar());

		// This is another type of logging, with the help of TestNg Reporter log
		// This has to be very carefully used, you should only print the very
		// important message in to this
		// This will populate the logs in the TestNG HTML reports
		Reporter.log("SignIn Action is successfully performed"+"\n");

	}

}
