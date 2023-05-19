package com.kodlanir.tests;

import com.kodlanir.listeners.Retry;
import com.kodlanir.pages.PomManager;
import com.kodlanir.utils.BrowserUtils;
import com.kodlanir.utils.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends PomManager {

    @Test(retryAnalyzer = Retry.class) //retryAnalyzer = Retry.class
    public void retryDummyTest()
    {
        System.out.println("This is dummy test for retry");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = {"registerPositive"})
    public void loginPositiveTest() {

        landingLoginPage();
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertTrue(driver.getCurrentUrl().contains("account/login"));
        getLoginPage().email.sendKeys(Config.getProperty("email"));
        getLoginPage().password.sendKeys(Config.getProperty("password"));

        getLoginPage().loginBtn.click();

        // logout test
        BrowserUtils.mouseHover(getAccountPage().myAccountMenuLink);

        BrowserUtils.waitForVisibility(getAccountPage().myAccountPopup, 3);
        getAccountPage().logoutMenu.click();

        BrowserUtils.waitForVisibility(getAccountPage().logoutMsg, 5);

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("logout"));
    }

    @Test // enabled = false
    public void loginNegativeTest() {
        landingLoginPage();
        getLoginPage().email.sendKeys("randomemail@gmail.com");
        getLoginPage().password.sendKeys("RandomPassword.");
        getLoginPage().loginBtn.click();

        BrowserUtils.waitForVisibility(getLoginPage().errorMessage, 3);
        Assert.assertTrue(getLoginPage().errorMessage.getText().contains("No match for E-Mail Address and/or Password"));

    }



    public void landingLoginPage() {
        driver.get(Config.getProperty("baseUrl"));
        BrowserUtils.mouseHover(getHomepage().myAccountMenu);
        BrowserUtils.waitForVisibility(getHomepage().myAccountPopupMenu, 3);
        getHomepage().loginOpt.click();

    }
}
