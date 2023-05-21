package com.kodlanir.pagesfactory;

import com.kodlanir.utils.Config;
import com.kodlanir.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Annotations {
    public static WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {

        driver = Driver.getDriver();

    }


    @AfterMethod(enabled = false)
    public void afterMethod() {

        driver.get(Config.getProperty("baseUrl"));
    }

    @AfterTest
    public void afterTest()
    {

        Driver.closeDriver();
    }
}
