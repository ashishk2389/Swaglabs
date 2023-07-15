package com.swaglab.testscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.swaglab.basefolder.BaseClass;
import com.swaglab.pageobject.LoginPage;
import com.swaglab.pageobject.ProductPage;

public class ProductPageTest {
	WebDriver driver;
	BaseClass base = new BaseClass();
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;



	@BeforeTest  
	public  void initilizeBroswer()

	{
		System.out.print("browser_initilize");
		base.getDriver();


		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);


	}


	@Test
	@Parameters({"user","pass"})
	public void addtocart(String user,String pass) {

		ProductPage pp = new ProductPage(base.driver);
		LoginPage loginPage = new LoginPage(base.driver);
		loginPage.user.sendKeys(user);
		loginPage.password.sendKeys(pass);
		loginPage.login.click();

		base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//	WebDriverWait wait = new WebDriverWait(driver,30);
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));

		//	  pp.product1.click();
		pp.product2.click();
		pp.product3.click();
		pp.product4.click();

		ExtentTest test = extent.createTest("MyFirstTest");
		test.pass("details");

		// short-hand
		extent.createTest("MyFirstTest").pass("details");

		// description
		extent.createTest("MyFirstTest", "Test Description").pass("details");

		extent.flush();
	}
	
	
}
