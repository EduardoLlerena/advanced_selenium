package com.herokuapp.theinternet.newwindow;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.pages.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewWindowTests extends TestUtilities {

    @Test
    public void newWindowTest(){
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();

        WindowsPage windowsPage = welcomePage.clickMultipleWindowsLink();

        windowsPage.clickHiperlinkOpenNewWindow();

        NewWindowPage newWindowPage = windowsPage.switchToNewWindowPage();

        String actualTitle = newWindowPage.getNewWindowTitle();
        String actualURL = newWindowPage.getCurrentURL(driver);

        Assert.assertEquals(actualTitle,"New Window","Title is not the same");
        Assert.assertEquals(actualURL,"https://the-internet.herokuapp.com/windows/new","URL is not the same");

    }
}
