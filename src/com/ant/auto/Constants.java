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
	public static final String ACCOUNT_SEPARATOR = "----";
	
	//配置关键字
	public static final String USERNAME_STR = "username"; 
	public static final String PASSWORD_STR = "password"; 

	public static final String BAIDU_STR = "baidu"; 
	public static final String WEIBO_STR = "weibo"; 
	public static final String ACCOUNT_STR = "account"; 
	public static final String TARGET_STR = "target"; 
	public static final String TOUTIAO_TARGET_STR = "toutiao_target"; 
	public static final String QQ_STR = "qq"; 

}
