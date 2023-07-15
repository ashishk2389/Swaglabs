package com.swaglab.pageobject;
import org.openqa.selenium.support.*;

import com.swaglab.basefolder.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		  this.driver = driver;
		  PageFactory.initElements(driver, this);
		  System.out.print("LoginPage constructor has been called");

	}
//	Username element
	@FindBy(xpath="//input[@id='user-name']")
	public
	WebElement user ;

//  Password element
	@FindBy(id="password")
	public
	WebElement password;
//	login button
	public
	@FindBy(xpath="//input[@id='login-button']")
	WebElement login;
	
	public ProductPage clickOnLogin()
	{
		login.click();
		
		return new ProductPage(driver);
	}
}
