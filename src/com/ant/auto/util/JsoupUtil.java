package com.ant.auto.util;

import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 提供jsoup获取内容的类
 * 
 * @author:sekift
 * @time:2014-8-11 上午11:10:46
 * @version:
 */
public class JsoupUtil {
	// 连接时间
	public static final int connectTime = 5 * 60 * 60;// 5分钟
	// 默认的html模板
	public static final String html = "<html><head></head><bode></body></html>";

	public static Elements getByTag(String url, String tagName) {
		return getDocByConnect(url).getElementsByTag(tagName);
	}

	public static Elements getByAttrClass(String url, String className) {
		return getDocByConnect(url).getElementsByClass(className);
	}

	public static Element getByAttrId(String url, String idName) {
		return getDocByConnect(url).getElementById(idName);
	}

	// 获取doc connect方式
	public static Document getDocByConnect(String url) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).timeout(connectTime).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}

	// 获取doc connect ignore content方式
	public static Document getDocByConnectIgnoreContent(String url) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).timeout(connectTime).ignoreContentType(true).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}

	// 获取doc parse方式
	public static Document getDocByParse(String url) {
		Document doc = null;
		try {
			doc = Jsoup.parse(new URL(url), connectTime);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	public static void main(String args[]){
		//
		Document doc = getDocByParse("https://tieba.baidu.com/?page=like");
		System.out.println(doc.getElementById("likeforumwraper"));
	}
}
