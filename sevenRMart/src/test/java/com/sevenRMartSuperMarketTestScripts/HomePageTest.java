package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sevenRMartSuperMarketPages.HomePagePage;
import com.sevenRMartSuperMarketPages.LoginPage;

import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;
import retry.Retry;

public class HomePageTest extends Base {
	
	 HomePagePage  homepagepage ;
	 LoginPage loginpage;

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "usernameInput", "PasswordInput" })
	public void getStylePropertyColorOfMoreInfoInHomePage(String usernameInput,String PasswordInput) throws IOException 
	{
		String expectedstylePropertyOfMoreInfo=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"homePageData");
		loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnsignInButton();
		homepagepage= new  HomePagePage(driver);
		String actualstylePropertyOfMoreInfo=homepagepage.getStyleProperties();
		assertEquals(actualstylePropertyOfMoreInfo,expectedstylePropertyOfMoreInfo,"Style property is not matching");
		
    }
}
