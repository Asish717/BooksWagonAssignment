package com.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.InputEvent;

public class LoggingOut {
    Logger logger=Logger.getLogger(LoggingOut.class.getName());
    WebDriver driver;
    @FindBy(xpath = "//*[text()='My Account']")
    WebElement checkingIfLoggedOut;
    public LoggingOut(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String logoutOption() throws AWTException, InterruptedException {
        Robot robot=new Robot();
        robot.mouseMove(1120,170);
        Thread.sleep(500);
        robot.mouseMove(1120,470);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        logger.info("Successfully logged out");
        String checkText=checkingIfLoggedOut.getText();
        return checkText;
    }
}
