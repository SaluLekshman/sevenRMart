package com.sevenRMartSuperMarketPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class AdminUsersPage {
	public WebDriver driver;
	PageUtility pageutility=new  PageUtility();
	
	 public  AdminUsersPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	 @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement clickOnMoreInfo;
	 @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement clickOnNewButtonInAdminUsersPage;
	 @FindBy(xpath="//input[@id='username']") WebElement enterUserNameInNewAdminUsersPage;
	 @FindBy(xpath="//input[@id='password']") WebElement enterpasswordInNewAdminUsersPage;
	 @FindBy(xpath="//select[@id='user_type']") WebElement selectUserTypeInNewAdminUsersPage;
	 @FindBy(xpath="//tr//th//following::td")  List<WebElement> adminUsersTableValues;
	 @FindBy(xpath="//a[@onclick='click_button(2)']")  WebElement clickOnSearchInadminUsersTable;
	 @FindBy(xpath="//input[@id='un']") WebElement enterUserNameInSearchAdminUsersPage;
	 @FindBy(xpath="//button[@name='Search']") WebElement clickOnSearchButtonInSearchAdminUsersInAdminUsersPage;
	 @FindBy(xpath="//select[@id='ut']") WebElement selectUserTypeinSearchNewAdminUsersPage;
	 @FindBy(xpath="//select[@id='ut']") WebElement selectUserTypeinSearchAdminUsersInAdminUsersPage;
	 public AdminUsersPage  clickOnAdminUsersMoreInfo()
	 {
		clickOnMoreInfo.click();
		return this;
	 }
	 public AdminUsersPage  clickOnNewButtonInAdminUsersPage()
	 {
		 clickOnNewButtonInAdminUsersPage.click();
		 return this;
	 }
	 public AdminUsersPage enterUserNameInNewAdminUsersPage(String userName)
	 {
		 pageutility.enterText(enterUserNameInNewAdminUsersPage,userName);
		 return this;
	 }
	 public AdminUsersPage enterpasswordInNewAdminUsersPage(String password)
	 {
		 pageutility.enterText(enterpasswordInNewAdminUsersPage,password);
		 return this;
	 }
	 public AdminUsersPage selectUserTypeInNewAdminUsersPage()
	 {
		pageutility.selectDropdownbyIndex(selectUserTypeInNewAdminUsersPage, 2);
		selectUserTypeInNewAdminUsersPage.submit();
		return this;
	 }
	 public AdminUsersPage  clickOnSearchInadminUsersTable()
	 {
		 clickOnSearchInadminUsersTable.click();
		 return this;
	 }
	 public AdminUsersPage enterUserNameInSearchAdminUsersPage(String userName)
	 {
		 pageutility.enterText(enterUserNameInSearchAdminUsersPage,userName);
		 return this;
	 }
	 
	 public String searchNewUseraddedIsUpdatedInAdminUsersTable(String expectedSearchValue) 
	 {
	 	 
	 	 List<WebElement> row=adminUsersTableValues;
	 	  for(WebElement tablerow:row)
	 	  {
	 		  ArrayList<String> rowvalue=new ArrayList<String>();
	 		  String actualSearchValue= tablerow.getText();
	 		  rowvalue.add( actualSearchValue);
	 		  if( actualSearchValue.contains(expectedSearchValue))
	 		  {
	 			  System.out.println("The search result is correct");
	 		      break;  
	 		  }
	 		  
	 	  }
	 	return expectedSearchValue;
	
	 }
	 public AdminUsersPage selectUserTypeinSearchNewAdminUsersPage()
	 {
		 WaitUtility.waitForElementIsPresent(driver, selectUserTypeInNewAdminUsersPage);
		 pageutility.selectDropdownbyIndex(selectUserTypeInNewAdminUsersPage, 2);
		 selectUserTypeInNewAdminUsersPage.submit();
		 return this;
	 }
	 
	 public AdminUsersPage clickOnSearchButtonInSearchAdminUsersInAdminUsersPage()
	 {
		 WaitUtility.waitForElement(driver,clickOnSearchButtonInSearchAdminUsersInAdminUsersPage);
		 clickOnSearchButtonInSearchAdminUsersInAdminUsersPage.click();
		 return this;
	 }
	 public AdminUsersPage selectUserTypeinSearchAdminUsersInAdminUsersPage()
	 {
		 pageutility.selectDropdownbyIndex(selectUserTypeinSearchAdminUsersInAdminUsersPage,2);
		return this;
	 }
	 
}


