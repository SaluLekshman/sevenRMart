package com.sevenRMartSuperMarketTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.PushNotificationPage;
import com.sevenRMartSuperMarketPages.LoginPage;

import Utilities.ExcelUtility;

public class PushNotificationsTest extends Base {
	HamburgerMenuPage hamburgermenupage;
	PushNotificationPage pushnotificationpage;
	LoginPage loginpage;
	
	
	@Test(retryAnalyzer = Retry.class)
	@Parameters({"usernameInput","PasswordInput"})
	public void pushNotifications(String usernameInput,String PasswordInput) throws IOException 
	{
		String inputMainMenu=ExcelUtility.getString(0,3,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"hamBurgerMenuData");
	    String titleInput=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"pushNotificationInformation");
	    String descriptionInput=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"pushNotificationInformation");
		loginpage=new LoginPage(driver);
	    loginpage.userNameElement(usernameInput).passwordElement(PasswordInput).signInElement();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.ClickOnpushNotificationelement();
		hamburgermenupage=new HamburgerMenuPage(driver);
		hamburgermenupage.selectMenu(inputMainMenu);
		pushnotificationpage.enterTitleElement(titleInput).descriptionElement(descriptionInput).clickOnsendElement();
		String actualAlertMessageText=pushnotificationpage.getTextalertMessageElement();
		boolean actualAlertMessageIsDisplayed=pushnotificationpage.alertMessageElementIsDisplayed();
		assertTrue(actualAlertMessageIsDisplayed,"The alert message is not displayed");	
	}
}
