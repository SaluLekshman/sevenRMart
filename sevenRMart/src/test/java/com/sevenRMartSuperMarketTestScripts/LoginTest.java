package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.LoginPage;

import Utilities.ExcelUtility;
import retry.Retry;

public class LoginTest extends Base {
	LoginPage loginpage;
	@Test(priority=1)
	@Parameters({"usernameInput","PasswordInput"})
	public void loginWithValidCredentials(String usernameInput,String PasswordInput) throws IOException
	{
		 
		 String expectedUrl=ExcelUtility.getString(1,2,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"loginPageData");
		 loginpage=new LoginPage(driver);
		 Retry retry;
		 loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickRememberMe().clicksignIn();
		 String actualUrl=driver.getCurrentUrl();
		 assertEquals(actualUrl,expectedUrl,"The logged in fails");
		 
	}
	
	@Test(priority=2,dataProvider="LoginProvider")
	public void loginWithInValidCredentials(String usernameInput,String PasswordInput) throws IOException
	{
		 loginpage=new LoginPage(driver);
		 loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickRememberMe().clicksignIn();
		 boolean isDispalyedalertElement=loginpage.alertMessage();
		 assertTrue(isDispalyedalertElement,"The alert message is not displayed");
		 
	}

	@DataProvider(name="LoginProvider")
    public Object[][] getDataFromDataprovider() throws IOException
	{
    return new Object[][] 
    	{
             {"admin","admin123"}, 
             {"admin1","admin"}, 
             {"Admin","adminnew"} 
    	};
	}
	
}
