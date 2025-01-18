package com.pragmatic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptPopupsTest {
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
    public void testAlert() {
        //webDriver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        webDriver.findElement(By.xpath("//button[contains(text(),'Alert')]")).click();
        Alert jsAlert = webDriver.switchTo().alert();

        //Check the alert message
        Assert.assertEquals(jsAlert.getText(), "I am a JS Alert");

        //Click Ok button and check the message
        jsAlert.accept();
        Assert.assertEquals(webDriver.findElement(By.id("result")).getText().trim(), "You successfully clicked an alert");
    }

    @Test
    public void testConfirmationOk() {
        webDriver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        Alert jsConfirm = webDriver.switchTo().alert();

        //Check the alert message
        Assert.assertEquals(jsConfirm.getText(), "I am a JS Confirm");

        //Click Ok button and check the message
        jsConfirm.accept();
        Assert.assertEquals(webDriver.findElement(By.id("result")).getText().trim(), "You clicked: Ok");
    }

    @Test
    public void testConfirmationCancel() {
        webDriver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
        Alert jsDismiss = webDriver.switchTo().alert();

        //Check the alert message
        Assert.assertEquals(jsDismiss.getText(), "I am a JS Confirm");

        //Click Ok button and check the message
        jsDismiss.dismiss();
        Assert.assertEquals(webDriver.findElement(By.id("result")).getText().trim(), "You clicked: Cancel");
    }

    @Test
    public void testPrompt() {
        webDriver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();
        Alert jsPrompt = webDriver.switchTo().alert();

        //Check the alert message
        Assert.assertEquals(jsPrompt.getText(), "I am a JS prompt");

        //Send text to the prompt
        String textToEnter = "Hello";
        jsPrompt.sendKeys(textToEnter);

        //Click Ok button and check the message
        jsPrompt.accept();
        Assert.assertEquals(webDriver.findElement(By.id("result")).getText().trim(), "You entered: "+ textToEnter);
        Assert.assertEquals(webDriver.findElement(By.id("result")).getText().trim(), String.format("You entered: %s",textToEnter));
    }
}
