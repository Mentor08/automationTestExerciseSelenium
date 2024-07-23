package com.orangeHRM.tests;

import com.orangeHRM.baseClasses.BaseTest;
import com.orangeHRM.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "verify if users can login using valid credentials")
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

    @Test(priority = 2, description = "verify if there's validation for failed login attempt")
    public void validateFailedLogin(){

        logger.info("Starting failed login test");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        logger.info("Navigated to login page");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("Admin");

        // using invalid password
        loginPage.setPassword("testpass");
        loginPage.clickLogin();

        // Add assertion to failed login
        loginPage.validateLoginTitle();
        logger.info("Failed Login test completed");
    }

    @Test(priority = 3, description = "verify if the system handles failed login")
    public void validateFailedLoginWithErrorMessage(){
        logger.info("Starting failed login test with error handling");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        logger.info("Navigated to login page");

        LoginPage loginPage = new LoginPage(driver);
        // invalid username and password
        loginPage.setUsername("testuser");
        loginPage.setPassword("testpass");
        loginPage.clickLogin();

        // Add assertion to failed login
        loginPage.validateFailedLogin();
        logger.info("Failed Login test with error handling completed");
    }
}
