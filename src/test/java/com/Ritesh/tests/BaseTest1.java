package com.Ritesh.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Ritesh.common.config1;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest1 {
	
	public WebDriver driver;
	public static ExtentReports report=null;
	public static ExtentTest logger; 
	public static String extentReport;
	
	public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver", config1.ChromePath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(config1.url);
		driver.manage().timeouts().implicitlyWait(config1.globalTimeout, TimeUnit.SECONDS);
		
	}
	
	public void closeApp()
	{
		driver.close();
		driver.quit();
	}
	

}
