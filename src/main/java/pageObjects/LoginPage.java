package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
	
	public WebDriver driver;
	
	private By email = By.id("username");////input[@id='username']
	private By password = By.xpath("//input[@id='password']");
	private By keepMeSignedIn = By.xpath("//input[@id='keepMeSignedIn']");
	private By submitButton = By.id("login");
	private By forgotPassword = By.cssSelector("#recoveryPassword");
	private By createAccountButton = By.id("createAccount");
	private By usernameErrorMessage = By.id("username--ErrorMessage");
	private By passwordErrorMessage = By.id("password--ErrorMessage");
	private By cantFindAccount = By.xpath("//div[contains(text(),'We can't find your account.')]");
	private By authAlertDisplay = By.xpath("//div[@data-test='authAlertDisplay']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void verifyLoginPageElements() {
		Assert.assertTrue(driver.findElement(email).isDisplayed());
		Assert.assertTrue(driver.findElement(password).isDisplayed());
		Assert.assertTrue(driver.findElement(submitButton).isDisplayed());
		Assert.assertTrue(driver.findElement(forgotPassword).isDisplayed());
		Assert.assertTrue(driver.findElement(createAccountButton).isDisplayed());
	}

	public ForgotPasswordPage forgotPassword()
	{
		driver.findElement(forgotPassword).click();
		return new ForgotPasswordPage(driver);
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getKeepMeSignedIn()
	{
		return driver.findElement(keepMeSignedIn);
	}
	
	public WebElement getSubmitButton()
	{
		return driver.findElement(submitButton);
	}
	
	public WebElement getForgotPassword()
	{
		return driver.findElement(forgotPassword);
	}
	
	public WebElement getCreateAccountButton()
	{
		return driver.findElement(createAccountButton);
	}
	
	public WebElement getUsernameErrorMessage()
	{
		return driver.findElement(usernameErrorMessage);
	}
	
	public WebElement getPasswordErrorMessage()
	{
		return driver.findElement(passwordErrorMessage);
	}
	
	public WebElement getCantFindAccount()
	{
		return driver.findElement(cantFindAccount);
	}
	
	public WebElement getAuthAlertDisplay()
	{
		return driver.findElement(authAlertDisplay);
	}

}
