package com.selenium;

import com.selenium.base.BaseClass;
import com.selenium.pages.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;

public class TestPage extends BaseClass {
    Logger logger=Logger.getLogger(TestPage.class.getName());
    LoginPage loginPage;
    SearchingBook searchRequiredBook;
    SelectingBook selectingBook;
    BuyingBook buyingBook;
    CheckingCart checkingCart;
    LoggingOut loggingOut;
    @BeforeTest
    public void start(){
        setup();
        loginPage=new LoginPage(driver);
        searchRequiredBook=new SearchingBook(driver);
        selectingBook=new SelectingBook(driver);
        buyingBook=new BuyingBook(driver);
        checkingCart=new CheckingCart(driver);
        loggingOut=new LoggingOut(driver);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 1)
    public void loginPage() throws InterruptedException {
        String loginResultCheck=loginPage.loginScreen();
        Assert.assertEquals(loginResultCheck,"My Account");
        logger.info("Verified account logged in");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void searchingBookRequired(){
        String searchResultCheck=searchRequiredBook.searchRequiredBook();
        Assert.assertEquals(searchResultCheck,"\"a p j kalam\"");
        logger.info("Verified book searched is correct");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void selectingRequiredBook() throws InterruptedException {
        String selectedBookCheck=selectingBook.bookSelected();
        Assert.assertEquals(selectedBookCheck,"Turning Points: A Journey Through Challenges");
        logger.info("Verified book selected is correct");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void buyingTheBook() throws AWTException, InterruptedException {
        String checkingIfBookAddedOrNot=buyingBook.buyingBookOperation();
        Assert.assertEquals(checkingIfBookAddedOrNot,"Product successsfully added to the cart");
        logger.info("Verified if book added");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void checkingIfBookAddedToCart() throws AWTException {
        String checkingIfCartOpenedOrNot=checkingCart.checkingTheCart();
        Assert.assertEquals(checkingIfCartOpenedOrNot,"My Shopping Cart");
        logger.info("Verified book is in cart");
    }

    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 6)
    public void logoutPage() throws AWTException, InterruptedException {
        String checkingIfLoggedOutOrNot=loggingOut.logoutOption();
        Assert.assertEquals(checkingIfLoggedOutOrNot,"My Account");
        logger.info("Verified if successfully logged out");
    }

    @AfterTest
    public void end(){
        driver.close();
    }
}