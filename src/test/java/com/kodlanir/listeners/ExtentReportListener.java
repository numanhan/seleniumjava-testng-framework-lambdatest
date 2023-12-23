package com.kodlanir.listeners;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.kodlanir.utils.Log;
import com.kodlanir.utils.OutUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.kodlanir.pagesfactory.Annotations.driver;


public class ExtentReportListener implements ITestListener { // extends OutUtils

    ExtentReports extent = OutUtils.getExtentReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();


    @Override
    public void onStart(ITestContext context) {
       context.setAttribute("WebDriver",driver);
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test = extent.createTest(result.getMethod().getMethodName()); // test name
        extentTest.set(test);
        Log.info("Testname : " + result.getName() + " started.");
        //extentTest.get().log(Status.WARNING, "Testcase description : " + result.getMethod().getDescription() );
        extentTest.get().log(Status.INFO, result.getMethod().getMethodName() + " testcase is started.");
    }

    @Override
    public void onTestSuccess(ITestResult result) { // public synchronized void
        Log.info("Testname : " + result.getName() + " successed.");
        extentTest.get().log(Status.PASS, "Test passed successfully..");
        extentTest.get().assignCategory("Success"); // Category ekleme

    }

    @Override
    public void onTestFailure(ITestResult result) {

        Log.info("On Test Failure : " + result.getName());
        extentTest.get().log(Status.FAIL, result.getMethod().getMethodName()+ " testcase is failed");
        String testName = result.getMethod().getMethodName();
        String destFilePath = OutUtils.takeScreenShotPage(testName);
        extentTest.get().fail(result.getThrowable());
        extentTest.get().addScreenCaptureFromPath(destFilePath, testName);

        // for full page ss
        //String destFullFilePath = OutUtils.takeFullScreenshot(testName);
        //extentTest.get().addScreenCaptureFromPath(destFullFilePath, testName);

        extentTest.get().assignCategory("Failed"); // assignAuthor

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("On Test Skipped : " + result.getName());
        extentTest.get().log(Status.SKIP, result.getMethod().getMethodName() + " testcase skipped..");
        extentTest.get().assignCategory("Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        if (extent != null) {
            extent.flush(); // NullPointerException ? Acaba tum suite bitince mi flush yapmak gerekiyor, flaky
        }
    }

}

/*
	- TestNg de Listeners methodlarının içinden bir classtaki variable a erişmenin uzun bir yolu var :
		result.getTestClass().getRealClass().getDeclaredField("fieldName").get(result.getInstance());
		Yani :
		result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
 */
