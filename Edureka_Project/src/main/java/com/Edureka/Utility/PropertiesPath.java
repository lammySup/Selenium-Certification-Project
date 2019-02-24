package com.Edureka.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesPath {

	private static String LoggerPath;
	private static String ExcelFilePath;
	private static String ExcelFileName;
	private static String Screenshots;
	private static String UploadImagePath;
	private static String UploadImage;

	public static void main(String[] args) {
		System.out.println(setLoggerPath());
		System.out.println(ExcelFilePath());
		System.out.println(ExcelFileName());
		System.out.println(Screenshots());
		System.out.println(UploadImagePath());
		System.out.println(UploadImage());
	}
	public static String setLoggerPath() {
		try {
			Properties p = new Properties();
			// Read object repository file
			InputStream stream = new FileInputStream(new File(
					"./path.properties"));
			// load all objects
			p.load(stream);
			LoggerPath = (String) p.get("loggerpath");
			Log.info("Path of Logger XML" + LoggerPath);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return LoggerPath;

	}

	public static String ExcelFilePath() {
		try {
			Properties p = new Properties();
			// Read object repository file
			InputStream stream = new FileInputStream(new File(
					"./path.properties"));
			// load all objects
			p.load(stream);
			ExcelFilePath = (String) p.get("ExcelFilePath");
			Log.info("Path of Excel File Path" +ExcelFilePath);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ExcelFilePath;

	}

	public static String ExcelFileName() {
		try {
			Properties p = new Properties();
			// Read object repository file
			InputStream stream = new FileInputStream(new File(
					"./path.properties"));
			// load all objects
			p.load(stream);
			ExcelFileName = (String) p.get("ExcelFileName");
			Log.info("Path of Excel File Name" + ExcelFileName);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ExcelFileName;

	}

	public static String Screenshots() {
		try {
			Properties p = new Properties();
			// Read object repository file
			InputStream stream = new FileInputStream(new File(
					"./path.properties"));
			// load all objects
			p.load(stream);
			Screenshots = (String) p.get("Screenshots");
			Log.info("Path of Screenshots Folder Path" +Screenshots);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Screenshots;

	}

	public static String UploadImagePath() {
		try {
			Properties p = new Properties();
			// Read object repository file
			InputStream stream = new FileInputStream(new File(
					"./path.properties"));
			// load all objects
			p.load(stream);
			UploadImagePath = (String) p.get("UploadImagePath");
			Log.info("Path of Image To be Upload" + UploadImagePath);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return UploadImagePath;

	}

	public static String UploadImage() {
		try {
			Properties p = new Properties();
			// Read object repository file
			InputStream stream = new FileInputStream(new File(
					"./path.properties"));
			// load all objects
			p.load(stream);
			UploadImage = (String) p.get("UploadImage");
			Log.info("Path of Image To be Upload" + UploadImage);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return UploadImage;

	}

}
