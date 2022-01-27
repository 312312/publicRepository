package com.sky.qa.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Sky.qa.baseclass.BaseClass;
import com.Sky.qa.pages.HomePage;
import com.Sky.qa.pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoginPageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	ExtentReports extent;
	
	@BeforeTest
	public void reportSetUp()
	{
		
		String path= System.getProperty("user.dir")+"\\Extentreport\\index.html";

		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("Web Testing");
		report.config().setDocumentTitle("kytap Automation");
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Rohit","Saini");
			
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		System.out.println("Login page started");
		loginPage= new LoginPage();
			
	}
	
	
	
	@Test(priority=1)
	public void pageTitle()
	{
		extent.createTest("page Title").assignCategory("Regression").assignAuthor("Rohit");
		String title= loginPage.validatePageTitle();
		System.out.println(title);
//		Assert.assertEquals(title,"Sign In1232Skytap");
		
		
	}
	
	
	@Test(priority=2)
	public void loginApplication() throws AWTException
	{	
		extent.createTest("Login Application").assignCategory("Regression").assignAuthor("Rohit");

		
		homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		
		
	}
	
	
	
	@AfterTest
	public void afterMethod()
	{
		extent.flush();
		
	}

}
