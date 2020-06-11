package com.ajio.PageTests;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ajio.Pages.HomepagePage;
import com.ajio.Pages.SignInPage;
import com.ajio.Pages.SignOutPage;

@Listeners(com.ajio.listner.Listener.class)
public class SignOutPageTest extends SignOutPage {
	
	SignInPage signin;
	 SignOutPage signout;
	HomepagePage home;
	Logger log = Logger.getLogger(SignOutPageTest.class);

	

	@BeforeMethod
	public  void setUp() {
		openBrowser();
		maxiBrowserWindow();
		signout = new SignOutPage();
		signin = new SignInPage();
		home = new HomepagePage();
		launchURL();
		deleteAllCookies();
		pageLoadTimeOut();
		implicitWait();

	}

	@Test(description = "To verify successfull SignOut after clicking on SignOut Link")
	public  void verify_Successfull_SignOut() {
		home.clickSignIn_JoinAjio();
		signin.enterEmailOrMobileNumer();
		signin.click_On_continueButton();
		signin.enterPassword();
		signin.click_On_startShopping();
		Assert.assertTrue(signin.is_MyAccount_Visible(), "Unsuccessfull SignIn");

		Assert.assertTrue(signout.click_On_signOut(), "Unsuccessfull SignOut!!");
	}

	@AfterMethod
	private void tearDown() {
		closeBrowserWindow();
	}
}
