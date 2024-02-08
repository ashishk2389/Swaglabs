package com.swaglab.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.basefolder.BaseClass;

public class ProductPage extends BaseClass{
	
	public int itemsAddedToCart =0;
	
//	PageFctory -- Object Repo
	
//	product1 add to cart 
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	public
	WebElement backpack ;

//	product2 add to cart 
	@FindBy(id="//button[@id='add-to-cart-sauce-labs-bike-light']")
	public
	WebElement bikeLight;
	
//	product3 add to cart 
	public
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']")
	WebElement onesie;
	
//	product4 add to cart 
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
	public
	WebElement tShirt;
	
//	Shopping cart container
	@FindBy(xpath="//a[@class='shopping_cart_link']//span")
	public
	WebElement addToCartIcon;
	

	//Intilization of the page objects	
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
//Actions:
	public WebElement addToCartBackpack()
	{
		backpack.click();
		itemsAddedToCart++;
		return backpack;
		
	}
	public WebElement addToCartBikeLight()
	{
		bikeLight.click();
		itemsAddedToCart++;
		return bikeLight;
	}
	public WebElement addToCartOnesie()
	{
		onesie.click();
		itemsAddedToCart++;
		return onesie;
	}
	public WebElement addToCartTShirt()
	{
		tShirt.click();
		itemsAddedToCart++;
		return tShirt;
	}
	
	public WebElement validateAddToCartIcon()
	{
		return addToCartIcon;
	}
	

}
