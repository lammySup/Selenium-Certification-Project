package com.Edureka.Utility;

public class Constant {
	public static final String URL = "https://www.edureka.co/";
	public static final String Path_TestData = PropertiesPath.ExcelFilePath(); // "D:/EclipseLuna/Edureka-Project/DataExcel/";
	public static final String File_TestData = PropertiesPath.ExcelFileName(); // "TestData.xlsx";
	public static final String Path_ScreenShot = PropertiesPath.Screenshots();  // "./Screenshots/";
	
	// Test Data Sheet Columns
	public static final int Col_TestCaseName = 0;
	public static final int Col_UserName = 1;
	public static final int Col_Password = 2;
	public static final int Col_Browser = 3;
	public static final int Col_Course = 4;
	public static final int Col_Result = 5;
	
/*
	public static void main(String[] args) {
		System.out.println(Path_TestData);
		System.out.println(File_TestData);
		
	}*/
}
