package com.kodlanir.tests;

import com.kodlanir.pagesfactory.PomManager;
import com.kodlanir.utils.BrowserUtils;
import com.kodlanir.utils.Config;
import io.qameta.allure.Description;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class E2ETests extends PomManager {
    @Test(priority = 1, description = "E2E Test from homepage to addToCart")
    public void addToCart() {
        driver.get(Config.getProperty("baseUrl"));
        getHomepage().shopByCategoryMenuLink.click();

        BrowserUtils.waitForVisibility(getHomepage().shopCategoriesLeftMenu, 6);

        getHomepage().componentCategory.click();
        //category-component page
        BrowserUtils.waitForVisibility(getCategoryProductPage().listOfCardProducts.get(0), 20);
        //kodlar
        WebElement instockChck = getCategoryProductPage().inStockCheck;

        BrowserUtils.clickWithJS(instockChck);
        BrowserUtils.scrollToElement(getCategoryProductPage().categoryName);

        BrowserUtils.waitFor(2);

        BrowserUtils.waitForVisibility(getCategoryProductPage().productImages.get(0), 20);

        WebElement firstElement = getCategoryProductPage().listOfCardProducts.get(0);

        String firstTitle = getCategoryProductPage().productTitles.get(0).getText();
        String firstPrice = getCategoryProductPage().productPrices.get(0).getText();

        //String[] firstProduct = {firstTitle, firstPrice};

        BrowserUtils.mouseHover(firstElement);

        BrowserUtils.waitForVisibility(getCategoryProductPage().miniProductSliders.get(0), 4);

        // selenium.StaleElementReferenceException: stale element reference: stale element not found
        staleElementErrorClick(getCategoryProductPage().addToCartBtns.get(0));

        BrowserUtils.waitForVisibility(getCategoryProductPage().toastPopup.get(0), 4);


        BrowserUtils.mouseHover(getCategoryProductPage().listOfCardProducts.get(2)); // thirdProduct
        WebElement thirdElement = getCategoryProductPage().listOfCardProducts.get(2);

        BrowserUtils.waitForVisibility(getCategoryProductPage().miniProductSliders.get(2), 4);

        staleElementErrorClick(getCategoryProductPage().addToCartBtns.get(2));

        List<WebElement> toastPopup = getCategoryProductPage().toastPopup;

        // TODO message niye eksik geliyor, sebebini bulamadim. Karakter siniri mi var
        String message = "actual result : " + toastPopup.size() + " expected result : != 1";
        Assert.assertTrue(toastPopup.size() >= 1, message);


    }

    public void staleElementErrorClick(WebElement element) {
        try {
            BrowserUtils.clickWithJS(element);
        } catch (StaleElementReferenceException e) {
            element.click();
        }
    }
}
