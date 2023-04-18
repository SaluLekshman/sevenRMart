package com.sevenRMartSuperMarketTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.ManagrUsersPage;
import com.sevenRMartSuperMarketPages.Verify_LoginPage;

import Utilities.ExcelUtility;

public class ManageUsersTest extends Base
{
	HamburgerMenuPage hamburgermenupage;
    ManagrUsersPage manageuserspage;
	Verify_LoginPage loginpage;
	@Test
	public void manageUsersSearchButtonBackGround() throws IOException
	{
		  String usernameInput=ExcelUtility.getString(1,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"loginData");
		  String PasswordInput=ExcelUtility.getString(1,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"loginData");
		  String inputMainMenu=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"hamBurgerMenuData");
		  String expectedBackGroundColor="rgba(0, 123, 255, 1)";
		  loginpage=new Verify_LoginPage(driver);
		  loginpage.userNameElement(usernameInput);
		  loginpage.passwordElement(PasswordInput);
		  loginpage.signInElement();
		  hamburgermenupage=new HamburgerMenuPage(driver);
		  hamburgermenupage.selectMenu(inputMainMenu);
		  manageuserspage=new ManagrUsersPage(driver);
	      String actualBackgroundColor= manageuserspage.searchButtonElement();
	      assertEquals(actualBackgroundColor,expectedBackGroundColor,"The background color is not"+expectedBackGroundColor);
	     
		
	}
	@Test
	public void manageUsersResetButtonBorderColor() throws IOException
	{
		  String usernameInput=ExcelUtility.getString(1,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"loginData");
		  String PasswordInput=ExcelUtility.getString(1,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"loginData");
		  String ExpectedBorderColor="rgb(255, 193, 7)";
		  loginpage=new Verify_LoginPage(driver);
		  loginpage.userNameElement(usernameInput);
		  loginpage.passwordElement(PasswordInput);
		  loginpage.signInElement();
		  driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/list-user");
		  manageuserspage=new ManagrUsersPage(driver);
		  String actualBorderColor= manageuserspage.resetButtonElement();
		  assertEquals(actualBorderColor,ExpectedBorderColor,"The border color is not blue");
		  
	}
}
