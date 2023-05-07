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




}
