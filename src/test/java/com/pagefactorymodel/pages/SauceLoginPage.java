package com.pagefactorymodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLoginPage {

    private final WebDriver webDriver;

    @FindBy(id = "user-name")
    WebElement txtUsername;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "login-button")
    WebElement btnLogin;

    @FindBy(css = "h3[data-test='error']")
    WebElement msgError;

    public SauceLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    //Method Type 1
    /*
    public void typeUsername(String username) {
        txtUsername.sendKeys(username);
    }
    */

    public SauceLoginPage typeUsername(String username) {
        txtUsername.sendKeys(username);
        return this;
    }

    //Method Type 2
    public SauceLoginPage typePassword(String password) {
        txtPassword.sendKeys(password);
        return this;
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public SauceLoginPage clearUsername() {
        txtUsername.clear();
        return this;
    }

    public SauceLoginPage clearPassword() {
        txtPassword.clear();
        return this;
    }

    public String getError() {
        return msgError.getText().trim();
    }
}
