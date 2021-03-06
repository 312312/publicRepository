package com.Sky.qa.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Sky.qa.utils.TestUtils;

public class BaseClass {

//	public static WebDriver driver;
	public static ChromeDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	
	
	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Automation\\ObjectModel\\src\\main\\java\\com\\Sky\\qa\\configuration\\configuration.property");
			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public static void initialization()

	{
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\rohit.saini\\Downloads\\chromedriver_win32\\chromedriver.exe");
	
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			
			
			
//			DesiredCapabilities capabilities = new DesiredCapabilities();
//			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//			options.merge(capabilities);
			
			driver = new ChromeDriver();
		}

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		

	}
	
	public static void getScreenshot(String methodName, WebDriver driver) throws IOException
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination= System.getProperty("user.dir")+"\\reports\\"+ methodName +".png";		
		FileUtils.copyFile(src, new File(destination));	
		
	}

}
