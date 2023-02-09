package target;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CartFormPage;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.ProductFormPage;
import pageObjects.ProductListPage;
import resources.Utilities;
import resources.base;
import resources.excelDataDriven;

public class CheckoutValidation extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(CheckoutValidation.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = intializeDriver();
	}
	
	@Test(groups={"Smoke"})
	public void productCheckoutValidation() throws InterruptedException, IOException {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Utilities utils = new Utilities(driver);
		excelDataDriven excel1 = new excelDataDriven();
		ArrayList<String> data1 = excel1.getData("SearchProductValidation");

		//login with valid user from global values
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getLogin();
		Thread.sleep(2000);
		landingPage.getAccountSignin().click();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmail().sendKeys(utils.getGlobalValue("userLogin"));
		loginPage.getPassword().sendKeys(utils.getGlobalValue("userPassword"));
		loginPage.getSubmitButton().click();
		
		//search product, add it to the cart, click checkout
		landingPage.performSearch(data1.get(1));
		ProductListPage productListPage = new ProductListPage(driver);
		productListPage.verifyProductListPageElements();
		log.info("Product List page elements verified successfully");
		productListPage.clickProduct(0);
		ProductFormPage productFormPage = new ProductFormPage(driver);
		productFormPage.verifyProductFormPageElements();
		log.info("Product Form page elements verified successfully");

        utils.scrollToElement(productFormPage.getProductDetails());
        Assert.assertTrue(productFormPage.getProductDetails().isDisplayed());
        log.info("Product details displayed successfully");
        utils.scrollToElement(productFormPage.getProductTitle());
        productFormPage.getAddtoCartButton().click();
		driver.switchTo().defaultContent();
		productFormPage.getCheckoutLink().click();
		log.debug("Clicked Checkout Link");
		
		//verify cart page and click checkout
		CartFormPage cartFormPage=new CartFormPage(driver);
		cartFormPage.verifyCartFormPageElements();
		log.info("Cart Form page elements verified successfully");
		cartFormPage.getCheckoutButton().click();
		log.debug("Clicked Checkout Button");
		
		//verify checkout page with test data from excel
		excelDataDriven d = new excelDataDriven();
		ArrayList<String> data = d.getData("CheckoutValidation");
		
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.verifyCheckoutFormPageElements();
		log.info("Checkout page elements verified successfully");
		
		//assert you can't place the order without card data
		Assert.assertFalse(checkoutPage.getPlaceOrderButton().isEnabled());
		log.info("Place Order Button is disabled");
		
		//add credit card data
		checkoutPage.getCreditCardNumber().sendKeys(data.get(1));
		checkoutPage.getCreditCardExpiration().sendKeys(data.get(2));
		checkoutPage.getCreditCardCvv().sendKeys(data.get(3));
		checkoutPage.getCreditCardName().sendKeys(data.get(4));
		checkoutPage.getAddressCountry().sendKeys(data.get(5));
		checkoutPage.getAddressLine().sendKeys(data.get(6));
		checkoutPage.getAddressZipCode().sendKeys(data.get(7));
		checkoutPage.getAddressCity().sendKeys(data.get(8));
		checkoutPage.getMobileNumber().sendKeys(data.get(9));
		
		//assert you can place order now, save card data and click place order
		Assert.assertTrue(checkoutPage.getPlaceOrderButton().isEnabled());
		log.info("Place Order Button is enabled");
		checkoutPage.getSaveAndContinueButton().click();
		checkoutPage.getPlaceOrderButton().click();
		log.debug("Clicked Place Order Button");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
