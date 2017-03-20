package com.ant.auto.toutiao;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.Constants;
import com.ant.auto.core.AssembleBrowser;
import com.ant.auto.core.AssembleProperties;

public class ToutiaoMain {
	private static final Logger logger = LoggerFactory
			.getLogger(ToutiaoMain.class);

	public static void main(String args[]) {
		WebDriver driver = null;
		int type = 2;
		String chargeType = null;
		if (1 == type) {
			chargeType = Constants.WEIBO_STR;
		} else if (2 == type) {
			chargeType = Constants.QQ_STR;
		}
		List<Map<String, String>> list = AssembleProperties.loadPro(chargeType,
				Constants.ACCOUNT_STR);
		List<Map<String, String>> targetList = AssembleProperties.loadPro(
				Constants.TOUTIAO_TARGET_STR, Constants.ACCOUNT_STR);
		for (Map<String, String> map : list) {
			driver = AssembleBrowser.setChrome();
			driver = ToutiaoLogin.ttLogin(map.get(Constants.USERNAME_STR),
					map.get(Constants.PASSWORD_STR), driver, type);
			for (Map<String, String> targetMap : targetList) {
				driver = ToutiaoViewFollow.viewFollow(driver,
						targetMap.get(Constants.TARGET_STR));
				ToutiaoOperate.operateTarget(driver, type);
			}
			logger.info(map.get(Constants.USERNAME_STR) + " 已经完成任务。");
			driver.quit();
		}
	}
}
