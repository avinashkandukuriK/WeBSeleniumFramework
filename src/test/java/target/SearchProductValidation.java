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
import pageObjects.ProductListPage;
import resources.base;
import resources.excelDataDriven;

public class SearchProductValidation extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = intializeDriver();
	}
	
	@Test(groups={"Smoke"})
	public void searchProductFunctionality() throws InterruptedException, IOException {
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		excelDataDriven d = new excelDataDriven();
		ArrayList<String> data = d.getData("SearchProductValidation");
		
		//go to landing page, perform search and verify product list page elements
		LandingPage landingPage = new LandingPage(driver);
		landingPage.verifyLandingPageElements();
		landingPage.performSearch(data.get(1));
		Thread.sleep(3000);
		ProductListPage plPage = new ProductListPage(driver);
		plPage.verifyProductListPageElements();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
