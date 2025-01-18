package com.datadriven;

import org.testng.annotations.DataProvider;

public class LoginInputData {
    @DataProvider(name = "user-login")
    public Object[][] userInput(){
        return new Object[][]{
                {"","","Epic sadface: Username is required"},
                {"standard_user","","Epic sadface: Password is required"},
                {"","secret_sauce","Epic sadface: Username is required"},
                {"standard_user","secret_sauce1","Epic sadface: Username and password do not match any user in this service"},
        };
    }
}
