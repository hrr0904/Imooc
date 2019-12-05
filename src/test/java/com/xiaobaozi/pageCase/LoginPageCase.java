package com.xiaobaozi.pageCase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.xiaobaozi.Operate.LoginOperate;
import com.xiaobaozi.PageAdapter.LoginAdapter;

import org.testng.annotations.AfterClass;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

@Listeners({ LoginAdapter.class })
public class LoginPageCase extends BaseCase {
	LoginOperate loginOperate;
	
	public WebDriver driver;
	// SendEmailUtil emailUtil;
	private static Logger logger = Logger.getLogger(LoginPageCase.class);

	@Parameters({ "url1" })
	@BeforeClass
	public void BeforeClass(String url) {
		PropertyConfigurator.configure("log4j.properties");
		driver = initDriver("chrome");
		logger.debug("打开登录页面:" + url);
		driver.get(url);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// emailUtil = new SendEmailUtil();
		loginOperate = new LoginOperate(driver);

	}

	@Parameters({ "username", "password" })
	@Test
	public void Login(String username, String password) {
		loginOperate.user_login(username, password);
	}

	@AfterClass
	public void AfterClass() {
		driver.quit();
		// emailUtil.send();
	}

}
