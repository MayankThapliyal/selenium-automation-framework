package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginBtn = By.id("login-button");
	private By errorMsg = By.cssSelector("#login_button_container > div > form > div.error-message-container.error");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
		return this;
	}
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	
	public String getErrorMessage() {
		return driver.findElement(errorMsg).getText();
	}
}
