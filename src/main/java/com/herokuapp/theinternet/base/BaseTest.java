package com.herokuapp.theinternet.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.AfterMethod;



import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.lang.reflect.Method;

//will print the messages on everything, since everything uses BaseTest
@Listeners({ com.herokuapp.theinternet.base.TestListener.class })
public class BaseTest {
    protected WebDriver driver;
    protected Logger log;

    protected String testSuiteName;
    protected String testName;
    protected String testMethodName;

    //Parameters don't need to be called the same, but they have to be in the same order
    @Parameters({ "browser","chromeProfile","deviceName" })
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser, @Optional String profile,@Optional String deviceName, ITestContext ctx) {
        String testName = ctx.getCurrentXmlTest().getName();
        log = LogManager.getLogger(testName);

        BrowserDriverFactory factory = new BrowserDriverFactory(browser,log);


       //driver = factory.createDriver();
        if(profile != null){
            driver=factory.createChromeWithProfile(profile);
        }else if(deviceName != null){
            driver = factory.createChromeWithMobileEmulation(deviceName);
        } else{
            driver = factory.createDriver();
        }


       driver.manage().window().maximize();

       //Returns name of the suite xml
       this.testSuiteName = ctx.getSuite().getName();
       this.testName = testName;
       this.testMethodName = method.getName();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Close driver");
        // Close browser
        driver.quit();
    }
}
