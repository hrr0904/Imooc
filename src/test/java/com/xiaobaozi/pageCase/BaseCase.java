package com.xiaobaozi.pageCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseCase {
	WebDriver driver;
	public WebDriver initDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\eclipse\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		return driver;
		
	}

}
