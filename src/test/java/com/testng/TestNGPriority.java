package com.testng;
import org.testng.annotations.Test;

public class TestNGPriority {

    @Test(priority = 4)
    public void testMethod1() {
        //Your selenium code goes here
        System.out.println("TestNGPriority.testMethod1");
    }

    @Test
    public void testMethod2() {
        //Your selenium code goes here
        System.out.println("TestNGPriority.testMethod2");
    }

    @Test(priority = 1)
    public void testMethod3() {
        //Your selenium code goes here
        System.out.println("TestNGPriority.testMethod3");
    }

    @Test(priority = 2)
    public void testMethod4() {
        //Your selenium code goes here
        System.out.println("TestNGPriority.testMethod4");
    }

    @Test(priority = 3)
    public void testMethod5() {
        //Your selenium code goes here
        System.out.println("TestNGPriority.testMethod5");
    }
}