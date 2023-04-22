package com.sevenRMartSuperMarketPages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManagePayMentMethodsPage {
	public WebDriver driver;

	public ManagePayMentMethodsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//p[text()='Manage Payment Methods']") WebElement managePaymentmethodsElement;
	@FindBy(xpath = "//a[text()='Home']") WebElement managePaymentmethodsPageHomeButton;
	@FindBy(xpath = "//a[contains(@href,'list-payment-methods?edit=2&page_ad=1')]") WebElement managePaymentMethodsActionElement;
	@FindBy(xpath="//input[@id='name']") WebElement managePaymentMethodsInformationsTitleElement;
	@FindBy(xpath="//input[@id='limit']") WebElement managePaymentMethodsInformationsLimitElement;
	@FindBy(xpath="//button[@name='Update']") WebElement managePaymentMethodsInformationsUpdateButtonElement;
	
	
	
	public boolean IsDispalyedmanagePaymentmethodsElement() {
		WaitUtility.waitForElementClickable(driver, managePaymentmethodsElement);
		return PageUtility.isElementDisplayed(managePaymentmethodsElement);
	}

	public void clickOnmanagePaymentmethodsElement() {
		WaitUtility.waitForElementClickable(driver, managePaymentmethodsElement);
		PageUtility.clickOnElement(managePaymentmethodsElement);
		;
	}

	public void clickOnmanagePaymentmethodsPageHomeButton() {
		WaitUtility.waitForElement(driver, managePaymentmethodsPageHomeButton);
		PageUtility.clickOnElement(managePaymentmethodsPageHomeButton);
		
	}
	public ManagePayMentMethodsPage managePaymentMethodsActionElement() 
	{
		managePaymentMethodsActionElement.click();
		return this;
	}
public ManagePayMentMethodsPage managePaymentMethodsInformationsTitleElement(String titleInput)
	{
	    managePaymentMethodsInformationsTitleElement.clear();
		managePaymentMethodsInformationsTitleElement.sendKeys(titleInput);
		return this;
			
	}
 public ManagePayMentMethodsPage managePaymentMethodsInformationsLimitElement(String limitInput)
	{
	    managePaymentMethodsInformationsLimitElement.clear();
	 	managePaymentMethodsInformationsLimitElement.sendKeys(limitInput);
		return this;
	 	
			
	}

public ManagePayMentMethodsPage managePaymentMethodsInformationsUpdateButtonElement()
	{
	  	managePaymentMethodsInformationsUpdateButtonElement.click();
		return this;
	}	

	public String managePaymentMethodTitle(String expectedPaymentMethodTitle) {

		List<WebElement> row = driver.findElements(By.xpath("//tr//th//following::td"));
		for (WebElement tablerow : row) {
			ArrayList<String> rowvalue = new ArrayList<String>();
			String actualPaymentMethodType = tablerow.getText();
			rowvalue.add(actualPaymentMethodType);
			System.out.println(rowvalue);
			if (actualPaymentMethodType.equals(expectedPaymentMethodTitle)) {
				System.out.println("The Payment method is  credit card is not available");
				break;
			}

		}
		return expectedPaymentMethodTitle;

	}
	
	public String managePaymentMethodPayLimit(String expectedPaylimit) {

		List<WebElement> row = driver.findElements(By.xpath("//tr//th//following::td"));
		for (WebElement tablerow : row) {
			ArrayList<String> rowvalue = new ArrayList<String>();
			String actualPaylimit = tablerow.getText();
			rowvalue.add(actualPaylimit);
			System.out.println(rowvalue);
			if (actualPaylimit.equals(expectedPaylimit)) {
				System.out.println("The Pay limit is not set as 50000");
				break;
			}

		}
		return expectedPaylimit;

	}
	
	

}
