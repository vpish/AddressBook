package com.lohika.addressbook.pages;

import com.lohika.addressbook.core.BasePage;
import com.lohika.addressbook.core.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    @FindBy(linkText = "Logout")
    private WebElement logoutButton;
    @FindBy(linkText = "add new")
    private WebElement addNew;



    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        clickOnElement(logoutButton);
    }

    public Boolean isUserLoggedIn() {
        Wait.forElement(logoutButton);
        if (logoutButton.isDisplayed()) {
            return true;
        } else return false;
    }

    public void addNew() {
        clickOnElement(addNew);
    }
}
