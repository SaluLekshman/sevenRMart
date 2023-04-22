package com.sevenRMartSuperMarketPages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class PushNotificationPage {
	public WebDriver driver;
	 public PushNotificationPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	 @FindBy(xpath="//p[text()='Push Notifications']") static WebElement clickOnpushNotificationElement;
	 @FindBy(xpath="//input[@id='title']") WebElement enterTitleElement;
	 @FindBy(xpath="//input[@id='description']") WebElement descriptionElement;
	 @FindBy(xpath="//button[@name='create']") WebElement sendElement;
	 @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertMessageElement;
	 public void ClickOnpushNotificationelement()
	 {
		 WaitUtility.waitForElementClickable(driver,clickOnpushNotificationElement);
		 PageUtility.clickOnElement(clickOnpushNotificationElement); 
	 }
	 public PushNotificationPage enterTitleElement(String titleInput) 
	 {
		 WaitUtility.waitForElement(driver,enterTitleElement);
		 PageUtility.enterText(enterTitleElement,titleInput );
		return this;
	
		 
	 }

	 public PushNotificationPage descriptionElement(String descriptionInput) 
	 {
		 WaitUtility.waitForElement(driver, descriptionElement);
		 PageUtility.enterText(descriptionElement,descriptionInput);
		return this;
		 
	 }
	 
	public PushNotificationPage clickOnsendElement()
	{
		WaitUtility.waitForElementClickable(driver,sendElement);
		PageUtility.clickOnElement(sendElement);
		return this;
	}
	public String getTextalertMessageElement()
	{
		
		return PageUtility.getElementText(alertMessageElement);
		
	}
	public boolean alertMessageElementIsDisplayed()
	{
		
		return PageUtility.isElementDisplayed(alertMessageElement);	
	}

}
