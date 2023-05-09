package com.kodlanir.tests;

import com.kodlanir.pages.PomManager;
import com.kodlanir.utils.BrowserUtils;
import com.kodlanir.utils.Config;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends PomManager {

    @Test(dependsOnMethods = {"registerPositive"})
    public void loginPositiveTest()
    {
        driver.get(Config.getProperty("baseUrl"));
        Actions actions = new Actions(driver);
        actions.moveToElement(getHomepage().myAccountMenu).build().perform();
        BrowserUtils.waitForVisibility(getHomepage().myAccountPopupMenu, 3);
        getHomepage().loginOpt.click();

        BrowserUtils.waitForPageToLoad(5);

        Assert.assertTrue(driver.getCurrentUrl().contains("account/login"));

        getLoginPage().email.sendKeys(Config.getProperty("email"));
        getLoginPage().password.sendKeys(Config.getProperty("password"));

        getLoginPage().loginBtn.click();
    }
}
