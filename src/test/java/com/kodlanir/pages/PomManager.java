package com.kodlanir.pages;


import com.kodlanir.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class PomManager extends Annotations{

    private Homepage homepage;
    private RegisterPage registerPage;
    private SuccessPage successPage;

    public Homepage getHomepage() {

        return homepage == null ? new Homepage() : homepage;
    }

    public RegisterPage getRegisterPage() {

        return registerPage == null ? new RegisterPage() : registerPage;
    }

    public SuccessPage getSuccessPage() {

        return successPage == null ? new SuccessPage() : successPage;
    }
}
