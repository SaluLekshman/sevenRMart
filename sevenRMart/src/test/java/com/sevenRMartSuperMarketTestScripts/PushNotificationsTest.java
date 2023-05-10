package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.PushNotificationPage;
import com.sevenRMartSuperMarketPages.LoginPage;
import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;
import retry.Retry;

public class PushNotificationsTest extends Base
{
	HamburgerMenuPage hamburgermenupage;
	PushNotificationPage pushnotificationpage;
	LoginPage loginpage;
	@Test(retryAnalyzer = Retry.class)
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyAnAlertMessageIsDisplayed_ByEnteringTitleAndDescriptionAndClickSendButtonInPushNotiFicationPage(String usernameInput,String PasswordInput)  
	{
		String inputMainMenu=ExcelUtility.getString(0,3,GeneralUtilities.FILEPATH,"hamBurgerMenuData");
	    String titleInput=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"pushNotificationInformation");
	    String descriptionInput=ExcelUtility.getString(0,1,GeneralUtilities.FILEPATH,"pushNotificationInformation");
		loginpage=new LoginPage(driver);
	    loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		pushnotificationpage=new PushNotificationPage(driver);
		pushnotificationpage.ClickOnpushNotificationelement();
		hamburgermenupage=new HamburgerMenuPage(driver);
		hamburgermenupage.selectMenu(inputMainMenu);
		pushnotificationpage.enterValueOnTitleField(titleInput).enterValueOnDescriptionField(descriptionInput).clickSendbutton();
		boolean alertMessageIsDisplayed=pushnotificationpage.verifyAlertMessageIsDisplayed();
		assertTrue(alertMessageIsDisplayed,"The alert message is not displayed");	
	}
}
