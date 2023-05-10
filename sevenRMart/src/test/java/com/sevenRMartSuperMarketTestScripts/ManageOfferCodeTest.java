package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sevenRMartSuperMarketPages.ManageOfferCodePage;
import com.sevenRMartSuperMarketPages.LoginPage;
import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;
import Utilities.PageUtility;
import retry.Retry;

public class ManageOfferCodeTest extends Base {
	GeneralUtilities generalUtilities;
	ManageOfferCodePage manageoffercodepage;
	LoginPage loginpage;
	Retry retry;
	
	@Test(groups = {"regression" })
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyNewOfferCodeCanBeAddedByClickingNewButtonAndEnteringValidOfferDetails(String usernameInput,String PasswordInput) throws IOException 
	{
	 
	    String enterOfferCodeInput=null;
	    String enterPercentageInput=ExcelUtility.getNumeric(0,1,GeneralUtilities.FILEPATH,"manageOfferCodePageData");
	    String enterAmountInput=ExcelUtility.getNumeric(0,2,GeneralUtilities.FILEPATH,"manageOfferCodePageData");
	    String enterDescriptionInput=ExcelUtility.getString(0,3,GeneralUtilities.FILEPATH,"manageOfferCodePageData");
	    loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		manageoffercodepage=new ManageOfferCodePage(driver);
		manageoffercodepage.clickOnMoreInfo().
		clickOnNewButton().
		enterTheOfferCode(enterOfferCodeInput).
		enterPercentage(enterPercentageInput).
		enterAmount(enterAmountInput).
		enterDescription( enterDescriptionInput);
		manageoffercodepage.imageChoseFile();
		manageoffercodepage.clickOnSaveButton();
		Boolean isNewOfferCodeAdded=manageoffercodepage.addNewOfferCode();
		assertTrue(isNewOfferCodeAdded,"New offer is not added ,already exist code");
		
	}
	@Test(groups = {"regression" })
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyNewOfferCodeAddedIsDisplayedInListOfferCodeTableByClickingSearchButton(String usernameInput,String PasswordInput) 
	{
	 
	    String enterOfferCodeInput=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"manageOfferCodePageData");
	    loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		manageoffercodepage=new ManageOfferCodePage(driver);
		manageoffercodepage.clickOnMoreInfo();
		String actualSearchResult=manageoffercodepage.searchNewOfferCodeAdded(enterOfferCodeInput);
		assertEquals(actualSearchResult,enterOfferCodeInput," New offer code added is not displayed in the list offer table");
		
		
	}
	
}
