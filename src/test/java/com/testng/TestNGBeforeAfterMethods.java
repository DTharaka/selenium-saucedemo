package com.testng;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGBeforeAfterMethods {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("TestNGBeforeAfterMethods.beforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("TestNGBeforeAfterMethods.afterMethod");
    }

    @Test
    public void testMethod1() {
        //Your selenium code goes here
        System.out.println("TestNGBeforeAfterMethods.testMethod1");
    }

    @Test
    public void testMethod2() {
        //Your selenium code goes here
        System.out.println("TestNGBeforeAfterMethods.testMethod2");
    }

    @Test
    public void testMethod3() {
        //Your selenium code goes here
        System.out.println("TestNGBeforeAfterMethods.testMethod3");
    }

    @Test
    public void testMethod4() {
        //Your selenium code goes here
        System.out.println("TestNGBeforeAfterMethods.testMethod4");
    }

    @Test
    public void testMethod5() {
        //Your selenium code goes here
        System.out.println("TestNGBeforeAfterMethods.testMethod5");
    }

}