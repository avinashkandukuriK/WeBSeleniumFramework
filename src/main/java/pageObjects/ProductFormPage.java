package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductFormPage {

	public WebDriver driver;
	
	private By breadcrumbContainer = By.xpath("//div[@data-test='@web/Breadcrumb/Container']");
	private By productTitle = By.xpath("//h1[@data-test='product-title']");
	private By productCarousel = By.xpath("//section[@data-test='product-carousel']");
	private By iconGeneralHeart = By.xpath("//span[@data-test='IconGeneralHeartOutline']");
	private By productPrice = By.xpath("//span[@data-test='product-price']");
	private By ratingFeedbackContainer = By.xpath("//div[@data-test='ratingFeedbackContainer']");
	private By addToCartButton = By.xpath("//button[@data-test='shippingButton']");
	private By productDetails = By.xpath("//div[@id='product-detail-tabs']");
	private By checkoutLink = By.xpath("//a[normalize-space()='View cart & check out']");
	
	public ProductFormPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getProductTitle() {
		return driver.findElement(productTitle);
	}
	
	public WebElement getCheckoutLink() {
		return driver.findElement(checkoutLink);
	}
	
	public WebElement getAddtoCartButton() {
		return driver.findElement(addToCartButton);
	}
	
	public WebElement getProductDetails() {
		return driver.findElement(productDetails);
	}
	
	public void verifyProductFormPageElements() {
		Assert.assertTrue(driver.findElement(breadcrumbContainer).isDisplayed());
		Assert.assertTrue(driver.findElement(productTitle).isDisplayed());
		Assert.assertTrue(driver.findElement(productCarousel).isDisplayed());
		Assert.assertTrue(driver.findElement(iconGeneralHeart).isDisplayed());
		Assert.assertTrue(driver.findElement(productPrice).isDisplayed());
		Assert.assertTrue(driver.findElement(ratingFeedbackContainer).isDisplayed());
		Assert.assertTrue(driver.findElement(addToCartButton).isDisplayed());
		Assert.assertTrue(driver.findElement(productDetails).isDisplayed());
	}

}
