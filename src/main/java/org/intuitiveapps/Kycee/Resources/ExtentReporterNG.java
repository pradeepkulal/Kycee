package org.intuitiveapps.Kycee.Resources;

import org.intuitiveapps.Kycee.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.Status;

public class ExtentReporterNG {
	public static ExtentReports getReporterObject() {
		//ExtentReports, ExtentSparkReporter
				ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\index.html");
				reporter.config().setReportName("Assesment Test");
				reporter.config().setDocumentTitle("Extent reports");
				ExtentReports extent = new ExtentReports();
				extent.attachReporter(reporter);
				extent.setSystemInfo("Tester Name", "Pradeep1");
				return extent;
	}
	
	private static ExtentReports extent = ExtentReporterNG.getReporterObject();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    public static void logTestStart(String methodName) {
        ExtentTest test = extent.createTest(methodName);
        extentTest.set(test);
    }

    public static void logTestSuccess(String methodName) {
        extentTest.get().log(Status.PASS, methodName + " Test is Passed");
    }

    public static void logTestFailure(String methodName, Throwable throwable) {
        extentTest.get().fail(throwable);
    }

    public static void addScreenCapture(String path, String methodName) {
        extentTest.get().addScreenCaptureFromPath(path, methodName);
    }

    public static void flushReports() {
        extent.flush();
    }

	public static void logError(WebElement eleName, String actualResult,String expectedResult) {
		extentTest.get().fail(eleName.getText() +" Actual Result: " + actualResult +" Expected Result: " + expectedResult);
		String path = System.getProperty("user.dir")+ "\\ScreenShots\\" + eleName.getText().concat(AbstractComponents.getCurrentTimeInString()) + ".png";
		AbstractComponents.takeScreenShot(eleName, path);
		extentTest.get().addScreenCaptureFromPath(path);
	}
}
