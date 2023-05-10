package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sevenRMartSuperMarketPages.SiteNamePage;
import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;
import retry.Retry;

import com.sevenRMartSuperMarketPages.LoginPage;


public class SiteNameTest extends Base
{
	LoginPage loginpage;
	SiteNamePage sitenamepage;
	@Test(retryAnalyzer = Retry.class)
	@Parameters({"usernameInput","PasswordInput"})
	public void verifySiteNameIsDisplayedCorrectlyInHomePageByFetchingTextOfSiteName(String usernameInput,String PasswordInput) 
	{
		String expectedSiteName=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"siteNameData");
		loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		sitenamepage=new SiteNamePage(driver);
		boolean siteNameIsdisplyed=sitenamepage.verifySiteNameIsDisplayed();
		String actualSiteName=sitenamepage.getTextOfsiteName();
		assertTrue(siteNameIsdisplyed,"The site name is not displayed");
		assertEquals(actualSiteName,expectedSiteName,"The site name displayed is not as expected");
	}
	@Test(retryAnalyzer = Retry.class)
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyTheFontColorOfsiteNameIsWhite(String usernameInput,String PasswordInput) 
	{
		String expectedSiteNameColor=ExcelUtility.getString(1,0,GeneralUtilities.FILEPATH,"siteNameData");
		loginpage=new LoginPage(driver);
		sitenamepage=new SiteNamePage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		String actualSiteNameColor=sitenamepage.getColorOfSiteName();
		assertEquals(actualSiteNameColor,expectedSiteNameColor,"The font color of site name  is not white");
	}
		
}
