package com.sevenRMartSuperMarketTestScripts;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.VerifyUsersPage;
import com.sevenRMartSuperMarketPages.LoginPage;

import Utilities.ExcelUtility;
import retry.Retry;

public class VerifyUsersTest extends Base {
	HamburgerMenuPage hamburgermenupage;
	VerifyUsersPage  verifyuserpage;
	LoginPage loginpage;
	Retry retry;
	@Test
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyUsers(String usernameInput,String PasswordInput)
	{
		String inputMainMenu=ExcelUtility.getString(0,2,constants.Constants.TESTDATAFILEPATH,"hamBurgerMenuData");
	    String enterNameValue=ExcelUtility.getString(0,0,constants.Constants.TESTDATAFILEPATH,"listUsersData");
	    String expectedSearchResultNotFound=ExcelUtility.getString(1,0,constants.Constants.TESTDATAFILEPATH,"listUsersData");
	    String expectedSearchResult=ExcelUtility.getString(1,1,constants.Constants.TESTDATAFILEPATH,"listUsersData");
		loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
		verifyuserpage=new VerifyUsersPage(driver);
		verifyuserpage.clickOnverifyUserElement();
		hamburgermenupage=new HamburgerMenuPage(driver);
		hamburgermenupage.selectMenu(inputMainMenu);
		verifyuserpage.clickOnVerifyUsersSearchButtonElement();
		verifyuserpage.enterNameElement(enterNameValue);
        verifyuserpage.clickOnsearchListUsersSearchButtonElement();
        String actualSearchResult=verifyuserpage.searchListUsersSearchResultGetTextElement();
        assertEquals(actualSearchResult,expectedSearchResultNotFound,"The search result is not correct");
	}
}

