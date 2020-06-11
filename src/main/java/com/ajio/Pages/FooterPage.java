package com.ajio.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ajio.keyword.Keyword;

public class FooterPage extends Keyword {

	@FindBy(css = "span[class=\"ic-Chevron-down\"]")
	private static WebElement seoDropDown;

	@FindBy(css = "div[class=\"seo-dropdown-content\"]")
	private static WebElement seoDDListOptions;

	@FindBy(xpath = "//div[text()='AJIO']")
	private static WebElement ajioHeadLine;

	@FindBy(xpath = "//section[1]//div[2]/a")

	public static List<WebElement> ajioHeaderItems;

	// Constructor

	public FooterPage() {
		PageFactory.initElements(driver, this);
	}

	// Methods

	public static boolean isSEODropDownVisible() {
		return seoDropDown.isDisplayed();
	}

	public static boolean isSEODropDownListOptionsVisible() {
		seoDropDown.click();
		return seoDDListOptions.isDisplayed();
	}

	public static boolean isAjioHeader_Visible() {
		return ajioHeadLine.isDisplayed();
	}

	public static List<String> ajioHeaderList() {
		 stringElements = new ArrayList();
		for (WebElement element : ajioHeaderItems) {
			stringElements.add(element.getText());

		}
		return stringElements;

	}
	public static List<String> ajioHeaderListExpected(){
		stringElements = new ArrayList();
		stringElements.add("Who We Are");
		stringElements.add("Join Our Team");
		stringElements.add("Terms & Conditions");
		stringElements.add("We Respect Your Privacy");
		stringElements.add("Fees & Payments");
		stringElements.add("Returns & Refunds Policy");
		stringElements.add("Promotions Terms & Conditions");

		
		return stringElements;
	}

}
