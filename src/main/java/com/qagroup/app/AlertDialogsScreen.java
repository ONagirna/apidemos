package com.qagroup.app;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class AlertDialogsScreen {

	@AndroidFindBy(accessibility = "Text Entry dialog")
	private MobileElement textEntryDialog;

	@AndroidFindBy(id = "android:id/parentPanel")
	private List<MobileElement> dialogs;
	
	@AndroidFindBy(id = "io.appium.android.apis:id/username_edit")
	private MobileElement nameField;
	
	@AndroidFindBy(id = "io.appium.android.apis:id/password_edit")
	private MobileElement passwordField;
	
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement okButton;

	@AndroidFindBy(id = "io.appium.android.apis:id/screen")
	private MobileElement alertDialogScreen;
	
	private AppiumDriver<MobileElement> driver;

	public AlertDialogsScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@Step("Select 'Text Entry Dialog' tab")
	public AlertDialogsScreen selectTextEntryDialog() {
		textEntryDialog.click();
		return this;
	}

	@Step("Check that 'Text Entry dialog' is displayed")
	public boolean isDialogDisplayed() {
		return dialog().isDisplayed();
	}

	private MobileElement dialog() {
		if (dialogs.size() > 1)
			throw new RuntimeException("Not unique locator for dialog element!");

		if (dialogs.size() == 0)
			throw new RuntimeException("Incorrect locator for dialog element!");

		return dialogs.get(0);
	}
	
	public AlertDialogsScreen thenOnAlertDialogsScreen() {
		return this;
	}

	
	@Step("Enter name on 'Text Entry dialog' popup")
	public AlertDialogsScreen enterName() {
		Faker faker = new Faker();
		String fakeName = faker.name().fullName();
	
		nameField.click();
		nameField.sendKeys(fakeName);
		return this;
	}
	
	@Step("Enter password on 'Text Entry dialog' popup")
	public AlertDialogsScreen enterPassword() {
		Faker faker = new Faker();
		String fakePassword = faker.internet().password();
		
		passwordField.click();
		passwordField.sendKeys(fakePassword);
		return this;
	}
	
	@Step("Click on OK button on 'Text Entry dialog' popup")
	public AlertDialogsScreen clickOkButton() {
		okButton.click();
		return this;
	}
	
	@Step("Check that 'Alert Dialogs screen' is displayed")
	public boolean isAlertDialogsScreenDisplayed() {
		return alertDialogScreen.isDisplayed();
	}
	

}
