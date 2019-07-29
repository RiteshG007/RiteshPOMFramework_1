package com.Ritesh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Ritesh.common.CommonFunctions1;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.Ritesh.common.CommonFunctions1;

public class LoginPage1 {
	
	private WebDriver driver;
	private ExtentTest logger;
	
	public LoginPage1(WebDriver driver, ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
	}
	
	//######### Locator Definition ############
	
	By tb_username=By.name("user_name");
	By tb_pwd=By.name("user_password");
	By btn_login=By.name("Login");
	By img_logoLogin=By.xpath("//img[@src='include/images/vtiger-crm.gif']");
	By txt_loginErrMsg=By.xpath("//td[contains(text(),'You must specify a valid username and password.')]");
		
	
	
	//##############################################################
	// Method Name: verifyTitle , Parameters:String exptTitle
	// Created By: Ritesh Gedam
	// Date : 21/06/2019
	//###############################################################
	
	public boolean verifyTitle(String exptTitle) throws Exception
	{
		if(exptTitle.equals(driver.getTitle().trim()))
		{
			logger.log(LogStatus.PASS, "Expected Title:"+exptTitle+" and Actual Title:"+driver.getTitle()+" has been matched successfully");
			return true;
		}
		else
		{
			String filename=CommonFunctions1.getscreenshot(driver);
			logger.log(LogStatus.FAIL, "Expected Title:"+exptTitle+" and Actual title:"+driver.getTitle()+"does not match <a href="+filename+">Screenshot</a>");
			return false;
		}
	}
	
			
	public boolean verifyLoginPageLogo()
	{
		try
		{
		
			if (driver.findElement(img_logoLogin).isDisplayed())
			{
				logger.log(LogStatus.PASS, "Login Page logo validated suucesfully");
				return true;
			}
			else
			{
				logger.log(LogStatus.FAIL, "Invalid Login Page Logo");
				return false;
			}
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			return false;
		}
			
	}
	
	public boolean verifyLoginPageErrorMsg()
	{
		try
		{
			if(driver.findElement(txt_loginErrMsg).isDisplayed())
			{
				logger.log(LogStatus.PASS, "Error msg validated suucesfully");
				return true;
			}
			else
			{
				logger.log(LogStatus.FAIL, "Invalid error msg");
				return false;
			}
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			return false;
		}
	}
	
	public void login(String user, String pwd)
	{
		driver.findElement(tb_username).clear();
		logger.log(LogStatus.PASS, "Textbox cleared successfully");
		driver.findElement(tb_username).sendKeys(user);
		logger.log(LogStatus.PASS, "Text:"+user+" entered successfully within username textbox");
		driver.findElement(tb_pwd).clear();
		logger.log(LogStatus.PASS, "Password field cleared successfully");
		driver.findElement(tb_pwd).sendKeys(pwd);
		logger.log(LogStatus.PASS, "Password entered successfully");
		driver.findElement(btn_login).click();
		logger.log(LogStatus.PASS, "Login button clicked successfully");
		
	}
	
	
	

}
