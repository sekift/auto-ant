package com.ant.auto;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ant.auto.core.AssembleBrowser;
import com.ant.auto.core.AssembleProperties;
import com.ant.auto.util.SleepUtil;

public class RunMain {
	public static void main(String args[]) {
		List<Map<String, String>> list = AssembleProperties.loadPro(
				"baidu_flower", "url");
		for (Map<String, String> map : list) {
			System.out.println(map.get(Constants.PASSWORD_STR));
		}

//		WebDriver driver = AssembleBrowser.setOpera();
//		driver.get("https://www.baidu.com");
//		driver.findElement(By.name("wd")).sendKeys("Selenium");
//		//SleepUtil.sleepBySecond(10, 20);
//		driver.quit();
	}
}
