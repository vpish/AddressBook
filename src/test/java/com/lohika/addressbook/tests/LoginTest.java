package com.lohika.addressbook.tests;

import com.lohika.addressbook.TestData.UsersCredentials;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void testLogout() {
        mainPage.logout();
        Assert.assertTrue(loginPage.isLoginPageOpened(), "User is not signed out");
    }

    @Test (dependsOnMethods = {"testLogout"}, dataProvider = "IncorrectCredentials", dataProviderClass = UsersCredentials.class)
    public void testLogin_failed(String userName, String password) {
        loginPage.login(userName,password);
        Assert.assertTrue(loginPage.isLoginPageOpened(), "User is not signed out");
    }

    @Test (dependsOnMethods = {"testLogin_failed"}, dataProvider = "CorrectCredentials", dataProviderClass = UsersCredentials.class)
    public void testLogin_successful(String userName, String password) {
        loginPage.login(userName,password);
        Assert.assertTrue(mainPage.isUserLoggedIn(), "User is not LoggedIn");
        mainPage.logout();
    }



}
