package com.sevenRMartSuperMarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver ;
	PageUtility pageutility=new PageUtility() ;
	 public LoginPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	 @FindBy (xpath="//input[@type='text']") WebElement enterUsername;
	 @FindBy(xpath="//input[@type='password']") WebElement enterPassword;
	 @FindBy(xpath="//button[text()='Sign In']") WebElement clickSignIn;
	 @FindBy(xpath="//label[@for='remember']") WebElement clickRememberMe;
	 @FindBy (xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement alertMessage;
	 @FindBy(xpath="//span[text()='7rmart supermarket']") WebElement siteName;
	 
	 public boolean verifySiteNameIsDisplayed()
	 {
		 WaitUtility.waitForElement(driver, siteName);
		 return pageutility.isElementDisplayed(siteName);
	 }

	 public  LoginPage enterUsername(String usernameInput)
	 {
		 WaitUtility.waitForElement(driver,enterUsername);
		 pageutility.enterText(enterUsername, usernameInput);
		 return this;
	 }
	 public  LoginPage enterPassword(String PasswordInput)
	 {
		 WaitUtility.waitForElement(driver, enterPassword); 
		 pageutility.enterText(enterPassword,PasswordInput) ;
		 return this;
		 
	 }
	 public boolean verifySignInButtonIsEnabled()
	 {
		 WaitUtility.fluentwaitForElementSelected(driver, clickSignIn);
		 return pageutility.elementIsEnabled(clickSignIn);
	 }
	 public   LoginPage clickOnsignInButton()
	 {
		 WaitUtility.waitForElementClickable(driver, clickSignIn);
		 pageutility.clickOnElement(clickSignIn);
		return this;
		 
	 }
	 public LoginPage clickOnRememberMeButton()
	 {
		 WaitUtility.waitForElement(driver,clickRememberMe);
		 pageutility.clickOnElement(clickRememberMe);
		 return this;
	 }
	 public boolean verifyAlertMessageIsDisplayed()
	 {
		 WaitUtility.waitForElement(driver, alertMessage);
		 return pageutility.isElementDisplayed(alertMessage);
	 }
	
}
