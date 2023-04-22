package com.sevenRMartSuperMarketTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.ManageOfferCodePage;
import com.sevenRMartSuperMarketPages.LoginPage;

import Utilities.ExcelUtility;

public class ManageOfferCodeTest extends Base {
	HamburgerMenuPage hamburgermenupage;
	ManageOfferCodePage manageoffercodepage;
	LoginPage loginpage;
	
	@Test(groups = {"regression" })
	@Parameters({"usernameInput","PasswordInput"})
	public void manageoffercode(String usernameInput,String PasswordInput) throws IOException 
	{
	    String inputMainMenu=ExcelUtility.getString(0,5,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"hamBurgerMenuData");
	    loginpage=new LoginPage(driver);
		loginpage.userNameElement(usernameInput);
		loginpage.passwordElement(PasswordInput);
		loginpage.signInElement();
		manageoffercodepage=new ManageOfferCodePage(driver);
		boolean isDisplayedmanageOfferCodeElement=manageoffercodepage.isDispalyedmanageOfferCodeElement();
		assertTrue(isDisplayedmanageOfferCodeElement,"The manage offerCode is not displayed");
		manageoffercodepage.clickOnmanageOfferCodeElement();
		hamburgermenupage=new HamburgerMenuPage(driver);
		hamburgermenupage.selectMenu(inputMainMenu);
	}
}
