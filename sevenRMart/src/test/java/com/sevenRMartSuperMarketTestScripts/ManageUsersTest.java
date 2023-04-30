package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.ManageUsersPage;
import com.sevenRMartSuperMarketPages.LoginPage;

import Utilities.ExcelUtility;

public class ManageUsersTest extends Base
{
	HamburgerMenuPage hamburgermenupage;
    ManageUsersPage manageuserspage;
	LoginPage loginpage;
	@Test
	public void VerifyManageUsersSearchButtonBackGroundColor()
	{
		  String usernameInput=ExcelUtility.getString(1,0,constants.Constants.TESTDATAFILEPATH,"loginPageData");
		  String PasswordInput=ExcelUtility.getString(1,1,constants.Constants.TESTDATAFILEPATH,"loginPageData");
		  String inputMainMenu=ExcelUtility.getString(0,0,constants.Constants.TESTDATAFILEPATH,"hamBurgerMenuData");
		  String expectedBackGroundColor=ExcelUtility.getString(0,0,constants.Constants.TESTDATAFILEPATH,"manageUsersData");
		  loginpage=new LoginPage(driver);
		  loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
		  hamburgermenupage=new HamburgerMenuPage(driver);
		  hamburgermenupage.selectMenu(inputMainMenu);
		  manageuserspage=new ManageUsersPage(driver);
	      String actualBackgroundColor= manageuserspage.searchButtonElement();
	      assertEquals(actualBackgroundColor,expectedBackGroundColor,"The background color is not"+expectedBackGroundColor);
	     
		
	}
	@Test
	public void verifyManageUsersResetButtonBorderColor() 
	{
		  String usernameInput=ExcelUtility.getString(1,0,constants.Constants.TESTDATAFILEPATH,"loginPageData");
		  String PasswordInput=ExcelUtility.getString(1,1,constants.Constants.TESTDATAFILEPATH,"loginPageData");
		  String inputMainMenu=ExcelUtility.getString(0,0,constants.Constants.TESTDATAFILEPATH,"hamBurgerMenuData");
		  String expectedBorderColor =ExcelUtility.getString(1,0,constants.Constants.TESTDATAFILEPATH,"manageUsersData");
		  loginpage=new LoginPage(driver);
		  loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
		  hamburgermenupage=new HamburgerMenuPage(driver);
		  hamburgermenupage.selectMenu(inputMainMenu);
		  manageuserspage=new ManageUsersPage(driver);
		  String actualBorderColor= manageuserspage.resetButtonElement();
		  assertEquals(actualBorderColor,expectedBorderColor,"The border color is not blue");
		  
	}
	
	@Test
	public void VerifyUserIsAvailable_InListUsersTable_InManageUsersPage_ByClickingOnSearchButton() 
	{
		  String usernameInput=ExcelUtility.getString(1,0,constants.Constants.TESTDATAFILEPATH,"loginPageData");
		  String PasswordInput=ExcelUtility.getString(1,1,constants.Constants.TESTDATAFILEPATH,"loginPageData");
		  String inputMainMenu=ExcelUtility.getString(0,0,constants.Constants.TESTDATAFILEPATH,"hamBurgerMenuData");
		  String expectedSearchUserValue=ExcelUtility.getString(0,1,constants.Constants.TESTDATAFILEPATH,"manageUsersData");
		  String enterTextOnNameValue=ExcelUtility.getString(0,1,constants.Constants.TESTDATAFILEPATH,"manageUsersData");
		  loginpage=new LoginPage(driver);
		  loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
		  hamburgermenupage=new HamburgerMenuPage(driver);
		  hamburgermenupage.selectMenu(inputMainMenu);
		  manageuserspage=new ManageUsersPage(driver);
		  manageuserspage.clickOnlistUsersSearchButtonElement().enterTextOnNameElement(enterTextOnNameValue).ClickOnsearchUsersButtonElement();
		  String actualSearchUserResult=manageuserspage.searchResultListUser(expectedSearchUserValue);
		  assertEquals(actualSearchUserResult,expectedSearchUserValue,"The search result is not coorect");
		  
	
		   
	}
}
