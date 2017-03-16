package com.ant.auto.toutiao;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.ant.auto.core.AssembleBrowser;
import com.ant.auto.core.AssembleProperties;

public class ToutiaoMain {
	public static void main(String args[]) {
		WebDriver driver = null;
		List<Map<String, String>> qqList = AssembleProperties.loadPro("qq",
				"account");
		List<Map<String, String>> targetList = AssembleProperties.loadPro(
				"toutiao_target", "account");
		for (Map<String, String> map : qqList) {
			driver = AssembleBrowser.setChrome();
			driver = ToutiaoLogin.ttLogin(map.get("username"),
					map.get("password"), driver, 2);
			for (Map<String, String> targetMap : targetList) {
				ToutiaoViewFollow.viewFollow(driver,
						targetMap.get("target"));
			}
		}
	}
}
