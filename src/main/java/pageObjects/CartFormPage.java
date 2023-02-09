package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartFormPage {

	public WebDriver driver;
	
	private By cartTitle = By.xpath("//h1[normalize-space()='Cart']");
	private By cartItemGroups = By.xpath("//div[@data-test='cart-item-groups']");
	private By cartSummaryTitle = By.xpath("//h2[@data-test='cart-summary-title']");
	private By cartSummarySubTotal = By.xpath("//div[@data-test='cart-summary-subTotal']");
	private By cartSummaryDelivery = By.xpath("//div[@data-test='cart-summary-delivery']");
	private By cartSummaryTaxes = By.xpath("//div[@data-test='cart-summary-taxes']");
	private By cartSummaryTotal = By.xpath("//div[@data-test='cart-summary-total']");
	private By checkoutButton = By.xpath("//button[@data-test='checkout-button']");
	
	public CartFormPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCheckoutButton() {
		return driver.findElement(checkoutButton);
	}
	
	public void verifyCartFormPageElements() {
		Assert.assertTrue(driver.findElement(cartTitle).isDisplayed());
		Assert.assertTrue(driver.findElement(cartItemGroups).isDisplayed());
		Assert.assertTrue(driver.findElement(cartSummaryTitle).isDisplayed());
		Assert.assertTrue(driver.findElement(cartSummarySubTotal).isDisplayed());
		Assert.assertTrue(driver.findElement(cartSummaryDelivery).isDisplayed());
		Assert.assertTrue(driver.findElement(cartSummaryTaxes).isDisplayed());
		Assert.assertTrue(driver.findElement(cartSummaryTotal).isDisplayed());
	}
	
}
