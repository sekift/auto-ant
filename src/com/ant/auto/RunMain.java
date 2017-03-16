package com.ant.auto;

import java.util.List;
import java.util.Map;

import com.ant.auto.core.AssembleProperties;

public class RunMain {
	public static void main(String args[]) {
		List<Map<String, String>> list = AssembleProperties.loadPro(
				"toutiao_target", "account");
		for (Map<String, String> map : list) {
			System.out.println(map.get("toutiao_target"));
		}
	}
}
