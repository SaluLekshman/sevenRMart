package com.sevenRMartSuperMarketTest;

import static org.testng.Assert.assertTrue;

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
		private boolean vegProductTypeElementIsEnabled;
		
		@Test(groups = {"regression" })
		@Parameters({"usernameInput","PasswordInput"})
		public void manageProducts(String usernameInput,String PasswordInput) throws IOException 
		{
			
		    String inputMainMenu=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"hamBurgerMenuData");
		    String inputTitleText=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageProductData");
		    String inputCategory=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageProductData");
			manageproductpage=new ManageProductsPage(driver);
			loginpage=new Verify_LoginPage(driver);
			loginpage.userNameElement(usernameInput);
			loginpage.passwordElement(PasswordInput);
			loginpage.signInElement();
			manageproductpage.clickOnmanageaproductElement();
			hamburgermenupage=new HamburgerMenuPage(driver);
			hamburgermenupage.selectMenu(inputMainMenu);
			boolean isDisplayedListproduct=manageproductpage.isdisplayedlistProductElement();
			assertTrue(isDisplayedListproduct,"The List Prodcut is not displyed");
			manageproductpage.clickOnnewElement();
			manageproductpage.EnterTitleElement(inputTitleText);
			boolean vegProductTypeElemenIsEnabled=manageproductpage.vegProductTypeElementIsEnabled();
			assertTrue(vegProductTypeElemenIsEnabled,"The veg prodct type is enabled");
			manageproductpage.clickNonVegProductTypeElement();
			manageproductpage.EntercategoryElement(inputCategory);
			
			
			
		}
}
