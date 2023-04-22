package com.sevenRMartSuperMarketPages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExcelUtility;
import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageUsersPage {
public WebDriver driver;
	
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

public ManageUsersPage clickOnlistUsersSearchButtonElement()
{
	listUsersSearchButtonElement.click();
	return this;
}
public  ManageUsersPage enterTextOnNameElement(String inputText)
{
	WaitUtility.waitForElement(driver, enterTextOnNameElement);
	PageUtility.enterText(enterTextOnNameElement, inputText);
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
	return PageUtility. stylePropertyValidation(searchButtonElement, "background-color");
	
	
}
public String resetButtonElement()
{
	
	WaitUtility.waitForElement(driver, resetButtonElement);
	return PageUtility. stylePropertyValidation(resetButtonElement, "border-color");
}

public String searchResultListUser(String expectedSearchValue) throws IOException
{
	 //String expectedSearchValue1=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageUsersData");
	 List<WebElement> row=driver.findElements(By.xpath("//tr//th//following::td"));
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