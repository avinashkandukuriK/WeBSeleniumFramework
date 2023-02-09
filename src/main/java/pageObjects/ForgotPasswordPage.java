package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	
	public WebDriver driver;
	
	By passwordReset = By.cssSelector("div[for='resetPassword']");
	By temporaryCode = By.cssSelector("div[for='otpSignin']");
	By sendCodeButton = By.id("continue");
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getPasswordReset()
	{
		return driver.findElement(passwordReset);
	}
	
	public WebElement getTemporaryCode()
	{
		return driver.findElement(temporaryCode);
	}
	
	public WebElement getSendCodeButton()
	{
		return driver.findElement(sendCodeButton);
	}

}
