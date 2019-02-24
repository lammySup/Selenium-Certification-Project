package com.Edureka.TestCases;

import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Edureka.AppModules.SignIn_Action;
import com.Edureka.PageObjects.BaseClass;
import com.Edureka.Utility.Constant;
import com.Edureka.Utility.ExcelUtils;
import com.Edureka.Utility.Log;
import com.Edureka.Utility.PropertiesPath;
import com.Edureka.Utility.Utils;

@Listeners(com.Edureka.Utility.Listeners_Laxmi.class)
public class ExploretheCoursesRegistered {

	public WebDriver driver;
	public WebDriverWait wait;
	private String sTestCaseName;
	private int iTestCaseRow;
	public Actions action = null;

	@Test
	public void EnrolledCourse() throws Exception {

		try {
			SignIn_Action.Execute(iTestCaseRow);
			wait = new WebDriverWait(driver, 20);
			action = new Actions(driver);
			wait.until(ExpectedConditions.elementToBeClickable(By
					.id("dropdownMenu3")));
			WebElement LCourses = driver.findElement(By.id("dropdownMenu3"));
			action.moveToElement(LCourses).click().build().perform();

			WebElement LAll_Courses = driver
					.findElement(By
							.xpath("//a[@id='dropdownMenu3']//following::a[@data-button-name='My Classroom']"));
			action.moveToElement(LAll_Courses).click().build().perform();
			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//span[contains(text(),'My Classroom')]")));

			if (driver.getPageSource().contains(
					"It looks like you are not enrolled for any course")) {
				System.out.println("Not enrolled to any course");
			} else {
				System.out.println("You have enrolled for below courses");
				Log.info("################## You have enrolled for below courses #################");

				List<WebElement> LEnrolledCourses = driver.findElements(By
						.xpath("//span[@class='name']"));

				for (WebElement EnrolledCourse : LEnrolledCourses) {
					System.out.println(EnrolledCourse.getText());
					Log.info("Enrolled Course - " + EnrolledCourse.getText());

				}

				WebElement LProfilePic = driver.findElement(By
						.className("user_image"));
				action.moveToElement(LProfilePic).click().build().perform();
				WebElement LLogOut = driver.findElement(By
						.xpath("//a[contains(text(),'Log Out')]"));
				action.moveToElement(LLogOut).click().build().perform();

				wait.until(ExpectedConditions
						.titleContains("Instructor-Led Online Training with 24X7 Lifetime Support | Edureka"));

				// This is to check that if any of your verification during the
				// execution is failed
				if (BaseClass.bResult == true) {
					// If the value of boolean variable is True, then your test
					// is
					// complete pass and do this
					ExcelUtils.setCellData("Pass", iTestCaseRow,
							Constant.Col_Result);
				} else {
					// If the value of boolean variable is False, then your test
					// is
					// fail, and you like to report it accordingly
					// This is to throw exception in case of fail test, this
					// exception will be caught by catch block below
					throw new Exception(
							"Test Case Failed because of Verification");
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			// If in case you got any exception during the test, it will mark
			// your test as Fail in the test result sheet
			ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
			Utils.takeScreenshot(driver, sTestCaseName);
			Log.error(e.getMessage());
			// Again throwing the exception to fail the test completely in the
			// TestNG results
			throw (e);
		}

	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		// Configuring Log4j logs, please see the following posts to learn about
		// Log4j Logging
		DOMConfigurator.configure(PropertiesPath.setLoggerPath());

		// Getting the Test Case name, as it will going to use in so many places
		// The main use is to get the TestCase row from the Test Data Excel
		// sheet
		sTestCaseName = this.toString();
		// From above method we get long test case name including package and
		// class name etc.
		// The below method will refine your test case name, exactly the name
		// use have used
		sTestCaseName = Utils.getTestCaseName(this.toString());

		// Start printing the logs and printing the Test Case name
		Log.startTestCase(sTestCaseName);

		// Setting up the Test Data Excel file using Constants variables
		ExcelUtils.setExcelFile(
				Constant.Path_TestData + Constant.File_TestData, "Sheet1");

		// Fetching the Test Case row number from the Test Data Sheet
		// This row number will be feed to so many functions, to get the
		// relevant data from the Test Data sheet
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,
				Constant.Col_TestCaseName);
		// Launching the browser, this will take the Browser Type from Test Data
		// Sheet
		driver = Utils.OpenBrowser(iTestCaseRow);

		// Initializing the Base Class for Selenium driver
		new BaseClass(driver);
	}

	@AfterMethod
	public void afterMethod() {
		// Printing beautiful logs to end the test case
		Log.endTestCase(sTestCaseName);
		// Closing the opened driver
		driver.quit();
	}
}
