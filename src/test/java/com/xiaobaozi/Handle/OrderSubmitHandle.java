package com.xiaobaozi.Handle;

import org.openqa.selenium.WebDriver;

import com.xiaobaozi.page.OrderSubmitPage;

public class OrderSubmitHandle {
	
	OrderSubmitPage submitPage;
	public OrderSubmitHandle(WebDriver driver) {
		submitPage = new OrderSubmitPage(driver);
	}
	
	// 获取课程名称
	public String getTitle() {
		return submitPage.getCourseTitle().getText();
	}
	
	// 获取课程价格
	public String getPrice() {
		return submitPage.getPrice().getText();
	}
	
	// 点击提交订单按钮
	public void click_submit() {
		submitPage.getSubmitBtn().click();
	}
	
	// 点击弹窗的前往订单中心的按钮
	public void click_modalSubmit() {
		submitPage.getModalSubmit().click();
	}

}
