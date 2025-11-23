package base;


import driver.DriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	protected WebDriver driver;
  
  @BeforeMethod
  public void setUp() {
	  DriverManager.setDriver();
	  driver = DriverManager.getDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.saucedemo.com/");
  }

  @AfterMethod
  public void tearDown() {
	  DriverManager.quitDriver();
  }

}
