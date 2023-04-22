package com.sevenRMartSuperMarketTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.SiteNamePage;
import com.sevenRMartSuperMarketPages.LoginPage;


public class SiteNameTest extends Base
{
	LoginPage loginpage;
	SiteNamePage sitenamepage;
	@Test
	@Parameters({"usernameInput","PasswordInput"})
	public void siteName(String usernameInput,String PasswordInput)
	{
		loginpage=new LoginPage(driver);
		sitenamepage=new SiteNamePage(driver);
		String expectedSiteName="7rmart supermarket";
	    loginpage.userNameElement(usernameInput);
		loginpage.passwordElement(PasswordInput);
		loginpage.signInElement();
		boolean siteNameIsdisplyed=sitenamepage.siteNameIsDisplayed();
		assertTrue(siteNameIsdisplyed,"The site name is not displayed");
		String actualSiteName=sitenamepage.siteNameGetText();
		assertEquals(actualSiteName,expectedSiteName,"The site name displayed is not as expected");
	}
}
