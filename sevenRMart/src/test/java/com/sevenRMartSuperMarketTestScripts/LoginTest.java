package com.sevenRMartSuperMarketTestScripts;


import static org.testng.Assert.assertTrue;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sevenRMartSuperMarketPages.LoginPage;

import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;
import retry.Retry;

public class LoginTest extends Base 
{
	LoginPage loginpage;
	@Test(priority=1,retryAnalyzer = Retry.class)
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyUserCanloginByEnteringValidCredentialsAndCLickSignInButton(String usernameInput,String PasswordInput)
	{  
		 loginpage=new LoginPage(driver);
		 loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		 boolean IsSiteNameDiplayed=loginpage.verifySiteNameIsDisplayed();
		 assertTrue(IsSiteNameDiplayed,"The logged in fails with valid usernmae and password");
	}
	
	@Test(priority=2,dataProvider="LoginProvider")
	public void VerifyAnAlertMessageIsShownByEnteringInValidCredentialsAndClickSignInButton(String usernameInput,String PasswordInput)
	{
		 loginpage=new LoginPage(driver);
		 loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		 boolean isDispalyedalertMessage=loginpage.verifyAlertMessageIsDisplayed();
		 assertTrue(isDispalyedalertMessage,"The an alert message is not displayed"); 
	}

	@DataProvider(name="LoginProvider")
    public Object[][] getDataFromDataprovider()
	{
    return new Object[][] 
    	{
    		{"admin","Admin"},
    		{"admin1","admin"}, 
    		{"Admin","adminnew"} 
    	};
	}
	
}
