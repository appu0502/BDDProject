package com.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static String relativePath =System.getProperty("user.dir");
	public static Properties getProperties() throws IOException {
		String strPath = relativePath + "/src/test/java/resources/config.properties";
		FileInputStream fi = new FileInputStream(strPath);
		prop = new Properties();
		prop.load(fi);
		fi.close();
		return prop;
	}

	public static WebDriver getDriver() {
		try {
			prop = getProperties();

			System.setProperty("webdriver.chrome.driver",relativePath + "/src/test/java/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(130,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}catch(Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
}
