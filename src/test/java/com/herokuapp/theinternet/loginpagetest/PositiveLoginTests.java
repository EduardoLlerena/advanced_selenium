package com.herokuapp.theinternet.loginpagetest;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {

	@Test
	public void logInTest() {
		String expectedSuccessMessage = "You logged into a secure area!";

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver,log);
		welcomePage.openPage();
		takeScreenshot("WelcomePage opened");

		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		takeScreenshot("LoginPage opened");

		//Add a new cookie
		Cookie cookie = new Cookie("username","tomsmith","the-internet.herokuapp.com","/",null);
		loginPage.setCookie(cookie);


		SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith","SuperSecretPassword!");
		takeScreenshot("SecureAreaPage opened.");

		//Get cookies
		String usernameCookie = secureAreaPage.getCookie("username");
		String sessionCookie = secureAreaPage.getCookie("rack.session");
		log.info("Username cookie: "+usernameCookie);
		log.info("Session cookie: " + sessionCookie);


		String currentSuccessMessage = secureAreaPage.getSuccessMessageText();
		//Verifications
		Assert.assertEquals(secureAreaPage.getCurrentURL(),secureAreaPage.getPageUrl(),"URL is incorrect");
		Assert.assertTrue(secureAreaPage.isLogoutButtonVisible(),"Logout button is not visible");
		Assert.assertTrue(currentSuccessMessage.contains(expectedSuccessMessage),"Success message: '"+currentSuccessMessage + "' \n is not as the one expected: "+expectedSuccessMessage );


		/*log.info("Starting logIn test");
		String url = "http://the-internet.herokuapp.com/";
		driver.get(url);
		log.info("Main page is opened.");

		// Click on Form Authentication link
		driver.findElement(By.linkText("Form Authentication")).click();

		// enter username and password
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		sleep(3000);

		// push log in button
		WebElement logInButton = driver.findElement(By.className("radius"));
		wait.until(ExpectedConditions.elementToBeClickable(logInButton));
		logInButton.click();

		// verifications
		// new url
		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

		// log out button is visible
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='button secondary radius']")).isDisplayed(),
				"logOutButton is not visible.");

		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = driver.findElement(By.id("flash")).getText();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	*/
	}

}
