package com.selenium.base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseClass {
    Logger logger=Logger.getLogger(BaseClass.class.getName());
    public static WebDriver driver;
    public void setup(){
        PropertyConfigurator.configure("E:\\BooksWagonAssignment\\log4j.properties");
        driver=new ChromeDriver();
        logger.info("Launching the browser");
        driver.manage().window().maximize();
        driver.get("https://www.bookswagon.com");
        logger.info("Launching the BooksWagon site");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
