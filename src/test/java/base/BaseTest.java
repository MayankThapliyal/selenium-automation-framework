package base;


import driver.DriverManager;
import utils.ConfigReader;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest implements WebDriverProvider{
	protected WebDriver driver;
  
  @BeforeMethod
  public void setUp() {
	  DriverManager.setDriver();
	  driver = DriverManager.getDriver();
	  driver.manage().window().maximize();
	  driver.get(ConfigReader.get("url"));
  }

  @AfterMethod
  public void tearDown() {
	  DriverManager.quitDriver();
  }

  @Override
  public WebDriver getDriver(){
    return driver;
  }

}
