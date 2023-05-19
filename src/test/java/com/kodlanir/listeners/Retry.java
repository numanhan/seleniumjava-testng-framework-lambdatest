package com.kodlanir.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    int count = 0;
    int maxTry = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < maxTry) {
            count++;
            return true;
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
