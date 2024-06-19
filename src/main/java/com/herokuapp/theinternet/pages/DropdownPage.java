package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePageObject{
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void selectOption(int option){
       log.info("Selecting option "+ option + " from dropdown");
       WebElement dropdownElement = find(dropdown);
       Select dropdown = new Select(dropdownElement);

       //Select can be done by index, by value or by visible text
       dropdown.selectByIndex(option);
    }

    public String getSelectedOptionText(){
        WebElement dropdownElement = find(dropdown);
        Select dropdown = new Select(dropdownElement);

        String selectedOption = dropdown.getFirstSelectedOption().getText();;
        return selectedOption;
    }
}
