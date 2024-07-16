package com.orangeHRM.tests;

import com.orangeHRM.baseClasses.BaseTest;
import com.orangeHRM.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void validateSuccessfulLogin(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("Admin");
        loginPage.setPassword("admin123");
        loginPage.clickLogin();

        // Add assertion to verify login success
        loginPage.validateSuccessfulLogin();
    }

    @Test
    public void validateFailedLogin(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("Admin");

        // using invalid password
        loginPage.setPassword("testpass");
        loginPage.clickLogin();

        // Add assertion to failed login
        loginPage.validateLoginTitle();
    }

    @Test
    public void validateFailedLoginWithErrorMessage(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        LoginPage loginPage = new LoginPage(driver);
        // invalid username and password
        loginPage.setUsername("testuser");
        loginPage.setPassword("testpass");
        loginPage.clickLogin();

        // Add assertion to failed login
        loginPage.validateFailedLogin();

    }
}
