package com.qagroup.apidemos.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qagroup.app.AlertDialogsScreen;
import com.qagroup.app.ApiDemos;
import com.qagroup.app.MainScreen;

public class TextEntryDialogTest {
	
	private AlertDialogsScreen onAlertDialogsScreen;
	private MainScreen onMainScreen;

	

	@BeforeClass
	public void setup() {
		onMainScreen = ApiDemos.openMainScreen();
		onAlertDialogsScreen = onMainScreen.navigateToAlertDialogs();
	}
	
	@Test
	public void fillOutFieldsOnTextEntryDialog() {
		onAlertDialogsScreen.enterName();
		onAlertDialogsScreen.enterPassword();
		onAlertDialogsScreen.clickOkButton();

		assertTrue(onAlertDialogsScreen.isAlertDialogsScreenDisplayed(), "'Text Entry dialog' popup has not been closed after entering name and password.");
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		ApiDemos.close();
	}

}
