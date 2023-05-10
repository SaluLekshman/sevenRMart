package com.sevenRMartSuperMarketTestScripts;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sevenRMartSuperMarketPages.LoginPage;
import com.sevenRMartSuperMarketPages.MobileSliderPage;
import retry.Retry;

public class MobileSliderTest extends Base {

	LoginPage loginpage;
	MobileSliderPage mobileslidepage;
	@Test(retryAnalyzer = Retry.class)
	@Parameters({ "usernameInput", "PasswordInput" })
	public void verifyAnAlertMessageIsDisplayedByClickingNewButtonAndSelectCategory_UploadImage_AndClickSaveButton(String usernameInput,String PasswordInput) throws IOException 
	{
		loginpage=new LoginPage(driver);
		loginpage.enterUsername(usernameInput).enterPassword(PasswordInput).clickOnRememberMeButton().clickOnsignInButton();
		mobileslidepage=new MobileSliderPage(driver);
		mobileslidepage.clickOnMobileSliderMoreInfo().clickOnNewButtonInMobileSliderPage().selectCategoryFromDropDownInAddNewSliderPage();
		mobileslidepage.clickOnImageChooseFileInAddNewMobileSliderPage();
		mobileslidepage.clickOnSaveButtonInInAddNewMobileSliderPage();
		boolean alertMessageIsDispalyed=mobileslidepage.VerifyAlertMessageIsDisplayed();
		assertTrue( alertMessageIsDispalyed,"An alert message is not displayed");
		
	}
}
