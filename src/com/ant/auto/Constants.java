package com.ant.auto;

public class Constants {
	// 指定浏览器
	public interface Driver {
		// chrome驱动
		String driverChrome = "webdriver.chrome.driver";
		// 浏览器地址
		String driverChromeDir = "D:\\selenium\\chromedriver.exe";
		// gecko驱动
		String gecko = "webdriver.gecko.driver";
		// gecko地址
		String geckoDir = "D:\\selenium\\geckodriver.exe";
		// Firefox地址
		String firefoxDir = "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
	}

	// 账号分割
	public static final String accountSeparator = "----";

}
