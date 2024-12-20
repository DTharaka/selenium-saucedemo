package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductIsExistInStoreTest {

    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }

    @Test
    public void testProductIsExistInStore() {

        String searchProduct = "Sauce Labs Fleece Jackets";
        boolean productAvailable = false;

        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        webDriver.findElement(By.id("login-button")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("span[data-test='title']")).getText(),
                "Products");

        // Get all product names
        List<WebElement> productElements = webDriver.findElements(By.cssSelector(".inventory_item_name "));

        //Add product names to an array
        List<String> productNames = new ArrayList<>();
        for (WebElement productElement : productElements) {
            productNames.add(productElement.getText());
        }

        for (String productName : productNames) {
            if (productName.equals(searchProduct)) {
                productAvailable = true;
                System.out.println(searchProduct + "is available in the store");;
                break;
            }
        }
        if (!productAvailable){
            System.out.println(searchProduct + "is not available in the store");;
        }
    }
}
