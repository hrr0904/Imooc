package com.xiaobaozi.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public WebElement Getsignin() {
		return GetElement("signin");
	}

	public WebElement Getemail() {
		return GetElement("username");	
	}
	
	public WebElement Getpassword() {
		return GetElement("password");	
	}
	
	public WebElement GetloginBtn() {
		return GetElement("login_btn");	
	}
	
	public WebElement GetCard() {
		return GetElement("card_info");	
	}
	
	public WebElement GetName() {
		return GetElement("name_info");	
	}
	
}
