package com.xiaobaozi.Operate;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.xiaobaozi.Handle.CourseDetailsHandle;
import com.xiaobaozi.Handle.LoginPageHandle;

public class AddCartOperate {
	CourseDetailsHandle courseHandle;
	LoginPageHandle loginHandle;
	private static Logger logger = Logger.getLogger(AddCartOperate.class);

	public AddCartOperate(WebDriver driver) {
		courseHandle = new CourseDetailsHandle(driver);
		loginHandle = new LoginPageHandle(driver);
	}
	
	/**
	 * 登录态下加入购物车
	 */
	public void Addcart() {
		// 获取当前购物车的数量
		int before_num = courseHandle.get_cartNum();
		logger.debug("点击加入购物车前，当前的购物车数量为：" + before_num);
		// 点击添加购物车
		courseHandle.click_addcart();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取点击添加购物车之后的数量
		int after_num = courseHandle.get_cartNum();
		logger.debug("点击加入购物车后，当前的购物车数量为：" + after_num);
		// 判断数量是否有添加
		if (after_num == (before_num + 1)) {
			logger.debug("添加成功！！！");
		} else {
			System.out.println("未添加成功");
		}
	}
	
	/**
	 * 商品已在购物车，点击添加购物车 基于添加购物车操作，再次操作
	 */
	public void AddCart_exist() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("再次点击加入购物车");
		// 点击添加购物车
		courseHandle.click_addcart();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 点击立即购买
		logger.debug("点击立即支付");
		courseHandle.click_go();

	}

}
