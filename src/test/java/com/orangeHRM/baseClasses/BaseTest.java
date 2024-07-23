package com.orangeHRM.baseClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeMethod
    public void setUp() {
        logger.info("Setting up WebDriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("Screen maximization completed");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        logger.info("Implemented waiting mechanism to handle asynchronous tasks");
        logger.info("WebDriver setup completed");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            logger.info("Closing WebDriver");
            driver.quit();
            logger.info("WebDriver closed.");
        }
    }

}
