package com.Sky.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Sky.qa.baseclass.BaseClass;

public class LoginPage extends BaseClass{

	
	@FindBy(name="user[login_name]")
	WebElement username;
	
	@FindBy(name="user[login_password]")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Sign in']")
	WebElement loginbutton;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	

//Actions
	
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
		
	public HomePage login(String ur, String pwd)
	{
		username.sendKeys(ur);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new HomePage();
		
	}
	
	
}
