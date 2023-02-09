package resources;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listeners extends base implements ITestListener {
	private static ExtentReports extent = ExtentReportManager.createInstance();
	ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public static Logger log = LogManager.getLogger(Listeners.class.getName());
	
    @Override		
    public void onTestStart(ITestResult result) {					
    	ExtentTest test = extent.createTest(result.getClass().getName() + " :: " + result.getMethod().getMethodName());
    	extentTest.set(test);
    }
	
	@Override		
    public void onFinish(ITestContext arg0) {					
		if (extent !=null) {
			extent.flush();	
		}
    }		

    @Override		
    public void onStart(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
        // TODO Auto-generated method stub				
        		
    }		

    @Override		
    public void onTestFailure(ITestResult result) {					
    	extentTest.get().fail(result.getThrowable());
    	WebDriver driver = null;
    	String testMethodName = result.getMethod().getMethodName();
    	
    	try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
    	{
			
    	}
    	try {
    		extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			extentTest.get().fail("Test failed, cannot attach screenshot");
			log.error("Test failed, cannot attach screenshot");
		}
    	
    	String logText = "<b> Test Method " + testMethodName + "Failed</b>";
    	Markup m = (Markup) MarkupHelper.createLabel(logText, ExtentColor.RED);
    	extentTest.get().log(Status.FAIL, m);
    	log.error("Test failed....Attention! Test name: " +result.getName());
    }		

    @Override		
    public void onTestSkipped(ITestResult result) {					
    	String logText = "<b> Test Method " + result.getMethod().getMethodName() + " Skipped<b>";
    	Markup m = (Markup) MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
    	extentTest.get().log(Status.SKIP, m);		
    }		

    @Override		
    public void onTestSuccess(ITestResult result) {					
    	String logText = "<b> Test Method " + result.getMethod().getMethodName() + " Successfull<b>";
    	Markup m = (Markup) MarkupHelper.createLabel(logText, ExtentColor.GREEN);
    	extentTest.get().log(Status.PASS, m);
    }		

}
