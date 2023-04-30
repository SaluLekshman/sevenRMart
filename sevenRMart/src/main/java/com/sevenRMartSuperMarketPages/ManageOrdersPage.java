package com.sevenRMartSuperMarketPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageOrdersPage {
	public WebDriver driver;
	
	 public ManageOrdersPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	}
	 @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']") WebElement clickOnMoreInfo;
	 @FindBy(xpath="//a[text()='Change Status']") WebElement clickOnChangeStatus;
     @FindBy(xpath="//select[@id='status']")  WebElement clickOnUpdateStatus;
     @FindBy(xpath="//button[@name='Update_st']")  WebElement clickOnChangeDeliveryStausUpdateButton;
     @FindBy(xpath="//a[text()='Assign Delivery Boy']") WebElement clickOnAssignDeliveryBoy;
     @FindBy(xpath="//select[@id='delivery_boy_id']") WebElement clickOnSelectDeliverBoyFromDropDown;
     @FindBy(xpath="//button[@type='submit']")  WebElement clickOnAssignDeliverBoyUpdateButton;
     @FindBy(xpath="//button[@class='close']")  WebElement closeAlertMessageButton;
     @FindBy(xpath="//tr//th//following::td//option[@value='9']")  List<WebElement> listOrderTableCellValue;
     @FindBy(xpath="//a[text()='View']")  WebElement clickOnViewButtonInManageOrdersPageListOrdersTable;
     @FindBy(xpath="//div//h1[text()='Order Details']") WebElement orderDetailsPage;
     @FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Order/delete?del=693&page_ad=1'][1]") WebElement ClickOndeleteButtonOrderDetailsInListOrderTable;
     @FindBy(xpath="//div[contains(@class,'alert-success ')]") WebElement alertOrderDeletedSuccessfully;
     
	
	 public ManageOrdersPage clickOnMoreInfo()
	 {
		 clickOnMoreInfo.click();
		 return this;

	 }
	 public ManageOrdersPage clickOnChangeStatus()
	 {
		 clickOnChangeStatus.click();
		 return this;

	 }
	 public ManageOrdersPage clickOnUpdateStatus()
	 {
		 clickOnUpdateStatus.click();
		 PageUtility.selectDropdownbyIndex(clickOnUpdateStatus,1);
		 return this;

	 }
	 
	 public ManageOrdersPage clickOnAssignDeliveryBoy()
	 {
		 clickOnAssignDeliveryBoy.click();
		 return this;

	 }
	 public ManageOrdersPage clickOnChangeDeliveryStausUpdateButton()
	 {
		 
		 WaitUtility.waitForElement(driver,clickOnChangeDeliveryStausUpdateButton);
		 PageUtility.clickOnElement(clickOnChangeDeliveryStausUpdateButton);
		return this;
		 

	 }
	 public ManageOrdersPage clickOnSelectDeliverBoyFromDropDown()
	 {
		 clickOnSelectDeliverBoyFromDropDown.click();
		 WaitUtility.waitForElement(driver,clickOnSelectDeliverBoyFromDropDown);
		 PageUtility.selectDropdownbyIndex(clickOnSelectDeliverBoyFromDropDown,3);
		 clickOnSelectDeliverBoyFromDropDown.submit();
		 return this;

	 }
	 public ManageOrdersPage closeAlertMessageButton()
	 {
		 closeAlertMessageButton.click();
		 return this;

	 }
	 
	 public ManageOrdersPage clickOnViewButtonInManageOrdersPageListOrdersTable()
	 {
		 clickOnViewButtonInManageOrdersPageListOrdersTable.click();
		 return this;

	 }
	 public boolean isAbleToViewOrderDetailsInManageOrdersPage()
	 
	 {
		 WaitUtility.waitForElement(driver,orderDetailsPage);
		 return PageUtility.isElementDisplayed(orderDetailsPage);
		 
	 }
	 public String  ClickOndeleteButtonOrderDetailsInListOrderTable()
	 {
		 ClickOndeleteButtonOrderDetailsInListOrderTable.click();
		 return driver.switchTo().alert().getText().toString();
	 }
	 public boolean isAbleToDeleteOrderDetailsFromListOrderTable()
	 {
		 WaitUtility.waitForElement(driver,alertOrderDeletedSuccessfully);
		 return PageUtility.isElementDisplayed(alertOrderDeletedSuccessfully);

	 }
	 
	 public String searchInListOrderTable(String expectedSearchValue) 
	 {
	 	 
	 	 List<WebElement> row= listOrderTableCellValue;
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
	 
	 
}
