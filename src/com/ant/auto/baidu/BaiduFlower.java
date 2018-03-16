package com.ant.auto.baidu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.util.SleepUtil;

/**
 * 百度给小偶像送花
 * 
 * @author Administrator
 * 
 */
public class BaiduFlower {
	private static final Logger logger = LoggerFactory
			.getLogger(BaiduFlower.class);

	// 百度送花
	public static void sendFlower(String username, String password,
			WebDriver driverPre) {
		WebDriver driver = BaiduLogin.baiduLogin(username, password, driverPre);

		Navigation navigation = driver.navigate();
		// navigation.to("https://baike.baidu.com/item/%E9%99%88%E6%80%9D/1304195");//PC
		navigation
				.to("https://wapbaike.baidu.com/item/%E9%99%88%E6%80%9D/1304195");// 手机端
		SleepUtil.sleepBySecond(1, 5);

		// 滚动
		((JavascriptExecutor) driver).executeScript("scrollTo(0, 1200)");

		// 点击送花，每天可以送3次
		WebElement element = driver.findElement(By.id("J-send"));
		try {
			for (int i = 0; i < 3; i++) {
				SleepUtil.sleepBySecond(1, 2);
				element.click();
			}
		} catch (WebDriverException e) {
			logger.error("出错了：" + e.getMessage());
		}
		SleepUtil.sleepBySecond(3, 8);
		// 直接关闭
		driver.quit();
	}
}
