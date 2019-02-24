package com.Edureka.AppModules;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Edureka.PageObjects.BaseClass;
import com.Edureka.PageObjects.EditProfile;
import com.Edureka.Utility.Log;
import com.Edureka.Utility.UploadImage;

public class EditProfile_Action extends BaseClass {

	public static Actions action = null;
	public static WebDriverWait wait;

	public EditProfile_Action(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// iTestcaseRow is the row number of our Testcase name in the Test Data
	// sheet
	// iTestcaseRow is passed as an Argument to this method, so that it can used
	// inside this method
	public static void execute() throws Exception {
		wait = new WebDriverWait(driver, 30);
		action = new Actions(driver);
		try {
			action.moveToElement(EditProfile.ClickOn_MyProfileImage()).click()
					.build().perform();
			action.moveToElement(EditProfile.ClickOn_MyProfile_Button())
					.click().build().perform();
			Log.info("Navgating to my profile page");

			wait.until(ExpectedConditions.visibilityOf(EditProfile
					.ClickOn_Personal_Details()));
			action.moveToElement(EditProfile.ClickOn_Personal_Details())
					.click().build().perform();
			Log.info("Update Profile Details >> Personal Details");
			Thread.sleep(2000);
			action.moveToElement(EditProfile.ClickOn_UploadCameraIcon())
					.click().build().perform();
			wait.until(ExpectedConditions.visibilityOf(EditProfile
					.ClickOn_ChooseFile()));
			action.moveToElement(EditProfile.ClickOn_ChooseFile()).click()
					.build().perform();
			UploadImage uploadImage = new UploadImage();
			uploadImage.MatchesPattern();

			wait.until(ExpectedConditions.elementToBeClickable(EditProfile
					.ClickOn_UploadButton()));
			action.moveToElement(EditProfile.ClickOn_UploadButton()).click()
					.build().perform();
			wait.until(ExpectedConditions.invisibilityOf(EditProfile
					.ClickOn_UploadButton()));

			Log.info("################## Personal Details #####################");

			wait.until(ExpectedConditions.visibilityOf(EditProfile
					.Update_FullName()));
			action.moveToElement(EditProfile.Update_FullName()).click()
					.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Laxmi Prakash")
					.build().perform();
			Log.info("Full Name field updated successfully");

			action.moveToElement(EditProfile.Upadate_CurrentRole())
					.click()
					.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Automated Tester")
					.sendKeys(Keys.TAB).build().perform();
			Log.info("Current Role updated successfully");
			Log.info("Changes Validated successfully");

			Select SelectExperience = new Select(
					EditProfile.Update_Experience());
			SelectExperience.selectByValue("2-4 years");
			Log.info("Changes Validated successfully");
			Log.info("Selected the professional experience from the dropdown menu");

			ValidateChangesSaved();

			action.moveToElement(EditProfile.ClickOn_Continue()).click()
					.build().perform();

			Log.info("################## Professional Details #####################");

			wait.until(ExpectedConditions.visibilityOf(EditProfile
					.Update_CompanyName()));
			action.moveToElement(EditProfile.Update_CompanyName())
					.click()
					.sendKeys(Keys.chord(Keys.CONTROL, "a"),
							"QualityKiosk Technologies Pvt. Ltd.").build()
					.perform();
			Log.info("Changes Validated successfully");
			Log.info("Updated Company Name");

			// action.moveToElement(EditProfile.Update_CurrentJob()).click()
			// .build().perform();
			Select SelectCurrentJob = new Select(
					EditProfile.Update_CurrentJob());
			SelectCurrentJob.selectByValue("Mid Management");
			Log.info("Changes Validated successfully");
			Log.info("Updated Current Job Level");

			Select SelectCurrentIndustry = new Select(
					EditProfile.Update_CurrentIndustry());
			SelectCurrentIndustry
					.selectByValue("IT-Software / Software Services");
			Log.info("Changes Validated successfully");
			Log.info("Updated Current Industry");

			action.moveToElement(EditProfile.Update_LinkedinProfile())
					.click()
					.sendKeys(Keys.chord(Keys.CONTROL, "a"),
							"www.linkedin.com/in/laxmi-prakash-10670078")
					.build().perform();
			Log.info("Changes Validated successfully");
			Log.info("Updated Linkedin Profile");

			action.moveToElement(EditProfile.Update_UserSkill())
					.click()
					.sendKeys(Keys.chord(Keys.CONTROL, "a"),
							"Jmeter,Silk Performer,AppDynamics,Dynatrace,Load Testing,Client Meetings")
					.build().perform();
			Log.info("Changes Validated successfully");
			Log.info("Updated Linkedin Profile");

			ValidateChangesSaved();

			action.moveToElement(EditProfile.ClickOn_Next()).click().build()
					.perform();

			Log.info("################## Career Details #####################");

			wait.until(ExpectedConditions.visibilityOf(EditProfile
					.Update_IntrestedJob()));
			Select SelectIntrestedJob = new Select(
					EditProfile.Update_IntrestedJob());
			SelectIntrestedJob.selectByValue("Software Testing");
			Log.info("Changes Validated successfully");
			Log.info("Updated Intrested Job");

			Select SelectEmploymentType = new Select(
					EditProfile.Update_EmploymentType());
			SelectEmploymentType.selectByValue("Permanent");
			Log.info("Changes Validated successfully");
			Log.info("Updated Employment Type");

			Select Select_CTC = new Select(EditProfile.Update_CTC());
			Select_CTC.selectByValue("5-10 LPA");
			Log.info("Changes Validated successfully");
			Log.info("Updated Employment Type");

			ValidateChangesSaved();

			action.moveToElement(EditProfile.ClickOn_Back()).click().build()
					.perform();
			action.moveToElement(EditProfile.ClickOnEdurekaLogo()).click()
					.build().perform();

		} catch (Exception e) {
			throw (e);
		}
	}

	public static void ValidateChangesSaved() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.className("changes-saved")));
	}

}
