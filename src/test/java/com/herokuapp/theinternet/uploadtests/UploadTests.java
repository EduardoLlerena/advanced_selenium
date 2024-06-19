package com.herokuapp.theinternet.uploadtests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTests extends TestUtilities {

	@Test(dataProvider = "filesProvider")
	public void fileUploadTest(int testCaseNumber,String fileName) {
		/*log.info("Starting fileUploadTest #" + no + " for " + fileName);

		// open File Uploader Page
		WelcomePageObject welcomePageObject = new WelcomePageObject(driver,log);
		welcomePageObject.openPage();
		FileUploaderPage fileUploaderPage = welcomePageObject.clickFileUploadEditorLink();

		// Select file
		fileUploaderPage.selectFile(fileName);

		// Push upload button
		fileUploaderPage.pushUploadButton();

		// Get uploaded files
		String fileNames = fileUploaderPage.getUploadedFilesNames();

		// Verify selected file uploaded
		Assert.assertTrue(fileNames.contains(fileName),
				"Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");*/

		log.info("Starting imageUploadTest #"+testCaseNumber + " for file "+fileName);

		WelcomePage welcomePage = new WelcomePage(driver,log);
		welcomePage.openPage();
		FileUploaderPage fileUploaderPage = welcomePage.clickFileUploadEditorLink();

		fileUploaderPage.selectFile(fileName);
		fileUploaderPage.pushUploadButton();

		// Get uploaded files
		String fileNames = fileUploaderPage.getUploadedFilesNames();

		// Verify selected file uploaded
		Assert.assertTrue(fileNames.contains(fileName),
				"Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
	}
}
