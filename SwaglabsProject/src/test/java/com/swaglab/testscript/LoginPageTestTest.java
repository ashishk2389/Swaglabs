package com.swaglab.testscript;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swaglab.basefolder.BaseClass;
import com.swaglab.pageobject.LoginPage;

public class LoginPageTestTest {
	
	
	BaseClass base = new BaseClass();
	String ExpectedTitle = "https://www.saucedemo.com/inventory.html";
//	WebDriver driver = base.driver;
	
	@BeforeTest  
public  void initilizeBroswer()

  {
	System.out.print("browser_initilize");
	  base.getDriver();
  }
  

  @Test
  @Parameters({"user","pass"})
  public void testLoginTest(String user,String pass) {
		LoginPage loginPage = new LoginPage(base.driver);
	    loginPage.user.sendKeys(user);
		loginPage.password.sendKeys(pass);
		loginPage.login.click();
	  System.out.print("wokring");
	  base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	  Check if login was sucessfull
	  Assert.assertEquals(ExpectedTitle, base.driver.getCurrentUrl());
  }
  

  
//  
//	@AfterTest  
//public  void  closeBroswer()
//
//{
//		base.driver.quit();
//}

   
 
}
