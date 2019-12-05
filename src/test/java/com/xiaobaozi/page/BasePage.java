package com.xiaobaozi.page;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.xiaobaozi.util.proUtil;



/**
 * @author xiaobaozi
 * Page类的基类，用来封装各类方法
 */
public class BasePage {
	WebDriver driver;
	private static Logger logger = Logger.getLogger(BasePage.class);
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		
	}

	/**
	 * 获取元素定位
	 * @param methon：定位方法
	 * @param location：定位元素
	 * @return：返回定位
	 */
	public By GetLocal(String method, String location) {
		By by = null;
		if(method.equals("name")) {
			by = By.name(location);
		}else if(method.equals("id")) {
			by = By.id(location);
		}else if(method.equals("class")) {
			by = By.className(location);	
		}else if(method.equals("css")) {
			by = By.cssSelector(location);
		}else if(method.equals("xpath")) {
			by = By.xpath(location);
		}else if(method.equals("tag")) {
			by = By.tagName(location);
		}else if(method.equals("linkText")){
			by = By.linkText(location);
		}else if(method.equals("parttialLinkTest")) {
			by = By.partialLinkText(location);	
		}
		return by;
	}
	
	/**
	 * 获取元素
	 * @param method
	 * @param location
	 * @return
	 */
	public WebElement GetElement(String key) {
		proUtil proutil = new proUtil("Element.properties");
		logger.debug("配置参数为"+key);
		String[] Locator = proutil.GetProperties(key);
		logger.debug("获取元素方法为"+Locator[0]);
		logger.debug("获取元素定位为"+Locator[1]);
		return driver.findElement(this.GetLocal(Locator[0], Locator[1]));
	}
	
	/**
	 * 获取所有子元素
	 * @param element
	 * @param key
	 * @return
	 */
	public List<WebElement> GetAllElement(WebElement element, String key) {
		proUtil proutil = new proUtil("Element.properties");
		logger.debug("配置参数为"+key);
		String[] Locator = proutil.GetProperties(key);
		logger.debug("获取元素方法为"+Locator[0]);
		logger.debug("获取元素定位为"+Locator[1]);
		return element.findElements(this.GetLocal(Locator[0], Locator[1]));
	}
	
	/**
	 * 获取子元素
	 * @param element
	 * @param key
	 * @return
	 */
	public WebElement getChildElement(WebElement element, String key) {
		proUtil proutil = new proUtil("Element.properties");
		logger.debug("配置参数为"+key);
		String[] Locator = proutil.GetProperties(key);
		logger.debug("获取元素方法为"+Locator[0]);
		logger.debug("获取元素定位为"+Locator[1]);
		return element.findElement(this.GetLocal(Locator[0], Locator[1]));
	}
	
	/**
	 * @param toElement
	 * 鼠标移动到指定元素上方
	 */
	public void move_element(WebElement toElement) {
		Actions action = new Actions(driver);
		action.moveToElement(toElement).perform();
	}
	
	/**
	 * 跳转至对应的弹窗
	 * @param toAlter
	 */
	public void switch_alter() {
		driver.switchTo().alert();
		
	}
	
	/**
	 * 跳转至对应的模态窗
	 */
	public void switchToModel() {
		driver.switchTo().activeElement();
		
	}
	
	// 植入cookie
	public void add_cookie() {
		String value = ("FmOWJjYjRhNzc5MzQzNDcxOTZmMjM4ZTExMTA1NzUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMjIwNTM2MwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA5Nzk0OTM5MzJAcXEuY29tAAAAAAAAAAAAAAAAAAAAADBkNTljOWUwZjgyODRiODUzOWJhOGNjNzcxYTNmYWFinifXXWtL1VY%3DMT");
		driver.manage().deleteAllCookies();
		Cookie cookie = new Cookie("apsid",value,".imooc.com","/",null);
		driver.manage().addCookie(cookie);
	}

}
