package com.qagroup.app;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;


public class MainScreen {
	
	private AppiumDriver<MobileElement> driver;
	
	@AndroidFindBy(accessibility = "App")
	private MobileElement appTab;
	
	@AndroidFindBy(accessibility = "Views")
	private MobileElement viewsTab;
	
	public MainScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
	@Step("Select 'App' tab")
	public AppScreen selectAppTab() {
		appTab.click();
		return new AppScreen(driver);
	}
	
	@Step("Navigate to the 'Text Entry dialog' popup")
	public AlertDialogsScreen navigateToAlertDialogs() {
		selectAppTab().thenOnAppScreen().selectAlertDialogsTab().thenOnAlertDialogsScreen().selectTextEntryDialog();
		return new AlertDialogsScreen(driver);
	}
	
	@Step("Select 'Views' tab")
	public ViewsScreen clickOnViewsTab() {
		viewsTab.click();
		return new ViewsScreen(driver);
		
	}
	
}
