package com.testng;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameters {

    @Parameters({"browser-name"})
    @Test(groups = {"smoke", "regression"})
    public void testMethod1(String browserName) {
        //Your selenium code goes here
        System.out.println("browserName = " + browserName);
        System.out.println("TestNGParameters.testMethod1");
    }

    @Parameters({"browser-name"})
    @Test
    public void testMethod2(String browserName) {
        //Your selenium code goes here
        System.out.println("TestNGParameters.testMethod2");
        System.out.println("browserName = " + browserName);
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