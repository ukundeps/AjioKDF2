package com.ajio.customUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CustomUtil {

	static Properties prop = new Properties();

	//To get locatorName with type and value
	public static String getLocator(String locatorName) {
		String locator = "";
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\NRK\\javapract\\PriyaRevison\\AjioKDF2\\src\\main\\resources\\AjioObjectRepository.properties");
			prop.load(fis);
			locator = prop.getProperty(locatorName).trim();

		} catch (FileNotFoundException e) {
			System.out.println("Object repository not found!!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println("Locator Name: "+locator);
		return locator;

	}

	public static String[] getLocatorValue(String locatorName) {
		return getLocator(locatorName).split("##");

	}
	
	
	//To get actual Parameteres from Repository 
	
	public static String getParameter(String name) {
		String locator = "";
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\NRK\\javapract\\PriyaRevison\\AjioKDF2\\src\\main\\resources\\AjioObjectRepository.properties");
			prop.load(fis);
			locator = prop.getProperty(name).trim();

		} catch (FileNotFoundException e) {
			System.out.println("Object repository not found!!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*System.out.println("Config Parameter  Name: "+locator);*/
		return locator;

	}
	
	
/*public static void main(String[] args) {
	getLocator("button");
}
	*/
}
