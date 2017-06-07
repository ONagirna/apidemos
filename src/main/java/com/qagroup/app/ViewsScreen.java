package com.qagroup.app;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ru.yandex.qatools.allure.annotations.Step;

public class ViewsScreen {
	
	private AppiumDriver<MobileElement> driver;
	
	@AndroidFindBy(accessibility = "Expandable Lists")
	private MobileElement expandableListsTab;
	
	
	public ViewsScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
	@Step("Select 'Expandable Lists' tab")
	public ExpandableListsScreen clickExpandableListsTab() {
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}
		expandableListsTab.click();
		return new ExpandableListsScreen(driver);
	}
	
	

}
