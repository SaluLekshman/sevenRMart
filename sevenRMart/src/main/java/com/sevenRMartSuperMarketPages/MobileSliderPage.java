package com.sevenRMartSuperMarketPages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class MobileSliderPage {
	public WebDriver driver;
	PageUtility pageUtility=new PageUtility();
	
	 public  MobileSliderPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-mobileslider']") WebElement clickOnMobileSliderMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Mobileslider/add']") WebElement clickOnNewButtonInMobileSliderPage;
	@FindBy(xpath="//select[@id='cat_id']") WebElement selectCategoryFromDropDownInAddNewSliderPage;
	@FindBy(xpath="//input[@id='main_img']") WebElement clickOnImageChooseFileInAddNewMobileSliderPage;
	@FindBy(xpath="//button[@type='submit']") WebElement clickOnSaveButtonInInAddNewMobileSliderPage;
	@FindBy(xpath="//div[contains(@class,'alert-success ')]") WebElement alertMobileSliderCreatedSuccessfully;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Mobileslider/delete?del=554&page_ad=1'][1]") WebElement clickOnDeleteButtonInListMobileSliderTable;
	public MobileSliderPage clickOnMobileSliderMoreInfo()
	 {
		 clickOnMobileSliderMoreInfo.click();
		 return this;
	 }
	public MobileSliderPage clickOnNewButtonInMobileSliderPage()
	 {
		clickOnNewButtonInMobileSliderPage.click();
		 return this;
	 }
	public MobileSliderPage selectCategoryFromDropDownInAddNewSliderPage()
	 {
		WaitUtility.waitForElement(driver, selectCategoryFromDropDownInAddNewSliderPage);
		pageUtility.selectDropdownbyIndex(selectCategoryFromDropDownInAddNewSliderPage, 4);
		return this;
	 }
	public void  clickOnImageChooseFileInAddNewMobileSliderPage() throws IOException 
	 {
		try
		{
			clickOnImageChooseFileInAddNewMobileSliderPage.sendKeys("C:\\Users\\SHALU\\OneDrive\\Desktop\\grocery.jpeg");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	 }
	public MobileSliderPage   clickOnSaveButtonInInAddNewMobileSliderPage()
	 {
		 clickOnSaveButtonInInAddNewMobileSliderPage.click();
		 return this;
	 }
	public Boolean VerifyAlertMessageIsDisplayed()
	 {
		WaitUtility.waitForElement(driver,alertMobileSliderCreatedSuccessfully);
	    return pageUtility.isElementDisplayed( alertMobileSliderCreatedSuccessfully);
	 }
	public String clickOnDeleteButtonInListMobileSliderTable()
	 {
		 clickOnDeleteButtonInListMobileSliderTable.click();
		 return driver.switchTo().alert().getText();
		 
	 }
			 
	 
}
