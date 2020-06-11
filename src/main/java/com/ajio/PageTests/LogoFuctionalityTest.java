package com.ajio.PageTests;

import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
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
public class LogoFuctionalityTest extends SignInPage {
	 SignInPage signin;
	HomepagePage home;
	
	Logger log = Logger.getLogger(SignOutPageTest.class);

	

	@BeforeMethod
	public  void setUp() {
		openBrowser();
		maxiBrowserWindow();
		signin = new SignInPage();
		home = new HomepagePage();
		launchURL();
		deleteAllCookies();
		pageLoadTimeOut();
		implicitWait();

	}

	@Test(description = "Vreify logo functionality of redirecting to homepage")
	public void verify_logo_functionality() {
		home.clickSignIn_JoinAjio();
		if (signin.is_signInModalPop_Up_Visible()) {
			log.info("SignIn Modal Pop-up Opned!!");

			signin.enterEmailOrMobileNumer();
			signin.click_On_continueButton();
			signin.enterPassword();
			signin.click_On_startShopping();
			expllicitWait();
		} else {
			log.error("Signin Modal PopUp not Opened!!");
		}
		try {
			Assert.assertTrue(signin.is_MyAccount_Visible(), "Unsuccessfull Login!!!");
		} catch (StaleElementReferenceException e) {
			refresh();
		}

		signin.click_On_MyAccount();
		if (driver.getTitle().equals("AJIO")) {
			log.info("Redirected to My Account Page");
		} else {
			log.error("Not Redirected to My Account Page");
		}

		signin.click_On_Logo();
		Assert.assertTrue(
				driver.getTitle().equals("Online Shopping for Women, Men, Kids – Clothing, Footwear, Fashion | AJIO"));

	}

	@AfterMethod
	public static void tearDown() {
		driver.close();
	}

}