package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public class SecureAreaPage extends BasePageObject {
    private String url = "https://the-internet.herokuapp.com/secure";

    private By logOutButtonLocator = By.xpath("//a[@class='button secondary radius']");
    private By loginMessageLocator = By.id("flash-messages");


    public SecureAreaPage(WebDriver driver, Logger log){
        super(driver,log);
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public String getPageUrl(){
        return url;
    }

    public boolean isLogoutButtonVisible(){
        return find(logOutButtonLocator).isDisplayed();
    }

    public String getSuccessMessageText(){
        return find(loginMessageLocator).getText();
    }



}
