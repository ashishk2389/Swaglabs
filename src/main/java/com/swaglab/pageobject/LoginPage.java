package com.swaglab.pageobject;
import org.openqa.selenium.support.*;

import com.swaglab.basefolder.BaseClass;
import com.swaglab.utilitycomponent.TestTimeUtil;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseClass{

//	PageFctory -- Object Repo
	
//	Username element
	@FindBy(xpath="//input[@id='user-name']")
	public
	WebElement user ;

//  Password element
	@FindBy(xpath="//input[@id='password']")
	public
	WebElement password;
//	login button
	public
	@FindBy(xpath="//input[@id='login-button']")
	WebElement login;
//	logo element
	@FindBy(xpath="//div[contains(text(),'Swag Labs')]")
	WebElement logo;
	
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")
	WebElement burgerIcon;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
	WebElement logout;
	
	
	
//Intilization of the page objects	
	public LoginPage()
	{
	  PageFactory.initElements(driver, this);	
	}
	
	
//	Actions:
	
 public String vlidateLogo()
 {
	 return logo.getText();
 }
 
 public String vlidateLogin(String user ,String pwd)
 {
	 this.user.clear();
	 this.user.sendKeys(user);
	 password.clear();
	 password.sendKeys(pwd);
	 login.click();
	 
 	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	 return driver.getCurrentUrl();
 }
 
 public void logout()
 {
	 burgerIcon.click();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 logout.click();
 }
	
 
 public ProductPage Login(String user ,String pwd)
 {
	 this.user.sendKeys(user);
	 password.sendKeys(pwd);
	 login.click();
	 
 	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	 return new ProductPage();
 }
	
 
 
}
