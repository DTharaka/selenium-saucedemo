package com.testng;
import org.testng.annotations.Test;

public class TestNGDependsOnMethods {

    @Test
    public void testMethod1() {
        //Your selenium code goes here
        System.out.println("TestNGDependsOnMethods.testMethod1");
    }

    @Test
    public void testMethod2() {
        //Your selenium code goes here
        System.out.println("TestNGDependsOnMethods.testMethod2");
    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    @Test(dependsOnMethods = {"testMethod5", "testMethod2"})
    public void testMethod3() {
        //Your selenium code goes here
        System.out.println("TestNGDependsOnMethods.testMethod3");
    }

    @Test(dependsOnMethods = {"testMethod1"})
    public void testMethod4() {
        //Your selenium code goes here
        System.out.println("TestNGDependsOnMethods.testMethod4");
    }

    @Test
    public void testMethod5() {
        //Your selenium code goes here
        System.out.println("TestNGDependsOnMethods.testMethod5");
    }

}