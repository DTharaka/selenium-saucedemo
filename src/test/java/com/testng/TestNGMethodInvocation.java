package com.testng;
import org.testng.annotations.Test;

public class TestNGMethodInvocation {

    @Test(invocationCount = 0)
    public void testMethod1() {
        //Your selenium code goes here
        System.out.println("TestNGMethodInvocation.testMethod1");
    }

    @Test(invocationCount = 4, invocationTimeOut = 3000)
    public void testMethod2() throws InterruptedException {
        //Your selenium code goes here
        Thread.sleep(2000);
        System.out.println("TestNGMethodInvocation.testMethod2");
    }

    @Test
    public void testMethod3() {
        //Your selenium code goes here
        System.out.println("TestNGMethodInvocation.testMethod3");
    }

    @Test
    public void testMethod4() {
        //Your selenium code goes here
        System.out.println("TestNGMethodInvocation.testMethod4");
    }

    @Test
    public void testMethod5() {
        //Your selenium code goes here
        System.out.println("TestNGMethodInvocation.testMethod5");
    }

}