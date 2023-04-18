package com.sevenRMartSuperMarketPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HamburgerMenuPage {
	WebDriver driver;
	public HamburgerMenuPage  (WebDriver driver)
	{
		this.driver=driver;//same driver 
		
	}
	
	public void selectMenu(String input)
	{   
		By categories=By.xpath("//i[@class='nav-icon fas fa-th-large']//following::a[@href]");
		List<WebElement> selectCategoryelement=driver.findElements(categories);
		for(WebElement category:selectCategoryelement)
		{
			String categoryName=category.getText();
			if(categoryName.equals(input))
			{
				category.click();
				break;
			}
		}
	}
}
