package com.kodlanir.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends Base{

    @FindBy(tagName = "h1")
    public WebElement successText;
}
