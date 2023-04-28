package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.ManageOfferCodePage;
import com.sevenRMartSuperMarketPages.LoginPage;
import Utilities.ExcelUtility;
import retry.Retry;

public class ManageOfferCodeTest extends Base {
	HamburgerMenuPage hamburgermenupage;
	ManageOfferCodePage manageoffercodepage;
	LoginPage loginpage;
	Retry retry;
	
	@Test(groups = {"regression" })
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyNewOfferCodeCanBeAddedByEnteringOfferInformation(String usernameInput,String PasswordInput) throws IOException 
	{
	 
	    String enterOfferCodeInput=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageOfferCodePageData");
	    String enterPercentageInput=ExcelUtility.getNumeric(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageOfferCodePageData");
	    String enterAmountInput=ExcelUtility.getNumeric(0,2,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageOfferCodePageData");
	    String enterDescriptionInput=ExcelUtility.getString(0,3,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageOfferCodePageData");
	    loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickRememberMe().clicksignIn();
		manageoffercodepage=new ManageOfferCodePage(driver);
		manageoffercodepage.clickOnMoreInfo().
		clickOnNewButton().
		enterTheOfferCode(enterOfferCodeInput).
		enterPercentage(enterPercentageInput).
		enterAmount(enterAmountInput).
		enterDescription( enterDescriptionInput).
		imageChoseFile().
		clickOnSaveButton();
		Boolean isNewOfferCodeAdded=manageoffercodepage.addNewOfferCode();
		assertTrue(isNewOfferCodeAdded,"New offer is not added ,already exist code");
		
	}
	@Test(groups = {"regression" })
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyNewOfferCodeAddedIsDisplayedInListOfferCodeTable(String usernameInput,String PasswordInput) throws IOException 
	{
	 
	    String enterOfferCodeInput=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageOfferCodePageData");
	    String enterPercentageInput=ExcelUtility.getNumeric(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageOfferCodePageData");
	    String enterAmountInput=ExcelUtility.getNumeric(0,2,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageOfferCodePageData");
	    String enterDescriptionInput=ExcelUtility.getString(0,3,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageOfferCodePageData");
	    loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickRememberMe().clicksignIn();
		manageoffercodepage=new ManageOfferCodePage(driver);
		manageoffercodepage.clickOnMoreInfo();
		String actualSearchResult=manageoffercodepage.searchNewOfferCodeAdded(enterOfferCodeInput);
		assertEquals(actualSearchResult,enterOfferCodeInput," New offer code added is not displayed in the list offer table");
		
		
	}
	
}
