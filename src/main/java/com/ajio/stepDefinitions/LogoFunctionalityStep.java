package com.ajio.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.ajio.Pages.HomepagePage;
import com.ajio.Pages.SignInPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
@Listeners(com.ajio.listner.Listener.class)
public class LogoFunctionalityStep extends HomepagePage {
	
	  HomepagePage home;
	  SignInPage signin;
	Logger  log=Logger.getLogger(LogoFunctionalityStep.class);
	
	
	@Before//cucumber annotation will execute after every actions of Cucumber methods
	public void inializePageObject() {
		openBrowser();
		home=new HomepagePage();
		signin=new SignInPage();

	}
	
	@Given("^User launches application url$")
	public void user_launches_application_url() {
		launchURL();
		maxiBrowserWindow();
		pageLoadTimeOut();
		implicitWait();
		 log.info("Ajio Url Launched Successfully!!");
	    
	}

	@Then("^User Clicks on Sign\\/Join Ajio Link$")
	public void user_Clicks_on_Sign_Join_Ajio_Link() {
	    home.clickSignIn_JoinAjio();
	    
	   
	}

	@Then("^A pop-up will open and user enters valid credentials in that pop-up$")
	public void a_pop_up_will_open_and_user_enters_valid_credentials_in_that_pop_up() {
		if(signin.is_signInModalPop_Up_Visible()) {
			log.info("SignIn Modal Pop-up Opned!!");
		
	   signin.enterEmailOrMobileNumer();
	   signin.click_On_continueButton();
	   signin.enterPassword();
	   signin.click_On_startShopping();
	   expllicitWait();
		}else {
			log.error("Signin Modal PopUp not Opened!!");
		}
	   Assert.assertTrue(signin.is_MyAccount_Visible(), "Unsuccessfull Login!!!");
	}

	@Then("^User clicks My Account to redirect to  My acount page$")
	public void user_clicks_My_Account_to_redirect_to_My_acount_page() {
	 signin.click_On_MyAccount();
	 if(driver.getTitle().equals("AJIO")) {
		 log.info("Redirected to My Account Page");
	 }else {
		 log.error("Not Redirected to My Account Page");
	 }
	}

	@When("^User clicks on Ajio Logo$")
	public void user_clicks_on_Ajio_Logo() {
	    signin.click_On_Logo();
	}

	@Then("^Verify the page is redirecting to homepage from My account page$")
	public void verify_the_page_is_redirecting_to_homepage_from_My_account_page() {
	  Assert.assertTrue(driver.getTitle().equals("Online Shopping for Women, Men, Kids – Clothing, Footwear, Fashion | AJIO"));
	  
	}

	
	
	
	
}
