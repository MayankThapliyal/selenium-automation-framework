package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTests extends BaseTest{
  @Test
  public void validLoginTest() {
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.enterUsername("standard_user")
	  			.enterPassword("secret_sauce")
	  			.clickLogin();
	  
	  Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "User did not navigate to login page");
  }
  
  @Test
  public void invalidLoginTest() {
	  LoginPage loginPage = new LoginPage(driver);
	  loginPage.enterUsername("wrong_user").enterPassword("wrong_password")
	  .clickLogin();
	  
	  Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"), "Error message not displayed for invalid login");
  }
}
