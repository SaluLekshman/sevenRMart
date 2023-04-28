package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.ManageProductsPage;
import com.sevenRMartSuperMarketPages.LoginPage;
import Utilities.ExcelUtility;
import retry.Retry;

public class ManageProductsTest extends Base{
	
		HamburgerMenuPage hamburgermenupage;
		ManageProductsPage manageproductpage;
		LoginPage loginpage;
		Retry retry;
		@Test(groups = {"regression" })
		@Parameters({"usernameInput","PasswordInput"})
		public void manageProductsAddProductTypeRadioButton(String usernameInput,String PasswordInput) throws IOException 
		{
			
		    String inputMainMenu=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"hamBurgerMenuData");
		    String inputTitleText=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageProductData");
		    String inputCategory=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageProductData");
			manageproductpage=new ManageProductsPage(driver);
			loginpage=new LoginPage(driver);
			loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
			manageproductpage.clickOnmanageaproductElement();
			hamburgermenupage=new HamburgerMenuPage(driver);
			hamburgermenupage.selectMenu(inputMainMenu);
			manageproductpage.clickOnnewElement();
			manageproductpage.EnterTitleElement(inputTitleText);
			boolean nonVegProductTypeElemenIsEnabled=manageproductpage.nonVegProductTypeElementIsEnabled();
			manageproductpage.clickNonVegProductTypeElement();
			boolean isEnabledpricetypeLitreRadioButton=manageproductpage.isEnabledpricetypeLitreRadioButtonElement();
			manageproductpage.clickOnpricetypeLitreRadioButtonElement();
			assertTrue(nonVegProductTypeElemenIsEnabled,"The Non veg radio button  is  not enabled");
			assertTrue(isEnabledpricetypeLitreRadioButton,"The price type liter is not enabled");
			
		}
		@Test(groups = {"regression" },retryAnalyzer = Retry.class)
		@Parameters({"usernameInput","PasswordInput"})
		public void manageProductsfaker(String usernameInput,String PasswordInput) throws IOException 
		{
			
		    String inputMainMenu=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"hamBurgerMenuData");
		    String inputTitleText=ExcelUtility.getString(0,0,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageProductData");
		    String inputCategory=ExcelUtility.getString(0,1,System.getProperty("user.dir")+constants.Constants.TESTDATAFILE,"manageProductData");
			manageproductpage=new ManageProductsPage(driver);
			loginpage=new LoginPage(driver);
			loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
			manageproductpage.clickOnmanageaproductElement();
			hamburgermenupage=new HamburgerMenuPage(driver);
			hamburgermenupage.selectMenu(inputMainMenu);
			manageproductpage.clickOnnewElement();
			manageproductpage.EnterTitleElement(inputTitleText);
			manageproductpage.categoryElementFaker();
			manageproductpage.subCategoryElementFaker();
		
		}
}
