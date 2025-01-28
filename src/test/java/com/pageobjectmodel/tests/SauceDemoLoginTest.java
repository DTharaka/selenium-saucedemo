package com.pageobjectmodel.tests;

import com.pageobjectmodel.SauceDemoTestBase;
import com.pageobjectmodel.pages.SauceLandingPage;
import com.pageobjectmodel.pages.SauceLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoLoginTest extends SauceDemoTestBase {

    @Test
    public void testLoginWithDefaultUserCredentials() {
        SauceLoginPage loginPage = new SauceLoginPage(webDriver);
        loginPage.typeUsername("standard_user").typePassword("secret_sauce").clickLogin();

        SauceLandingPage landingPage = new SauceLandingPage(webDriver);
        Assert.assertEquals(landingPage.getPageTitle(), "Products");
    }

    @Test
    public void testLoginWithBlankUserNameAndBlankPassword() {
        SauceLoginPage loginPage = new SauceLoginPage(webDriver);
        loginPage.clearUsername().clearPassword().clickLogin();
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username is required");
    }

    @Test
    public void testLoginWithBlankUserNameAndPassword() {
        SauceLoginPage loginPage = new SauceLoginPage(webDriver);
        loginPage.clearUsername().typePassword("secret_sauce").clickLogin();
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username is required");
    }

    @Test
    public void testLoginWithUserNameAndBlankPassword() {
        SauceLoginPage loginPage = new SauceLoginPage(webDriver);
        loginPage.typeUsername("standard_user").clearPassword().clickLogin();
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Password is required");
    }

    @Test
    public void testLoginWithInvalidUserNameAndInvalidPassword() {
        SauceLoginPage loginPage = new SauceLoginPage(webDriver);
        loginPage.typeUsername("standard_user1").typePassword("secret_sauce1").clickLogin();
        Assert.assertEquals(loginPage.getError(),"Epic sadface: Username and password do not match any user in this service");
    }
}
