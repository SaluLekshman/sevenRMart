package com.sevenRMartSuperMarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManagePayMentMethodsPage {
	public WebDriver driver;
	 public ManagePayMentMethodsPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	 
	 @FindBy(xpath="//p[text()='Manage Payment Methods']") WebElement managePaymentmethodsElement;
	 @FindBy(xpath="//a[text()='Home']") WebElement managePaymentmethodsPageHomeButton;
	 public boolean IsDispalyedmanagePaymentmethodsElement()
	 {
		 WaitUtility.waitForElementClickable(driver,managePaymentmethodsElement);
		 return PageUtility.isElementDisplayed(managePaymentmethodsElement);
	 }
	 public void clickOnmanagePaymentmethodsElement()
	 {
		 WaitUtility.waitForElementClickable(driver,managePaymentmethodsElement );
		 PageUtility.clickOnElement(managePaymentmethodsElement);
	 }
	 public void clickOnmanagePaymentmethodsPageHomeButton()
	 {
		 WaitUtility.waitForElement(driver,managePaymentmethodsPageHomeButton);
		 PageUtility.clickOnElement(managePaymentmethodsPageHomeButton);
		 
	 }
}
