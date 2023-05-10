package com.sevenRMartSuperMarketTestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import Utilities.GeneralUtilities;
import Utilities.ScreenShotUtility;
import Utilities.WaitUtility;

public class Base {
	public WebDriver driver;
	public Properties prop,prop1;
	FileInputStream fs,fs1;
	public ScreenShotUtility scrshot;
	WaitUtility waitutility=new WaitUtility();
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initialiseBrowser(String browser) throws Exception 
	{
	
	try
	{
		prop=new Properties();
		fs = new FileInputStream(GeneralUtilities.CONFIGfILEPATH);
		prop.load(fs);
	}
	catch (FileNotFoundException e)
	{
		e.printStackTrace();
	}

	try
	{
		prop1=new Properties();
		fs = new FileInputStream(GeneralUtilities.FILEPATH);
		prop1.load(fs);
	
	} 
	catch (IOException e) 
	{
		e.printStackTrace();
	}
	
	if(browser.equalsIgnoreCase("firefox")){

		driver = WebDriverManager.firefoxdriver().create();
	}

	else if(browser.equalsIgnoreCase("chrome"))
	{

		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().create();
		driver=new ChromeDriver(chromeOptions);
	}

	else if(browser.equalsIgnoreCase("edge"))
	{
		EdgeOptions edgeOptions = new EdgeOptions();
		WebDriverManager.edgedriver().create();
		driver = new EdgeDriver(edgeOptions);
	}
	else
	{
	throw new Exception("Browser is not correct");
	}

	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	waitutility.pageLoadTimeout(driver);
	}
	@AfterMethod(alwaysRun = true)
	public void browserQuit(ITestResult iTestResult) throws IOException 
	{
	if (iTestResult.getStatus() == ITestResult.FAILURE) 
	{
	scrshot = new ScreenShotUtility();
	scrshot.getScreenShot(driver, iTestResult.getName());
	}
	driver.quit();
	}
}
