package com.herokuapp.theinternet.keypressestests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTests extends TestUtilities {

	@Test
	public void pressKeyTest() {
		log.info("Starting pressKeyTest");

		// open KeyPressesPage
		WelcomePage welcomePage = new WelcomePage(driver,log);
		welcomePage.openPage();
		KeyPressesPage keyPressesPage = welcomePage.clickKeyPressEditorLink();

		// Push keyboard key
		keyPressesPage.pressKey(Keys.ENTER);

		// Get Results text
		String result = keyPressesPage.getResultText();

		// Verify Result text is expected
		Assert.assertTrue(result.equals("You entered: ENTER"),
				"result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
	}

	@Test
	public void pressKeyWithActionsTest() {
		log.info("Starting pressKeyWithActionsTest");

		// open KeyPressesPage
		WelcomePage welcomePage = new WelcomePage(driver,log);
		welcomePage.openPage();
		KeyPressesPage keyPressesPage = welcomePage.clickKeyPressEditorLink();

		// Push keyboard key
		keyPressesPage.pressKeyWithActions(Keys.SPACE);

		// Get Results text
		String result = keyPressesPage.getResultText();

		// Verify Result text is expected
		Assert.assertTrue(result.equals("You entered: SPACE"),
				"result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
	}
}
