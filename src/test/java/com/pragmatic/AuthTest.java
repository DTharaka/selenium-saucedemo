package com.pragmatic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthTest {
    private WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }

    @Test
    public void testBasicAut() {

        //Navigate to the url
        webDriver.get("https://the-internet.herokuapp.com/basic_auth");

        //Validate the success message
        String pageSource = webDriver.getPageSource();
        //Assert.assertEquals(pageSource.contains("Congratulations! You must have the proper credentials.")

    }
}
