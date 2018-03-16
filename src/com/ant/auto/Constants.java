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
		// 新版Firefox地址
		String firefoxDir = "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
		// 旧版Firefox地址
		String firefoxDirOld = "D:\\Program Files\\Mozilla Firefox\\firefox.exe";
		//opera驱动
		String opera = "webdriver.opera.driver";
		//opera驱动地址
		String operaDir = "D:\\selenium\\operadriver.exe";
		//opera浏览器地址
		//String operaBrowserDir = "D:\\Program Files\\Opera\\launcher.exe";
		String operaBrowserDir = "D:\\Program Files\\Opera\\51.0.2830.55\\opera.exe";
		
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
	
	public static final int SHARE_WEIBO = 1;
	public static final int SHARE_QQ = 1;
	

}
