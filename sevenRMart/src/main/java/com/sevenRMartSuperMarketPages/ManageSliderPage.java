package com.sevenRMartSuperMarketPages;

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
	
	 public  ManageSliderPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	 @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider']") WebElement clickOnMoreInfo;
	 @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement clickOnNewButton;
	 @FindBy(xpath="//input[@id='main_img']") WebElement imageChooseFile;
	 @FindBy(xpath="//input[@id='link']") WebElement enterLink;
	 @FindBy(xpath="//button[@type='submit']") WebElement clickOnsaveButton;
	 @FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement alertSliderCreatedSuccessfully;
	 @FindBy(xpath="//i[@class='fas fa-trash-alt']") WebElement clickOnDeleteSliderFromListSliderTable;
	 @FindBy(xpath="//div[contains(@class,\"alert-success \")]") WebElement alertSliderdeletedSuccessfully;
	 public void clickOnMoreInfo()
	 {
		 clickOnMoreInfo.click();

		
	 }
	 public void clickOnNewButton()
	 {
		clickOnNewButton.click();
		
	 }
	 public void imageChoseFile() 
	 {
		 imageChooseFile.sendKeys("C:\\Users\\SHALU\\OneDrive\\Desktop\\grocery.jpeg");
		 
	 }
	 public void enterTheOfferCode(String offerCodeInput)
	 {
		 enterLink.sendKeys(offerCodeInput);

	 }
	 
	 public void clickOnSaveButton() 
	 {
		 clickOnsaveButton.submit();
		
	 }
	 public Boolean  isNewSliderCreatedSuccessfully()
	 {
		return PageUtility.isElementDisplayed(alertSliderCreatedSuccessfully);
			 
	 }

	 public String searchNewSliderAdded(String expectedSearchValue) 
	 {
	 	 
	 	 List<WebElement> row=driver.findElements(By.xpath("//tr//th//following::td"));
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
	 public void clickOnDeleteSliderFromListSliderTable () 
	 {
		
		 clickOnDeleteSliderFromListSliderTable.click();
		 driver.switchTo().alert().accept();
	 }
	 public String getAlertMessageText() 
	 {
		 WaitUtility.waitForElement(driver, alertSliderCreatedSuccessfully);
		 return PageUtility.getElementText(alertSliderCreatedSuccessfully);
	 }
	 public Boolean isSliderDeletedFromListSliderTable() 
	 {
		 WaitUtility.waitForElement(driver, alertSliderCreatedSuccessfully);
		 return PageUtility.isElementDisplayed(alertSliderCreatedSuccessfully);
	 }
	 
}
