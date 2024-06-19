package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
public class WelcomePage extends BasePageObject{

    private String pageUrl = "https://the-internet.herokuapp.com/";

    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By checkboxesLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
    private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
    private By editorLinkLocator = By.linkText("WYSIWYG Editor");
    private By keyPressLinkLocator = By.linkText("Key Presses");
    private By fileUploadLinkLocator = By.linkText("File Upload");
    private By dragAndDropLinkLocator = By.linkText("Drag and Drop");
    private By hoversLinkLocator = By.linkText("Hovers");
    private By sliderLinkLocator = By.linkText("Horizontal Slider");
    private By jsErrorLinkLocator = By.linkText("JavaScript onload event error");




    
    public WelcomePage(WebDriver driver, Logger log){
        super(driver,log);
    }

    //Opens welcome page
    public void openPage(){
        log.info("Opening page: "+pageUrl);
        openUrl(pageUrl);
        log.info("Page opened.");
    }

    public LoginPage clickFormAuthenticationLink(){
        log.info("Clicking Form Authentication link on Welcome Page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver,log);
    }

    public CheckboxesPage clickCheckboxesLink(){
        log.info("Clicking Checkboxes link on Welcome Page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver,log);
    }

    public DropdownPage clickDropdownLink(){
        log.info("Clicking Dropdown link on Welcome Page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver,log);
    }

    public JavaScriptAlertsPage clickJavaScriptAlertsLink(){
        log.info("Clicking Javascript alerts link on Welcome Page");
        click(javaScriptAlertsLinkLocator);
        return new JavaScriptAlertsPage(driver,log);
    }

    public WindowsPage clickMultipleWindowsLink(){
        log.info("Clicking Multiple windows link on Welcome Page ");
        click(multipleWindowsLinkLocator);
        return new WindowsPage(driver,log);
    }

    public EditorPage clickWYSIWYGEditorLink() {
        log.info("Clicking WYSIWYG Editor link on Welcome Page");
        click(editorLinkLocator);
        return new EditorPage(driver, log);
    }

    public KeyPressesPage clickKeyPressEditorLink() {
        log.info("Clicking Key presses link on Welcome Page");
        click(keyPressLinkLocator);
        return new KeyPressesPage(driver, log);
    }

    public FileUploaderPage clickFileUploadEditorLink() {
        log.info("Clicking File Upload link on Welcome Page");
        click(fileUploadLinkLocator);
        return new FileUploaderPage(driver, log);
    }

    public DragAndDropPage clickDragAndDropPageEditorLink() {
        log.info("Clicking Drag And Drop link on Welcome Page");
        click(dragAndDropLinkLocator);
        return new DragAndDropPage(driver, log);
    }

    public HoversPage clickHoversPageEditorLink() {
        log.info("Clicking Hovers link on Welcome Page");
        click(hoversLinkLocator);
        return new HoversPage(driver, log);
    }

    public HorizontalSliderPage clickSliderPageEditorLink() {
        log.info("Clicking Horizontal Slider link on Welcome Page");
        click(sliderLinkLocator);
        return new HorizontalSliderPage(driver, log);
    }

    public JSErrorPage clickJsErrorPageEditorLink() {
        log.info("Clicking JS Error link on Welcome Page");
        click(jsErrorLinkLocator);
        return new JSErrorPage(driver, log);
    }
}
