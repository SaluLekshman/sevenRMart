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
	 public PushNotificationPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	 @FindBy(xpath="//p[text()='Push Notifications']") static WebElement clickOnpushNotification;
	 @FindBy(xpath="//input[@id='title']") WebElement enterTitle;
	 @FindBy(xpath="//input[@id='description']") WebElement enterDescription;
	 @FindBy(xpath="//button[@name='create']") WebElement clickSendbutton;
	 @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertMessage;
	 public void ClickOnpushNotificationelement()
	 {
		 WaitUtility.waitForElementClickable(driver,clickOnpushNotification);
		 PageUtility.clickOnElement(clickOnpushNotification); 
	 }
	 public PushNotificationPage enterTitle(String titleInput) 
	 {
		 WaitUtility.waitForElement(driver,enterTitle);
		 PageUtility.enterText(enterTitle,titleInput );
		return this;
	
		 
	 }

	 public PushNotificationPage enterDescription(String descriptionInput) 
	 {
		 WaitUtility.waitForElement(driver, enterDescription);
		 PageUtility.enterText(enterDescription,descriptionInput);
		return this;
		 
	 }
	 
	public PushNotificationPage clickSendbutton()
	{
		WaitUtility.waitForElementClickable(driver,clickSendbutton);
		PageUtility.clickOnElement(clickSendbutton);
		return this;
	}
	public String getTextalertMessage()
	{
		
		return PageUtility.getElementText(alertMessage);
		
	}
	public boolean alertMessageIsDisplayed()
	{
		
		return PageUtility.isElementDisplayed(alertMessage);	
	}

}
