package com.kodlanir.pages;

import com.kodlanir.pagesfactory.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends Base {

    @FindBy(tagName = "h1")
    public WebElement successText;

    @FindBy(xpath = "(//a[contains(@href,'account/logout')])[2]")
    public WebElement logoutBtn;
}
