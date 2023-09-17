package com.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectingBook {
    Logger logger=Logger.getLogger(SelectingBook.class.getName());
    WebDriver driver;
    @FindBy(xpath = "//*[text()='Turning Points: A Journey Through Challenges']")
    WebElement selectedbook;
    @FindBy(id = "ctl00_phBody_ProductDetail_lblTitle")
    WebElement selectedBookCheck;
    public SelectingBook(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String bookSelected() throws InterruptedException {
        List<WebElement>listOfBooks=driver.findElements(By.id("listSearchResult"));
        System.out.println(listOfBooks.size());
        for (WebElement element : listOfBooks){
            String name= element.getText();
            System.out.println(name);
        }
        logger.info("List of books printed");
        selectedbook.click();
        logger.info("Required book selected");
        Thread.sleep(1000);
        String checkText=selectedBookCheck.getText();
        return checkText;
    }
}
