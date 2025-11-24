package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	private static final int TIMEOUT = 10;
	
	public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
		return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT))
				.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static WebElement waitForClickability(WebDriver driver, WebElement element) {
		return new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT))
				.until(ExpectedConditions.elementToBeClickable(element));
	}
}
