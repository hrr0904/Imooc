package com.xiaobaozi.Handle;

import org.openqa.selenium.WebDriver;

import com.xiaobaozi.page.OrderPayPage;

public class OrderPayHandle {
	OrderPayPage orderPayPage;
	public OrderPayHandle(WebDriver driver) {
		orderPayPage  = new OrderPayPage(driver);
	}
	
	//获取订单编号
	public String getNum() {
		return orderPayPage.getOrderNum().getText();
	}
	
	//获取订单价格
	public String getPrice() {
		return orderPayPage.getOrderPrice().getText();
	}
	
	//点击支付按钮
	public void click_payBtn() {
		orderPayPage.getOrderPay().click();
	}
	
}
