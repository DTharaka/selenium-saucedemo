package com.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceLoginPage {

    private final WebDriver webDriver;

    private final By txtUsername = By.id("user-name");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.id("login-button");
    private final By msgError = By.cssSelector("h3[data-test='error']");

    public SauceLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Method Type 1
    /*
    public void typeUsername(String username) {
        txtUsername.sendKeys(username);
    }
    */

    public SauceLoginPage typeUsername(String username) {
        webDriver.findElement(txtUsername).sendKeys(username);
        return this;
    }

    //Method Type 2
    public SauceLoginPage typePassword(String password) {
        webDriver.findElement(txtPassword).sendKeys(password);
        return this;
    }

    public void clickLogin() {
        webDriver.findElement(btnLogin).click();
    }

    public SauceLoginPage clearUsername() {
        webDriver.findElement(txtUsername).clear();
        return this;
    }

    public SauceLoginPage clearPassword() {
        webDriver.findElement(txtPassword).clear();
        return this;
    }

    public String getError() {
        return webDriver.findElement(msgError).getText().trim();
    }
}
