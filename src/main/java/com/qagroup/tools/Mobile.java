package com.qagroup.tools;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Mobile {

	public static AppiumDriver<MobileElement> startApp() {
		String platformVariable = System.getProperty("mobile");

		if ("android".equals(platformVariable) || platformVariable == null)
			return startAndroid();

		if ("ios".equals(platformVariable))
			return startIos();

		throw new RuntimeException("Unknown or Unsupported mobile platform: " + platformVariable);
	}

	private static AndroidDriver<MobileElement> startAndroid() {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
		capabilities.setCapability(MobileCapabilityType.APP, appPath());
		capabilities.setCapability(AndroidMobileCapabilityType.AVD, "Pixel_API_24");

		
		AndroidDriver<MobileElement> driver = null;
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
		return driver;
	}

	private static IOSDriver<MobileElement> startIos() {
		throw new NotImplementedException("Not implemented for iOS yet");
	}

	private static String appPath() {
		String userDir = System.getProperty("user.dir");
		File pathToApk = new File(userDir, "ApiDemos-debug.apk");
		return pathToApk.getAbsolutePath();

	}
}
