package com.xiaobaozi.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author xiaobaozi
 *截图方法工具类
 */
public class ScreenShotUtil {
	
	public void ScreenShot(WebDriver driver) {
		//设置文件名称
		long date = System.currentTimeMillis();
		String name = String.valueOf(date);
		//获取路径
		String path = System.getProperty("user.dir")+"\\image\\";
		//文件名
		String filePath = path + name + ".PNG";
		// 截图
		File screenfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// 截图复制到硬盘
		try {
			FileUtils.copyFile(screenfile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
