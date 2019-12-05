package com.xiaobaozi.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPayPage extends BasePage{
	
	public OrderPayPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//定位订单编号
	public WebElement getOrderNum(){
		return GetElement("order_id");
	}
	
	//获取订单金额
	public WebElement getOrderPrice() {
		return GetElement("order_price");
	}
	
	//获取订单支付按钮
	public WebElement getOrderPay() {
		return GetElement("order_pay");
	}
}
