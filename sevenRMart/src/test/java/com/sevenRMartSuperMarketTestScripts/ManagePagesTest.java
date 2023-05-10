package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sevenRMartSuperMarketPages.LoginPage;
import com.sevenRMartSuperMarketPages.ManagePagesPage;
import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;
import retry.Retry;


public class ManagePagesTest extends Base {
	
	ManagePagesPage  managepages;
	LoginPage loginpage;
	Retry retry;
	@Test(groups = {"regression" },retryAnalyzer = Retry.class)
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyPageIsPresentInListPagesTableByEnteringPageNameAndClickingSearchButton(String usernameInput,String PasswordInput) 
	{
	String enterTitleInput=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"managePagesData");
	loginpage=new LoginPage(driver);
    loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
    managepages=new ManagePagesPage(driver);
    managepages.clickOnMoreInfo();
    managepages.searchButtonOnManagePages();
	managepages.enterTitleInSearchListPages(enterTitleInput);
	managepages.searchButtonOnSearchListPagesInManagePages();
	String actualSearchResult=managepages.searchPagesInListPagesInManagePages(enterTitleInput);
	assertEquals(actualSearchResult,enterTitleInput,"The searched page  is not found");
	
	}
}
