package com.kodlanir.listeners;

import com.kodlanir.utils.Driver;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

import static io.qameta.allure.Allure.suite;


public class AllureReportListener2 implements TestLifecycleListener, ITestListener { // extends OutUtils



    @Override
    public void beforeTestStop(TestResult result) { // from TestLifecycleListener
        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.SKIPPED || result.getStatus() == Status.BROKEN) {
            if (Driver.getDriver() != null) {
                Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES)));
            }

        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onStart(ITestContext context) { // SUITE
        String suiteName = context.getSuite().getName(); // from TestNG.xml
        suite(suiteName); // testngxml den suite ismini okutabilir miyiz.

    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}

/*
	- TestNg de Listeners methodlarının içinden bir classtaki variable a erişmenin uzun bir yolu var :
		result.getTestClass().getRealClass().getDeclaredField("fieldName").get(result.getInstance());
		Yani :
		result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
 */
// Allure
/*
https://github.com/allure-framework/allure2/releases
Command line server ını pc ye indirip Advanced System Environment da "bin" folder ına kadar olan kismi
Path e ekle.
Sonra allure-reports folder ında cmd
    allure serve
ya da
    allure serve allure-reports
komutları ile açabilrsin.


 */

/**
 *
 *  @Attachment(value = "Failed test screenshot", type = "image/png")
 *     public static byte[] takeScreenshotToAttachOnAllureReport() {
 *         try {
 *             return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(BYTES);
 *         } catch (Exception ex) {
 *             ex.getMessage();
 *         }
 *         return new byte[0];
 *     }
 *
 *     @Attachment(value = "Take step screenshot", type = "image/png")
 *     public static byte[] takeScreenshotStep() {
 *         try {
 *             return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(BYTES);
 *         } catch (Exception ex) {
 *             ex.getMessage();
 *         }
 *         return new byte[0];
 *     }
 *
 *     @Attachment(value = "Browser Information", type = "text/plain")
 *     public static String addBrowserInformationOnAllureReport() {
 *         return Driver.getBrowserType();
 *     }
 *
 *
 *     //Text attachments for Allure
 *     @Attachment(value = "{0}", type = "text/plain")
 *     public static String saveTextLog(String message) {
 *         return message;
 *     }
 *
 *     //HTML attachments for Allure
 *     @Attachment(value = "{0}", type = "text/html")
 *     public static String attachHtml(String html) {
 *         return html;
 *     }
 */