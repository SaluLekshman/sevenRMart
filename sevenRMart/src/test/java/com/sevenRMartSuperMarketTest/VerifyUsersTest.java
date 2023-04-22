package com.sevenRMartSuperMarketTest;


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

public class VerifyUsersTest extends Base {
	HamburgerMenuPage hamburgermenupage;
	VerifyUsersPage  verifyuserpage;
	LoginPage loginpage;
	@Test(retryAnalyzer = Retry.class)
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyUsers(String usernameInput,String PasswordInput) throws IOException
	{
		String inputMainMenu=ExcelUtility.getString(0,2,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"hamBurgerMenuData");
	    String enterNameValue=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"listUsersData");
	    String expectedSearchResultNotFound=ExcelUtility.getString(1,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"listUsersData");
	    String expectedSearchResult=ExcelUtility.getString(1,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"listUsersData");
		loginpage=new LoginPage(driver);
	    loginpage.userNameElement(usernameInput).passwordElement(PasswordInput).signInElement();
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

