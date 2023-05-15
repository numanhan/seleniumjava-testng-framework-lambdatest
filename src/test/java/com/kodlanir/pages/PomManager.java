package com.kodlanir.pages;


public class PomManager extends Annotations {

    private Homepage homepage;
    private RegisterPage registerPage;
    private SuccessPage successPage;
    private LoginPage loginPage;

    private AccountPage accountPage;

    private CategoryProductPage categoryProductPage;

    public Homepage getHomepage() {

        return homepage == null ? new Homepage() : homepage;
    }

    public RegisterPage getRegisterPage() {

        return registerPage == null ? new RegisterPage() : registerPage;
    }

    public SuccessPage getSuccessPage() {

        return successPage == null ? new SuccessPage() : successPage;
    }

    public LoginPage getLoginPage() {
        return loginPage == null ? new LoginPage() : loginPage;
    }

    public AccountPage getAccountPage() {
        return accountPage == null ? new AccountPage() : accountPage;
    }

    public CategoryProductPage getCategoryProductPage() {
        return categoryProductPage == null ? new CategoryProductPage() : categoryProductPage;
    }

}
