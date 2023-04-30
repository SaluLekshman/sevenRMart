package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.SiteNamePage;

import Utilities.ExcelUtility;

import com.sevenRMartSuperMarketPages.LoginPage;


public class SiteNameTest extends Base
{
	LoginPage loginpage;
	SiteNamePage sitenamepage;
	@Test
	@Parameters({"usernameInput","PasswordInput"})
	public void verifySiteNameIsDisplayedCorrectly(String usernameInput,String PasswordInput)
	{
		String expectedSiteName=ExcelUtility.getString(0,0,constants.Constants.TESTDATAFILEPATH,"siteNameData");
		loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
		sitenamepage=new SiteNamePage(driver);
		boolean siteNameIsdisplyed=sitenamepage.siteNameIsDisplayed();
		String actualSiteName=sitenamepage.siteNameGetText();
		assertTrue(siteNameIsdisplyed,"The site name is not displayed");
		assertEquals(actualSiteName,expectedSiteName,"The site name displayed is not as expected");
	}
	@Test
	@Parameters({"usernameInput","PasswordInput"})
	public void getFontsizeOfsiteName(String usernameInput,String PasswordInput) throws IOException
	{
		String expectedSiteNameColor=ExcelUtility.getString(1,0,constants.Constants.TESTDATAFILEPATH,"siteNameData");
		loginpage=new LoginPage(driver);
		sitenamepage=new SiteNamePage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
		String actualSiteNameColor=sitenamepage.getColorOfSiteName();
		assertEquals(actualSiteNameColor,expectedSiteNameColor,"The site name color is not white");
	}
		
}
