package com.kodlanir.pages;

import com.kodlanir.pagesfactory.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Base {

    @FindBy(xpath = "(//span[contains(text(),'My account')])[2]")
    public WebElement myAccountMenuLink;

    @FindBy(css = "ul.mz-sub-menu-96")
    public WebElement myAccountPopup;

    @FindBy(xpath = "//span[contains(text(), 'Logout')]/../..")
    public WebElement logoutMenu;

    @FindBy(xpath = "//h1")
    public WebElement logoutMsg;

}
