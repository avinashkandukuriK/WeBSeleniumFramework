package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductListPage {

	public WebDriver driver;
	
	private By productGrid = By.xpath("//div[@data-component-title='Product Grid']");
	private By facetCardsContainer = By.xpath("//div[@data-test='facetCardsContainer']");
	private By resultsHeader = By.xpath("//h2[@data-test='resultsHeading']");
	private By seoPaginationLink = By.xpath("//a[@data-test='seo-pagination-link']");
	private By productItem = By.xpath("//div[@data-test='@web/ProductCard/ProductCardVariantDefault']");
	
	public ProductListPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickProduct(int number) {
		driver.findElements(productItem).get(number).click();
	}
	
	public void verifyProductListPageElements() {
		Assert.assertTrue(driver.findElement(productGrid).isDisplayed());
		Assert.assertTrue(driver.findElement(facetCardsContainer).isDisplayed());
		Assert.assertTrue(driver.findElement(resultsHeader).isDisplayed());
		Assert.assertTrue(driver.findElement(seoPaginationLink).isDisplayed());
		Assert.assertTrue(driver.findElement(facetCardsContainer).isDisplayed());
		Assert.assertTrue(driver.findElements(productItem).size()>0);
	}

}
