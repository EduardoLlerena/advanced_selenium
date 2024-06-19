package com.herokuapp.theinternet.hoverstests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoversPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTests extends TestUtilities {

	@Test
	public void user2ProfileTest() {
		log.info("Starting user2ProfileTest");

		// Open HoversPage
		WelcomePage welcomePage = new WelcomePage(driver,log);
		welcomePage.openPage();

		HoversPage hoversPage = welcomePage.clickHoversPageEditorLink();

		// Open User 2 profile
		hoversPage.openUserProfile(2);

		// Verify correct user profile opened
		Assert.assertTrue(hoversPage.getCurrentURL(driver).contains("/users/2"),
				"Url of opened page is not expected User 1 page url");
	}
}
