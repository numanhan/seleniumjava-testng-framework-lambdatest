package com.kodlanir.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryProductPage extends Base {

    @FindBy(css = "h1.h4")
    public WebElement categoryName; //Components

    @FindBy(xpath = "(//label[text()='In stock'])[2]")
    public WebElement inStockCheck;

    @FindBy(css = "div.product-thumb")
    public List<WebElement> listOfCardProducts;

    @FindBy(css = "div.product-thumb h4")
    public List<WebElement> productTitles;

    @FindBy(css = "div.product-thumb div.price")
    public List<WebElement> productPrices;

    @FindBy(css = "div.product-action")
    public List<WebElement> miniProductSliders;

    @FindBy(xpath = "//button[@title='Add to Cart']")
    public List<WebElement> addToCartBtns;

    @FindBy(css = "div.toast.m-3.fade")
    public List<WebElement> toastPopup;




}
