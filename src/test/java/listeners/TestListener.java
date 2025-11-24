package listeners;

import base.WebDriverProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.*;
import utils.ScreenshotUtils;
import reporting.*;

import java.lang.reflect.Method;

public class TestListener implements ITestListener,ISuiteListener {
    

    @Override
    public void onStart(ISuite suite){
    	ExtentManager.initRunFolder();
    	ExtentManager.getExtentReports();
    }

    @Override
    public void onFinish(ISuite suite){
        ExtentManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult result){
        Method method =result.getMethod().getConstructorOrMethod().getMethod();
        String testName = method.getName();
        ExtentTestManager.setTest(ExtentManager.getExtentReports().createTest(testName));
        ExtentTestManager.getTest().log(Status.INFO, "Test started: "+ testName);
    }

    @Override
    public void onTestSuccess(ITestResult result){
        ExtentTestManager.getTest().log(Status.PASS,"Test passed");
        ExtentTestManager.removeTest();
    }

    @Override
    public void onTestFailure(ITestResult result){
        Object currentClass = result.getInstance();
        String path = null;
        try{
            //BaseTest stores driver in protected field 'driver'
            WebDriverProvider provider = (WebDriverProvider) currentClass;
            if(provider !=null && provider.getDriver() !=null) {
            	String runFolder = ExtentManager.getRunFolder();
            	path = ScreenshotUtils.takeScreenshot(provider.getDriver(), result.getMethod().getMethodName(), runFolder);
            	if(path!=null) {
            		ExtentTestManager.getTest().addScreenCaptureFromPath(path);
            	} else {
            		ExtentTestManager.getTest().log(Status.WARNING, "Screenshot path was null");
            	}
            } else {
            	ExtentTestManager.getTest().log(Status.WARNING, "Webdriver not available for screenshot");
            }
        } catch(ClassCastException e){
        	ExtentTestManager.getTest().log(Status.WARNING, "Test instance does not implement WebDriverProvider");
        } catch(Exception e) {
        	ExtentTestManager.getTest().log(Status.WARNING, "Failed to capture screenshot: " + e.getMessage());
        }
        ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());
        ExtentTestManager.removeTest();
        
    }

    @Override
    public void onTestSkipped(ITestResult result){
        ExtentTestManager.getTest().log(Status.SKIP,"Test skipped");
        ExtentTestManager.removeTest();
    }

    @Override public void onTestFailedButWithinSuccessPercentage(ITestResult result){}
    @Override public void onStart(ITestContext context){}
    @Override public void onFinish(ITestContext context) {}
}
