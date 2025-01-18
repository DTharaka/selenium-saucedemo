package com.pragmatic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitTest {

    WebDriver webDriver;

    @Test
    public void testButtonClickWithImplicitWait() {
        webDriver = new ChromeDriver();
        webDriver.get("https://eviltester.github.io/synchole/buttons.html");

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        webDriver.findElement(By.id("easy00")).click();
        webDriver.findElement(By.id("easy01")).click();
        webDriver.findElement(By.id("easy02")).click();
        webDriver.findElement(By.id("easy03")).click();
        Assert.assertEquals(webDriver.findElement(By.id("easybuttonmessage")).getText(),"All Buttons Clicked");

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        webDriver.close();
    }
}
