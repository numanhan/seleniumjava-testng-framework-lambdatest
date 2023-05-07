package com.kodlanir.tests;

import com.kodlanir.pages.PomManager;
import com.kodlanir.utils.BrowserUtils;
import com.kodlanir.utils.Config;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterTests extends PomManager {

    @Test()
    public void registerPositive()
    {
        String url = Config.getProperty("baseUrl");
        driver.get(url);

        Assert.assertTrue(driver.getCurrentUrl().contains(url));

        Actions act = new Actions(driver);

        act.moveToElement(getHomepage().myAccountMenu).build().perform();
        WebElement popupMenu = getHomepage().myAccountPopupMenu;

        BrowserUtils.waitForVisibility(popupMenu, 5);
        getHomepage().registerOpt.click();

        // wait
        BrowserUtils.waitForPageToLoad(10);

        Assert.assertTrue(driver.getCurrentUrl().contains("account/register"));

        getRegisterPage().firstName.sendKeys("Esma");
        getRegisterPage().lastName.sendKeys("Yilmaz");
        getRegisterPage().email.sendKeys("esmayyx@gmail.com");
        getRegisterPage().phone.sendKeys("32142345656");
        getRegisterPage().password.sendKeys("12345.+");
        getRegisterPage().rePassword.sendKeys("12345.+");

        getRegisterPage().chckTerm.click();
        getRegisterPage().continueBtn.click();

        Assert.assertEquals(getSuccessPage().successText.getText(), "Your Account Has Been Created!");

    }


}
