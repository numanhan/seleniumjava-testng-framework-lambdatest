package com.kodlanir.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Base{

    @FindBy(id = "input-firstname")
    public WebElement firstName;

    @FindBy(id = "input-lastname")
    public WebElement lastName;

    @FindBy(id = "input-email")
    public WebElement email;

    @FindBy(id = "input-telephone")
    public WebElement phone;

    @FindBy(id = "input-password")
    public WebElement password;

    @FindBy(id = "input-confirm")
    public WebElement rePassword;

    @FindBy(css = "div.custom-checkbox")
    public WebElement chckTerm;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueBtn;


}
