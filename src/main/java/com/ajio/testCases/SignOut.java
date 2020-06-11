package com.ajio.testCases;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ajio.keyword.Keyword;

@Listeners(com.ajio.listner.Listener.class)
public class SignOut extends Keyword {
	@BeforeTest
	public static void setUp() {
		openBrowser();
		maxiBrowserWindow();
		launchURL();
		deleteAllCookies();
		pageLoadTimeOut();
		implicitWait();
	}

	// Problem: Sometime times without captcha we can signIn successfullly
	// butsometimes captch is showing so we can't

	@BeforeMethod(description = "To verify succesfull signIn after  entering valid email id / mobile number and  valid     Password  ")
	public static void signIn() {
		click("signIn/JoinAjio");
		enterText("email", "ukundepriya@gmail.com");
		click("continue");
		enterText("loginpassword", "Priya123@");
		click("startShopping");
		expllicitWait();
		try {
			Assert.assertTrue(isDisplayed("signOut"), "unsuccessfull login");
		} catch (StaleElementReferenceException e) {
			driver.navigate().refresh();
		}
	}

	@Test(description = "To verify succesfull Signout after  clicking on signout link ")
	public static void ajio_030() {
		click("signOut");
		expllicitWait();
		Assert.assertTrue(isDisplayed("signIn/JoinAjio"), "Unsuccessfull Signout");
	}

	@AfterMethod
	public static void tearDown() {
		driver.close();
	}
}
