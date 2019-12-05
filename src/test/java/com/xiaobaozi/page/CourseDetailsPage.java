package com.xiaobaozi.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 课程详情页
 * @author xiaobaozi
 *
 */
public class CourseDetailsPage extends BasePage{

	public CourseDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// 获取课程名称
	public WebElement getClassName() {
		return GetElement("coursename");
	}
	
	// 获取课程价格
	public WebElement getClassPrice() {
		return GetElement("courseprice");
	}
	
	// 获取立即购买按钮
	public WebElement getBuyBtn() {
		return GetElement("BuyBtn");
	}
	
	// 获取加入购物车按钮
	public WebElement getAddCartBtn() {
		return GetElement("cartBtn");
	}
	
	// 获取当前购物车数量
	public WebElement getCartNum() {
		return GetElement("cartNum");
	}
	
	// 获取购物车
	public WebElement getCart() {
		return GetElement("cart");
	}
	
	// 获取购物车里面的所有商品
	public List<WebElement> getAllCourse(){
		WebElement box = GetElement("cart_box");
		System.out.println("-------------------------------------"+"-----------------------------------");
		List<WebElement> lis = GetAllElement(box, "all_course");
		return lis;
	}
	
	// 获取购物车的每个商品名称
	@SuppressWarnings("null")
	public List<WebElement> getOneCourse() {
		List<WebElement> courseName = null;
		for(WebElement element:getAllCourse()) {
			System.out.println(getAllCourse());
			courseName.add(getChildElement(getChildElement(element, "one_course"),"one_name"));
			
		}
		return courseName;
	}
	
	// 获取提示弹窗
	public WebElement getAlter() {
		return GetElement("cart_alter");
	}
	
	// 获取去结算按钮
	public WebElement getGoPay() {
		return getChildElement(GetElement("cart_alter"), "go_pay");
	}

}
