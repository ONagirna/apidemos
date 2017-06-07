package com.qagroup.app;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ExpandableListsScreen {
	
	public ExpandableListsScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	private AppiumDriver<MobileElement> driver;
	
	@AndroidFindBy(accessibility = "3. Simple Adapter")
	private MobileElement simpleAdapterTab;
	
	public ExpandableListsScreen clickSimpleAdapterTab() {
		simpleAdapterTab.click();
		return new ExpandableListsScreen(driver);
		
	}

}
