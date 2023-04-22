package com.sevenRMartSuperMarketTest;

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
	public void manageUsersSearchButtonBackGround() throws IOException
	{
		  String usernameInput=ExcelUtility.getString(1,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"loginPageData");
		  String PasswordInput=ExcelUtility.getString(1,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"loginPageData");
		  String inputMainMenu=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"hamBurgerMenuData");
		  String expectedBackGroundColor=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageUsersData");
		  loginpage=new LoginPage(driver);
		  loginpage.userNameElement(usernameInput);
		  loginpage.passwordElement(PasswordInput);
		  loginpage.signInElement();
		  hamburgermenupage=new HamburgerMenuPage(driver);
		  hamburgermenupage.selectMenu(inputMainMenu);
		  manageuserspage=new ManageUsersPage(driver);
	      String actualBackgroundColor= manageuserspage.searchButtonElement();
	      assertEquals(actualBackgroundColor,expectedBackGroundColor,"The background color is not"+expectedBackGroundColor);
	     
		
	}
	@Test
	public void manageUsersResetButtonBorderColor() throws IOException
	{
		  String usernameInput=ExcelUtility.getString(1,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"loginPageData");
		  String PasswordInput=ExcelUtility.getString(1,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"loginPageData");
		  String inputMainMenu=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"hamBurgerMenuData");
		  String expectedBorderColor =ExcelUtility.getString(1,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageUsersData");
		  loginpage=new LoginPage(driver);
		  loginpage.userNameElement(usernameInput);
		  loginpage.passwordElement(PasswordInput);
		  loginpage.signInElement();
		  hamburgermenupage=new HamburgerMenuPage(driver);
		  hamburgermenupage.selectMenu(inputMainMenu);
		  manageuserspage=new ManageUsersPage(driver);
		  String actualBorderColor= manageuserspage.resetButtonElement();
		  assertEquals(actualBorderColor,expectedBorderColor,"The border color is not blue");
		  
	}
	
	@Test
	public void searchUsersInManageUsers() throws IOException
	{
		  String usernameInput=ExcelUtility.getString(1,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"loginPageData");
		  String PasswordInput=ExcelUtility.getString(1,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"loginPageData");
		  String inputMainMenu=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"hamBurgerMenuData");
		  String expectedSearchValue=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageUsersData");
		  String enterTextOnNameValue=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageUsersData");
		  loginpage=new LoginPage(driver);
		  loginpage.userNameElement(usernameInput);
		  loginpage.passwordElement(PasswordInput);
		  loginpage.signInElement();
		  hamburgermenupage=new HamburgerMenuPage(driver);
		  hamburgermenupage.selectMenu(inputMainMenu);
		  manageuserspage=new ManageUsersPage(driver);
		  manageuserspage.clickOnlistUsersSearchButtonElement();
		  manageuserspage.enterTextOnNameElement(enterTextOnNameValue);
		  manageuserspage.ClickOnsearchUsersButtonElement();
		  manageuserspage.searchResultListUser(expectedSearchValue);
		  
	
		   
	}
}
