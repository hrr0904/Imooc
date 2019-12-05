package com.xiaobaozi.PageAdapter;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.xiaobaozi.pageCase.LoginPageCase;
import com.xiaobaozi.util.ScreenShotUtil;

public class LoginAdapter extends TestListenerAdapter{
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestSuccess(tr);
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		LoginPageCase onetest = (LoginPageCase)tr.getInstance();
		WebDriver driver = onetest.driver;
		ScreenShotUtil ssutil = new ScreenShotUtil();
		ssutil.ScreenShot(driver);
		super.onTestFailure(tr);
	}

}
