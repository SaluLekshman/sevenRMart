package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.LoginPage;
import com.sevenRMartSuperMarketPages.ManageOrdersPage;

import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;
import retry.Retry;

public class ManageOrdersTest extends Base {

	HamburgerMenuPage hamburgermenupage;
	ManageOrdersPage manageorderspage;
	LoginPage loginpage;
	Retry retry;

	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "usernameInput", "PasswordInput" })
	public void verifyStatusOfIOrderIsUpdatedByClickingChangeStatusInListOrderSTableAndSelectStausFromDropdownButtonThenClickUpdate(String usernameInput,String PasswordInput)
	{
		String statusInput=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"manageOrdersPageData");
		loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnsignInButton();
		manageorderspage = new ManageOrdersPage(driver);
		manageorderspage.clickOnMoreInfo().clickOnChangeStatus().clickOnUpdateStatus();
		manageorderspage.clickOnChangeDeliveryStausUpdateButton();
		String actualStatusValue=manageorderspage.searchInListOrderTable(statusInput);
		assertEquals(actualStatusValue,statusInput,"change status is not updated in list orderTable");
	}
	@Test
	@Parameters({ "usernameInput", "PasswordInput" })
	public void verifydeliveryBoyForEveryOrderIsUpdatedInListOrderTableByClickingAssignDeliveryBoyAndSelectDeliverBoYfromDropDownButtonThenClickUpdate(String usernameInput,String PasswordInput)  
	{
		String assignDeliverBoyInput=ExcelUtility.getString(0,1,GeneralUtilities.FILEPATH,"manageOrdersPageData");
		loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnsignInButton();
		manageorderspage = new ManageOrdersPage(driver);
		manageorderspage.clickOnMoreInfo().clickOnAssignDeliveryBoy().clickOnSelectDeliverBoyFromDropDown().closeAlertMessageButton();
		String actualDeliveryBoy=manageorderspage.searchInListOrderTable(assignDeliverBoyInput);
		assertEquals(actualDeliveryBoy,assignDeliverBoyInput,"delivery boy name is not Updated  in list order table");
	}
	@Test
	@Parameters({ "usernameInput", "PasswordInput" })
	public void verifyUsersCanViewOrderDetailsByClickingViewButtonInListOrdersTable(String usernameInput,String PasswordInput)
	{
		loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword( PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		manageorderspage = new ManageOrdersPage(driver);
		manageorderspage.clickOnMoreInfo().clickOnViewButtonInManageOrdersPageListOrdersTable();
		boolean isAbleToViewOrderDetails= manageorderspage.isAbleToViewOrderDetailsInManageOrdersPage();
		assertTrue(isAbleToViewOrderDetails,"Users Cannnot View OrderDetails In Manage Orders Page By Clicking View In ListOrdersTable");
	}
	@Test
	@Parameters({ "usernameInput", "PasswordInput" })
	public void verifyUsersGetAnAlertMessageByClickingDeleteButtonInListOrderTable(String usernameInput,String PasswordInput)  
	{
		String getTextOfAlertMessage=ExcelUtility.getString(1,0,GeneralUtilities.FILEPATH,"manageOrdersPageData");
		loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword( PasswordInput).clickOnsignInButton();
		manageorderspage = new ManageOrdersPage(driver);
		manageorderspage.clickOnMoreInfo();
		String getText=manageorderspage.ClickOndeleteButtonOrderDetailsInListOrderTable();
		assertEquals(getText,getTextOfAlertMessage,"unable to delete Order details from list orders Table");
		
}
	}
