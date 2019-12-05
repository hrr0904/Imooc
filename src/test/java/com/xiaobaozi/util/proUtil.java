package com.xiaobaozi.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class proUtil {
	String path;
	public proUtil(String path) {
		this.path = path;	
	}
	
	public Properties GetData(String key) {
		Properties pro = null;
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(path));
			pro = new Properties();
			pro.load(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	}
	
	public String[] GetProperties(String key){
		String[] property = null;
		Properties pro = this.GetData(key);
		String data = pro.getProperty(key);
		if(data!= null) {
			property = data.split(">");
		}
		return property;
	}
	
	

}
