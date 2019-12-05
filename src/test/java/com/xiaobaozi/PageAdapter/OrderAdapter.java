package com.xiaobaozi.PageAdapter;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.xiaobaozi.pageCase.OrderCase;
import com.xiaobaozi.util.ScreenShotUtil;

public class OrderAdapter extends TestListenerAdapter{
	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestSuccess(tr);
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		OrderCase onetest = (OrderCase)tr.getInstance();
		WebDriver driver = onetest.driver;
		ScreenShotUtil ssutil = new ScreenShotUtil();
		ssutil.ScreenShot(driver);
		super.onTestFailure(tr);
	}

}
