package com.saucedemo;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleProductCheckoutTest {

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
    public void testMultipleProductCheckout() {

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();;

        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        webDriver.findElement(By.id("login-button")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("span[data-test='title']")).getText(), "Products");

        webDriver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click();
        webDriver.findElement(By.cssSelector("#add-to-cart-sauce-labs-onesie")).click();
        webDriver.findElement(By.cssSelector("button[data-test='add-to-cart-test.allthethings()-t-shirt-(red)']")).click();

        webDriver.findElement(By.cssSelector(".shopping_cart_link")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("span[data-test='title']")).getText(), "Your Cart");
        webDriver.findElement(By.cssSelector("#checkout")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("span[data-test='title']")).getText(), "Checkout: Your Information");
        webDriver.findElement(By.id("first-name")).sendKeys(firstName);
        webDriver.findElement(By.id("last-name")).sendKeys(lastName);
        webDriver.findElement(By.id("postal-code")).sendKeys("1000");
        webDriver.findElement(By.id("continue")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("span[data-test='title']")).getText(), "Checkout: Overview");
        webDriver.findElement(By.id("finish")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("span[data-test='title']")).getText(), "Checkout: Complete!");
        Assert.assertEquals(webDriver.findElement(By.cssSelector(".complete-header")).getText(), "Thank you for your order!");
    }
}
