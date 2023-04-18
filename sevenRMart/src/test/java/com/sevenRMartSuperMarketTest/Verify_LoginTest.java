package com.sevenRMartSuperMarketTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.Verify_LoginPage;



public class Verify_LoginTest extends Base {
	Verify_LoginPage verifyloginpage;
	@Test(dataProvider="LoginProvider")
	public void loginWithValidCredentials(String usernameInput,String PasswordInput) throws IOException
	{
		 verifyloginpage=new Verify_LoginPage(driver);
		 verifyloginpage.userNameElement(usernameInput);
		 verifyloginpage.passwordElement(PasswordInput);
		 verifyloginpage.rememberMeElement();
		 boolean isSignInButtonEnabled=verifyloginpage.signInButtonIsEnabled();
		 assertTrue(isSignInButtonEnabled,"Signin button is enabled");
		 verifyloginpage.signInElement();
	}

	@DataProvider(name="LoginProvider")
    public Object[][] getDataFromDataprovider() throws IOException
	{
    return new Object[][] 
    	{
             {"admin","admin"},
             {"admin","admin123"},
             {"admin1","admin"},
             {"Admin","adminnew"}
            
    	};
	}
	
}
