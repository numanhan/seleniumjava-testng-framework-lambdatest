package com.kodlanir.pages;

import com.kodlanir.pagesfactory.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base {

    @FindBy(id = "input-email")
    public WebElement email;

    @FindBy(id = "input-password")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginBtn;

    @FindBy(css = "div.alert-danger")
    public WebElement errorMessage;
}
