package com.lohika.addressbook.TestData;

import org.testng.annotations.DataProvider;

public class UsersCredentials {

    @DataProvider(name = "IncorrectCredentials")
    public Object[][] credentials() {
        return new Object[][]{
                {"vvpp03", "12abcd"},
                {"abcd", "abcd"},
                {"abcd", ""},
                {"", "abcd"},
                {"", ""},
        };
    }

    @DataProvider(name = "CorrectCredentials")
    public Object[][] credentials2() {
        return new Object[][]{
                {"admin", "secret"},
                {"qwerty", "1qaz2wsx"},
        };
    }

}
