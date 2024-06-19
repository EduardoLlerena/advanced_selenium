package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptAlertsPage extends BasePageObject{

    private By jsAlert = By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirm = By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPrompt = By.xpath("//button[text()='Click for JS Prompt']");

    private By resultTextLocator = By.id("result");


    public JavaScriptAlertsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openJSAlert(){
        log.info("Opening JSAlert");
        click(jsAlert);
    }

    public void openJSConfirm(){
        log.info("Opening JSConfirm");
        click(jsConfirm);
    }

    public void openJSPrompt(){
        log.info("Opnening JSPrompt");
        click(jsPrompt);
    }

    public void acceptJSAlert(){
        log.info("Clicking OK on js alert.");
        Alert alert = switchToAlert();
        alert.accept();

    }

    public void dismissJSAlert(){
        log.info("Clicking Cancel on JS confirm");
        Alert alert = switchToAlert();
        alert.dismiss();
    }

    public String getResultText(){
        String result = find(resultTextLocator).getText();
        log.info("Result text: "+ result);
        return result;
    }

    public void sendTextAlert(String textToWrite){
        log.info("Writing in alert");
        Alert alert = switchToAlert();
        alert.sendKeys(textToWrite);
    }

    public String getJSAlertText(){
        Alert alert = switchToAlert();
        return alert.getText();
    }


}
