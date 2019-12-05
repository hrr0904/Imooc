package com.xiaobaozi.Handle;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.xiaobaozi.page.CourseDetailsPage;

public class CourseDetailsHandle {
	CourseDetailsPage detailsPage;
	
	public CourseDetailsHandle(WebDriver driver) {
		detailsPage = new CourseDetailsPage(driver);
		
	}
	
	// 获取当前课程名称
	public String getCourseName() {
		return detailsPage.getClassName().getText();
	}
	
	// 获取课程价格
	public String getCoursePrice() {
		return detailsPage.getClassPrice().getText();
	}
	
	// 点击立即购买按钮
	public void click_buy() {
		detailsPage.getBuyBtn().click();
	}
	
	// 点击立即购买
	public void click_addcart() {
		detailsPage.getAddCartBtn().click();
		
	}
	
	// 查看当前的购物车数量
	public int get_cartNum() {
		WebElement cartNum = detailsPage.getCartNum();
		try {
			int num = Integer.parseInt(cartNum.getText());
			return num;
		}catch(Exception e){
			return 0;
			
		}	
	}
	
	// 鼠标移动至购物车
	public void move_cart() {
		detailsPage.move_element(detailsPage.getCart());
	}
	
	// 点击购物车按钮
	public void click_cart() {
		detailsPage.getCart().click();
	}
	
	// 获取每个商品名称
	@SuppressWarnings("null")
	public List<String> getAllName(){
		List<String> name = null;
		for(WebElement element:detailsPage.getAllCourse()) {
			name.add(element.getText());
		}
		return null;
	}
	
	public void click_go() {
		detailsPage.getGoPay().click();
	}
	
	
	public void SwitchToModel() {
		detailsPage.switchToModel();
	}

}
