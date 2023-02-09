package target;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.ProductFormPage;
import pageObjects.ProductListPage;
import resources.Utilities;
import resources.base;
import resources.excelDataDriven;

public class ProductValidation extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(ProductValidation.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = intializeDriver();
	}
	
	@Test(groups={"Smoke"})
	public void productFormValidation() throws InterruptedException, IOException {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Utilities utils = new Utilities(driver);
		excelDataDriven d = new excelDataDriven();
		ArrayList<String> data = d.getData("SearchProductValidation");
		
		//go to landing page and search for product
		LandingPage landingPage = new LandingPage(driver);
		landingPage.performSearch(data.get(1));
		Thread.sleep(3000);
		
		//verify product list page
		ProductListPage plPage = new ProductListPage(driver);
		plPage.verifyProductListPageElements();
		log.info("Product List page elements verified successfully");
		
		//click product and verify product page
		plPage.clickProduct(1);
		ProductFormPage pfPage = new ProductFormPage(driver);
		pfPage.verifyProductFormPageElements();
		log.info("Product Form page elements verified successfully");
		utils.scrollToElement(pfPage.getProductDetails());
		pfPage.getProductDetails().isDisplayed();
		log.info("Product details displayed successfully");
		utils.scrollToElement(pfPage.getProductTitle());
		
		//add product to cart
		pfPage.getAddtoCartButton().click();
		log.debug("Clicked add to cart button");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
