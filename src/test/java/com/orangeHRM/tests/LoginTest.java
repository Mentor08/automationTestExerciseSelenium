package com.orangeHRM.tests;

import com.orangeHRM.baseClasses.BaseTest;
import com.orangeHRM.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void validateSuccessfulLogin(){
        logger.info("Starting login test");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        logger.info("Navigated to login page");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("Admin");
        loginPage.setPassword("admin123");
        loginPage.clickLogin();

        // Add assertion to verify login success
        loginPage.validateSuccessfulLogin();
        logger.info("Login test completed");
    }

    @Test
    public void validateFailedLogin(){
        logger.info("Starting login test");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        logger.info("Navigated to login page");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("Admin");

        // using invalid password
        loginPage.setPassword("testpass");
        loginPage.clickLogin();

        // Add assertion to failed login
        loginPage.validateLoginTitle();
        logger.info("Login test completed");
    }

    @Test
    public void validateFailedLoginWithErrorMessage(){
        logger.info("Starting login test");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        logger.info("Navigated to login page");

        LoginPage loginPage = new LoginPage(driver);
        // invalid username and password
        loginPage.setUsername("testuser");
        loginPage.setPassword("testpass");
        loginPage.clickLogin();

        // Add assertion to failed login
        loginPage.validateFailedLogin();
        logger.info("Login test completed");
    }
}
