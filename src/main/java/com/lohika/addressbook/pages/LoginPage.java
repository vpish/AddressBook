package com.lohika.addressbook.pages;

import com.lohika.addressbook.core.BasePage;
import com.lohika.addressbook.core.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='user']")
    private WebElement userInput;
    @FindBy(css = "input[name=pass]")
    private WebElement passInput;
    @FindBy(css = "input[value=Login]")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String name, String pass) {
        insertTextToElement(name, userInput);
        insertTextToElement(pass, passInput);
        clickOnElement(loginButton);
    }

    public Boolean isLoginPageOpened() {
        Wait.forElement(loginButton);
        if (loginButton.isDisplayed()){
            return true;
        } else return false;
    }

}
