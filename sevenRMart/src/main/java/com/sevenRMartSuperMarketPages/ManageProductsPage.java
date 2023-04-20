package com.sevenRMartSuperMarketPages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtility;
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
	 @FindBy(xpath="//input[@value='Veg']") WebElement vegProductTypeElement;
	 @FindBy(xpath="//input[@value='Nonveg']") WebElement nonVegProductTypeElement;
	 @FindBy(xpath="//input[@value='Others']") WebElement otherProductTypeElement;
	 @FindBy(xpath="//select[@id='cat_id']") WebElement categoryElement;
	 
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
		 //String inputTitleText=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageProductData");
		 PageUtility.enterText(EnterTitleElement,inputTitleText);
	 }
	 public boolean vegProductTypeElementIsEnabled() 
	 {
		 WaitUtility.waitForElement(driver,vegProductTypeElement );
		 return PageUtility.elementIsEnabled(vegProductTypeElement);
	 }
	 public boolean clickNonVegProductTypeElement() 
	 {
		 WaitUtility.waitForElementClickable(driver,nonVegProductTypeElement );
		 return PageUtility.clickOnElement(nonVegProductTypeElement);
	 }
	 public String EntercategoryElement(String inputCategory ) 
	 {  
		 WaitUtility.waitForElement(driver, categoryElement); 
		 PageUtility.enterText(categoryElement, inputCategory);
		 return inputCategory;
	 }
}
