package com.herokuapp.theinternet.checkboxespagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.herokuapp.theinternet.pages.WelcomePage;

public class CheckboxesTests extends TestUtilities {

    @Test
    public void selectingTwoCheckboxesTest(){
        log.info("Starting selectingTwoCheckboxesTest");

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        //click on checkboxes link
        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();

        //Select all checkboxes
        checkboxesPage.selectAllCheckboxes();

        //Verify all checboxes are checked
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(),"Not all checkboxes are checked");

    }
}
