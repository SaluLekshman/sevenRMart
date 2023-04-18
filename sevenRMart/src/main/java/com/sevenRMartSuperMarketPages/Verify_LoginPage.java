package com.sevenRMartSuperMarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class Verify_LoginPage {
	public WebDriver driver ;
	 public Verify_LoginPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	 @FindBy (xpath="//input[@type='text']") WebElement usernameElement;
	 @FindBy(xpath="//input[@type='password']") WebElement passwordElement;
	 @FindBy(xpath="//button[text()='Sign In']") WebElement signInElement;
	 @FindBy(xpath="//label[@for='remember']") WebElement rememberMeElement;
	 
	 public void userNameElement(String usernameInput)
	 {
		 WaitUtility.waitForElement(driver,usernameElement);
		 PageUtility.enterText(usernameElement, usernameInput);
	 }
	 public void passwordElement(String PasswordInput)
	 {
		 WaitUtility.waitForElement(driver, passwordElement); 
		 PageUtility.enterText(passwordElement,PasswordInput) ;
		 
	 }
	 public boolean signInButtonIsEnabled()
	 {
		 WaitUtility.fluentwaitForElementSelected(driver, signInElement);;
		 return PageUtility.elementIsEnabled(signInElement);
	 }
	 public void signInElement()
	 {
		 WaitUtility.waitForElementClickable(driver, signInElement);
		 PageUtility.clickOnElement(signInElement);
	 }
	 public void rememberMeElement()
	 {
		 WaitUtility.waitForElement(driver,rememberMeElement );
		 PageUtility.clickOnElement(rememberMeElement);
	 }
}
