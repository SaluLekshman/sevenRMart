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

public class ManageUsersPage {
public WebDriver driver;
PageUtility pageUtility=new PageUtility();
	
	public ManageUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//a[@href='javascript:void(0)']") WebElement searchButtonElement;
@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") WebElement resetButtonElement;
@FindBy(xpath="//a[@href='javascript:void(0)']")WebElement listUsersSearchButtonElement;
@FindBy(xpath="//input[@id='un']")WebElement enterTextOnNameElement;
@FindBy(xpath="//a[@href='javascript:void(0)']")WebElement searchUsersButtonElement;
@FindBy(xpath="//tr//th//following::td") List<WebElement> manageUsers_ListUsersTable;


public ManageUsersPage clickOnlistUsersSearchButtonElement()
{
	listUsersSearchButtonElement.click();
	return this;
}
public  ManageUsersPage enterTextOnNameElement(String inputText)
{
	WaitUtility.waitForElement(driver, enterTextOnNameElement);
	pageUtility.enterText(enterTextOnNameElement, inputText);
	return this;
}
public  ManageUsersPage ClickOnsearchUsersButtonElement()
{
	searchUsersButtonElement.click();
	return this;
}

public String searchButtonElement()
{
	WaitUtility.waitForElement(driver, searchButtonElement);
	return pageUtility.stylePropertyValidation(searchButtonElement, "background-color");
	
	
}
public String resetButtonElement()
{
	
	WaitUtility.waitForElement(driver, resetButtonElement);
	return pageUtility.stylePropertyValidation(resetButtonElement, "border-color");
}

public String searchUserInListUserTable(String expectedSearchValue) 
{
	 List<WebElement> row= manageUsers_ListUsersTable;
	  for(WebElement tablerow:row)
	  {
		  ArrayList<String> rowvalue=new ArrayList<String>();
		  String actualSearchValue= tablerow.getText();
		  rowvalue.add( actualSearchValue);
		  System.out.println(rowvalue);
		  if( actualSearchValue.equals(expectedSearchValue))
		  {
			  System.out.println("The search result is correct");
		      break;  
		  } 
	  }
	return expectedSearchValue; 	
}


}