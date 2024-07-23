package com.orangeHRM.pages;

import com.orangeHRM.baseClasses.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    private WebElement successfulLogin;

    @FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
    private WebElement loginPageTitle;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsername(String username) {
        logger.info("Entering username: {}", username);
        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {
        logger.info("Entering password: {}", password);
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        logger.info("Clicking on the login button");
        loginButton.click();
    }

    public void validateLoginTitle() {
        loginPageTitle.isDisplayed();
    }

    public void validateSuccessfulLogin() {
        successfulLogin.isDisplayed();
    }

    public void validateFailedLogin() {
        loginErrorMessage.isDisplayed();
    }



}
