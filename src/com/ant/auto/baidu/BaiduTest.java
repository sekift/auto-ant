package com.ant.auto.baidu;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BaiduTest {

	public static void main(String[] args) {
//		System.setProperty("webdriver.chrome.driver",
//				"D:\\selenium\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "D:\\selenium\\geckodriver.exe");
		File pathBinary = new File("D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		WebDriver driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
//		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new FirefoxDriver(capabilities);
		driver.manage().window().setSize(new Dimension(400, 800));
		
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();

		// 输入框输入内容
		driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("selenium");

		// 删除一个m
		driver.findElement(By.xpath("//*[@id='kw']")).sendKeys(Keys.BACK_SPACE);

		// 输入m 空格 教程
		driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("m");
		driver.findElement(By.xpath("//*[@id='kw']")).sendKeys(Keys.SPACE);
		driver.findElement(By.xpath("//*[@id='kw']")).sendKeys("教程");

		// 全选输入框内容
		driver.findElement(By.xpath("//*[@id='kw']")).sendKeys(Keys.CONTROL,
				"a");

		// 剪切输入框内容
		driver.findElement(By.xpath("//*[@id='kw']")).sendKeys(Keys.CONTROL,
				"x");

		// 粘贴输入框内容
		driver.findElement(By.xpath("//*[@id='kw']")).sendKeys(Keys.CONTROL,
				"v");

		// 通过回车来代替提交动作
		driver.findElement(By.xpath("//*[@id='kw']")).sendKeys(Keys.ENTER);

		// 开发者模式
		driver.findElement(By.xpath("//*[@id='kw']")).sendKeys(Keys.CONTROL,Keys.SHIFT
				,"i");
		
		waitTime(5000);
		driver.quit();
	}

	static public void waitTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
