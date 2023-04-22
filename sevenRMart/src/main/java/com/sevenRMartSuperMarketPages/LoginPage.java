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
	 @FindBy (xpath="//input[@type='text']") WebElement usernameElement;
	 @FindBy(xpath="//input[@type='password']") WebElement passwordElement;
	 @FindBy(xpath="//button[text()='Sign In']") WebElement signInElement;
	 @FindBy(xpath="//label[@for='remember']") WebElement rememberMeElement;
	 @FindBy (xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement alertElement;
	 
	 public  LoginPage userNameElement(String usernameInput)
	 {
		 WaitUtility.waitForElement(driver,usernameElement);
		 PageUtility.enterText(usernameElement, usernameInput);
		 return this;
	 }
	 public  LoginPage passwordElement(String PasswordInput)
	 {
		 WaitUtility.waitForElement(driver, passwordElement); 
		 PageUtility.enterText(passwordElement,PasswordInput) ;
		 return this;
		 
	 }
	 public boolean signInButtonIsEnabled()
	 {
		 WaitUtility.fluentwaitForElementSelected(driver, signInElement);;
		 return PageUtility.elementIsEnabled(signInElement);
	 }
	 public  LoginPage signInElement()
	 {
		 WaitUtility.waitForElementClickable(driver, signInElement);
		 PageUtility.clickOnElement(signInElement);
		 return this;
	 }
	 public LoginPage rememberMeElement()
	 {
		 WaitUtility.waitForElement(driver,rememberMeElement );
		 PageUtility.clickOnElement(rememberMeElement);
		 return this;
	 }
	 public boolean alertElement()
	 {
		 WaitUtility.waitForElement(driver, alertElement);
		 return PageUtility.isElementDisplayed(alertElement);
	 }
	
}
