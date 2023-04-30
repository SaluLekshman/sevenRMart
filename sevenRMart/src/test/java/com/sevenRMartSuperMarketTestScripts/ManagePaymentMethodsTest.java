package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.ManagePayMentMethodsPage;
import com.sevenRMartSuperMarketPages.LoginPage;

import Utilities.ExcelUtility;
import Utilities.TestDataUtility;
import retry.Retry;

public class ManagePaymentMethodsTest extends Base {
	HamburgerMenuPage hamburgermenupage;
	ManagePayMentMethodsPage managepaymentmethodpage;
	LoginPage loginpage;
	Retry retry;
	@Test(groups = {"regression" })
	@Parameters({"usernameInput","PasswordInput"})
	public void managePaymentMethodsType(String usernameInput,String PasswordInput) 
	{
		
	    String inputMainMenu=ExcelUtility.getString(0,4,constants.Constants.TESTDATAFILEPATH,"hamBurgerMenuData");
		String expectedPaymentMethodType=ExcelUtility.getString(0,0,constants.Constants.TESTDATAFILEPATH,"managePayementMethodData");
		String expectedPayLimit=ExcelUtility.getNumeric(0,1,constants.Constants.TESTDATAFILEPATH,"managePayementMethodData");
	    loginpage=new LoginPage(driver);
	    loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
	    managepaymentmethodpage=new ManagePayMentMethodsPage(driver);
		managepaymentmethodpage.clickOnmanagePaymentmethodsElement();
		hamburgermenupage=new HamburgerMenuPage(driver);
		hamburgermenupage.selectMenu(inputMainMenu);
		String actualPaymentMethod=managepaymentmethodpage.managePaymentMethodTitle(expectedPaymentMethodType);
		String actualPaylimit=managepaymentmethodpage.managePaymentMethodTitle(expectedPayLimit);
		assertEquals(actualPaymentMethod, expectedPaymentMethodType,"The credit card payment method is not available");
		assertEquals(actualPaylimit, expectedPayLimit,"The payment limit is not available");
		
		
	}
	@Test(groups = {"regression" })
	@Parameters({"usernameInput","PasswordInput"})
	public void managePaymentMethodsAction(String usernameInput,String PasswordInput) 
	{
	    String inputMainMenu=ExcelUtility.getString(0,4,constants.Constants.TESTDATAFILEPATH,"hamBurgerMenuData");
	    String titlteInput=ExcelUtility.getString(0,0,constants.Constants.TESTDATAFILEPATH,"managePayementMethodData");
	    String PayLimitInput=ExcelUtility.getNumeric(0,1,constants.Constants.TESTDATAFILEPATH,"managePayementMethodData");
	    loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
		managepaymentmethodpage=new ManagePayMentMethodsPage(driver);
		managepaymentmethodpage.clickOnmanagePaymentmethodsElement();
		hamburgermenupage=new HamburgerMenuPage(driver);
		hamburgermenupage.selectMenu(inputMainMenu);
		managepaymentmethodpage.managePaymentMethodsActionElement();
		managepaymentmethodpage.managePaymentMethodsInformationsTitleElement(titlteInput).managePaymentMethodsInformationsLimitElement(PayLimitInput).managePaymentMethodsInformationsUpdateButtonElement();
		String actualPaymentMethod=managepaymentmethodpage.managePaymentMethodTitle(titlteInput);
		String actualPaylimit=managepaymentmethodpage.managePaymentMethodPayLimit(PayLimitInput);
		assertEquals(actualPaymentMethod, titlteInput,"The credit card payment method is not available");
		assertEquals(actualPaylimit,PayLimitInput ,"The payment limit is not available");
		//managepaymentmethodpage.clickOnmanagePaymentmethodsPageHomeButton();
		
	}
	
	@Test(groups = {"regression" })
	@Parameters({"usernameInput","PasswordInput"})
	public void navigateBackToManagePayment(String usernameInput,String PasswordInput) 
	{
	    String inputMainMenu=ExcelUtility.getString(0,4,constants.Constants.TESTDATAFILEPATH,"hamBurgerMenuData");
	    String titlteInput=ExcelUtility.getString(0,0,constants.Constants.TESTDATAFILEPATH,"managePayementMethodData");
	    String PayLimitInput=ExcelUtility.getNumeric(0,1,constants.Constants.TESTDATAFILEPATH,"managePayementMethodData");
	    loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
		managepaymentmethodpage=new ManagePayMentMethodsPage(driver);
		managepaymentmethodpage.clickOnmanagePaymentmethodsElement();
		hamburgermenupage=new HamburgerMenuPage(driver);
		hamburgermenupage.selectMenu(inputMainMenu);
		managepaymentmethodpage.managePaymentMethodsActionElement();
		managepaymentmethodpage.managePaymentMethodsInformationsTitleElement(titlteInput).managePaymentMethodsInformationsLimitElement(PayLimitInput).managePaymentMethodsInformationsUpdateButtonElement();
		managepaymentmethodpage.clickOnmanagePaymentmethodsPageHomeButton();
		
	}
	
	
}
