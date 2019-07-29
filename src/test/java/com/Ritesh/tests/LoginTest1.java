package com.Ritesh.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Ritesh.common.CommonFunctions1;
import com.Ritesh.pages.HeaderPage1;
import com.Ritesh.pages.HomePage1;
import com.Ritesh.pages.LoginPage1;

public class LoginTest1 extends BaseTest1 {
	
	@BeforeClass(alwaysRun=true)
	public void startApp()
	{
		if(report==null)
		{
			report=CommonFunctions1.setupResult();
		}
		if(driver==null)
		{
			launchApp();
		}
	}
	
	
	
	@Test(priority=1)
	public void validateTitle() throws Exception
	{
		logger=report.startTest("validateTitle");
		LoginPage1 lp=new LoginPage1(driver,logger);
		boolean output=lp.verifyTitle("vtiger CRM - Commercial Open Source CRM123");
		//Assert.assertEquals(output, true);
		report.endTest(logger);
		report.flush();
	}
	
	@Test(priority=2)
	public void validateLogo()
	{
		logger=report.startTest("validateLogo");
		LoginPage1 lp=new LoginPage1(driver,logger);
		boolean output=lp.verifyLoginPageLogo();
		Assert.assertEquals(output, true);
		report.endTest(logger);
		report.flush();
		
	}
	
	@Test(priority=3)
	public void validateInvalidLogin()
	{
		logger=report.startTest("validateInvalidLogin");
		LoginPage1 lp=new LoginPage1(driver,logger);
		lp.login("abc", "xyz");
		boolean output=lp.verifyLoginPageErrorMsg();
		Assert.assertEquals(output, true);
		report.endTest(logger);
		report.flush();
		
	}
	
	@Test(priority=4)
	public void validateValidLogin()
	{
		logger=report.startTest("validateValidLogin");
		LoginPage1 lp=new LoginPage1(driver,logger);
		lp.login("admin", "admin");
		HeaderPage1 hp=new HeaderPage1(driver,logger); 
		boolean output=hp.verifyLink("Logout");
		Assert.assertEquals(output, true);
		report.endTest(logger);
		report.flush();
		
	}
	
	
	
	@AfterClass
	public void tierDown()
	{
		report.flush();
		if(driver!=null)
		{
			closeApp();
		}
	}
	

}
