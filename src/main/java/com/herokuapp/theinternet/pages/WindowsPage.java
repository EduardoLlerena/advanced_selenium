package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowsPage extends BasePageObject{
    private By newWindowHiperlink = By.xpath("//*[@id=\"content\"]/div/a");

    public WindowsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void clickHiperlinkOpenNewWindow(){
        log.info("Clicking to open new window");
        click(newWindowHiperlink);
    }

    public NewWindowPage switchToNewWindowPage(){
        log.info("Looking for 'New Window' page");
        switchToWindowWithTitle("New Window");
        return new NewWindowPage(driver,log);
    }
}
