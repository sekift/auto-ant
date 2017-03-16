package com.ant.auto.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ant.auto.Constants;
import com.ant.auto.util.ConfigUtil;

/**
 * 装配配置
 * 
 * @author Administrator
 * 
 */
public class AssembleProperties {
	private static final Logger logger = LoggerFactory
			.getLogger(AssembleProperties.class);

	public static List<Map<String, String>> loadPro(String configValue,
			String value) {
		Map map = (Map) ConfigUtil.getConfigValue(configValue);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		List<String> accountList = new ArrayList<String>();
		// 如果account只有一个，那么
		if (map != null && map.size() > 0) {
			Object obj = map.get(value);
			if (obj instanceof String) {
				accountList.add((String) obj);
			} else if (obj instanceof List) {
				accountList = (List<String>) obj;
			} else {
				logger.error("配置加载失败，请检查类型。");
			}
			logger.info("配置加载成功。");
		} else {
			logger.error("配置加载失败，请检查。");
		}
		try {
			if (accountList != null && accountList.size() > 0) {
				for (String str : accountList) {
					Map<String, String> resultMap = new HashMap<String, String>();
					// 判断是否有密码
					if (!str.contains(Constants.accountSeparator)) {
						resultMap.put("target", str);
					} else {
						String[] mapArray = str
								.split(Constants.accountSeparator);
						resultMap.put("username", mapArray[0]);
						resultMap.put("password", mapArray[1]);
					}
					list.add(resultMap);
				}
			}
		} catch (Exception e) {
			logger.error("配置解析错误", e);
		}
		return list;
	}
}
