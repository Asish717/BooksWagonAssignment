package com.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.InputEvent;

public class CheckingCart {
    Logger logger=Logger.getLogger(CheckingCart.class.getName());
    WebDriver driver;
    @FindBy(xpath = "//*[text()='My Shopping Cart']")
    WebElement checkingIfAdded;
    public CheckingCart(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String checkingTheCart() throws AWTException {
        Robot robot=new Robot();
        robot.mouseMove(1240,160);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        logger.info("Opened cart");
        String checkText=checkingIfAdded.getText();
        return checkText;
    }
}
