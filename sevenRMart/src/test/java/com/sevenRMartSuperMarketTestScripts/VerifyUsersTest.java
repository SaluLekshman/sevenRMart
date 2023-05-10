package com.sevenRMartSuperMarketTestScripts;


import static org.testng.Assert.assertEquals;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sevenRMartSuperMarketPages.HamburgerMenuPage;
import com.sevenRMartSuperMarketPages.VerifyUsersPage;
import com.sevenRMartSuperMarketPages.LoginPage;
import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;
import retry.Retry;

public class VerifyUsersTest extends Base {
	HamburgerMenuPage hamburgermenupage;
	VerifyUsersPage  verifyuserpage;
	LoginPage loginpage;
	@Test(retryAnalyzer = Retry.class)
	@Parameters({"usernameInput","PasswordInput"})
	public void verifyUserIsAvailableInListUsersTableByClickingSearchButtonAndEnteringValueInNameField(String usernameInput,String PasswordInput)
	{
		String inputMainMenu=ExcelUtility.getString(0,2,GeneralUtilities.FILEPATH,"hamBurgerMenuData");
	    String enterNameValue=ExcelUtility.getString(0,0,GeneralUtilities.FILEPATH,"listUsersData");
	    String expectedSearchResult=ExcelUtility.getString(1,0,GeneralUtilities.FILEPATH,"listUsersData");
		loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		verifyuserpage=new VerifyUsersPage(driver);
		verifyuserpage.clickOnverifyUser();
		hamburgermenupage=new HamburgerMenuPage(driver);
		hamburgermenupage.selectMenu(inputMainMenu);
		verifyuserpage.clickOnVerifyUsersSearchButton();
		verifyuserpage.enterTextInTextFieldName(enterNameValue);
        verifyuserpage.clickOnsearchButtonInSearchListUsers();
        String actualSearchResult=verifyuserpage.getText_SearchResultOfVerifyUsersSearch();
        assertEquals(actualSearchResult,expectedSearchResult,"The searched user is not in the table");
	}
}

