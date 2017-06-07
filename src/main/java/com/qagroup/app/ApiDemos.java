package com.qagroup.app;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qagroup.tools.Mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class ApiDemos {
	private static AppiumDriver<MobileElement> driver;
	
	@Step("Open ApiDemos main screen")
	public static MainScreen openMainScreen() {
		driver = Mobile.startApp();
		return new MainScreen(driver);
	}

	@Step("Close App")
	public static void close() {
		if (driver != null)
			driver.quit();
		driver = null;
	}

	@Attachment("Screenshot")
	public static byte[] takeScreenshot() {
		TakesScreenshot takesScreenshot = TakesScreenshot.class.cast(driver);
		return takesScreenshot.getScreenshotAs(OutputType.BYTES);
	}
	
}
