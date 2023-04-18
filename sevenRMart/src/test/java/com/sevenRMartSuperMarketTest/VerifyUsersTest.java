package com.sevenRMartSuperMarketTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.VerifyUsersPage;
import com.sevenRMartSuperMarketPages.Verify_LoginPage;

import Utilities.ExcelUtility;

public class VerifyUsersTest extends Base {
	HamburgerMenuPage hamburgermenupage;
	VerifyUsersPage  verifyuserpage;
	Verify_LoginPage loginpage;
	@Test
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyUsers(String usernameInput,String PasswordInput) throws IOException
	{
		String inputMainMenu=ExcelUtility.getString(0,2,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"hamBurgerMenuData");
	    String enterNameValue=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"listUsersData");
	    String expectedSearchResult=ExcelUtility.getString(1,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"listUsersData");
		loginpage=new Verify_LoginPage(driver);
	    loginpage.userNameElement(usernameInput);
		loginpage.passwordElement(PasswordInput);
		loginpage.signInElement();
		verifyuserpage=new VerifyUsersPage(driver);
		boolean verifyUserElementIsEnabled=verifyuserpage.verifyUserElementIsEnabled();
		assertTrue(verifyUserElementIsEnabled,"verify users button is not enabled");
		verifyuserpage.clickOnverifyUserElement();
		hamburgermenupage=new HamburgerMenuPage(driver);
		hamburgermenupage.selectMenu(inputMainMenu);
		boolean verifyUsersSearchButtonElementIsDisplayed=verifyuserpage.verifyUsersSearchButtonElementIsDisplayed();
		assertTrue(verifyUsersSearchButtonElementIsDisplayed,"The verify userd search button is not displayed");
		VerifyUsersPage.clickOnVerifyUsersSearchButtonElement();
		VerifyUsersPage.enterNameElement(enterNameValue);
		boolean searchListUsersSearchButtonElementIsenabled=verifyuserpage.searchListUsersSearchButtonElementIsenabled();
        VerifyUsersPage.clickOnsearchListUsersSearchButtonElement();
        String actualSearchResult=verifyuserpage.searchListUsersSearchResultElement();
        
		
	}
}