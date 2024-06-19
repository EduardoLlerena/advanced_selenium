package com.herokuapp.theinternet.loginpagetest;

import com.herokuapp.theinternet.base.CsvDataProviders;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Map;

public class NegativeLoginTests extends TestUtilities {

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {
		WelcomePage welcomePage = new WelcomePage(driver,log);
		welcomePage.openPage();

		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		loginPage.logInUnsuccessful(username,password);

		loginPage.waitForErrorMessage();
		String actualMessage =loginPage.getLoginErrorMessage();
		Assert.assertTrue(actualMessage.contains(expectedErrorMessage),"Messages do not match. \n + Expected: "+ expectedErrorMessage +"\n Actual: "+ actualMessage );

		/*
		log.info("Starting negativeTest");

		// open main page
		String url = "http://the-internet.herokuapp.com/";
		driver.get(url);
		log.info("Main page is opened.");

		// Click on Form Authentication link
		driver.findElement(By.linkText("Form Authentication")).click();

		// enter username and password
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		// push log in button
		driver.findElement(By.className("radius")).click();

		// Verification
		String actualErrorMessage = driver.findElement(By.id("flash")).getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);*/
	}


	@Test(priority = 1,dataProvider = "csvReader",dataProviderClass = CsvDataProviders.class)
	public void negativeTestWithSpreadsheetParameters(Map<String, String> testData) {
		//Data
		String testNumber = testData.get("testNumber");
		String testDescription= testData.get("testDescription");
		String username= testData.get("username");
		String password= testData.get("password");
		String expectedErrorMessage= testData.get("expectedMessage");

		log.info("Starting test #"+testNumber+" "+ testDescription);

		WelcomePage welcomePage = new WelcomePage(driver,log);
		welcomePage.openPage();

		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		loginPage.logInUnsuccessful(username,password);

		loginPage.waitForErrorMessage();
		String actualMessage =loginPage.getLoginErrorMessage();
		Assert.assertTrue(actualMessage.contains(expectedErrorMessage),"Messages do not match. \n + Expected: "+ expectedErrorMessage +"\n Actual: "+ actualMessage );

	}



}
