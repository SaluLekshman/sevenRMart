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

public class ManageProductsPage {
	public WebDriver driver;
	
	 public ManageProductsPage (WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	 @FindBy(xpath="//h1[text()='List Products']") WebElement listProductElement;
	 @FindBy(xpath="//a[@class='active nav-link']") WebElement manageaproductElement;
	 @FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newElement;
	 @FindBy(xpath="//input[@id='title']") WebElement EnterTitleElement;
	 @FindBy(xpath="//input[@value='Veg']") WebElement vegProductTypeRadioButtonElement;
	 @FindBy(xpath="//input[@value='Nonveg']") WebElement nonVegProductTypeRadioButtonElement;
	 @FindBy(xpath="//input[@value='Others']") WebElement otherProductTypeRadioButtonElement;
	 @FindBy(xpath="//select[@id='cat_id']") WebElement categoryElement;
	 @FindBy(xpath="//select[@id='sub_id']") WebElement subCategoryElement;
	 @FindBy(xpath="//input[@value='weight']") WebElement pricetypeWeightRadioButtonElement;
	 @FindBy(xpath="//input[@value='piece']") WebElement pricetypePieceRadioButtonElement;
	 @FindBy(xpath="//input[@value='litre']") WebElement pricetypeLitreRadioButtonElement;
	 @FindBy(xpath="//input[@value='serves']") WebElement pricetypeServesRadioButtonElement;
 
	 public void clickOnmanageaproductElement()
	 {
		 WaitUtility.waitForElementClickable(driver,manageaproductElement );
		 PageUtility.clickOnElement(manageaproductElement);
	 }
	 public boolean isdisplayedlistProductElement()
	 {
		 WaitUtility.waitForElement(driver, listProductElement);
		 return PageUtility.isElementDisplayed(listProductElement);
	 }
	 public void clickOnnewElement()
	 {
		 WaitUtility.waitForElementClickable(driver, newElement);
		 PageUtility.clickOnElement(newElement);
	 }
	 public void EnterTitleElement( String inputTitleText) throws IOException 
	 {  
		 WaitUtility.waitForElement(driver, EnterTitleElement);
		 PageUtility.enterText(EnterTitleElement,inputTitleText);
	 }
	 public boolean nonVegProductTypeElementIsEnabled() 
	 {
		 WaitUtility.waitForElement(driver, nonVegProductTypeRadioButtonElement);
		 return PageUtility.elementIsEnabled(nonVegProductTypeRadioButtonElement);
	 }
	 public boolean clickNonVegProductTypeElement() 
	 {
		 WaitUtility.waitForElementClickable(driver,nonVegProductTypeRadioButtonElement );
		 return PageUtility.clickOnElement(nonVegProductTypeRadioButtonElement);
	 }
	 public void categoryElementFaker( ) 
	 {  
		 WaitUtility.waitForElement(driver, categoryElement); 
		 FakerUtility.fakerFoodName(categoryElement);
		
	 }
	 
	 public void subCategoryElementFaker( ) 
	 {  
		 WaitUtility.waitForElement(driver, subCategoryElement); 
		 FakerUtility.fakerFoodName(subCategoryElement);
		
	 }
	 
	 public void clickOnpricetypeLitreRadioButtonElement()
	 {
		 pricetypeLitreRadioButtonElement.click();
	 }
	 public boolean isEnabledpricetypeLitreRadioButtonElement()
	 {
		 return PageUtility.elementIsEnabled(pricetypeLitreRadioButtonElement);
	 }
	 
}
