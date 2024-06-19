package com.herokuapp.theinternet.dropdowntests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dropdowntests extends TestUtilities {

    @Test
    public void optionTwoTest(){
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        DropdownPage dropdownPage = welcomePage.clickDropdownLink();
        dropdownPage.selectOption(2);

        String selectedOption = dropdownPage.getSelectedOptionText();
        Assert.assertEquals(selectedOption,"Option 2","Option 2 is not selected. Instead, selected option is: "+ selectedOption);
    }
}
