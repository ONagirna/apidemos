package com.qagroup.apidemos.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qagroup.app.ApiDemos;
import com.qagroup.app.ExpandableListsScreen;
import com.qagroup.app.MainScreen;
import com.qagroup.app.ViewsScreen;

public class NavigationToViewsTabTest {
	
	private MainScreen onMainScreen;
	private ViewsScreen onViewsScreen;
	private ExpandableListsScreen onExpandableListsScreen;

	@BeforeClass
	public void setup() {
		onMainScreen = ApiDemos.openMainScreen();
	}

	@Test
	public void navigateToViewsTab() {
		onMainScreen.clickOnViewsTab();
	}
	
	@Test(dependsOnMethods = "navigateToViewsTab")
	public void navigateToExpandableListsTab() {
		onViewsScreen.clickExpandableListsTab();
}
	

	@Test (dependsOnMethods = "navigateToExpandableListsTab")
	public void navigateToSimpleAdapterTab() {
		onExpandableListsScreen.clickSimpleAdapterTab();
		
	}
}
