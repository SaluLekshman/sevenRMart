package com.sevenRMartSuperMarketPages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtility;
import Utilities.PageUtility;

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
		 PageUtility.clickOnElement(clickOnpushNotificationElement);
		 
		 
	 }
	 public void enterTitleElement() throws IOException
	 {
		 
		 String titleInput=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"pushNotificationInformation");
		 PageUtility.enterText(enterTitleElement,titleInput ).click();
		
	
	 }
	 public void descriptionElement() throws IOException
	 {
		 String descriptionInput=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"pushNotificationInformation");
		 PageUtility.enterText(descriptionElement,descriptionInput);
		 
	 }
	 
	public void sendElement()
	{
		PageUtility.clickOnElement(sendElement);
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
