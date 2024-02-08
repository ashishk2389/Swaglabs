package com.swaglab.testscript;

import com.swaglab.basefolder.BaseClass;
import com.swaglab.pageobject.LoginPage;
import com.swaglab.pageobject.ProductPage;
import org.junit.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseClass {
}
//    ProductPage ProductPage;

//    @BeforeSuite
//    public void initilizeBroswer() {
//       initilization();
//       LoginPage loginPage = new LoginPage();
//       this.ProductPage = loginPage.Login("standard_user", "secret_sauce");
//    }

//    @Test
//    public void testAddToCartBackpack() {
//       Assert.assertFalse(this.ProductPage.addToCartBackpack().isDisplayed());
//    }

//    @Test
//    public void testAddToCartBikeLight() {
//       Assert.assertFalse(this.ProductPage.addToCartBikeLight().isDisplayed());
//    }

//    @Test
//    public void testAddToCartOnesie() {
//       Assert.assertFalse(this.ProductPage.addToCartOnesie().isDisplayed());
//    }

//    @Test
//    public void testAddToCartTShirt() {
//       Assert.assertFalse(this.ProductPage.addToCartTShirt().isDisplayed());
//    }

//    @Test
//    public void testAddToCartIcon() {
//       int itemsAddedToCart = Integer.parseInt(this.ProductPage.addToCartIcon.getText());
//       Assert.assertEquals((long)this.ProductPage.itemsAddedToCart, (long)itemsAddedToCart);
//    }
// }
