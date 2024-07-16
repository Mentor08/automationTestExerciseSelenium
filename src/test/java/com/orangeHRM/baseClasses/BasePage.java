package com.orangeHRM.baseClasses;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected Logger logger;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.logger = LoggerFactory.getLogger(this.getClass());
        PageFactory.initElements(driver, this);
    }
}
