package com.swaglab.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		  this.driver = driver;
		  PageFactory.initElements(driver, this);
		  System.out.print("LoginPage constructor has been called");

	}
//	product1 add to cart 
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	public
	WebElement product1 ;

//	product2 add to cart 
	@FindBy(id="//button[@id='add-to-cart-sauce-labs-bike-light']")
	public
	WebElement product2;
	
//	product3 add to cart 
	public
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']")
	WebElement product3;
	
//	product4 add to cart 
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
	public
	WebElement product4;


}
