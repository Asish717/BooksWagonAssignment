package com.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchingBook {
    Logger logger=Logger.getLogger(SearchingBook.class.getName());
    WebDriver driver;
    @FindBy(id = "inputbar")
    WebElement searchBar;
    @FindBy(name = "btnTopSearch")
    WebElement searchButton;
    @FindBy(xpath = "//span[text()='\"a p j kalam\"']")
    WebElement searchResultCheck;

    public SearchingBook(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String searchRequiredBook(){
        searchBar.sendKeys("a p j kalam");
        logger.info("Entered book name");
        searchButton.click();
        logger.info("Pressed search button");
        String checkText=searchResultCheck.getText();
        System.out.println(checkText);
        return checkText;
    }
}
