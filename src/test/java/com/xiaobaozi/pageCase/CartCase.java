package com.xiaobaozi.pageCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.xiaobaozi.Operate.AddCartOperate;
import com.xiaobaozi.Operate.LoginOperate;
import com.xiaobaozi.PageAdapter.CartAdapter;

@Listeners({ CartAdapter.class })
public class CartCase extends BaseCase {
	LoginOperate loginOperate;
	AddCartOperate cartOperate;

	public WebDriver driver;
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
		cartOperate = new AddCartOperate(driver);
		loginOperate.login_cookie();

	}

	@Parameters({ "url3" })
	@Test()
	public void AddCart(String url) {
		driver.get(url);
		cartOperate.Addcart();
	}

	@Test(dependsOnMethods = { "AddCart" })
	public void AddCart_exist() {
		cartOperate.AddCart_exist();
	}

	@org.testng.annotations.AfterClass
	public void AfterClass() {
		driver.quit();
	}

}
