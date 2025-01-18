package com.pragmatic.mails;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;

public class ResetPasswordTest {
    WebDriver webDriver;
    MailosaurClient mailosaur;
    SearchCriteria criteria;
    MessageSearchParams params;
    long testStart;
    String apiKey = "RP7TV2E9McehTmpoUrTmRILLDnXdjAll";
    String serverId = "utlpok57";
    String serverDomain = "utlpok57.mailosaur.net";

    @BeforeMethod
    public void beforeMethod() throws MailosaurException {
        webDriver = new ChromeDriver();
        webDriver.get("https://example.mailosaur.com/password-reset");
        mailosaur = new MailosaurClient(apiKey);
        criteria = new SearchCriteria();

        mailosaur.messages().deleteAll(serverId);

        testStart = System.currentTimeMillis();
    }

    @AfterMethod
    public void afterMethod() throws MailosaurException {
        webDriver.quit();
        params = new MessageSearchParams();
        params.withServer(serverId)
                .withReceivedAfter(testStart);
        //mailosaur.messages().deleteAll(serverId);
    }

    @Test
    public void testResetPassword() throws MailosaurException, IOException {
        String email = mailosaur.servers().generateEmailAddress(serverId);

        webDriver.findElement(By.id("email")).sendKeys(email);
        webDriver.findElement(By.cssSelector("button[type='submit']")).click();

        params = new MessageSearchParams();
        params.withServer(serverId);

        criteria.withSentTo(email);

        Message message = mailosaur.messages().get(params, criteria);

        Assert.assertNotNull(message);
        Assert.assertEquals(message.subject(), "Set your new password for ACME Product");

        String resetPasswordURL = message.html().links().get(0).href();
        webDriver.get(resetPasswordURL);
        webDriver.findElement(By.id("password")).sendKeys("123");
        webDriver.findElement(By.id("confirmPassword")).sendKeys("123");
        webDriver.findElement(By.cssSelector("button[type='submit']")).click();

        String pageSource = webDriver.getPageSource();
        Assert.assertEquals(pageSource.contains("Your new password has been set!"),"Your new password has been set!");

    }


}
