package com.pragmatic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAuthTest {
    private WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }

    @Test
    public void testBasicAuth() {
        String username = "admin";
        String password = "admin";
        String baseUrl = "https://the-internet.herokuapp.com/basic_auth";

        //String authenticatedUrl = "https://" + username + ":" + password + "@" + baseUrl.replace("https://","");
        String authenticatedUrl = String.format("https://%s:%s@the-internet.herokuapp.com/basic_auth",username,password);

        //Navigate to the URL
        webDriver.get(authenticatedUrl);

        //Validate the success message
        String pageSource = webDriver.getPageSource();
        Assert.assertTrue(pageSource.contains("Congratulations! You must have the proper credentials."),
                "Login failed: Expected success message not found!");

        Assert.assertEquals(webDriver.findElement(By.tagName("h3")).getText(), "Basic Auth");
        Assert.assertEquals(webDriver.findElement(By.tagName("p")).getText(), "Congratulations! You must have the proper credentials.");

    }
}
