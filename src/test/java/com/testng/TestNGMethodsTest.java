package com.testng;
import org.testng.annotations.Test;

public class TestNGMethodsTest {

    @Test
    public void testMethod1() {
        //Your selenium code goes here
        System.out.println("TestNGMethodsTest.testMethod1");
    }

    @Test(enabled = false)
    public void testMethod2() {
        //Your selenium code goes here
        System.out.println("TestNGMethodsTest.testMethod2");
    }

    @Test
    public void testMethod3() {
        //Your selenium code goes here
        System.out.println("TestNGMethodsTest.testMethod3");
    }

    @Test(enabled = false)
    public void testMethod4() {
        //Your selenium code goes here
        System.out.println("TestNGMethodsTest.testMethod4");
    }

    @Test
    public void testMethod5() {
        //Your selenium code goes here
        System.out.println("TestNGMethodsTest.testMethod5");
    }
}