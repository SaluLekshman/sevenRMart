package com.sevenRMartSuperMarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver ;
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
	 @FindBy(xpath="//span[text()='7rmart supermarket']") WebElement siteNameElement;
	 public boolean siteNameIsDisplayed()
	 {
		 WaitUtility.waitForElement(driver, siteNameElement);
		 return PageUtility.isElementDisplayed(siteNameElement);
	 }

	 
	 public  LoginPage enterUsername(String usernameInput)
	 {
		 WaitUtility.waitForElement(driver,enterUsername);
		 PageUtility.enterText(enterUsername, usernameInput);
		 return this;
	 }
	 public  LoginPage enterPassword(String PasswordInput)
	 {
		 WaitUtility.waitForElement(driver, enterPassword); 
		 PageUtility.enterText(enterPassword,PasswordInput) ;
		 return this;
		 
	 }
	 public boolean signInButtonIsEnabled()
	 {
		 WaitUtility.fluentwaitForElementSelected(driver, clickSignIn);
		 return PageUtility.elementIsEnabled(clickSignIn);
	 }
	 public   LoginPage clicksignIn()
	 {
		 WaitUtility.waitForElementClickable(driver, clickSignIn);
		 PageUtility.clickOnElement(clickSignIn);
		return this;
		 
	 }
	 public LoginPage clickRememberMe()
	 {
		 WaitUtility.waitForElement(driver,clickRememberMe);
		 PageUtility.clickOnElement(clickRememberMe);
		 return this;
	 }
	 public boolean alertMessage()
	 {
		 WaitUtility.waitForElement(driver, alertMessage);
		 return PageUtility.isElementDisplayed(alertMessage);
	 }
	
}
