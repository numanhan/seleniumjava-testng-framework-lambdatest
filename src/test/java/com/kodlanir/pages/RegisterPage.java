package com.kodlanir.pages;

import com.kodlanir.pagesfactory.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Base {

    @FindBy(id = "input-firstname")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
    public WebElement firstNameWarning;

    @FindBy(id = "input-lastname")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
    public WebElement lastNameWarning;

    @FindBy(id = "input-email")
    public WebElement email;

    @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
    public WebElement emailWarning;

    @FindBy(id = "input-telephone")
    public WebElement phone;

    @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
    public WebElement phoneWarning;

    @FindBy(id = "input-password")
    public WebElement password;

    @FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
    public WebElement passwordWarning;

    @FindBy(id = "input-confirm")
    public WebElement rePassword;

    @FindBy(xpath = "//input[@id='input-confirm']/following-sibling::div")
    public WebElement repasswordWarning;

    @FindBy(css = "div.custom-checkbox")
    public WebElement chckTerm;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueBtn;

    @FindBy(css = "div.alert-danger")
    public WebElement alertMessage;


}
