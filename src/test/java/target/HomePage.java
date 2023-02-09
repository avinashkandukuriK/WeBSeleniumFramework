package target;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = intializeDriver();
	}
	
	@Test(groups={"Smoke"}, dataProvider="getUserData")
	public void basePageNavigation(String username, String password, String text) throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		LandingPage landingPage = new LandingPage(driver);
		
		//go to landing page, verify basic elements and signin
		landingPage.verifyLandingPageElements();
		log.info("Landing page elements verified successfully");
		landingPage.getLogin();
		Thread.sleep(2000);
		landingPage.getAccountSignin().click();
		log.debug("Clicked on signin link");
		
		//go to login page, verify elements and try to signin
		LoginPage loginPage = new LoginPage(driver);
		loginPage.verifyLoginPageElements();
		log.info("Login page elements verified successfully");
		loginPage.getEmail().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		
		//click on submit bitton and verify alert
		loginPage.getSubmitButton().click();
		log.debug("Clicked on submit button");
		loginPage.getAuthAlertDisplay().isDisplayed();
		log.info("Authentication alert is displayed");
		
		//click on forgot password, verify password reset and send code
		ForgotPasswordPage fpPage = loginPage.forgotPassword();
		fpPage.getSendCodeButton().click();
		log.debug("Clicked on send code button");
		fpPage.getPasswordReset().click();
		fpPage.getSendCodeButton().click();
	}
	
	@DataProvider
	public Object[][] getUserData()
	{
		Object[][] data = new Object[1][3];
		data[0][0] = "testuser1@mail.com";
		data[0][1] = "pswdt5421";
		data[0][2] = "Not valid user";
		
		return data;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
