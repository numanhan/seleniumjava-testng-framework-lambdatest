package com.kodlanir.tests;


import com.github.javafaker.Faker;
import com.kodlanir.pages.PomManager;
import com.kodlanir.utils.BrowserUtils;
import com.kodlanir.utils.Config;
import com.kodlanir.utils.ExcelUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class RegisterTests extends PomManager {
    @Test
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

        String randomEmail = BrowserUtils.generateAnEmail();

        getRegisterPage().firstName.sendKeys("Esma");
        getRegisterPage().lastName.sendKeys("Yilmaz");
        getRegisterPage().email.sendKeys(randomEmail);
        getRegisterPage().phone.sendKeys("32142345656");
        getRegisterPage().password.sendKeys("12345.+");
        getRegisterPage().rePassword.sendKeys("12345.+");

        getRegisterPage().chckTerm.click();
        getRegisterPage().continueBtn.click();

        Assert.assertEquals(getSuccessPage().successText.getText(), "Your Account Has Been Created!");
        // Mevcut durumun korunmasi ilkesi geregi eklenen account un silinmesi gerekiyor ama bu sitede o
        // secenek yok.
        driver.get(url);
    }

    @Test(dataProvider = "getAllRegisterDataFromCsv")
    public void negativeTests1(String firstName,String lastName,String email,String phone,String password,String passConfirm, String warnMessg)
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

        getRegisterPage().firstName.sendKeys(firstName);
        getRegisterPage().lastName.sendKeys(lastName);
        getRegisterPage().email.sendKeys(email);
        getRegisterPage().phone.sendKeys(phone);
        getRegisterPage().password.sendKeys(password);
        getRegisterPage().rePassword.sendKeys(passConfirm);

        getRegisterPage().chckTerm.click();
        getRegisterPage().continueBtn.click();

    }

    @DataProvider
    public Object[][] getAllRegisterDataFromCsv()
    {

        Object[][] data = ExcelUtils.getCsvData("registeruser.csv", ",");
        // [[us1, pass1], [us2, pass2], [us3, pass3]]
        return data;

    }

    @Test(dataProvider = "getAllRegisterDataFromExcel")
    public void negativeTests2(String firstName,String lastName,String email,String phone,String password,String passConfirm, String warnMessg)
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

        Object[][] liste = ExcelUtils.getDataAllRows("registeruser.xlsx","pair");
        // [[us1, pass1], [us2, pass2], [us3, pass3]]

        return liste;

    }


}
