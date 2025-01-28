package com.pagefactorymodel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLandingPage {
    private final WebDriver webDriver;

    @FindBy(css = "span.title")
    WebElement title;

    public SauceLandingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
    }

    public String getPageTitle() {
        return title.getText().trim();
    }
}
