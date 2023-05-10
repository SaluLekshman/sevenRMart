package com.sevenRMartSuperMarketPages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageSliderPage {
	public WebDriver driver;
	PageUtility pageUtility=new PageUtility();
	 public  ManageSliderPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	 @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider']") WebElement clickOnMoreInfo;
	 @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement clickOnNewButton;
	 @FindBy(xpath="//input[@id='main_img']") WebElement imageChooseFile;
	 @FindBy(xpath="//input[@id='link']") WebElement enterLinkInLinkfield;
	 @FindBy(xpath="//button[@type='submit']") WebElement clickOnsaveButton;
	 @FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement alertMessage;
	 @FindBy(xpath="//i[@class='fas fa-trash-alt']") WebElement clickOnDeleteButtonInListSliderTable;
	 @FindBy(xpath="//tr//th//following::td") List<WebElement> listSliderTable;
	 public void clickOnMoreInfo()
	 {
		 clickOnMoreInfo.click();

	 }
	 public void clickOnNewButton()
	 {
		clickOnNewButton.click();
		
	 }
	 public void imageChoseFile() throws IOException
	 {
		 try 
		 {
		 imageChooseFile.sendKeys("C:\\Users\\SHALU\\OneDrive\\Desktop\\grocery.jpeg");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 
	 }
	 public void enterTheLink(String linkInput)
	 {
		 enterLinkInLinkfield.sendKeys(linkInput);

	 }
	 
	 public void clickOnSaveButton() 
	 {
		 clickOnsaveButton.submit();
		
	 }
	 public Boolean  isNewSliderCreatedSuccessfully()
	 {
		return pageUtility.isElementDisplayed(alertMessage);
			 
	 }

	 public String listSliderTable(String expectedSearchValue) 
	 {
	 	 
	 	 List<WebElement> row=listSliderTable;
	 	  for(WebElement tablerow:row)
	 	  {
	 		  ArrayList<String> rowvalue=new ArrayList<String>();
	 		  String actualSearchValue= tablerow.getText();
	 		  rowvalue.add( actualSearchValue);
	 		  System.out.println(rowvalue);
	 		  if( actualSearchValue.contains(expectedSearchValue))
	 		  {
	 			  System.out.println("The search result is correct");
	 		      break;  
	 		  }
	 		  
	 	  }
	 	return expectedSearchValue;
	
	 }
	 public void clickOnDeleteSliderInListSliderTable () 
	 {
		 
		 clickOnDeleteButtonInListSliderTable.click();
		 driver.switchTo().alert().accept();
	 }
	 public String getAlertMessageText() 
	 {
		 WaitUtility.waitForElement(driver, alertMessage);
		 return pageUtility.getElementText(alertMessage);
	 }
	 public Boolean alertMessageIsDisplayed() 
	 {
		 WaitUtility.waitForElement(driver,alertMessage);
		 return pageUtility.isElementDisplayed(alertMessage);
	 }
	 
}
