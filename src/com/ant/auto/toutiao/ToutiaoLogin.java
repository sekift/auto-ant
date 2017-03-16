package com.ant.auto.toutiao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.core.WebDriverOperate;
import com.ant.auto.util.SleepUtil;
import com.ant.auto.weibo.WeiboLogin;

public class ToutiaoLogin {
	private static final Logger logger = LoggerFactory
			.getLogger(WeiboLogin.class);
	private static final String toutiaoUrl = "http://www.toutiao.com";

	/**
	 * 头条登录 type的作用是区分微博还是qq：1 微博，2 qq
	 * 
	 * @param username
	 * @param password
	 * @param type
	 * @return
	 */
	public static WebDriver ttLogin(String username, String password,
			WebDriver driver, int type) {
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.navigate().to(toutiaoUrl);
		SleepUtil.sleepBySecond(2, 4);
		// 点击跳到登录
		driver.findElement(By.cssSelector("div.nav-login > a > span")).click();
		/**
		 * 1再点击去到具体微博/qq登录授权登录 2使用手机或者邮箱可能需要验证码
		 */
		SleepUtil.sleepBySecond(2, 4);
		if (1 == type) {
			// 微博
			driver.findElement(By.cssSelector("li.sns.weibo-login")).click();
			SleepUtil.sleepBySecond(5, 7);
			driver = weiboOauth(username, password, driver);
		} else if (2 == type) {
			// qq Firefox（49.0.2）下有问题，跳不转 原因是js加载错误
			driver.findElement(By.cssSelector("li.sns.qq-login")).click();
			SleepUtil.sleepBySecond(5, 7);
			driver = qqOauth(username, password, driver);
		}

		// 登录后 1最近授权过，无需再点击授权；2 点击授权
		// 首先判断是否已经登录
		WebElement oauthButton = WebDriverOperate.getWebElementByClassName(
				driver, "a.WB_btn_oauth.formbtn_01");
		if (oauthButton != null) {
			oauthButton.click();
		}
		// 去到 授权如果是502，可能是oauth的问题，可以直接去到主页
		SleepUtil.sleepBySecond(1, 2);
		driver.navigate().to(toutiaoUrl);
		SleepUtil.sleepBySecond(5, 10);

		// 判断真实是否已经登录
		String userHead = WebDriverOperate.getStringTextByCssSelector(driver,
				"a.user-head > span");
		if ("".equals(userHead)) {
			logger.error("登录失败了，请检查！");
			driver.close();
		}
		// 登录成功
		logger.info("账号 " + userHead + " 登录成功！");
		return driver;
	}

	/**
	 * 微博授权
	 * 
	 * @param username
	 * @param password
	 * @param driver
	 * @return
	 */
	private static WebDriver weiboOauth(String username, String password,
			WebDriver driver) {
		// 首先判断是否已经登录
		WebElement webEle = WebDriverOperate.getWebElementByClassName(driver,
				"account_name");

		// 未登录，有两种选择 1去WeiboLogin登录再返回授权界面，
		// 2直接在本页登录（如果是本页登录需要验证码那么去引用登录）
		if (webEle == null) {
			// 本页登录
			driver.findElement(By.id("userId")).clear();
			driver.findElement(By.id("userId")).sendKeys(username);
			SleepUtil.sleepBySecond(2, 7);
			driver.findElement(By.id("passwd")).clear();
			driver.findElement(By.id("passwd")).sendKeys(password);
			SleepUtil.sleepBySecond(2, 7);
			driver.findElement(By.cssSelector("a.WB_btn_login.formbtn_01"))
					.click();
			SleepUtil.sleepBySecond(2, 7);

			// 引用登录 就是去到WeiboLogin登录然后再返回扎个授权页面 暂时不提供
		}
		return driver;
	}

	/**
	 * qq授权
	 * 
	 * @param username
	 * @param password
	 * @param driver
	 * @return
	 */
	private static WebDriver qqOauth(String username, String password,
			WebDriver driver) {
		// 首先判断是否已经登录
		WebElement webEle = WebDriverOperate.getWebElementByClassName(driver,
				"account_name");

		if (webEle == null) {
			driver.findElement(By.id("u")).clear();
			driver.findElement(By.id("u")).sendKeys(username);
			SleepUtil.sleepBySecond(2, 7);
			driver.findElement(By.id("p")).clear();
			driver.findElement(By.id("p")).sendKeys(password);
			SleepUtil.sleepBySecond(2, 7);

			/**
			 * 验证码？很久未登录才需要验证码
			 * 判断验证码
			 */
			driver.findElement(By.id("go")).click();
			SleepUtil.sleepBySecond(2, 7);
		}
		return driver;
	}
}
