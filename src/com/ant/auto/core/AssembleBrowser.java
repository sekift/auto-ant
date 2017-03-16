package com.ant.auto.core;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ant.auto.Constants;
/**
 * 装配浏览器
 * @author Administrator
 *
 */
public class AssembleBrowser {
	// 装配chrome浏览器
	public static WebDriver setChrome() {
		System.setProperty(Constants.Driver.driverChrome,
				Constants.Driver.driverChromeDir);
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	// 装配chrome浏览器
	public static WebDriver setChromeAsPhone() {
		System.setProperty(Constants.Driver.driverChrome,
				Constants.Driver.driverChromeDir);
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Google Nexus 5");// 模拟手机端
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		WebDriver driver = new ChromeDriver(capabilities);
		return driver;
	}

	// 装配firefox浏览器
	public static WebDriver setFirefox() {
		System.setProperty(Constants.Driver.gecko, Constants.Driver.geckoDir);
		File pathBinary = new File(Constants.Driver.firefoxDir);
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		return driver;
	}
}
