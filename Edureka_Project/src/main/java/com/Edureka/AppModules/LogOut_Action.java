package com.Edureka.AppModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Edureka.PageObjects.BaseClass;
import com.Edureka.PageObjects.EditProfile;
import com.Edureka.PageObjects.LogOut;
import com.Edureka.Utility.Log;
import com.Edureka.Utility.Utils;

public class LogOut_Action extends BaseClass {
	private static WebElement L_Logout;
	static Actions action = null;

	public LogOut_Action(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void logOut() throws Exception {
		action = new Actions(driver);
		Utils.waitForElement(EditProfile.ClickOn_MyProfileImage());
		action.moveToElement(EditProfile.ClickOn_MyProfileImage()).click()
				.build().perform();
		L_Logout = LogOut.Logout_button();
		Utils.waitForElement(L_Logout);
		action.moveToElement(L_Logout).click().build().perform();
		Log.info("Performing Logout from Edureka");
	}

}
