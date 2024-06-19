package com.herokuapp.theinternet.alertstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertsTests extends TestUtilities {

    @Test
    public void jsAlertTest(){
        log.info("Starting jsAlertTest");
        SoftAssert softAssert = new SoftAssert();

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        //click on Javascript alerts link
        JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavaScriptAlertsLink();

        //click JS alert button
        javaScriptAlertsPage.openJSAlert();

        //get alert text
        String alertMessage = javaScriptAlertsPage.getJSAlertText();

        //click ok button
        javaScriptAlertsPage.acceptJSAlert();

        //get results text
        String result = javaScriptAlertsPage.getResultText();

        //Verifications -- soft assert even if it fails, everything will continue and all assertions that failed are logged
        softAssert.assertEquals(alertMessage,"I am a JS Alerts", "Messages are not the same");
        softAssert.assertEquals(result,"You successfully clicked an alerts", "Result messages are not the same");

        softAssert.assertAll();
    }

    @Test
    public void jsDismissTest(){
        log.info("Starting jsDismissTest");
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavaScriptAlertsLink();

        javaScriptAlertsPage.openJSConfirm();

        String message = javaScriptAlertsPage.getJSAlertText();

        javaScriptAlertsPage.dismissJSAlert();

        String result = javaScriptAlertsPage.getResultText();


        Assert.assertEquals(message,"I am a JS Confirm","Messages are not the same");
        Assert.assertEquals(result,"You clicked: Cancel","Result messages are not the same");

    }

    @Test
    public void jsPromptTest(){
        log.info("Starting jsPromptTest");
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        JavaScriptAlertsPage javaScriptAlertsPage = welcomePage.clickJavaScriptAlertsLink();

        javaScriptAlertsPage.openJSPrompt();

        String alertMessage = javaScriptAlertsPage.getJSAlertText();

        String textToSend = "Test text to send";
        javaScriptAlertsPage.sendTextAlert(textToSend);
        javaScriptAlertsPage.acceptJSAlert();

        String result = javaScriptAlertsPage.getResultText();


        Assert.assertEquals(alertMessage,"I am a JS prompt","Message is not the same");
        Assert.assertEquals(result,"You entered: "+ textToSend,"Result message is not the same");


    }

}
