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

public class ManagePagesPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
	
	
	 public   ManagePagesPage (WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	 @FindBy(xpath="//ul[@class='nav nav-pills nav-sidebar flex-column']//ancestor::a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']") WebElement clickOnMoreInfo;
	 @FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchButtonOnManagePages;
	 @FindBy(xpath="//input[@class='form-control']") WebElement enterTitleInSearchListPages;
	 @FindBy(xpath="//a[@onclick='click_button(2)']") WebElement searchButtonOnSearchListPagesInManagePages;
	 @FindBy(xpath="//tr//th//following::td") List<WebElement> listPagesTable;
	 public void clickOnMoreInfo()
	 {
		 driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/list-page");
	 }
	 public void searchButtonOnManagePages()
	 {
		 searchButtonOnManagePages.click();
	 }
	 
	 public void enterTitleInSearchListPages(String enterTitleInput)
	 {
		 
		 WaitUtility.waitForElement(driver, enterTitleInSearchListPages);
		 pageutility.enterText(enterTitleInSearchListPages, enterTitleInput);
	 }
	 public void searchButtonOnSearchListPagesInManagePages()
	 {
		 searchButtonOnSearchListPagesInManagePages.click();
	 }
	 public String searchPagesInListPagesInManagePages(String expectedSearchValue) 
	 {
	 	 
	 	 List<WebElement> row=listPagesTable;
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
