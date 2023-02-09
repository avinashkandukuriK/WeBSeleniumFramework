package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LandingPage {

	public WebDriver driver;
	
	private By header = By.xpath("//nav[@id='headerPrimary']");
	//data-test="@web/HeaderPrimaryNav"
	
	private By signin = By.cssSelector("a[aria-label='Account, sign in']");
	//data-test="@web/AccountLink"
	
	private By title = By.xpath("//h1[contains(text(),'Homepage')]");
	//data-test="page-title"
	
	private By storeMessageButton = By.cssSelector("button[@id='web-store-id-msg-btn']");
	//data-test="@web/StoreMessage/Button"
	
	private By accountSignin = By.xpath("//li[@id='listaccountNav-signIn']");
	//data-test="accountNav-signIn"
	
	private By searchInput = By.xpath("//input[@id='search']");
	//data-test="@web/Search/SearchInput"
	
	private By searchButton = By.xpath("//button[@data-test='@web/Search/SearchButton']");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public LoginPage getLogin() {
		driver.findElement(signin).click();
		LoginPage login = new LoginPage(driver);
		return login;
	}
	
	public WebElement getAccountSignin() {
		return driver.findElement(accountSignin);
	}

	public WebElement geTitle() {
		return driver.findElement(title);
	}

	public WebElement getStoreMessageButton() {
		return driver.findElement(storeMessageButton);
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}
	
	public void performSearch(String searchItem) {
		driver.findElement(searchInput).sendKeys(searchItem);
		driver.findElement(searchButton).click();
	}
	
	public void verifyLandingPageElements() {
		Assert.assertTrue(geTitle().isDisplayed());
//		Assert.assertTrue(getStoreMessageButton().isDisplayed());
		Assert.assertTrue(getHeader().isDisplayed());
	}


}
