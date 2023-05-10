package com.sevenRMartSuperMarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class SiteNamePage
{
	public WebDriver driver ;
	PageUtility pageUtility=new PageUtility();
	 public  SiteNamePage (WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	
	@FindBy(xpath="//span[text()='7rmart supermarket']") WebElement textOfsiteName;
	 public boolean verifySiteNameIsDisplayed()
	 {
		 WaitUtility.waitForElement(driver,textOfsiteName);
		 return pageUtility.isElementDisplayed(textOfsiteName);
	 }
	 public String getTextOfsiteName()
	 {
		 WaitUtility.waitForElement(driver,textOfsiteName);
		 return pageUtility.getElementText(textOfsiteName);
	 }
	 public String getColorOfSiteName()
	 {
		return pageUtility.stylePropertyValidation(textOfsiteName,"color");
		 
	 }
}
