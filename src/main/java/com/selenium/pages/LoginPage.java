package com.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    Logger logger=Logger.getLogger(LoginPage.class.getName());
    WebDriver driver;
    @FindBy(xpath = "//header/div[1]/div[1]/div[3]/ul[1]/li[1]/a[1]/span[2]")
    WebElement myAccountButton;
    @FindBy(id = "ctl00_phBody_SignIn_txtEmail")
    WebElement mobileSpace;
    @FindBy(id="ctl00_phBody_SignIn_txtPassword")
    WebElement passwordSpace;
    @FindBy(id = "ctl00_phBody_SignIn_btnLogin")
    WebElement signInButton;
    @FindBy(xpath = "//*[text()='My Account']")
    WebElement loginCheck;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String loginScreen() throws InterruptedException {
        myAccountButton.click();
        Thread.sleep(1000);
        logger.info("Entering to login page");
        mobileSpace.sendKeys("8297760717");
        passwordSpace.sendKeys("asish717@");
        logger.info("Details filled");
        signInButton.click();
        logger.info("Login successful");
        String checkText=loginCheck.getText();
        return checkText;
    }
}
