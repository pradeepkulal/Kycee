package org.intuitiveapps.Kycee.TestComponents;

import java.io.IOException;

import org.intuitiveapps.Kycee.Resources.ExtentReporterNG;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;


public class Listeners extends BaseTest implements ITestListener {
	ExtentTest test;
	  @Override
	    public void onTestStart(ITestResult result) {
		  ExtentReporterNG.logTestStart(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	ExtentReporterNG.logTestSuccess(result.getMethod().getMethodName());
	    }
	    
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReporterNG.logTestFailure(result.getMethod().getMethodName(), result.getThrowable());
		try {
			   driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
      
        String dest = null;
        try {
            dest = getScreenShot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ExtentReporterNG.addScreenCapture(dest, result.getMethod().getMethodName());

	}
	
	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onFinish(ITestContext result) {
		ExtentReporterNG.flushReports();
	}
}