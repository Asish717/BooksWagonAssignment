package com.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.InputEvent;

public class BuyingBook {
    Logger logger=Logger.getLogger(BuyingBook.class.getName());
    WebDriver driver;
    @FindBy(xpath = "//*[text()='Product successsfully added to the cart']")
    WebElement checkingIfBookAddded;
    public BuyingBook(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String buyingBookOperation() throws AWTException, InterruptedException {
        Robot robot=new Robot();
        robot.mouseMove(500,700);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(3000);
        logger.info("Clicked on Buy now");
        String checkText=checkingIfBookAddded.getText();
        return checkText;
    }
}
