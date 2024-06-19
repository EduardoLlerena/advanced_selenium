package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public class LoginPage extends BasePageObject{

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.tagName("button");
    private By loginFailedMessageLocator = By.id("flash");


    public LoginPage(WebDriver driver,Logger log){
       super(driver,log);
    }

    public String getLoginErrorMessage(){
        return getText(loginFailedMessageLocator);
    }

    //Execute log in
    public SecureAreaPage logIn(String username, String password){
        log.info("Executing login with username["+ username + "] and password["+ password + "]");
        type(username,usernameLocator);
        type(password,passwordLocator);
        click(loginButtonLocator);
        return new SecureAreaPage(driver,log);
    }

    public void logInUnsuccessful(String username, String password){
        log.info("Executing login with username["+ username + "] and password["+ password + "]");
        type(username,usernameLocator);
        type(password,passwordLocator);
        click(loginButtonLocator);
    }

    public void waitForErrorMessage(){
        waitForVisibilityOf(loginFailedMessageLocator);
    }


}
