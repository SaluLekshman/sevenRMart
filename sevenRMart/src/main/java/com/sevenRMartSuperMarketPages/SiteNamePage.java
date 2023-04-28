package com.sevenRMartSuperMarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class SiteNamePage {
	public WebDriver driver ;
	 public  SiteNamePage (WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	
	@FindBy(xpath="//span[text()='7rmart supermarket']") WebElement siteNameElement;
	 public boolean siteNameIsDisplayed()
	 {
		 WaitUtility.waitForElement(driver, siteNameElement);
		 return PageUtility.isElementDisplayed(siteNameElement);
	 }
	 public String siteNameGetText()
	 {
		 WaitUtility.waitForElement(driver, siteNameElement);
		 return PageUtility.getElementText(siteNameElement);
	 }
	 public String getColorOfSiteName()
	 {
		return PageUtility.stylePropertyValidation(siteNameElement, "color");
		 
	 }
}
