package com.sevenRMartSuperMarketPages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtility;
import Utilities.RandomdataUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class PushNotificationPage {
	public WebDriver driver;
	PageUtility pageUtility=new PageUtility();
	 public PushNotificationPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	 @FindBy(xpath="//p[text()='Push Notifications']") static WebElement clickOnpushNotification;
	 @FindBy(xpath="//input[@id='title']") WebElement enterValueOnTitleField;
	 @FindBy(xpath="//input[@id='description']") WebElement enterValueOnDescriptionField;
	 @FindBy(xpath="//button[@name='create']") WebElement clickSendbutton;
	 @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertMessage;
	 
	 public void ClickOnpushNotificationelement()
	 {
		 WaitUtility.waitForElementClickable(driver,clickOnpushNotification);
		 pageUtility.clickOnElement(clickOnpushNotification); 
	 }
	 public PushNotificationPage enterValueOnTitleField(String titleInput) 
	 {
		 WaitUtility.waitForElement(driver,enterValueOnTitleField);
		 pageUtility.enterText(enterValueOnTitleField,titleInput );
		 return this; 
	 }

	 public PushNotificationPage enterValueOnDescriptionField(String descriptionInput) 
	 {
		 WaitUtility.waitForElement(driver,enterValueOnDescriptionField);
		 pageUtility.enterText(enterValueOnDescriptionField,descriptionInput);
		 return this;
		 
	 }
	 
	public PushNotificationPage clickSendbutton()
	{
		WaitUtility.waitForElementClickable(driver,clickSendbutton);
		pageUtility.clickOnElement(clickSendbutton);
		return this;
	}
	public String getTextOfalertMessage()
	{
		
		return pageUtility.getElementText(alertMessage);
		
	}
	public boolean verifyAlertMessageIsDisplayed()
	{
		
		return pageUtility.isElementDisplayed(alertMessage);	
	}

}
