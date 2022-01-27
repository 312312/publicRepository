package com.sky.qa.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;

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
import com.Sky.qa.utils.DataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class EnvironmentPageTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	
	public EnvironmentPageTest()
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
		extent.setSystemInfo("Environment","Saini");
			
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage= new LoginPage();
			
	}
	
	
	
	@Test(priority=1)
	public void pageTitle()
	{
		extent.createTest("page Title").assignCategory("Regression").assignAuthor("Rohit");
		String title= loginPage.validatePageTitle();
		System.out.println(title);		
	}
	
	
	@Test(priority=2)
	public void loginApplication() throws AWTException
	{	
		extent.createTest("Login Application").assignCategory("Regression").assignAuthor("Rohit");
		homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	}
	
	@Test(priority=3)
	public void environmentPage() throws AWTException
	{	
		extent.createTest("Login Application").assignCategory("Regression").assignAuthor("Rohit");
		
		
		
		
		
	}
	
	
	@DataProvider (name"rohit")
  	public Object[][] excelDP() throws IOException{
     
        	Object[][] arrObj = getExcelData("Location of the excel file in your local system","Name
of the excel sheet where your data is placed");
        	return arrObj;
  	}
  	
  	
  	public String[][] getExcelData(String fileName, String sheetName){
        	
        	String[][] data = null;   	
  	  	try
  	  	{
  	   	FileInputStream fis = new FileInputStream(fileName);
  	   	XSSFWorkbook wb = new XSSFWorkbook(fis);
  	   	XSSFSheet sh = wb.getSheet(sheetName);
  	   	XSSFRow row = sh.getRow(0);
  	   	int noOfRows = sh.getPhysicalNumberOfRows();
  	   	int noOfCols = row.getLastCellNum();
  	   	Cell cell;
  	   	data = new String[noOfRows-1][noOfCols];
  	   	
  	   	for(int i =1; i<noOfRows;i++){
  		     for(int j=0;j<noOfCols;j++){
  		    	   row = sh.getRow(i);
  		    	   cell= row.getCell(j);
  		    	   data[i-1][j] = cell.getStringCellValue();
  	   	 	   }
  	   	}
  	  	}
  	  	catch (Exception e) {
  	     	   System.out.println("The exception is: " +e.getMessage());
           	}
        	return data;
  	}

	
	@AfterTest
	public void afterMethod()
	{
		extent.flush();
		
	}

}
