package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.AdminUsersPage;
import com.sevenRMartSuperMarketPages.HomePagePage;
import com.sevenRMartSuperMarketPages.LoginPage;

import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;
import retry.Retry;


public class AdminUsersTest extends Base {
	 LoginPage loginpage;
	 AdminUsersPage adminuserspage;
		@Test(retryAnalyzer = Retry.class)
		@Parameters({ "usernameInput", "PasswordInput" })
		public void VerifyNewAdminUserCanBeAddedInAdminUsersTableByClickingNewButton(String usernameInput,String PasswordInput) 
		{
			
			String expectedsearchvalue=ExcelUtility.getString(1,0,GeneralUtilities.FILEPATH,"loginPageData");
			loginpage = new LoginPage(driver);
			loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnsignInButton();
			adminuserspage= new AdminUsersPage(driver);
			adminuserspage.clickOnAdminUsersMoreInfo().clickOnNewButtonInAdminUsersPage().enterUserNameInNewAdminUsersPage(usernameInput).enterpasswordInNewAdminUsersPage(PasswordInput);
			String actualSearchValue=adminuserspage.searchNewUseraddedIsUpdatedInAdminUsersTable(expectedsearchvalue);
			assertEquals(actualSearchValue,expectedsearchvalue,"New admin user cannot be added ");
		}
		@Test(retryAnalyzer = Retry.class)
		@Parameters({ "usernameInput", "PasswordInput" })
		public void toCheckNewAdminUserAddedIsAvailableInAdminUsersTableByClickingSearchButton(String usernameInput,String PasswordInput)  
		{
			
			String expectedsearchvalue=ExcelUtility.getString(1,0,GeneralUtilities.FILEPATH,"loginPageData");
			loginpage = new LoginPage(driver);
			loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnsignInButton();
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
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		

