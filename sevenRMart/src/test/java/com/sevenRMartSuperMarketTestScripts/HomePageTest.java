package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sevenRMartSuperMarketPages.HomePagePage;
import com.sevenRMartSuperMarketPages.LoginPage;

import Utilities.ExcelUtility;
import retry.Retry;

public class HomePageTest extends Base {
	
	 HomePagePage  homepagepage ;
	 LoginPage loginpage;
	 Retry retry;

	@Test
	@Parameters({ "usernameInput", "PasswordInput" })
	public void getStylePropertyColorOfMoreInfoInHomePage(String usernameInput,String PasswordInput) 
	{
		String expectedstylePropertyOfMoreInfo=ExcelUtility.getString(0,0,constants.Constants.TESTDATAFILEPATH,"homePageData");
		loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
		homepagepage= new  HomePagePage(driver);
		String actualstylePropertyOfMoreInfo=homepagepage.getStyleProperties();
		assertEquals(actualstylePropertyOfMoreInfo,expectedstylePropertyOfMoreInfo,"Style property is not matching");
		
    }
}
