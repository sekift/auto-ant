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
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ant.auto.Constants;

/**
 * 装配浏览器
 * 
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

	// 装配firefox浏览器 - ZenMeta自动翻墙
	public static WebDriver setFirefox(String newOrOld, boolean defaultConf) {
		System.setProperty(Constants.Driver.gecko, Constants.Driver.geckoDir);
		File pathBinary = new File(newOrOld);
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		if (defaultConf) {
			ProfilesIni pi = new ProfilesIni();
			firefoxProfile = pi.getProfile("default");
		}
		WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		return driver;
	}

	// 装配opera浏览器 - ZenMeta自动翻墙（未完成）
	public static WebDriver setOpera() {
		System.setProperty(Constants.Driver.opera, Constants.Driver.operaDir);
		ChromeOptions options = new ChromeOptions();
		options.setBinary(Constants.Driver.operaBrowserDir);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		OperaDriver browser = new OperaDriver(capabilities);
		WebDriver driver = browser;
		return driver;
	}
}
