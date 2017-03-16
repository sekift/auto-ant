package com.ant.auto.weibo;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.ant.auto.core.AssembleBrowser;
import com.ant.auto.core.AssembleProperties;

public class WeiboMain {
	public static void main(String args[]) {
		WebDriver driver = null;
		List<Map<String, String>> list = AssembleProperties.loadPro("weibo",
				"account");
		for (Map<String, String> map : list) {
			driver = AssembleBrowser.setChrome();
			WeiboSend.sendTweet(map.get("username"), map.get("password"),
					driver);
		}
	}
}
