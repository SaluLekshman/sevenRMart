package com.sevenRMartSuperMarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class HomePagePage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility() ;
	
	 public HomePagePage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	 @FindBy(xpath="//a[@class='nav-link']") WebElement homePage;
	 @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']") WebElement clickOnMoreInfo;
	 public String getStyleProperties()
	 {
		 return pageutility.stylePropertyValidation(clickOnMoreInfo,"color");
	 }
	 public String getAlignment()
	 {
		  return pageutility.stylePropertyValidation(clickOnMoreInfo,"line-height");
	 }
}
