package com.ajio.PageTests;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ajio.Pages.FooterPage;
import com.ajio.Pages.HomepagePage;
import com.ajio.customUtil.CustomUtil;

@Listeners(com.ajio.listner.Listener.class)
public class FooterPageTest extends FooterPage {

	Logger log = Logger.getLogger(FooterPageTest.class);

	HomepagePage home;
	FooterPage footer;

	@BeforeMethod
	public void setUp() {
		openBrowser();
		maxiBrowserWindow();
		footer = new FooterPage();
		home = new HomepagePage();
		launchURL();
		deleteAllCookies();
		pageLoadTimeOut();
		implicitWait();

	}
	/*
	 * @Test(
	 * description="To verify SEO DropDown list is visible and after clicking on it all options are visible"
	 * ) public void verify_SEODropDownList_Visible_and_Options_Visible(){ if
	 * (footer.isSEODropDownVisible()) { log.info("SEO dropdown List is visible"); }
	 * else { log.error("SEO Drop down list  is absent"); }
	 * Assert.assertTrue(footer.isSEODropDownVisible());
	 * Assert.assertTrue(footer.isSEODropDownListOptionsVisible());
	 * 
	 * }
	 * 
	 * @Test(description="To verify Ajio Header is visible  ") public void
	 * verify_Ajio_Header_Visible() { if (footer.isAjioHeader_Visible()) {
	 * log.info("AJIO Header  is visible"); } else {
	 * log.error("AJIO Header   is absent"); }
	 * Assert.assertTrue(footer.isAjioHeader_Visible());
	 * 
	 * 
	 * }
	 */
	/*
	 * @Test(description="To verify Ajio Header All items Visible and correct   ")
	 * public void verify_Ajio_Header_Items_Visible() { List<String>
	 * items=footer.get_AjioHeader_Items(); for (String item : items) {
	 * System.out.println(item); }
	 * 
	 * 
	 * }
	 */

/*	@Test(description = "To verify Ajio Header All items are displayed ")
	public void verify_Ajio_Header_List_Displayed() {
		List actualItems = footer.ajioHeaderList();
		List expectedItems = footer.ajioHeaderListExpected();
		for (int i = 0; i < expectedItems.size(); i++) {
			Assert.assertEquals(actualItems.get(i), expectedItems.get(i), "Item Mismatched!!");
		}

	}*/
	@Test(description="Verify Ajio Header Links are working fine")
	public void verify_ajioHeaderLinks_Are_Working(){
		Assert.assertTrue(workingLinks(footer.ajioHeaderItems, CustomUtil.getParameter("baseUrl")),"Broken Link!!");
		
	}

	@AfterMethod
	public static void tearTear() {
		driver.close();
	}

}
