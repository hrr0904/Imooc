package com.xiaobaozi.Operate;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.xiaobaozi.Handle.LoginPageHandle;
import com.xiaobaozi.page.LoginPage;

public class LoginOperate {
	LoginPage loginpage;
	private static Logger logger = Logger.getLogger(LoginPageHandle.class);
	LoginPageHandle loginHandle;
	public LoginOperate(WebDriver driver) {
		loginHandle = new LoginPageHandle(driver);
	}
	
	public void user_login(String email, String password) {
		loginHandle.click_signin();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		loginHandle.set_email(email);
		loginHandle.set_password(password);
		loginHandle.click_loginBtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginHandle.move_to_element();
		String name = loginHandle.get_usernama();
		logger.debug("判断登录用户是否正确");
		Assert.assertEquals(name, "莲蓉包");
		
	}
	
	
	public void login_cookie() {
		loginHandle.init_cookie();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}


}
