package com.lohika.addressbook.tests;

import com.lohika.addressbook.core.DriverFactory;
import com.lohika.addressbook.core.Wait;
import com.lohika.addressbook.pages.LoginPage;
import com.lohika.addressbook.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.reporters.jq.Main;

import static com.lohika.addressbook.core.DriverFactory.BrowserType.CHROME;
import static com.lohika.addressbook.core.DriverFactory.BrowserType.FIREFOX;

public class BaseTest {

    protected WebDriver driver;
    protected final String SITE_URL = "http://172.22.62.90/addressbook/";
    protected LoginPage loginPage;
    protected MainPage mainPage;

    @BeforeClass(alwaysRun = true)
    public void SetupMethod() {
        // initialize WebDriver
        DriverFactory.BrowserType type = FIREFOX;
        driver = DriverFactory.getDriver(type);
        System.out.println("browser = " + type);
        // login to system
        driver.get(SITE_URL);
        loginPage = new LoginPage(driver);
        loginPage.login("qwerty", "1qaz2wsx");
        Wait.seconds(1);
        mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isUserLoggedIn(), "User is not Logged In");
    }

    @AfterClass(alwaysRun = true)
    public void cleanMethod() {
        driver.quit();
    }
}
