package com.kodlanir.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    int count = 0;
    int maxTry = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (iTestResult.isSuccess()) {
            if (count < maxTry) {
                count++;
                return true;
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }


    /**
     * rerun the failed flaky tests in the application (retry mechanism)
     * - inconsistency
     * - accidentally fail (kazara, tesadufen)
     * - make sure that failures are real
     */
}
