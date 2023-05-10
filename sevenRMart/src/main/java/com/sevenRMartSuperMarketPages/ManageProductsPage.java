package com.sevenRMartSuperMarketPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.RandomdataUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageProductsPage {
	public WebDriver driver;
	PageUtility pageUtility = new PageUtility();
	
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
	 @FindBy(xpath="//select[@id='cat_id']") WebElement selectCategorydropDownButton;
	 @FindBy(xpath="//select[@id='sub_id']") WebElement selectSubCategorydropDownButton;
	 @FindBy(xpath="//input[@value='weight']") WebElement pricetypeWeightRadioButton;
	 @FindBy(xpath="//input[@value='piece']") WebElement pricetypePieceRadioButton;
	 @FindBy(xpath="//input[@value='litre']") WebElement pricetypeLitreRadioButton;
	 @FindBy(xpath="//input[@value='serves']") WebElement pricetypeServesRadioButton;
 
	 public void clickOnmanageaproduct()
	 {
		 WaitUtility.waitForElementClickable(driver,ClickOnManageaproductPage );
		 pageUtility.clickOnElement(ClickOnManageaproductPage);
	 }
	 public boolean isdisplayedlistProduct()
	 {
		 WaitUtility.waitForElement(driver,listProduct);
		 return pageUtility.isElementDisplayed(listProduct);
	 }
	 public void clickOnnew()
	 {
		 WaitUtility.waitForElementClickable(driver,ClickOnNewButton);
		 pageUtility.clickOnElement(ClickOnNewButton);
	 }
	 public void EnterTitle( String inputTitleText) 
	 {  
		 WaitUtility.waitForElement(driver,EnterTitle);
		 pageUtility.enterText(EnterTitle,inputTitleText);
	 }
	 public boolean nonVegProductTypeRadioButtonIsEnabled() 
	 {
		 WaitUtility.waitForElement(driver, nonVegProductTypeRadioButton);
		 return pageUtility.elementIsEnabled(nonVegProductTypeRadioButton);
	 }
	 public boolean clickOnNonVegProductTypeRadioButton() 
	 {
		 WaitUtility.waitForElementClickable(driver,nonVegProductTypeRadioButton);
		 return pageUtility.clickOnElement(nonVegProductTypeRadioButton);
	 }
	 public boolean getRanadomdataValueForTextFieldCategory() 
	 {  
		 WaitUtility.waitForElement(driver,selectCategorydropDownButton); 
		 boolean randomDataForCategory=RandomdataUtility.fakerFoodName(selectCategorydropDownButton);
		 return randomDataForCategory;
		
	 }
	 
	 public boolean getRanadomdataValueForTextFieldSubCategory() 
	 {  
		 WaitUtility.waitForElement(driver,selectSubCategorydropDownButton); 
		 boolean randomDataForSubCategory=RandomdataUtility.fakerFoodName(selectSubCategorydropDownButton);
		 return randomDataForSubCategory;
	 }
	 
	 public void clickOnpricetypeLitreRadioButton()
	 {
		 pricetypeLitreRadioButton.click();
	 }
	 public boolean isEnabledpricetypeLitreRadioButton()
	 {
		 return pageUtility.elementIsEnabled(pricetypeLitreRadioButton);
	 }
	 
}
