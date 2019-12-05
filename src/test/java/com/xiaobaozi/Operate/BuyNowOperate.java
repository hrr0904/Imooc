package com.xiaobaozi.Operate;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.xiaobaozi.Handle.CourseDetailsHandle;
import com.xiaobaozi.Handle.LoginPageHandle;
import com.xiaobaozi.Handle.OrderPayHandle;
import com.xiaobaozi.Handle.OrderSubmitHandle;
import com.xiaobaozi.page.LoginPage;

public class BuyNowOperate {
	LoginPage loginpage;
	private static Logger logger = Logger.getLogger(LoginPageHandle.class);
	
	CourseDetailsHandle courseHandle;
	OrderSubmitHandle submitHandle;
	OrderPayHandle payHandle;
	public BuyNowOperate(WebDriver driver) {
		courseHandle = new CourseDetailsHandle(driver);
		submitHandle = new OrderSubmitHandle(driver);
		payHandle = new OrderPayHandle(driver);
	}
	
	/**
	 * 登录态立即购买未购买过的商品
	 */
	public void buy_now() {
		// 输出课程名称
		String cuorseName = courseHandle.getCourseName();
		// 输出课程价格
		System.out.println(courseHandle.getCoursePrice());
		// 点击加入立即购买
		courseHandle.click_buy();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取提交订单页面的课程名称
		String cursetitle = submitHandle.getTitle();
		logger.debug("判断课程名称是否相同");
		if(cuorseName.equals(cursetitle)) {
			// 获取订单页面的该课程价格
			System.out.println(submitHandle.getPrice());
			// 点击提交订单按钮
			submitHandle.click_submit();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 获取订单编号
			String orderNum= payHandle.getNum();
			if(orderNum != null) {
				logger.debug("订单编号为："+ orderNum);
				// 点击立即支付
				payHandle.click_payBtn();
			}	
		}
		else {
			System.out.println("提交订单页面的课程名称与课程详情页的课程名称不相符");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 点击立即购买，但已存在对应的订单
	 */
	public void buyNow_exist() {
		// 点击加入立即购买
		courseHandle.click_buy();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 点击提交订单按钮
		submitHandle.click_submit();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		submitHandle.click_modalSubmit();
		
	}
	
}
