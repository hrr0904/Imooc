package com.xiaobaozi.Handle;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.xiaobaozi.page.LoginPage;


public class LoginPageHandle {
	/*
	 * 1、给邮箱输入框，密码输入框输入内容
	 * 2、点击登录按钮
	 */
	
	LoginPage loginpage;
	private static Logger logger = Logger.getLogger(LoginPageHandle.class);
	
	public LoginPageHandle(WebDriver driver) {
		loginpage = new LoginPage(driver);
	}
	
	public void click_signin() {
		loginpage.Getsignin().click();
	}
	
	public void set_email(String email) {
		logger.debug("输入登录邮箱"+email);
		loginpage.Getemail().sendKeys(email);
	}
	
	public void set_password(String password) {
		logger.debug("输入登录密码"+password);
		loginpage.Getpassword().sendKeys(password);;
	}
	
	public void click_loginBtn() {
		logger.debug("点击登录按钮");
		loginpage.GetloginBtn().click();
	}
	
	public void move_to_element() {
		logger.debug("鼠标移动到指定位置");
		loginpage.move_element(loginpage.GetCard());
	}
	
	public String get_usernama() {
		WebElement name = loginpage.GetName();
		String username =  name.getText();
		logger.debug("登录用户名为"+username);
		return username;
	}
	
	//注入cookie
	public void init_cookie() {
		logger.debug("注入cookie，实现登录");
		loginpage.add_cookie();
	}
}
