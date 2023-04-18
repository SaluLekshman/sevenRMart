package Utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility
{
	 public static boolean clickOnElement(WebElement element)
     {
		 element.click();
		return false;
		 
     }
	
	public static boolean isDisplay(WebElement element) 
	{
		boolean status = element.isDisplayed();
		return status;
	}

	public static WebElement enterText(WebElement element, String value) 
	{
		element.sendKeys(value);
		return element;
	}
	
	public void sendKey(WebElement element, String s) 
	{
		element.sendKeys(s);
	}

	public static String getElementText(WebElement element) 
	{
		return element.getText();
	}

	public static void clickAndHoldOnElement(WebElement element, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
	}
	public static void doubleClick(WebElement element, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public static void rightClick(WebElement element, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	public static void dragAnddrop(WebElement dragableItem,WebElement dropItem, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.clickAndHold(dragableItem).moveToElement(dropItem).release(dropItem).build().perform();
	}

	public static void selectDropdownbyText(WebElement element, String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectDropdownbyIndex(WebElement element, int index) 
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}


	public static WebElement enterIntValue(WebElement element, CharSequence[] value) 
	{
		element.sendKeys(value);
		return element;
	}

	public static Boolean isElementDisplayed(WebElement element) 
	{
		return element.isDisplayed();
	}
	public static boolean elementIsEnabled(WebElement element)
	{
		return element.isEnabled();
	}
	public static boolean isSelected(WebElement element)
	{
		return element.isSelected();
	}
	public static void ScrollBy(WebDriver driver) 
	{
		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		Js1.executeScript("window.scrollBy(0,2500)");
	}

	public static void stopPageRefresh(WebDriver driver) 
	{
	JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	Js1.executeScript("window.stop();");

	}
	public String getToolTip(WebElement element) 
	{
		return element.getAttribute("title");
	}

	public void getClickElement(WebElement element)
	{
		element.click();
	}

	public void mediumDelay(int x) throws InterruptedException 
	{
		Thread.sleep(x);
	}

	public void selectFuncbyindex(WebElement element, int index) 
	{
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public void selectFuncbyValue(WebElement element, String value) 
	{
		Select select1 = new Select(element);
		select1.selectByValue(value);

	}

	public String selectFuncbyVisibletext(WebElement element, String visibletext) 
	{
		Select select = new Select(element);
		select.selectByVisibleText(visibletext);
		WebElement selectedValue = select.getFirstSelectedOption();
		return (selectedValue.getText());

	}

	public String FirstSelectedOption(WebElement element) 
	{
		Select select1 = new Select(element);
		String firstoption = select1.getFirstSelectedOption().getText();
		return (firstoption);
	}

	public List<WebElement> getAllOptions(Select s){

		List<WebElement> op = s.getOptions();
		return op;
	}
	
	
	public List<String> convertToStringList(List<WebElement> weList) 
	{
		List<String> strList = new ArrayList<String>();
		for (int i = 0; i < weList.size(); i++) 
		{

			strList.add(weList.get(i).getText());
		}

		return strList;

	}

	
	public static String stylePropertyValidation(WebElement element, String propertyType) 
	{
		return element.getCssValue(propertyType);
	}

}