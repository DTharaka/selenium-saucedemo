package com.pragmatic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownListSelectTest {

    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @AfterMethod
    public void afterMethod() {
        if (webDriver != null){
            webDriver.quit();
        }
    }

    @Test
    public void testDropdownListSelect() {
        Select selOption = new Select(webDriver.findElement(By.cssSelector(".form-select")));
        selOption.selectByIndex(2);
        Assert.assertEquals(selOption.getFirstSelectedOption().getText(), "Two");
        selOption.selectByValue("3");
        Assert.assertEquals(selOption.getFirstSelectedOption().getText(), "Three");
        selOption.selectByVisibleText("One");
        Assert.assertEquals(selOption.getFirstSelectedOption().getText(), "One");
    }
}
