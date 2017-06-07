package com.qagroup.app;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class AppScreen {
	
	private AppiumDriver<MobileElement> driver;
	
	@AndroidFindBy(accessibility = "Alert Dialogs")
	private MobileElement alertDialogs;
	
	
	public AppScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
	@Step("Select 'Alert Dialogs' tab")
	public AlertDialogsScreen selectAlertDialogsTab() {
		alertDialogs.click();
		return new AlertDialogsScreen(driver);
	}
	
	public AppScreen thenOnAppScreen() {
		return this;
	}

}
