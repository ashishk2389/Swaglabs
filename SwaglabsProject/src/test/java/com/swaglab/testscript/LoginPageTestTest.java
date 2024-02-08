package com.swaglab.testscript;

import com.swaglab.basefolder.BaseClass;
import com.swaglab.pageobject.LoginPage;
import com.swaglab.utilitycomponent.ExcelReader;
import java.io.IOException;
import java.time.Duration;
import org.junit.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTestTest extends BaseClass {
   LoginPage LoginPage;
   ExcelReader testData;

   @BeforeSuite
   public void initilizeBroswer() {
      initilization();
      this.LoginPage = new LoginPage();
   }

//   @Test(
//      priority = 1,
//      description = "Testing the logo is visible "
//   )
//   public void testLogo() {
//      Assert.assertEquals(this.LoginPage.vlidateLogo(), "Swag Labs");
//   }

   @DataProvider
   public String[][] getCredentails() throws IOException {
      return ExcelReader.getLoginCredenatils("Sheet1");
   }

   @Test(
      priority = 1,
      dataProvider = "getCredentails",
      description = "Testing login functionality"
   )
   public void testLogin(String user, String pass, String status) throws InterruptedException, IOException {
      String result = this.LoginPage.vlidateLogin(user, pass);
      String statusNew;
      if (result.equals("https://www.saucedemo.com/inventory.html")) {
         statusNew = "PASS";
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
         this.LoginPage.logout();
      } else {
         statusNew = "FAIL";
      }

      Assert.assertEquals(statusNew, status);
   }

   @AfterSuite
   public void tearDown() {
      driver.quit();
   }
}
