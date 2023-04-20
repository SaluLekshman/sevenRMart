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
By listUsersSearchButton=By.xpath("//a[@href='javascript:void(0)']");
By enterTextOnName=By.xpath("//input[@id='un']");
By searchListUsersButton=By.xpath("//a[@href='javascript:void(0)']");

public WebElement clickOnlistUsersSearchButtonElement()
{
	WebElement clickOnlistUsersSearchButtonElement =driver.findElement(listUsersSearchButton);
	return clickOnlistUsersSearchButtonElement;
	
}
public WebElement enterTextOnNameElement()
{
	WebElement enterTextOnNameElement =driver.findElement(enterTextOnName);
	return enterTextOnNameElement;
	
}
public WebElement searchListUsersButtonElement()
{
	WebElement searchListUsersButtonElement =driver.findElement(searchListUsersButton);
	return searchListUsersButtonElement;
	
}

public String searchButtonElement()
{
	WaitUtility.waitForElement(driver, searchButtonElement);
	return PageUtility. stylePropertyValidation(searchButtonElement, "background-color");
	/*
	 * PageUtility. stylePropertyValidation(searchButtonElement, "color"); return
	 * PageUtility. stylePropertyValidation(searchButtonElement, "border-color");
	 */
	
	
}
public String resetButtonElement()
{
	/*
	 * PageUtility.stylePropertyValidation(resetButtonElement, "background-color");
	 * PageUtility. stylePropertyValidation(resetButtonElement, "color");
	 */
	WaitUtility.waitForElement(driver, resetButtonElement);
	return PageUtility. stylePropertyValidation(resetButtonElement, "border-color");
}

public void searchResultListUser(String expectedSearchValue) throws IOException
{
	 //String expectedSearchValue1=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageUsersData");
	 List<WebElement> row=driver.findElements(By.xpath("//tr//th//following::td"));
	  for(WebElement tablerow:row)
	  {
		  ArrayList<String> rowvalue=new ArrayList<String>();
		  String actualSearchValue= tablerow.getText();
		  rowvalue.add( actualSearchValue);
		  System.out.println(rowvalue);
		  if( actualSearchValue.equals(actualSearchValue))
		  {
			  System.out.println("The search result is correct");
		      break;  
		  }
		  
	  }
	  

	
}


}



