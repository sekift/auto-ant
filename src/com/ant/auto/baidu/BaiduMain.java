package com.ant.auto.baidu;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.ant.auto.core.AssembleBrowser;
import com.ant.auto.core.AssembleProperties;

public class BaiduMain {
	public static void main(String args[]) {
		WebDriver driver = null;
		List<Map<String, String>> list = AssembleProperties.loadPro("baidu",
				"account");
		for (Map<String, String> map : list) {
			driver = AssembleBrowser.setChromeAsPhone();
			BaiduSignUp.signUpRun(map.get("username"), map.get("password"), driver);
		}
	}
}
