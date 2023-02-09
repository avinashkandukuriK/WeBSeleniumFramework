package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutPage {

	public WebDriver driver;
	
	//main containers
	private By checkoutContainer = By.xpath("//div[@data-test='checkout-container']");
	private By stepPickUp = By.id("STEP_PICKUP");
	private By stepDeliveryMethod = By.id("STEP_DELIVERYMETHOD");
	private By stepPayment = By.id("STEP_PAYMENT");
	private By stepPaymentGiftCards = By.id("STEP_PAYMENT_GIFT_CARDS");

	//credit card
	private By creditCardNumber = By.xpath("//input[@data-test='credit-card-number-input']");
	private By creditCardExpiration = By.xpath("//input[@data-test='creditCardInput-expiration']");
	private By creditCardCvv = By.xpath("//input[@data-test='creditCardInput-cvv']");
	private By creditCardName = By.id("creditCardInput-cardName");
	private By addressCountry = By.id("addressFormInput-country");
	private By addressLine = By.id("addressFormInput-addressLine1");
	private By addressZipCode = By.id("addressFormInput-zipCode");
	private By addressCity = By.id("addressFormInput-city");
	private By addressState = By.id("addressFormInput-state");
	private By mobileNumber= By.id("addressFormInput-mobile");
	private By saveAndContinueButton = By.xpath("//button[@data-test='save-and-continue-button']");
	
	//summary section
	private By cartSummaryTitle = By.xpath("//h2[@data-test='cart-summary-title']");
	private By cartSummarySubTotal = By.xpath("//div[@data-test='cart-summary-subTotal']");
	private By cartSummaryDelivery = By.xpath("//div[@data-test='cart-summary-delivery']");
	private By cartSummaryTaxes = By.xpath("//div[@data-test='cart-summary-taxes']");
	private By cartSummaryTotal = By.xpath("//div[@data-test='cart-summary-total']");
	private By placeOrderButton = By.xpath("//button[@data-test='placeOrderButton']");
	
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCreditCardNumber() {
		return driver.findElement(creditCardNumber);
	}
	
	public WebElement getCreditCardExpiration() {
		return driver.findElement(creditCardExpiration);
	}
	
	public WebElement getCreditCardCvv() {
		return driver.findElement(creditCardCvv);
	}
	
	public WebElement getCreditCardName() {
		return driver.findElement(creditCardName);
	}
	
	public WebElement getAddressCountry() {
		return driver.findElement(addressCountry);
	}
	
	public WebElement getAddressLine() {
		return driver.findElement(addressLine);
	}
	
	public WebElement getAddressZipCode() {
		return driver.findElement(addressZipCode);
	}
	
	public WebElement getAddressCity() {
		return driver.findElement(addressCity);
	}
	
	public WebElement getAddressState() {
		return driver.findElement(addressState);
	}
	
	public WebElement getMobileNumber() {
		return driver.findElement(mobileNumber);
	}
	
	public WebElement getSaveAndContinueButton() {
		return driver.findElement(saveAndContinueButton);
	}
	
	public WebElement getPlaceOrderButton() {
		return driver.findElement(placeOrderButton);
	}
	
	public void verifyCheckoutFormPageElements() {
		Assert.assertTrue(driver.findElement(checkoutContainer).isDisplayed());
		Assert.assertTrue(driver.findElement(stepPickUp).isDisplayed());
		Assert.assertTrue(driver.findElement(stepDeliveryMethod).isDisplayed());
		Assert.assertTrue(driver.findElement(stepPayment).isDisplayed());
		Assert.assertTrue(driver.findElement(stepPaymentGiftCards).isDisplayed());
		Assert.assertTrue(driver.findElement(creditCardNumber).isDisplayed());
		Assert.assertTrue(driver.findElement(creditCardExpiration).isDisplayed());
		Assert.assertTrue(driver.findElement(creditCardName).isDisplayed());
		Assert.assertTrue(driver.findElement(addressCountry).isDisplayed());
		Assert.assertTrue(driver.findElement(addressLine).isDisplayed());
		Assert.assertTrue(driver.findElement(addressZipCode).isDisplayed());
		Assert.assertTrue(driver.findElement(addressCity).isDisplayed());
		Assert.assertTrue(driver.findElement(addressState).isDisplayed());
		Assert.assertTrue(driver.findElement(mobileNumber).isDisplayed());
		Assert.assertTrue(driver.findElement(saveAndContinueButton).isDisplayed());
		Assert.assertTrue(driver.findElement(cartSummaryTitle).isDisplayed());
		Assert.assertTrue(driver.findElement(cartSummarySubTotal).isDisplayed());
		Assert.assertTrue(driver.findElement(cartSummaryDelivery).isDisplayed());
		Assert.assertTrue(driver.findElement(cartSummaryTaxes).isDisplayed());
		Assert.assertTrue(driver.findElement(cartSummaryTotal).isDisplayed());
		Assert.assertTrue(driver.findElement(placeOrderButton).isDisplayed());
	}
	
}
