package com.sevenRMartSuperMarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManagrUsersPage {
public WebDriver driver;
	
	public ManagrUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//a[@href='javascript:void(0)']") WebElement searchButtonElement;
@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") WebElement resetButtonElement;

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


}
