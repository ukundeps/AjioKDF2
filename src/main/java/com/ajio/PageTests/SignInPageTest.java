package com.ajio.PageTests;

import org.apache.log4j.Logger;
import org.hamcrest.core.IsSame;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ajio.Pages.HomepagePage;
import com.ajio.Pages.SignInPage;

@Listeners(com.ajio.listner.Listener.class)
public class SignInPageTest extends SignInPage {

	SignInPage signin;
	HomepagePage home;
	Logger log = Logger.getLogger(SignInPageTest.class);

	@BeforeMethod
	public void setUp() {
		openBrowser();
		maxiBrowserWindow();
		signin = new SignInPage();
		home = new HomepagePage();
		launchURL();
		deleteAllCookies();
		pageLoadTimeOut();
		implicitWait();

	}

	@Test(description = "To verify Successfull Login after providing valid username and password", groups = "Smoke Testing")
	public void verify_Successfull_Login() {
		home.clickSignIn_JoinAjio();
		signin.enterEmailOrMobileNumer();
		signin.click_On_continueButton();
		signin.enterPassword();
		signin.click_On_startShopping();
		Assert.assertTrue(signin.is_MyAccount_Visible(), "Unsuccessfull SignIn");

	}

	@Test(description = "To verify signIn_JoinAjio Link is redirecting to  loginformEmai Modal popUp ", groups = "Functional  Testing")
	public void verify_signIn_JoinAjio_Link_is_Redirecting_to_signUpModalPopUp() {
		home.clickSignIn_JoinAjio();
		Assert.assertTrue(signin.verify_loginformEmail_Visbile(), "loginformEmail_Visbile is not opened!!");

	}

	@Test(description = "To verify all  elements on login Form_Email  is Visible", groups = "Usability Testing")
	public void verify_loginFormEmail_Elements_Visibile() {
		home.clickSignIn_JoinAjio();
		Assert.assertTrue(signin.verify_WelcomeAjioMessage_Visbile(), "Welcome to AJIO message not visible!!");
		Assert.assertTrue(signin.verify_FacebookLogin_Visbile(), "Facebook Login is not visible!!");
		Assert.assertTrue(signin.verify_GoogleLogin_Visbile(), "Google login is not visible!!");
		Assert.assertTrue(signin.verify_EnterEmail_MobileNumber_Message_Visbile(),
				"Enter Email/Mobile number text Is not visible");
		Assert.assertTrue(signin.verify_termsAndCondition_Link_Visbile(), "Terms And Conditions Link is not visible!!");
		Assert.assertTrue(signin.verify_ContinueButton_Visbile(), "Continue button is not visisble!!");
		Assert.assertTrue(signin.verify_closeIcon_Visbile(), "Close icon is not displayed");

	}

	@Test(description = "To verify  termsAndCondition_Link_ is redirecting to terms and  ondition page", groups = "Functional  Testing")
	public void verify_TACLink_is_redirecting_to_TACPage() {
		home.clickSignIn_JoinAjio();
		Assert.assertEquals(signin.verify_termsAndCondition_Link_redirectingTo_TermsAndConditionPage(),
				"Terms & Conditions | Terms of Use | AJIO", "TAC Page title mismatched!!");
	}

	@Test(description = "To verify  after clicking on close icon, the loginForm is closing", groups = "Functional  Testing")
	public void verify_closing_LoginForm() {
		home.clickSignIn_JoinAjio();
		Assert.assertTrue(signin.click_closeIcon(), "Login FormNot closed!!!!");
	}

	@Test(description = "To verify After entering valid username and clicking on continue shoping LoginForm_Password Modal pop_Up Is dispaying", groups = "Functional  Testing")
	public void verify_loginForm_Password_ModalPopUp_Visible() {
		home.clickSignIn_JoinAjio();
		Assert.assertTrue(signin.verify_loginForm_Password_Visbile(), "loginForm_Password_is not Visbile");

	}

	@Test(description = "To verify all  elements on login Form_Password  is Visible", groups = "Usability Testing")
	public void verify_loginFormPassword_Elements_Visibile() {
		home.clickSignIn_JoinAjio();
		signin.verify_loginForm_Password_Visbile();
		Assert.assertTrue(signin.verify__gladYouAreBackMeg_Visible(), "Gald you are back  message not visible!!");
		Assert.assertTrue(signin.verify_enterYourPass_Text_Visible(), "Enter Password test  is not visible!!");
		Assert.assertTrue(signin.verify_loginWithOTP_Visible(), "LoginWith OTP Button  is not visible!!");
		Assert.assertTrue(signin.verify_backIcon_Visible(), "Back Icon  is not visible!!");
		Assert.assertTrue(signin.verify_closeIcon_Visbile(), "Close Icon  is not visible!!");

	}

	@Test(description = "To verify after clicking on signIn With Otp button Respective modal PopUp is displaying", groups = "Functional  Testing")
	public void verify_SignInWithOtp_ModalPop_Up() {
		home.clickSignIn_JoinAjio();
		signin.verify_loginForm_Password_Visbile();
		signin.click_loginWithOTP();
		Assert.assertTrue(signin.verify_signInWithOtp_ModalPopUp_Visible(),
				"SignInWith Otp Modal PopUp Is not visible!!");
	}

	@Test(description = "To verify after clicking back icon LoginForm_Email Modal Pop_Up is displaying!!", groups = "Functional  Testing")
	public void verify_backIcon_redirectingPage_To_LoginFormEmail() {
		home.clickSignIn_JoinAjio();
		signin.verify_loginForm_Password_Visbile();
		signin.click_backIcon();
		Assert.assertTrue(signin.verify_loginformEmail_Visbile(), "LoginForm_Email Modal Pop_Up is  not displayed!!");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
