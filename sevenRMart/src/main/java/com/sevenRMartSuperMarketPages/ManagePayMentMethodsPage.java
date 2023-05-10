package com.sevenRMartSuperMarketPages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManagePayMentMethodsPage {
	public WebDriver driver;
	PageUtility pageUtility = new PageUtility();

	public ManagePayMentMethodsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//p[text()='Manage Payment Methods']") WebElement clickOnmanagePaymentmethods;
	@FindBy(xpath = "//a[text()='Home']") WebElement clickOnManagePaymentmethodsPageHomeButton;
	@FindBy(xpath = "//a[contains(@href,'list-payment-methods?edit=2&page_ad=1')]") WebElement clickOnActionInManagePaymentMethodTable;
	@FindBy(xpath = "//input[@id='name']") WebElement enterTitleInManagePaymentMethodsInformations;
	@FindBy(xpath = "//input[@id='limit']") WebElement enterInformationsLimitInManagePaymentMethodsInformations;
	@FindBy(xpath = "//button[@name='Update']") WebElement clickOnUpdateButtonInManagePaymentMethodsInformations;
	@FindBy(xpath = "//span[text()='7rmart supermarket']") WebElement siteNameIsDispalyed;
	@FindBy(xpath = "//tr//th//following::td") List<WebElement> managePaymentMethodSTable;

	public boolean siteNameIsDisplayed() {
		WaitUtility.waitForElement(driver, siteNameIsDispalyed);
		return pageUtility.isElementDisplayed(siteNameIsDispalyed);
	}

	public String GetTextsiteName() {
		WaitUtility.waitForElement(driver, siteNameIsDispalyed);
		return pageUtility.getElementText(siteNameIsDispalyed);
	}

	public boolean IsDispalyedmanagePaymentmethods() {
		WaitUtility.waitForElementClickable(driver, clickOnmanagePaymentmethods);
		return pageUtility.isElementDisplayed(clickOnmanagePaymentmethods);
	}

	public void clickOnmanagePaymentmethods() {
		WaitUtility.waitForElementClickable(driver, clickOnmanagePaymentmethods);
		pageUtility.clickOnElement(clickOnmanagePaymentmethods);

	}

	public void clickOnmanagePaymentmethodsPageHomeButton() {
		WaitUtility.waitForElement(driver, clickOnManagePaymentmethodsPageHomeButton);
		pageUtility.clickOnElement(clickOnManagePaymentmethodsPageHomeButton);

	}

	public ManagePayMentMethodsPage clickOnActionInManagePaymentMethodTable() {
		clickOnActionInManagePaymentMethodTable.click();
		return this;
	}

	public String enterTitleInManagePaymentMethodsInformations(String titleInput) {
		enterTitleInManagePaymentMethodsInformations.clear();
		enterTitleInManagePaymentMethodsInformations.sendKeys(titleInput);
		return titleInput;
	}

	public String entersLimitInManagePaymentMethodsInformations(String limitInput) {
		enterInformationsLimitInManagePaymentMethodsInformations.clear();
		enterInformationsLimitInManagePaymentMethodsInformations.sendKeys(limitInput);
		return limitInput;

	}

	public ManagePayMentMethodsPage clickOnUpdateButton() {
		clickOnUpdateButtonInManagePaymentMethodsInformations.click();
		return this;
	}
	public String updateLimitInManagePaymentMethodsInformations(String titleInput) {
		
		enterTitleInManagePaymentMethodsInformations.sendKeys(titleInput);
		return titleInput;
	}
	public String updateTitleInManagePaymentMethodsInformations(String limitInput) {
	
		enterInformationsLimitInManagePaymentMethodsInformations.sendKeys(limitInput);
		return limitInput;

	}
	public String verifyCreditCardPaymentIsDisplayedInManagePaymentMethodTable(String expectedPaymentMethodTitle) {

		List<WebElement> row = managePaymentMethodSTable;
		for (WebElement tablerow : row) {
			ArrayList<String> rowvalue = new ArrayList<String>();
			String actualPaymentMethodType = tablerow.getText();
			rowvalue.add(actualPaymentMethodType);
			System.out.println(rowvalue);
			if (actualPaymentMethodType.contains(expectedPaymentMethodTitle))
			{
				System.out.println("The Payment method is  credit card is not available");
				break;
			}

		}
		return expectedPaymentMethodTitle;

	}

	public String verifyPayLimitPaymentIsDisplayedInManagePaymentMethodTable(String expectedPaylimit) {

		List<WebElement> row = managePaymentMethodSTable;
		for (WebElement tablerow : row) 
		{
			ArrayList<String> rowvalue = new ArrayList<String>();
			String actualPaylimit = tablerow.getText();
			rowvalue.add(actualPaylimit);
			System.out.println(rowvalue);
			if (actualPaylimit.contains(expectedPaylimit)) 
			{
				System.out.println("The Pay limit is not set as 50000");
				break;
			}

		}
		return expectedPaylimit;

	}

}
