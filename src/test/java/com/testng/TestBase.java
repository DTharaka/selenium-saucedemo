package com.testng;

import org.testng.annotations.*;

public class TestBase {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("TestBase.beforeSuite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("TestBase.afterSuite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("TestBase.beforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("TestBase.afterTest");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("TestBase.beforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("TestBase.afterClass");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("TestBase.beforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("TestBase.afterMethod");
    }
}
