package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import reporting.ExtentTestManager;

public class ElementActions {
	public static void click(WebDriver driver, WebElement element) {
		String actionDesc = "Click -> " + element.toString();
		try {
			WaitUtils.waitForClickability(driver, element).click();
			ExtentTestManager.getTest().log(Status.INFO, actionDesc);
		} catch(Exception e) {
			ExtentTestManager.getTest().log(Status.WARNING, "First click failed, retrying: " + actionDesc);
			WaitUtils.waitForClickability(driver, element);
			ExtentTestManager.getTest().log(Status.INFO, "Click succeeded on retry -> " + element.toString());
		}
	}
	
	public static void type(WebDriver driver, WebElement element, String value) {
		String actionDesc = "Type -> " + value + " into " + element.toString();
		WebElement el = WaitUtils.waitForVisibility(driver, element);
		el.clear();
		el.sendKeys(value);
		ExtentTestManager.getTest().log(Status.INFO, actionDesc);
	}
	
	public static String getText(WebDriver driver, WebElement element) {
		String text = WaitUtils.waitForVisibility(driver, element).getText();
		ExtentTestManager.getTest().log(Status.INFO, "GetText -> " + text + " from " + element.toString());
		return text;
	}
}

