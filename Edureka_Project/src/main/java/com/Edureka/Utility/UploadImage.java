package com.Edureka.Utility;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class UploadImage {

	private static final String Filepath = PropertiesPath.UploadImagePath();      // "D:\\Guru99Demo\\Files\\";
	private static final String InputFilePath = PropertiesPath.UploadImagePath(); // "D:\\Guru99Demo\\Files\\";

	static Pattern FileInput_TextBox = null;
	static Pattern Open_Button = null;

	public void MatchesPattern() throws FindFailed {
		// TODO Auto-generated method stub

		FileInput_TextBox = new Pattern(Filepath + "Filepath.PNG");
		Open_Button = new Pattern(InputFilePath + "OpenChoosenFile.PNG");

		Screen s = new Screen();
		s.wait(FileInput_TextBox, 20);
		s.type(FileInput_TextBox, InputFilePath);
		s.click(Open_Button);
		s.type(FileInput_TextBox,PropertiesPath.UploadImage());  // "IMG-20180612-WA0003.jpg"
		s.click(Open_Button);
		System.out.println("Uploading Choosen Image");

	}

}