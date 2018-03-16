package com.ant.auto.core;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 窗口切换
 * 
 * @author Administrator
 * 
 */
public class WebDriverOperate {
	private static final Logger logger = LoggerFactory
			.getLogger(WebDriverOperate.class);

	/**
	 * 根据title切换窗口--模糊匹配
	 * 
	 * @param driver
	 * @param windowTitle
	 * @return
	 */
	public static WebDriver switchToWindow(WebDriver driver, String windowTitle) {
		try {
			String currentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for (String s : handles) {
				if (s.equals(currentHandle))
					continue;
				else {
					driver.switchTo().window(s);
					if (driver.getTitle().contains(windowTitle)) {
						logger.info("转到窗口: " + windowTitle + " 成功！");
						break;
					} else
						continue;
				}
			}
		} catch (NoSuchWindowException e) {
			logger.error("窗口: " + windowTitle + " 未能找到！", e.fillInStackTrace());
		}
		return driver;
	}

	/**
	 * 根据title切换窗口--全匹配
	 * 
	 * @param driver
	 * @param windowTitle
	 * @return
	 */
	public static WebDriver switchToWindowFull(WebDriver driver,
			String windowTitle) {
		try {
			String currentHandle = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
			for (String s : handles) {
				if (s.equals(currentHandle))
					continue;
				else {
					driver.switchTo().window(s);
					if (driver.getTitle().equals(windowTitle)) {
						logger.info("转到窗口: " + windowTitle + " 成功！");
						break;
					} else
						continue;
				}
			}
		} catch (NoSuchWindowException e) {
			logger.error("窗口: " + windowTitle + " 未能找到！", e.fillInStackTrace());
		}
		return driver;
	}

	/**
	 * 下一个窗口
	 * 
	 * @param dr
	 * @return
	 */
	public static WebDriver switchWindows(WebDriver dr) {
		WebDriver window;
		String currentWindow = dr.getWindowHandle();
		Set<String> handles = dr.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			if (currentWindow == it.next())
				continue;
			window = dr.switchTo().window(it.next());
			return window;
		}
		return null;
	}

	// 获取数据
	public static String getStringTextByCssSelector(WebDriver driver,
			String element) {
		String result = "";
		try {
			result = driver.findElement(By.cssSelector(element)).getText();
		} catch (Exception e) {
			logger.warn("页面 " + driver.getCurrentUrl() + " ,获取元素 " + element
					+ " 不存在，请注意！");
		}
		return result;
	}

	// 获取数据
	public static String getStringTextByPath(WebDriver driver, String element) {
		String result = "";
		try {
			result = driver.findElement(By.xpath(element)).getText();
		} catch (Exception e) {
			logger.warn("页面 " + driver.getCurrentUrl() + " ,获取元素 " + element
					+ " 不存在，请注意！");
		}
		return result;
	}

	// 获取数据
	public static WebElement getWebElementByClassName(WebDriver driver,
			String element) {
		WebElement result = null;
		try {
			result = driver.findElement(By.className(element));
		} catch (Exception e) {
			logger.warn("页面 " + driver.getCurrentUrl() + " ,获取元素 " + element
					+ ",不存在，请注意！");
		}
		return result;
	}

	// 获取数据
	public static WebElement getWebElementByCssSelector(WebDriver driver,
			String element) {
		WebElement result = null;
		try {
			result = driver.findElement(By
					.cssSelector("a.WB_btn_oauth.formbtn_01"));
		} catch (Exception e) {
			logger.warn("页面 " + driver.getCurrentUrl() + " ,获取元素 " + element
					+ ",不存在，请注意！");
		}
		return result;
	}

	public void fullMethod() {
		WebDriver driver = new FirefoxDriver();
		// 前进
		driver.navigate().forward();
		// 后退
		driver.navigate().back();
	}
}
