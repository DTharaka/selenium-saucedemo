package com.pragmatic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ByChainedTest {

    @Test
    public void testByAll() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com/");

        By byUsername = new ByChained(By.tagName("form"),By.tagName("input"));

        List<WebElement> eleInputs = webDriver.findElements(byUsername);
        Assert.assertEquals(eleInputs.size(), 3);

        eleInputs.get(0).sendKeys("standard_user");
        eleInputs.get(1).sendKeys("secret_sauce");
        eleInputs.get(2).click();

        Assert.assertEquals(webDriver.findElement(By.cssSelector("span.title")).getText(), "Products", "Title is not correct");
        webDriver.quit();
    }
}
