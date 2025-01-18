package com.pragmatic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloSelenium {


    @Test
    public void testHelloSelenium() {

        //Create a browser instance
        WebDriver webDriver = new ChromeDriver();

        //Navigate to sauce demo site
        webDriver.get("https://www.saucedemo.com/");

        //Type username
        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Type password
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click login
        webDriver.findElement(By.id("login-button")).click();

        //Verify if user can login to the system
        Assert.assertEquals(webDriver.findElement(By.cssSelector("span[data-test='title']")).getText(),"Products");

        //Close the browser
        webDriver.quit();

    }
}
