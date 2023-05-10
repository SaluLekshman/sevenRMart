package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.ManageProductsPage;
import com.sevenRMartSuperMarketPages.LoginPage;
import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;
import retry.Retry;

public class ManageProductsTest extends Base
{
	
		HamburgerMenuPage hamburgermenupage;
		ManageProductsPage manageproductpage;
		LoginPage loginpage;
		@Test(groups = {"regression" },retryAnalyzer = Retry.class)
		@Parameters({"usernameInput","PasswordInput"})
		public void verifyRadioButtonsInAddProductTypePageIsEnabled(String usernameInput,String PasswordInput) 
		{
		    String inputMainMenu=ExcelUtility.getString(0,1,GeneralUtilities.FILEPATH,"hamBurgerMenuData");
			manageproductpage=new ManageProductsPage(driver);
			loginpage=new LoginPage(driver);
			loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
			manageproductpage.clickOnmanageaproduct();
			hamburgermenupage=new HamburgerMenuPage(driver);
			hamburgermenupage.selectMenu(inputMainMenu);
			manageproductpage.clickOnnew();
			boolean nonVegProductTypeRadioButtonIsEnabled=manageproductpage.nonVegProductTypeRadioButtonIsEnabled();
			manageproductpage.clickOnNonVegProductTypeRadioButton();
			boolean isEnabledpricetypeLitreRadioButton=manageproductpage.isEnabledpricetypeLitreRadioButton();
			manageproductpage.clickOnpricetypeLitreRadioButton();
			assertTrue(nonVegProductTypeRadioButtonIsEnabled,"The Non veg radio button  is  not enabled");
			assertTrue(isEnabledpricetypeLitreRadioButton,"The price type liter is not enabled");
			
		}
		@Test(groups = {"regression" },retryAnalyzer = Retry.class)
		@Parameters({"usernameInput","PasswordInput"})
		public void verifyRandomDataIsGeneratedForCategoryAndSubCategorydropDownButtonInAddProductInformationFormByClickingCategoryAndSubCategory(String usernameInput,String PasswordInput) 
		{
			
		    String inputMainMenu=ExcelUtility.getString(0,1,GeneralUtilities.FILEPATH,"hamBurgerMenuData");
		    String inputTitleText=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"manageProductData");
			manageproductpage=new ManageProductsPage(driver);
			loginpage=new LoginPage(driver);
			loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
			manageproductpage.clickOnmanageaproduct();
			hamburgermenupage=new HamburgerMenuPage(driver);
			hamburgermenupage.selectMenu(inputMainMenu);
			manageproductpage.clickOnnew();
			manageproductpage.EnterTitle(inputTitleText);
			boolean IsDisplayedFakerValueForCategory=manageproductpage.getRanadomdataValueForTextFieldCategory();
			boolean IsdisplayedFakerValueOfSubCategory=manageproductpage.getRanadomdataValueForTextFieldSubCategory();
			assertTrue(IsDisplayedFakerValueForCategory,"The random data for Category is not generated");
			assertTrue(IsdisplayedFakerValueOfSubCategory,"The randoma data for subCategory is not generated");
		
		}
}
