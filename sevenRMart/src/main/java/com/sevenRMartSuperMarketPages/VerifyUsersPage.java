package com.sevenRMartSuperMarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class VerifyUsersPage
{
	public WebDriver driver ;
	PageUtility pageUtility=new PageUtility();
	 public VerifyUsersPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
	 @FindBy(xpath="//p[text()='Verify Users']") WebElement clickOnverifyuser;
	 @FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")  WebElement clickOnSearchButtonInVerifyUserPage;
	 @FindBy(xpath="//input[@id='un'] ") WebElement enterTextInTextFieldName;
	 @FindBy(xpath="//button[@name='Search']") WebElement clickOnsearchButtonInSearchListUsers;
	 @FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']") WebElement searchResultOfVerifyUsersSearch;
	 
	 public boolean verifyUserPageIsEnabled()
	 {
		 WaitUtility.waitForElement(driver, clickOnverifyuser);
		 return pageUtility.elementIsEnabled( clickOnverifyuser);
	 }
	 public boolean clickOnverifyUser()
	 {
		 WaitUtility.waitForElementClickable(driver, clickOnverifyuser);
		 return pageUtility.clickOnElement( clickOnverifyuser);
	 }
	
	 public  boolean ToCheckverifyUsersSearchButtonIsDisplayed() 
	 {
		
		 return pageUtility.isElementDisplayed(clickOnSearchButtonInVerifyUserPage);
	 }
	 public  void clickOnVerifyUsersSearchButton()
	 {
		 pageUtility.clickOnElement(clickOnSearchButtonInVerifyUserPage);
	 }
	 
	 public  void enterTextInTextFieldName(String enterNameValue) 
	 {

		 WaitUtility.waitForElement(driver,enterTextInTextFieldName);
		 pageUtility.enterText(enterTextInTextFieldName,enterNameValue);
	 }
	 public boolean verifysearchButtonInSearchListUsersIsenabled()
	 {
		 
		return pageUtility.elementIsEnabled(clickOnsearchButtonInSearchListUsers);
	 }
	 public  void clickOnsearchButtonInSearchListUsers()
	 {

		 WaitUtility.waitForElementClickable(driver, clickOnsearchButtonInSearchListUsers);
		 pageUtility.clickOnElement(clickOnsearchButtonInSearchListUsers);
	 }
	 public String getText_SearchResultOfVerifyUsersSearch()
	 {
		 
		return pageUtility.getElementText(searchResultOfVerifyUsersSearch);
	 }
}
