package com.testng;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameters {

    @Parameters({"browser-name"})
    @Test( description = "Test Method 1",groups = {"smoke", "regression"})
    public void testMethod1(String browserName) {
        //Your selenium code goes here
        System.out.println("browserName = " + browserName);
        System.out.println("TestNGParameters.testMethod1");
    }

    @Parameters({"browser-name"})
    @Test(description = "Test Method 2", groups = {"smoke", "regression"})
    public void testMethod2(String browserName) {
        //Your selenium code goes here
        System.out.println("TestNGParameters.testMethod2");
        System.out.println("browserName = " + browserName);
        Assert.fail("Forcing test to be failed");
    }

    @Parameters({"browser-name"})
    @Test(groups = {"smoke"})
    public void testMethod3(String browserName) {
        //Your selenium code goes here
        System.out.println("browserName = " + browserName);
        System.out.println("TestNGParameters.testMethod3");
    }

    @Parameters({"browser-name"})
    @Test(groups = {"regression"})
    public void testMethod4(String browserName) {
        //Your selenium code goes here
        System.out.println("browserName = " + browserName);
        System.out.println("TestNGParameters.testMethod4");
    }

    @Parameters({"browser-name"})
    @Test(groups = {"smoke"})
    public void testMethod5(@Optional("IE") String browserName) {
        //Your selenium code goes here
        System.out.println("browserName = " + browserName);
        System.out.println("TestNGParameters.testMethod5");
    }

}