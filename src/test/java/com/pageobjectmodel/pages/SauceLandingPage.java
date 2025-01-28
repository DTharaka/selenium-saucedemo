package com.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceLandingPage {
    private final WebDriver webDriver;

    private By title = By.cssSelector("span.title");

    public SauceLandingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getPageTitle() {
        return webDriver.findElement(title).getText().trim();
    }
}
