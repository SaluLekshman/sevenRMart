package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.AdminUsersPage;
import com.sevenRMartSuperMarketPages.HomePagePage;
import com.sevenRMartSuperMarketPages.LoginPage;

import Utilities.ExcelUtility;
import retry.Retry;

public class AdminUsersTest extends Base {
	 LoginPage loginpage;
	 AdminUsersPage adminuserspage;
		Retry retry;

		@Test
		@Parameters({ "usernameInput", "PasswordInput" })
		public void VerifyNewAdminUserCanBeAddedInAdminUsersPage(String usernameInput,String PasswordInput) throws IOException 
		{
			
			String expectedsearchvalue=ExcelUtility.getString(1,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"loginPageData");
			loginpage = new LoginPage(driver);
			loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
			adminuserspage= new AdminUsersPage(driver);
			adminuserspage.clickOnAdminUsersMoreInfo().clickOnNewButtonInAdminUsersPage().enterUserNameInNewAdminUsersPage(usernameInput).enterpasswordInNewAdminUsersPage(PasswordInput);
			String actualSearchValue=adminuserspage.searchNewUseraddedIsUpdatedInAdminUsersTable(expectedsearchvalue);
			assertEquals(actualSearchValue,expectedsearchvalue,"New admin user  cannot be added ");
		}
		@Test
		@Parameters({ "usernameInput", "PasswordInput" })
		public void searchAdminUsersInAdminUsersPage(String usernameInput,String PasswordInput) throws IOException 
		{
			
			String expectedsearchvalue=ExcelUtility.getString(1,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"loginPageData");
			loginpage = new LoginPage(driver);
			loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
			adminuserspage= new AdminUsersPage(driver);
			adminuserspage.clickOnAdminUsersMoreInfo();
			adminuserspage.clickOnSearchInadminUsersTable();
			adminuserspage.enterUserNameInSearchAdminUsersPage(usernameInput);
			adminuserspage.selectUserTypeinSearchAdminUsersInAdminUsersPage();
			adminuserspage.clickOnSearchButtonInSearchAdminUsersInAdminUsersPage();
			String actualSearchValue=adminuserspage.searchNewUseraddedIsUpdatedInAdminUsersTable(expectedsearchvalue);
			assertEquals(actualSearchValue,expectedsearchvalue,"New admin user  cannot be added ");
		}
			
			
}		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		

