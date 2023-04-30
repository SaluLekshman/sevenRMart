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

public class ManageProductsTest extends Base
{
	
		HamburgerMenuPage hamburgermenupage;
		ManageProductsPage manageproductpage;
		LoginPage loginpage;
		Retry retry;
		@Test(groups = {"regression" })
		@Parameters({"usernameInput","PasswordInput"})
		public void VerifyManageProducts_AddProductTypeRadioButtons(String usernameInput,String PasswordInput) 
		{
			
		    String inputMainMenu=ExcelUtility.getString(0,1,constants.Constants.TESTDATAFILEPATH,"hamBurgerMenuData");
		    String inputTitleText=ExcelUtility.getString(0,0,constants.Constants.TESTDATAFILEPATH,"manageProductData");
			manageproductpage=new ManageProductsPage(driver);
			loginpage=new LoginPage(driver);
			loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
			manageproductpage.clickOnmanageaproduct();
			hamburgermenupage=new HamburgerMenuPage(driver);
			hamburgermenupage.selectMenu(inputMainMenu);
			manageproductpage.clickOnnew();
			manageproductpage.EnterTitle(inputTitleText);
			boolean nonVegProductTypeElemenIsEnabled=manageproductpage.nonVegProductTypeIsEnabled();
			manageproductpage.clickNonVegProductType();
			boolean isEnabledpricetypeLitreRadioButton=manageproductpage.isEnabledpricetypeLitreRadioButton();
			manageproductpage.clickOnpricetypeLitreRadioButton();
			assertTrue(nonVegProductTypeElemenIsEnabled,"The Non veg radio button  is  not enabled");
			assertTrue(isEnabledpricetypeLitreRadioButton,"The price type liter is not enabled");
			
		}
		@Test(groups = {"regression" })
		@Parameters({"usernameInput","PasswordInput"})
		public void manageProductsfaker(String usernameInput,String PasswordInput)
		{
			
		    String inputMainMenu=ExcelUtility.getString(0,1,constants.Constants.TESTDATAFILEPATH,"hamBurgerMenuData");
		    String inputTitleText=ExcelUtility.getString(0,0,constants.Constants.TESTDATAFILEPATH,"manageProductData");
			manageproductpage=new ManageProductsPage(driver);
			loginpage=new LoginPage(driver);
			loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clicksignIn();
			manageproductpage.clickOnmanageaproduct();
			hamburgermenupage=new HamburgerMenuPage(driver);
			hamburgermenupage.selectMenu(inputMainMenu);
			manageproductpage.clickOnnew();
			manageproductpage.EnterTitle(inputTitleText);
			manageproductpage.categoryElementFaker();
			boolean IsdisplayedFakerValueOfSubCategory=manageproductpage.subCategoryFaker();
			assertTrue(IsdisplayedFakerValueOfSubCategory,"The faker value of sub Category is not displayed");
		
		}
}
