package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.ManagePayMentMethodsPage;
import com.sevenRMartSuperMarketPages.SiteNamePage;
import com.sevenRMartSuperMarketPages.LoginPage;

import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;
import retry.Retry;

public class ManagePaymentMethodsTest extends Base {
	HamburgerMenuPage hamburgermenupage;
	ManagePayMentMethodsPage managepaymentmethodpage;
	LoginPage loginpage;
	SiteNamePage sitenamepage;
	@Test(groups = {"regression" },retryAnalyzer = Retry.class)
	@Parameters({"usernameInput","PasswordInput"})
	public void VerifyCerditCardPaymentMethodAndPayLimitIsDispalyedCorrectlyInManagePaymentMethodTable(String usernameInput,String PasswordInput)  
	{
	    String inputMainMenu=ExcelUtility.getString(0,4,GeneralUtilities.FILEPATH,"hamBurgerMenuData");
	    String titlteInput=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"managePayementMethodData");
	    String PayLimitInput=ExcelUtility.getNumeric(0,1,GeneralUtilities.FILEPATH,"managePayementMethodData");
	    loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		managepaymentmethodpage=new ManagePayMentMethodsPage(driver);
		managepaymentmethodpage.clickOnmanagePaymentmethods();
		hamburgermenupage=new HamburgerMenuPage(driver);
		hamburgermenupage.selectMenu(inputMainMenu);
		managepaymentmethodpage.clickOnActionInManagePaymentMethodTable();
		managepaymentmethodpage.enterTitleInManagePaymentMethodsInformations(titlteInput);
		managepaymentmethodpage.entersLimitInManagePaymentMethodsInformations(PayLimitInput);
		String actualPaymentMethod=managepaymentmethodpage.enterTitleInManagePaymentMethodsInformations(titlteInput);
		String actualPaylimit=managepaymentmethodpage.entersLimitInManagePaymentMethodsInformations(PayLimitInput);
		assertEquals(actualPaymentMethod, titlteInput,"The credit card payment method is not available");
		assertEquals(actualPaylimit,PayLimitInput ,"The payment limit is not available");
		
	}
	@Test(groups = {"regression" })
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyUserCanUpdatePaymentDetailsByClickingActionButtonInManagePaymentMethodsTableAndEnterUpdatedTitle_UpdatedPayLimit_AndClickUpdateButton(String usernameInput,String PasswordInput) 
	{
	    String inputMainMenu=ExcelUtility.getString(0,4,GeneralUtilities.FILEPATH,"hamBurgerMenuData");
	    String updatetitlteInput=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"managePayementMethodData");
	    String updatePayLimitInput=ExcelUtility.getNumeric(0,1,GeneralUtilities.FILEPATH,"managePayementMethodData");
	    loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		managepaymentmethodpage=new ManagePayMentMethodsPage(driver);
		managepaymentmethodpage.clickOnmanagePaymentmethods();
		hamburgermenupage=new HamburgerMenuPage(driver);
		hamburgermenupage.selectMenu(inputMainMenu);
		managepaymentmethodpage.clickOnActionInManagePaymentMethodTable();
		String actualPaymentMethod=managepaymentmethodpage.enterTitleInManagePaymentMethodsInformations(updatetitlteInput);
		String actualPaylimit=managepaymentmethodpage.entersLimitInManagePaymentMethodsInformations(updatePayLimitInput);
		managepaymentmethodpage.clickOnUpdateButton();
		assertEquals(actualPaymentMethod,updatetitlteInput,"The cpayment method is not updated");
		assertEquals(actualPaylimit,updatePayLimitInput,"The payment limit is not updated");
	}
	
	@Test(groups = {"regression" },retryAnalyzer = Retry.class)
	@Parameters({"usernameInput","PasswordInput"})
	public void VerifyUserCanNavigateBackToHomePageByClickingHomeButtonInManagePayementMethodPage(String usernameInput,String PasswordInput) 
	{
		
	    String inputMainMenu=ExcelUtility.getString(0,4,GeneralUtilities.FILEPATH,"hamBurgerMenuData");
	    String titlteInput=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"managePayementMethodData");
	    String PayLimitInput=ExcelUtility.getNumeric(0,1,GeneralUtilities.FILEPATH,"managePayementMethodData");
	    loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		managepaymentmethodpage=new ManagePayMentMethodsPage(driver);
		managepaymentmethodpage.clickOnmanagePaymentmethods();
		hamburgermenupage=new HamburgerMenuPage(driver);
		hamburgermenupage.selectMenu(inputMainMenu);
		managepaymentmethodpage.clickOnActionInManagePaymentMethodTable();
		managepaymentmethodpage.enterTitleInManagePaymentMethodsInformations(titlteInput);
		managepaymentmethodpage.entersLimitInManagePaymentMethodsInformations(PayLimitInput);
		managepaymentmethodpage.clickOnmanagePaymentmethodsPageHomeButton();
		sitenamepage=new SiteNamePage(driver);
		boolean siteNameIsdisplyed=sitenamepage.verifySiteNameIsDisplayed();
		assertTrue(siteNameIsdisplyed,"The user cannot navigate back to home page");
	}
	
	
}
