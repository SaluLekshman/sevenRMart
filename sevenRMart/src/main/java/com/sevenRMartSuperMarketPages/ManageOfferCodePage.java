package com.sevenRMartSuperMarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageOfferCodePage {
	public WebDriver driver;
	
	 public ManageOfferCodePage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	 @FindBy(xpath="//p[text()='Manage Offer Code']") WebElement manageOfferCodeElement;
  
   public boolean isDispalyedmanageOfferCodeElement() 
		{
   	    WaitUtility.waitForElement(driver, manageOfferCodeElement);
			return PageUtility.isElementDisplayed(manageOfferCodeElement);
		}
	 public void clickOnmanageOfferCodeElement()
	 {
		 WaitUtility.waitForElementClickable(driver,manageOfferCodeElement);
		 PageUtility.clickOnElement(manageOfferCodeElement);
	 }
}
