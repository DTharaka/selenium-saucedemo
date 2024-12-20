package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RemoveFromCartTest {

    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void afterMethod() {
        if (webDriver != null){
            webDriver.quit();
        }
    }

    @Test
    public void testRemoveFromCart() {

        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        webDriver.findElement(By.id("login-button")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("span[data-test='title']")).getText(), "Products");

        webDriver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        webDriver.findElement(By.cssSelector("#add-to-cart-sauce-labs-onesie")).click();
        webDriver.findElement(By.cssSelector("button[data-test='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();

        webDriver.findElement(By.cssSelector(".shopping_cart_link")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("span[data-test='title']")).getText(), "Your Cart");

        webDriver.findElement(By.cssSelector("button[data-test='remove-test.allthethings()-t-shirt-(red)']")).click();

    }
}
