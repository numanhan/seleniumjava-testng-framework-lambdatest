package com.kodlanir.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Base{

    @FindBy(xpath = "(//*[contains(text(),'My account')])[2]")
    public WebElement myAccountMenu;

    @FindBy(css = "ul.mz-sub-menu-96")
    public WebElement myAccountPopupMenu;

    @FindBy(css = "a[href*='account/login']")
    public WebElement loginOpt;

    @FindBy(css = "a[href*='account/register']")
    public WebElement registerOpt;

    @FindBy(xpath = "(//a[@aria-label='Shop by Category' and @href='#mz-component-1626147655'])[2]")
    public WebElement shopByCategoryMenuLink;

    @FindBy(css = "div#mz-component-1626147655")
    public WebElement shopCategoriesLeftMenu;

    @FindBy(xpath = "//span[contains(text(), 'Components')]/../..")
    public WebElement componentCategory;




}
