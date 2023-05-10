package com.kodlanir.tests;


import com.kodlanir.pages.PomManager;
import com.kodlanir.utils.BrowserUtils;
import com.kodlanir.utils.Config;
import com.kodlanir.utils.ExcelUtils;
import com.kodlanir.utils.JsonUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;


public class RegisterTests extends PomManager {
    String url = Config.getProperty("baseUrl");

    public void landingRegisterPage() {

        driver.get(url);

        Assert.assertTrue(driver.getCurrentUrl().contains(url));

        Actions act = new Actions(driver);

        act.moveToElement(getHomepage().myAccountMenu).build().perform();
        WebElement popupMenu = getHomepage().myAccountPopupMenu;

        BrowserUtils.waitForVisibility(popupMenu, 5);
        getHomepage().registerOpt.click();

        // wait
        BrowserUtils.waitForPageToLoad(10);
    }

    @Test
    public void registerPositive() {
        landingRegisterPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("account/register"));
        String randomEmail = BrowserUtils.generateAnEmail();
        String password = "12345.+";

        getRegisterPage().firstName.sendKeys("Esma");
        getRegisterPage().lastName.sendKeys("Yilmaz");
        getRegisterPage().email.sendKeys(randomEmail);
        Config.setProperty("email", randomEmail);
        getRegisterPage().phone.sendKeys("32142345656");
        getRegisterPage().password.sendKeys(password);
        getRegisterPage().rePassword.sendKeys(password);

        Config.setProperty("password", password);

        getRegisterPage().chckTerm.click();
        getRegisterPage().continueBtn.click();

        Assert.assertEquals(getSuccessPage().successText.getText(), "Your Account Has Been Created!");
        // Mevcut durumun korunmasi ilkesi geregi eklenen account un silinmesi gerekiyor ama bu sitede o
        // secenek yok.
        getSuccessPage().logoutBtn.click();
        driver.get(url);
    }


    @Test(dataProvider = "getAllRegisterDataFromCsv", enabled = false)
    public void negativeTests1(String firstName, String lastName, String email, String phone, String password, String passConfirm, String warnMessg) {
        landingRegisterPage();


        Assert.assertTrue(driver.getCurrentUrl().contains("account/register"));

        getRegisterPage().firstName.sendKeys(firstName);
        getRegisterPage().lastName.sendKeys(lastName);
        getRegisterPage().email.sendKeys(email);
        getRegisterPage().phone.sendKeys(phone);
        getRegisterPage().password.sendKeys(password);
        getRegisterPage().rePassword.sendKeys(passConfirm);

        getRegisterPage().chckTerm.click();
        getRegisterPage().continueBtn.click();

        String text = null;

        if (firstName.isEmpty()) {
            text = getRegisterPage().firstNameWarning.getText();
        } else if (lastName.isEmpty()) {
            text = getRegisterPage().lastNameWarning.getText();
        } else if (email.isEmpty()) {
            text = getRegisterPage().emailWarning.getText();
        } else if (phone.isEmpty()) {
            text = getRegisterPage().phoneWarning.getText();
        } else if (password.isEmpty()) {
            text = getRegisterPage().passwordWarning.getText();
        } else if (passConfirm.isEmpty()) {
            text = getRegisterPage().repasswordWarning.getText();
        }
        Assert.assertTrue(warnMessg.contains(text));

        driver.get(url);

    }

    @Test(enabled = false)
    public void registerWithExistingMail() {
        landingRegisterPage();
        String email = Config.getProperty("email");
        getRegisterPage().email.sendKeys(email);
        getRegisterPage().password.sendKeys(Config.getProperty("password"));
        getRegisterPage().chckTerm.click();
        getRegisterPage().continueBtn.click();
        WebElement alert = getRegisterPage().alertMessage;
        BrowserUtils.waitForVisibility(alert, 3);
        Assert.assertTrue(alert.getText().contains("E-Mail Address is already registered"));

    }


    @DataProvider
    public Object[][] getAllRegisterDataFromCsv() {

        Object[][] data = ExcelUtils.getCsvData("registeruser.csv", ",");
        // [[us1, pass1], [us2, pass2], [us3, pass3]]
        return data;

    }

    @Test(dataProvider = "getAllRegisterDataFromExcel", enabled = false)
    public void negativeTests2(String firstName, String lastName, String email, String phone, String password, String passConfirm, String warnMessg) {

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

        getRegisterPage().firstName.sendKeys(firstName);
        getRegisterPage().lastName.sendKeys(lastName);
        getRegisterPage().email.sendKeys(email);
        getRegisterPage().phone.sendKeys(phone);
        getRegisterPage().password.sendKeys(password);
        getRegisterPage().rePassword.sendKeys(passConfirm);


    }

    @DataProvider
    public Object[][] getAllRegisterDataFromExcel() //All Rows
    {

        Object[][] liste = ExcelUtils.getDataAllRows("registeruser.xlsx", "pair");
        // [[us1, pass1], [us2, pass2], [us3, pass3]]

        return liste;

    }

    @Test(dataProvider = "getAllRegisterDataFromExcel", enabled = false)
    public void negativeTests3(String firstName, String lastName, String email, String phone, String password, String passConfirm, String warnMessg) {

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

        getRegisterPage().firstName.sendKeys(firstName);
        getRegisterPage().lastName.sendKeys(lastName);
        getRegisterPage().email.sendKeys(email);
        getRegisterPage().phone.sendKeys(phone);
        getRegisterPage().password.sendKeys(password);
        getRegisterPage().rePassword.sendKeys(passConfirm);


    }




}
