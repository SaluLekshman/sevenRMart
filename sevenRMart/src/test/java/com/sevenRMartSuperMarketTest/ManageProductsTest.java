package com.sevenRMartSuperMarketTest;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.ManageProductsPage;
import com.sevenRMartSuperMarketPages.Verify_LoginPage;

import Utilities.ExcelUtility;

public class ManageProductsTest extends Base{
	
		HamburgerMenuPage hamburgermenupage;
		ManageProductsPage manageproductpage;
		Verify_LoginPage loginpage;
		
		@Test(groups = {"regression" })
		@Parameters({"usernameInput","PasswordInput"})
		public void manageProducts(String usernameInput,String PasswordInput) throws IOException 
		{
		    String inputMainMenu=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"hamBurgerMenuData");
			manageproductpage=new ManageProductsPage(driver);
			loginpage=new Verify_LoginPage(driver);
			loginpage.userNameElement(usernameInput);
			loginpage.passwordElement(PasswordInput);
			loginpage.signInElement();
			manageproductpage.clickOnmanageaproductElement();
			hamburgermenupage=new HamburgerMenuPage(driver);
			hamburgermenupage.selectMenu(inputMainMenu);
			manageproductpage.clickOnnewElement();
			manageproductpage.EnterTitleElement();
			
			
			
			
			
			
		}
}
