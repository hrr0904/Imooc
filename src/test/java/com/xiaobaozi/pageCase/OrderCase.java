package com.xiaobaozi.pageCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.xiaobaozi.Operate.AddCartOperate;
import com.xiaobaozi.Operate.BuyNowOperate;
import com.xiaobaozi.Operate.LoginOperate;
import com.xiaobaozi.PageAdapter.OrderAdapter;

@Listeners({ OrderAdapter.class })
public class OrderCase extends BaseCase{
	public WebDriver driver;
	
	LoginOperate loginOperate;
	BuyNowOperate buyOperate;
	AddCartOperate cartOperate;
	
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
		loginOperate = new LoginOperate(driver);
		buyOperate = new BuyNowOperate(driver);
		cartOperate = new AddCartOperate(driver);

	}

	@Parameters({ "username", "password" })
	@Test
	public void Login(String username, String password) {
		loginOperate.user_login(username, password);
	}

	@Parameters({ "url2" })
	@Test(dependsOnMethods = { "Login" })
	public void BuyCourse(String url) {
		driver.get(url);
		buyOperate.buy_now();

	}
	
	@Parameters({ "url2" })
	@Test(dependsOnMethods = { "BuyCourse" })
	public void BuyNow_exist(String url) {
		driver.get(url);
		buyOperate.buyNow_exist();
		logger.debug("已完成操作！！！");
	}
	
	@org.testng.annotations.AfterClass
	public void AfterClass() {
		driver.quit();
	}
	
}
