package com.Edureka.TestCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Edureka.AppModules.EditProfile_Action;
import com.Edureka.AppModules.LogOut_Action;
import com.Edureka.AppModules.SignIn_Action;
import com.Edureka.PageObjects.BaseClass;
import com.Edureka.Utility.Constant;
import com.Edureka.Utility.ExcelUtils;
import com.Edureka.Utility.Log;
import com.Edureka.Utility.PropertiesPath;
import com.Edureka.Utility.Utils;

@Listeners(com.Edureka.Utility.Listeners_Laxmi.class)
public class UpdateProfile {
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;

	@Test
	public void profileUpdate() throws Exception {
		try {
			SignIn_Action.Execute(iTestCaseRow);
			EditProfile_Action.execute();
			LogOut_Action.logOut();
		} catch (Exception e) {
			// TODO: handle exception
			// If in case you got any exception during the test, it will mark
			// your test as Fail in the test result sheet
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
