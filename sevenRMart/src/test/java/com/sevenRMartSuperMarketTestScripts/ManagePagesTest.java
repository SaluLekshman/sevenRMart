package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sevenRMartSuperMarketPages.LoginPage;
import com.sevenRMartSuperMarketPages.ManagePagesPage;


import Utilities.ExcelUtility;
import retry.Retry;

public class ManagePagesTest extends Base {
	
	ManagePagesPage  managepages;
	LoginPage loginpage;
	Retry retry;
	@Test(groups = {"regression" })
	@Parameters({"usernameInput","PasswordInput"})
	public void serachPageIsPresentInListPagesTable(String usernameInput,String PasswordInput)
	{
	String enterTitleInput=ExcelUtility.getString(0,0,constants.Constants.TESTDATAFILEPATH,"managePagesData");
	loginpage=new LoginPage(driver);
    loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
    managepages=new ManagePagesPage(driver);
    managepages.clickOnMoreInfo();
    managepages.searchButtonOnManagePages();
	managepages.enterTitleInSearchListPages(enterTitleInput);
	managepages.searchButtonOnSearchListPagesInManagePages();
	String actualSearchResult=managepages.searchPagesInListPagesInManagePages(enterTitleInput);
	assertEquals(actualSearchResult,enterTitleInput,"The searched page  is not found");
	
	}
}
