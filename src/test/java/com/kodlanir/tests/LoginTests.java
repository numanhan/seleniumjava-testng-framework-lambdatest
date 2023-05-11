package com.kodlanir.tests;

import com.kodlanir.pages.PomManager;
import com.kodlanir.utils.BrowserUtils;
import com.kodlanir.utils.Config;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends PomManager {

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
        //Actions actions = new Actions(driver);
        //actions.moveToElement(getAccountPage().myAccountMenuLink).build().perform();

        BrowserUtils.waitForVisibility(getAccountPage().myAccountPopup, 3);
        getAccountPage().logoutMenu.click();

        BrowserUtils.waitForVisibility(getAccountPage().logoutMsg, 5);

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("logout"));
        driver.get(Config.getProperty("baseUrl"));
    }

    @Test(enabled = false)
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
        Actions actions = new Actions(driver);
        actions.moveToElement(getHomepage().myAccountMenu).build().perform();
        BrowserUtils.waitForVisibility(getHomepage().myAccountPopupMenu, 3);
        getHomepage().loginOpt.click();

    }
}
