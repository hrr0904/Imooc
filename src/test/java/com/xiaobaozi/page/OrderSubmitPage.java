package com.xiaobaozi.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSubmitPage extends BasePage {

	public OrderSubmitPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// 获取商品名称
	public WebElement getCourseTitle() {
		return GetElement("courseTitle");
	}

	// 获取商品价格
	public WebElement getPrice() {
		return GetElement("coursePrice");
	}

	// 获取提交订单按钮
	public WebElement getSubmitBtn() {
		return GetElement("submitBtn");
	}
	
	// 获取弹窗的提交订单按钮
	public WebElement getModalSubmit() {
		return GetElement("modal_sumit");
	}

}
