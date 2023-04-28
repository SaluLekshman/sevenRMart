package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.LoginPage;
import com.sevenRMartSuperMarketPages.ManageSliderPage;

import Utilities.ExcelUtility;
import retry.Retry;

public class ManageSliderTest extends Base {
	HamburgerMenuPage hamburgermenupage;
	ManageSliderPage manageSliderPage;
	LoginPage loginpage;
	Retry retry;
	@Test
	@Parameters({"usernameInput","PasswordInput"})
	public void addNewSliderInListSliderTable(String usernameInput,String PasswordInput ) throws IOException
	{
		String linkInput=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageSliderPageData");
		loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickRememberMe().clicksignIn();
		manageSliderPage=new ManageSliderPage (driver);
		manageSliderPage.clickOnMoreInfo();
		manageSliderPage.clickOnNewButton();
		manageSliderPage.imageChoseFile();
		manageSliderPage.enterTheOfferCode(linkInput);
		manageSliderPage.clickOnSaveButton();
		boolean isNewSliderCreatedSuccessfully=manageSliderPage. isNewSliderCreatedSuccessfully();
		assertTrue( isNewSliderCreatedSuccessfully,"An alert message not displayed");
		
		

	}
	@Test
	@Parameters({"usernameInput","PasswordInput"})
	public void addNewSlideraddedIsDispalyedInListSliderTable(String usernameInput,String PasswordInput ) throws IOException
	{
		String expectedSearchValue=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageSliderPageData");
		loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickRememberMe().clicksignIn();
		manageSliderPage=new ManageSliderPage (driver);
		manageSliderPage.clickOnMoreInfo();
		String actualSearchValue=manageSliderPage.searchNewSliderAdded(expectedSearchValue);
		assertEquals(actualSearchValue,expectedSearchValue,"New slider added is not displayed in list slider table");
	}
	@Test
	@Parameters({"usernameInput","PasswordInput"})
	public void deleteSliderFromListSliderTable(String usernameInput,String PasswordInput ) throws IOException
	{
	
		
		loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickRememberMe().clicksignIn();
		manageSliderPage=new ManageSliderPage (driver);
		manageSliderPage.clickOnMoreInfo();
		manageSliderPage.clickOnDeleteSliderFromListSliderTable();
	    boolean isSliderDeletedFromListSliderTable=manageSliderPage.isSliderDeletedFromListSliderTable();
		assertTrue(isSliderDeletedFromListSliderTable,"Slider is not deleted from list slider table");

		
		
	}

}
