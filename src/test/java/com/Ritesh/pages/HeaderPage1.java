package com.Ritesh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

public class HeaderPage1 {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public HeaderPage1(WebDriver driver, ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
	}
	
	public boolean verifyLink(String lnkText)
	{
		try
		{
			if(driver.findElement(By.linkText(lnkText)).isDisplayed())
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
	
	
	public void verifyClickLink(String lnkText)
	{
		driver.findElement(By.linkText(lnkText)).click();
	}
	
	
	public LoginPage1 verifyLogoutLink(String lnkText)
	{
		driver.findElement(By.linkText(lnkText)).click();
		return new LoginPage1(driver,logger);
		
	}
	

}
