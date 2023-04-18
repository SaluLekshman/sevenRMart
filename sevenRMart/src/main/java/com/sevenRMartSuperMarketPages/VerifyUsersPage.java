package com.sevenRMartSuperMarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class VerifyUsersPage {
	public WebDriver driver ;
	 public VerifyUsersPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	 @FindBy(xpath="//p[text()='Verify Users']") WebElement verifyuserElement;
	 @FindBy(xpath="//a[@class=\"btn btn-rounded btn-primary\"]") static  WebElement verifyUserSearchButtonelement;
	 @FindBy(xpath="//input[@id=\"un\"] ")
	static WebElement enterNameElement;
	 @FindBy(xpath="//button[@name='Search']")
	static WebElement searchListUsersSearchButtonElement;
	 @FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")
	static WebElement searchListUsersSearchResultElement;
	 public boolean verifyUserElementIsEnabled()
	 {
		 //WaitUtility.waitForElement(driver,verifyuserElement );
		 return PageUtility.elementIsEnabled(verifyuserElement);
	 }
	 public boolean clickOnverifyUserElement()
	 {
		 //WaitUtility.waitForElementClickable(driver, verifyuserElement);
		 return PageUtility.clickOnElement(verifyuserElement);
	 }
	
	 public  boolean verifyUsersSearchButtonElementIsDisplayed() 
	 {
		
		 return PageUtility.isElementDisplayed(verifyUserSearchButtonelement);
	 }
	 public static void clickOnVerifyUsersSearchButtonElement()
	 {
		 PageUtility.clickOnElement(verifyUserSearchButtonelement);
	 }
	 
	 public static void enterNameElement(String enterNameValue) 
	 {
		
		 PageUtility.enterText(enterNameElement,enterNameValue);
	 }
	 public boolean searchListUsersSearchButtonElementIsenabled()
	 {
		 
		return PageUtility.elementIsEnabled(searchListUsersSearchButtonElement);
	 }
	 public static void clickOnsearchListUsersSearchButtonElement()
	 {
		
		PageUtility.clickOnElement(searchListUsersSearchButtonElement);
	 }
	 public static String searchListUsersSearchResultElement()
	 {
		 
		return PageUtility.getElementText(searchListUsersSearchResultElement);
	 }
}
