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

public class ManageProductsPage {
	public WebDriver driver;
	
	 public ManageProductsPage (WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	 @FindBy(xpath="//h1[text()='List Products']") WebElement listProduct;
	 @FindBy(xpath="//a[@class='active nav-link']") WebElement ClickOnManageaproductPage;
	 @FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement ClickOnNewButton;
	 @FindBy(xpath="//input[@id='title']") WebElement EnterTitle;
	 @FindBy(xpath="//input[@value='Veg']") WebElement vegProductTypeRadioButton;
	 @FindBy(xpath="//input[@value='Nonveg']") WebElement nonVegProductTypeRadioButton;
	 @FindBy(xpath="//input[@value='Others']") WebElement otherProductTypeRadioButton;
	 @FindBy(xpath="//select[@id='cat_id']") WebElement enterValueOnCategory;
	 @FindBy(xpath="//select[@id='sub_id']") WebElement enterVaueOnSubCategory;
	 @FindBy(xpath="//input[@value='weight']") WebElement pricetypeWeightRadioButton;
	 @FindBy(xpath="//input[@value='piece']") WebElement pricetypePieceRadioButton;
	 @FindBy(xpath="//input[@value='litre']") WebElement pricetypeLitreRadioButton;
	 @FindBy(xpath="//input[@value='serves']") WebElement pricetypeServesRadioButton;
 
	 public void clickOnmanageaproduct()
	 {
		 WaitUtility.waitForElementClickable(driver,ClickOnManageaproductPage );
		 PageUtility.clickOnElement(ClickOnManageaproductPage);
	 }
	 public boolean isdisplayedlistProduct()
	 {
		 WaitUtility.waitForElement(driver,listProduct);
		 return PageUtility.isElementDisplayed(listProduct);
	 }
	 public void clickOnnew()
	 {
		 WaitUtility.waitForElementClickable(driver, ClickOnNewButton);
		 PageUtility.clickOnElement(ClickOnNewButton);
	 }
	 public void EnterTitle( String inputTitleText) 
	 {  
		 WaitUtility.waitForElement(driver, EnterTitle);
		 PageUtility.enterText(EnterTitle,inputTitleText);
	 }
	 public boolean nonVegProductTypeIsEnabled() 
	 {
		 WaitUtility.waitForElement(driver, nonVegProductTypeRadioButton);
		 return PageUtility.elementIsEnabled(nonVegProductTypeRadioButton);
	 }
	 public boolean clickNonVegProductType() 
	 {
		 WaitUtility.waitForElementClickable(driver,nonVegProductTypeRadioButton );
		 return PageUtility.clickOnElement(nonVegProductTypeRadioButton);
	 }
	 public void categoryElementFaker( ) 
	 {  
		 WaitUtility.waitForElement(driver, enterValueOnCategory); 
		 RandomdataUtility.fakerFoodName(enterValueOnCategory);
		
	 }
	 
	 public boolean subCategoryFaker( ) 
	 {  
		 WaitUtility.waitForElement(driver, enterVaueOnSubCategory); 
		 return  RandomdataUtility.fakerFoodName(enterVaueOnSubCategory);
		
	 }
	 
	 public void clickOnpricetypeLitreRadioButton()
	 {
		 pricetypeLitreRadioButton.click();
	 }
	 public boolean isEnabledpricetypeLitreRadioButton()
	 {
		 return PageUtility.elementIsEnabled(pricetypeLitreRadioButton);
	 }
	 
}
