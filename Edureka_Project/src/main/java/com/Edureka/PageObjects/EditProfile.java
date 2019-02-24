package com.Edureka.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Edureka.Utility.Log;

public class EditProfile extends BaseClass {

	private static WebElement element;

	public EditProfile(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static WebElement ClickOn_MyProfileImage() {
		element = null;
		try {
			element = driver.findElement(By.xpath("//img[@class='img30']"));
			Log.info("Clicking On MY Profile Image on Home Page");
		} catch (Exception e) {
			Log.error("Continue button on Home page is not found");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement ClickOn_MyProfile_Button() {
		element = null;
		try {
			element = driver.findElement(By
					.xpath("//a[@data-button-name='My Profile']"));
			Log.info("Clicking On MY Profile on Home Page");
		} catch (Exception e) {
			Log.error("Continue button on Home page is not found");
			//throw (e);
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement ClickOn_Personal_Details() {
		element = null;
		try {
			element = driver.findElement(By.id("personal_details"));
			Log.info("Clicking on Personal_Details");
		} catch (Exception e) {
			Log.error("Continue button on Home page is not found");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement ClickOn_UploadCameraIcon() {
		element = null;
		try {
			element = driver.findElement(By.xpath("//i[@class='icon-camera']"));
			Log.info("Clicking on UploadCamera Icon to upload Photo");
		} catch (Exception e) {
			Log.error("Continue button on Home page is not found");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement ClickOn_ChooseFile() {
		element = null;
		try {
			element = driver.findElement(By
					.xpath("//span[contains(text(),'Choose File')]"));
			Log.info("Clicking on Choose File Icon to upload Photo");
		} catch (Exception e) {
			Log.error("Continue button on Home page is not found");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement ClickOn_UploadButton() {
		element = null;
		try {
			element = driver.findElement(By
					.xpath("//button[contains(text(),'Upload')]"));
			Log.info("Clicking on Upload Button to upload Photo");
		} catch (Exception e) {
			Log.error("Continue button on Home page is not found");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement Update_FullName() {
		element = null;
		try {
			element = driver.findElement(By.name("fullname"));
			Log.info("Updating Personal Details >> Full Name");
		} catch (Exception e) {
			Log.error("Continue button on Home page is not found");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement Upadate_CurrentRole() {
		element = null;
		try {
			element = driver.findElement(By
					.xpath("//input[@formcontrolname='currentrole']"));
			Log.info("Updating Personal Details >> Current Role");
		} catch (Exception e) {
			Log.error("Continue button on Home page is not found");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement Update_Experience() {
		element = null;
		try {
			element = driver.findElement(By.id("experience"));
			Log.info("Updating Personal Details >> Experience");
		} catch (Exception e) {
			Log.error("Continue button on Home page is not found");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement Update_CompanyName() {
		element = null;
		try {
			element = driver.findElement(By.name("companyName"));
			Log.info("Updating Personal Details >> Update Company Name");
		} catch (Exception e) {
			Log.error("Continue button on Home page is not found");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement Update_CurrentJob() {
		element = null;
		try {
			element = driver.findElement(By.name("currentjob"));
			Log.info("Updating Personal Details >> Update Current Job");
		} catch (Exception e) {
			Log.error("Continue button on Home page is not found");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement Update_CurrentIndustry() {
		element = null;
		try {
			element = driver
					.findElement(By.name("currentIndustry"));
			Log.info("current industry dropdown button is found on the Edit profile");
		} catch (Exception e) {
			Log.error("current industry dropdown button is  notfound on the Edit profile");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement Update_LinkedinProfile() {
		element = null;
		try {
			element = driver.findElement(By.name("linkedinLink"));
			Log.info("Updating Personal Details >> Update Linkedin Profile");
		} catch (Exception e) {
			Log.error("Continue button on Home page is not found");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement Update_UserSkill() {
		element = null;
		try {
			element = driver.findElement(By.name("userSkill"));
			Log.info("Updating Personal Details >> Update Skills");
		} catch (Exception e) {
			Log.error("Continue button on Home page is not found");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement Update_IntrestedJob() {
		element = null;
		try {
			element = driver.findElement(By.name("interestedJob"));
			Log.info("Intrested Job dropdown button is found");
		} catch (Exception e) {
			Log.error("Intrested Job dropdown button is found");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement Update_EmploymentType() {
		element = null;
		try {
			element = driver.findElement(By.name("elementType"));
			Log.info("emplyement Type dropdown button is found on the Edit profile");
		} catch (Exception e) {
			Log.error("emplyement Type dropdown button is not found on the Edit profile");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement Update_CTC() {
		element = null;
		try {
			element = driver.findElement(By.name("lastDrawnSalary"));
			Log.info("ctc dropdown button is found on the Edit profile");
		} catch (Exception e) {
			Log.error("ctc dropdown button is not found on the Edit profile");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement ClickOn_Next() {
		element = null;
		try {
			element = driver.findElement(By.xpath("//button[@type='submit']"));
			Log.info("Click On Next Button - Save");
		} catch (Exception e) {
			Log.error("Click On Next Button - Failed");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement ClickOn_Continue() {
		element = null;
		try {
			element = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
			Log.info("Click On Continue Button - Save");
		} catch (Exception e) {
			Log.error("Click On Continue Button - Failed");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement ClickOn_Back() {
		element = null;
		try {
			element = driver.findElement(By.xpath("//i[@class='icon-Arrow-Left']"));
			Log.info("Click On Back Button - After Saving !!!");
		} catch (Exception e) {
			Log.error("Click On Back Button - Failed");
			Log.error(e.toString());
		}
		return element;
	}

	public static WebElement ClickOnEdurekaLogo() {
		element = null;
		try {
			element = driver.findElement(By.xpath("//i[@class='icon-logo']"));
			Log.info("Go To Home Page and Logout");
		} catch (Exception e) {
			Log.error("Go To Home Page and Logout");
			Log.error(e.toString());
		}
		return element;
	}
}
