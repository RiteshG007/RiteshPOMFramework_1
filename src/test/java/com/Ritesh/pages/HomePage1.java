package com.Ritesh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class HomePage1 extends HeaderPage1 {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public HomePage1(WebDriver driver,ExtentTest logger) 
	{
		super(driver,logger);
		this.driver=driver;
		this.logger=logger;
	}
	
	//####### Locator Definition ###############
	
	By tab_Home=By.xpath("//a[@class='currentTab'][contains(text(),'Home')]");
	
	public boolean verifyHomePageTab()
	{
		try
		{
			if(driver.findElement(tab_Home).isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			return false;
		}
	}
	

}
