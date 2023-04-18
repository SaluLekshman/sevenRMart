package com.sevenRMartSuperMarketTest;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.ManagePayMentMethodsPage;
import com.sevenRMartSuperMarketPages.Verify_LoginPage;

import Utilities.ExcelUtility;

public class ManagePaymentMethodsTest extends Base {
	HamburgerMenuPage hamburgermenupage;
	ManagePayMentMethodsPage managepaymentmethodpage;
	Verify_LoginPage loginpage;
	
	@Test(groups = {"regression" })
	@Parameters({"usernameInput","PasswordInput"})
	public void managePayment(String usernameInput,String PasswordInput) throws IOException 
	{
	    String inputMainMenu=ExcelUtility.getString(0,4,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"hamBurgerMenuData");
	    loginpage=new Verify_LoginPage(driver);
		loginpage.userNameElement(usernameInput);
		loginpage.passwordElement(PasswordInput);
		loginpage.signInElement();
		managepaymentmethodpage=new ManagePayMentMethodsPage(driver);
		boolean IsDisplayedManagePaymentmethodsElement=managepaymentmethodpage.IsDispalyedmanagePaymentmethodsElement();
		managepaymentmethodpage.clickOnmanagePaymentmethodsElement();
		hamburgermenupage=new HamburgerMenuPage(driver);
		hamburgermenupage.selectMenu(inputMainMenu);
		managepaymentmethodpage.clickOnmanagePaymentmethodsPageHomeButton();
		
	}
}
