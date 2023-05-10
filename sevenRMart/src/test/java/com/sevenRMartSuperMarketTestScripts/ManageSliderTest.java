package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.LoginPage;
import com.sevenRMartSuperMarketPages.ManageSliderPage;
import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;
import retry.Retry;

public class ManageSliderTest extends Base {
	HamburgerMenuPage hamburgermenupage;
	ManageSliderPage manageSliderPage;
	LoginPage loginpage;
	@Test(retryAnalyzer = Retry.class)
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyAnalertMessageIsDisplayedByClickingNewButton_AndUploadImageByClickingChooseImageButton_AndEnterLinkInLinkField_AndClickSaveButton(String usernameInput,String PasswordInput ) throws IOException 
	{
		String link=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"manageSliderPageData");
		loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		manageSliderPage=new ManageSliderPage (driver);
		manageSliderPage.clickOnMoreInfo();
		manageSliderPage.clickOnNewButton();
		manageSliderPage.imageChoseFile();
		manageSliderPage.enterTheLink(link);
		manageSliderPage.clickOnSaveButton();
		boolean isNewSliderCreatedSuccessfully=manageSliderPage. isNewSliderCreatedSuccessfully();
		assertTrue( isNewSliderCreatedSuccessfully,"An alert message not displayed");
	}
	@Test(retryAnalyzer = Retry.class)
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyNewSlideraddedIsDispalyedInListSliderTableByFetchingLinkFromListSlidersTableAndCompareWithExpectedLinkValue(String usernameInput,String PasswordInput ) 
	{
		String expectedLink=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"manageSliderPageData");
		loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		manageSliderPage=new ManageSliderPage (driver);
		manageSliderPage.clickOnMoreInfo();
		String actualLink=manageSliderPage.listSliderTable(expectedLink);
		assertEquals(actualLink,expectedLink,"New slider added is not displayed in list slider table");
	}
	@Test(retryAnalyzer = Retry.class)
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyAnAlertMessageIsDisplayedByClickingDeleteButtonInListSlidersTable(String usernameInput,String PasswordInput ) throws IOException
	{
		loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		manageSliderPage=new ManageSliderPage (driver);
		manageSliderPage.clickOnMoreInfo();
		manageSliderPage.clickOnDeleteSliderInListSliderTable();
	    boolean isDispalyedAlertMessage=manageSliderPage.alertMessageIsDisplayed();
		assertTrue(isDispalyedAlertMessage,"An alert message is not displayed by clicking delete button");
	}

}
