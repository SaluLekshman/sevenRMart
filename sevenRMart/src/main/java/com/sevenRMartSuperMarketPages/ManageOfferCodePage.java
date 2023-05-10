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
import Utilities.RandomdataUtility;
import Utilities.WaitUtility;

public class ManageOfferCodePage {
	public WebDriver driver;
	PageUtility pageUtility=new PageUtility();
	
	 public ManageOfferCodePage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	
	 @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode']") WebElement clickOnMoreInfo;
	 @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Offercode/add']") WebElement clickOnNewButton;
	 @FindBy(xpath="//input[@id='offer_code']") WebElement enterTheOfferCode;
	 @FindBy(xpath="//input[@value='yes']") WebElement clickOnFirstOrderUserYesButton;
	 @FindBy(xpath="//input[@id='offer_per']") WebElement enterPercentage;
	 @FindBy(xpath="//input[@id='offer_price']") WebElement enterAmount;
	 @FindBy(xpath="//div[@contenteditable='true']") WebElement enterDescription;
	 @FindBy(xpath="//input[@id='main_img']") WebElement imageChoseFile;
	 @FindBy(xpath="//button[@name='create']") WebElement clickOnSaveButton;
	 @FindBy(xpath="//div[contains(@class,'alert-success ')]") WebElement alertOfferCodeCreatedSuccessfully;
	  
	 public ManageOfferCodePage clickOnMoreInfo()
	 {
		 clickOnMoreInfo.click();
		 return this;
	 }
	 public ManageOfferCodePage clickOnNewButton()
	 {
		clickOnNewButton.click();
		return this;
	 }
	 public ManageOfferCodePage enterTheOfferCode(String offerCodeInput)
	 {
		 pageUtility.enterText(enterTheOfferCode, RandomdataUtility.fakerNumber(enterTheOfferCode));
		 return this;
	 }
	 public ManageOfferCodePage clickOnFirstOrderUserYesButton() 
	 {
	     clickOnFirstOrderUserYesButton.click();
		 return this;
	 }
	 public ManageOfferCodePage enterAmount(String enterAmountInput) 
	 {
		enterAmount.sendKeys(enterAmountInput);
		return this;
	 }
	 public ManageOfferCodePage enterPercentage(String enterPercentageInput) 
	 {
		enterPercentage.sendKeys(enterPercentageInput);
		return this;
	 }
	 public ManageOfferCodePage enterDescription(String enterDescriptionInput) 
	 {
		 enterDescription.sendKeys(enterDescriptionInput);
		return this;
	 }

	 public void  imageChoseFile() throws IOException
	 {
		 try
		 {
		 imageChoseFile.sendKeys("C:\\Users\\SHALU\\OneDrive\\Desktop\\grocery.jpeg");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
	 }
	 
	 
	 public ManageOfferCodePage clickOnSaveButton() 
	 {
		imageChoseFile.submit();
		return this;
	 }
	 public String addNewOffer()
	 {
		return pageUtility.getElementText(alertOfferCodeCreatedSuccessfully);
			 
	 }
	 public Boolean addNewOfferCode()
	 {
		return pageUtility.isElementDisplayed(alertOfferCodeCreatedSuccessfully);
			 
	 }
	 
	 
	 public ManageOfferCodePage backToAddNewOfferCodePage()
	 {
		 driver.navigate().to("listOfferCodeUrl");
		 return this;
	 }
	 public String searchNewOfferCodeAdded(String expectedSearchValue) 
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

	 
}

