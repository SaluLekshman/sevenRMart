package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.ManageUsersPage;
import com.sevenRMartSuperMarketPages.LoginPage;
import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;
import retry.Retry;

public class ManageUsersTest extends Base
{
	HamburgerMenuPage hamburgermenupage;
    ManageUsersPage manageuserspage;
	LoginPage loginpage;
	@Test(retryAnalyzer = Retry.class)
	public void verifyManageUsersSearchButtonBackGroundColorIsBlue() 
	{
		  String usernameInput=ExcelUtility.getString(1,0,GeneralUtilities.FILEPATH,"loginPageData");
		  String PasswordInput=ExcelUtility.getString(1,1,GeneralUtilities.FILEPATH,"loginPageData");
		  String inputMainMenu=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"hamBurgerMenuData");
		  String expectedBackGroundColor=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"manageUsersData");
		  loginpage=new LoginPage(driver);
		  loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		  hamburgermenupage=new HamburgerMenuPage(driver);
		  hamburgermenupage.selectMenu(inputMainMenu);
		  manageuserspage=new ManageUsersPage(driver);
	      String actualBackgroundColor= manageuserspage.searchButtonElement();
	      assertEquals(actualBackgroundColor,expectedBackGroundColor,"The serach button background color is not blue");	
	}
	@Test(retryAnalyzer = Retry.class)
	public void verifyManageUsersPageResetButtonColorIsYellow() 
	{
		  String usernameInput=ExcelUtility.getString(1,0,GeneralUtilities.FILEPATH,"loginPageData");
		  String PasswordInput=ExcelUtility.getString(1,1,GeneralUtilities.FILEPATH,"loginPageData");
		  String inputMainMenu=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"hamBurgerMenuData");
		  String expectedBorderColor =ExcelUtility.getString(1,0,GeneralUtilities.FILEPATH,"manageUsersData");
		  loginpage=new LoginPage(driver);
		  loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		  hamburgermenupage=new HamburgerMenuPage(driver);
		  hamburgermenupage.selectMenu(inputMainMenu);
		  manageuserspage=new ManageUsersPage(driver);
		  String actualBorderColor= manageuserspage.resetButtonElement();
		  assertEquals(actualBorderColor,expectedBorderColor,"The Reset button  color is not Yellow");
	  
	}
	
	@Test(retryAnalyzer = Retry.class)
	public void VerifyUserIsAvailable_InListUsersTableByClickingSearchButtonAndEnteringValueInNameFieldAndClickSearchButtonInSearchListUsers()
	{
		  String usernameInput=ExcelUtility.getString(1,0,GeneralUtilities.FILEPATH,"loginPageData");
		  String PasswordInput=ExcelUtility.getString(1,1,GeneralUtilities.FILEPATH,"loginPageData");
		  String inputMainMenu=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"hamBurgerMenuData");
		  String expectedSearchUserValue=ExcelUtility.getString(0,1,GeneralUtilities.FILEPATH,"manageUsersData");
		  String enterTextOnNameValue=ExcelUtility.getString(0,1,GeneralUtilities.FILEPATH,"manageUsersData");
		  loginpage=new LoginPage(driver);
		  loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		  hamburgermenupage=new HamburgerMenuPage(driver);
		  hamburgermenupage.selectMenu(inputMainMenu);
		  manageuserspage=new ManageUsersPage(driver);
		  manageuserspage.clickOnlistUsersSearchButtonElement().enterTextOnNameElement(enterTextOnNameValue).ClickOnsearchUsersButtonElement();
		  String actualSearchUserResult=manageuserspage.searchUserInListUserTable(expectedSearchUserValue);
		  assertEquals(actualSearchUserResult,expectedSearchUserValue,"The searched user is not available in list user table");
		 
	}
}
