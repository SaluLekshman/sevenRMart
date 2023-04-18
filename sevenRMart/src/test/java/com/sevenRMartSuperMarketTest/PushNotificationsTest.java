package com.sevenRMartSuperMarketTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.PushNotificationPage;
import com.sevenRMartSuperMarketPages.Verify_LoginPage;

import Utilities.ExcelUtility;

public class PushNotificationsTest extends Base {
	HamburgerMenuPage hamburgermenupage;
	PushNotificationPage pushnotificationpage;
	Verify_LoginPage loginpage;
	
	
	@Test
	@Parameters({"usernameInput","PasswordInput"})
	public void pushNotifications(String usernameInput,String PasswordInput) throws IOException 
	{
		String inputMainMenu=ExcelUtility.getString(0,3,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"hamBurgerMenuData");
		String expectedAlertMessage="×\r\n"
				+ "Alert!\r\n"
				+ "Message send successfully";
		loginpage=new Verify_LoginPage(driver);
	    loginpage.userNameElement(usernameInput);
		loginpage.passwordElement(PasswordInput);
		loginpage.signInElement();
		pushnotificationpage=new PushNotificationPage( driver);
		pushnotificationpage.ClickOnpushNotificationelement();
		hamburgermenupage=new HamburgerMenuPage(driver);
		hamburgermenupage.selectMenu(inputMainMenu);
		//driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/list-notifications");
		pushnotificationpage.enterTitleElement();
		pushnotificationpage.descriptionElement();
		pushnotificationpage.sendElement();
		String actualAlertMessageText=pushnotificationpage.getTextalertMessageElement();
		boolean actualAlertMessageIsDisplayed=pushnotificationpage.alertMessageElementIsDisplayed();
		//assertEquals(actualAlertMessageText,expectedAlertMessage,"The alert message  send is incorrect ");
		assertTrue(actualAlertMessageIsDisplayed,"The alert message is not displayed");
		
		
		
	}
}
