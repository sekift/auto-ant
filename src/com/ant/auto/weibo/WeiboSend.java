package com.ant.auto.weibo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.ant.auto.util.SleepUtil;

public class WeiboSend {
	public static void sendTweet(String username, String password, WebDriver driverDis) {
		WebDriver driver = WeiboLogin.weiboLogin(username, password, driverDis);
		Actions actions = new Actions(driver);
		actions.moveByOffset(0, 0).click().build().perform();// 点击空白
		driver.findElement(By.cssSelector("textarea.W_input")).clear();
		SleepUtil.sleepBySecond(1, 3);
		driver.findElement(By.cssSelector("textarea.W_input")).sendKeys(
				"刚刚致电10086客户代表，还没等我开口，客服就问我：先生有什么可以帮到你吗？人家客气咱也不能狮子大张口"
						+ "，就麻起胆子说：那帮我充200块话费吧。然后毫无悬念的被拒绝。。。真TM虚伪！还大公司呢，真小气！");
		SleepUtil.sleepBySecond(3, 5);
		driver.findElement(By.linkText("发布")).click();
		SleepUtil.sleepBySecond(2, 4);
		driver.navigate()
				.to("http://weibo.com/");
		SleepUtil.sleepBySecond(20, 23);
		driver.close();
	}
}
