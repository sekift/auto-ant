package com.ant.auto.toutiao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.core.WebDriverOperate;
import com.ant.auto.util.SleepUtil;

/**
 * 这个类的目的是登录后从首页切换到关注列表中来， 并挑选需要打开的用户（就是配置中的toutiao_target）
 * 
 * @author Administrator
 * 
 */
public class ToutiaoViewFollow {
	private static final Logger logger = LoggerFactory
			.getLogger(ToutiaoViewFollow.class);

	private static final String titlePro = "的头条主页";

	public static WebDriver viewFollow(WebDriver driver, String target) {
		// 点入我的主页
		String userHead = WebDriverOperate.getStringTextByCssSelector(driver,
				"a.user-head > span");
		// 跳转到关注页
		driver.findElement(By.cssSelector("a.user-head > span")).click();
		SleepUtil.sleepBySecond(1, 3);

		// 切换到新打开的窗口
		driver = WebDriverOperate.switchToWindow(driver, userHead + titlePro);
		SleepUtil.sleepBySecond(1, 3);
		String number = driver.findElement(By.cssSelector("em.y-number > i"))
				.getText();
		int followSum = Integer.valueOf(number);
		if (followSum == 0) {
			logger.warn(userHead + " 此号没有关注人，请先关注。");

			// 直接关闭 或者 先转去搜索并关注
			driver.close();
		}
		SleepUtil.sleepBySecond(1, 3);

		// 跳转到关注详情栏
		driver.findElement(By.cssSelector("em.y-number > i")).click();
		/**
		 * 关注列表 第一个 driver.findElement(By.cssSelector("a > h3")).click(); 
		 * 第二个driver.findElement(By.xpath("//li[@id='table']/ul/li[2]/dl/dd[2]/a/h3")).click(); 
		 * 第三个 driver.findElement(By.xpath("//li[@id='table']/ul/li[3]/dl/dd[2]/a/h3")).click();
		 * 
		 */
		int targetNum = 0;
		String pathPre = "//li[@id='table']/ul/li[";
		String pathPro = "]/dl/dd[2]/a/h3";
		for (int i = 1; i <= followSum; i++) {
			if (target.equals(driver.findElement(
					By.xpath(pathPre + i + pathPro)).getText())) {
				logger.info("找到了 " + target + " 。");
				targetNum = i;
				break;
			}
		}
		
		//接下来可以跳转到target主页去操作了
		
		
		return driver;
	}

	/**
	 * 没有关注的先搜索并关注，然后再返回自己的页面
	 * 
	 * @param driver
	 * @return
	 */
	public static WebDriver searchAndFollow(WebDriver driver) {

		return driver;
	}

}
