package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.LoginPage;
import com.sevenRMartSuperMarketPages.MobileSliderPage;
import com.sevenRMartSuperMarketPages.SiteNamePage;

import Utilities.ExcelUtility;
import retry.Retry;

public class MobileSliderTest extends Base {

	LoginPage loginpage;
	MobileSliderPage mobileslidepage;
	Retry retry;

	@Test
	@Parameters({ "usernameInput", "PasswordInput" })
	public void verifyNewMobileSlidercanBeSAddedByClickingNewInMobileSliderPage(String usernameInput,String PasswordInput) 
	{
		loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
		mobileslidepage=new MobileSliderPage(driver);
		mobileslidepage.clickOnMobileSliderMoreInfo().clickOnNewButtonInMobileSliderPage().selectCategoryFromDropDownInAddNewSliderPage().clickOnImageChooseFileInAddNewMobileSliderPage().clickOnSaveButtonInInAddNewMobileSliderPage();
		boolean newSliderAddedInTheMobileSlideTable=mobileslidepage.VerifyNewMobileSliderIsaddedOnMobileSliderTable();
		assertTrue(newSliderAddedInTheMobileSlideTable,"New mobile Slider is not added in the table");
		
	}
	  @Test
	  @Parameters({ "usernameInput", "PasswordInput" }) 
	  public void verifyMobileSliderCanBeDeletedFromListMobileSlidersTableByClickingDeleteButtonInListMobileSliderTable(String usernameInput,String PasswordInput) 
	  {
		  String getTextOfAlertMessage=ExcelUtility.getString(0,0,constants.Constants.TESTDATAFILEPATH,"mobileSliderPageData");
		  loginpage=new LoginPage(driver);
		  loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).
		  clicksignIn(); mobileslidepage=new MobileSliderPage(driver);
		  mobileslidepage.clickOnMobileSliderMoreInfo();
		  String MobileSliderIsDeletedGetText=mobileslidepage.clickOnDeleteButtonInListMobileSliderTable(); 
		  assertEquals(MobileSliderIsDeletedGetText,getTextOfAlertMessage,"mobile Slider is not deleted from  the table");
	  
	  }
	 
}
