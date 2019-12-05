package com.xiaobaozi.util;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SendEmailUtil {
	
	MultiPartEmail email = new MultiPartEmail();
	
	public SendEmailUtil() {
		email.setHostName("smtp.163.com");
		email.setAuthentication("18813975031@163.com", "herr1995");
		try {
			email.setFrom("18813975031@163.com");
			email.addTo("979493932@qq.com");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setSubject(String subject) {
		email.setSubject(subject);
	}
	
	public void setTextBody(String body) {
		try {
			email.setMsg(body);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 发送附件文件
	public void setAnnex(String path, String description, String name) {
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(path);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		//文件描述
		attachment.setDescription(description);
		// 文件名称
		attachment.setName(name);
		try {
			email.attach(attachment);
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendEmail() {
		try {
			email.send();
			System.out.println("邮件发送完成");
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void send() {
		SendEmailUtil send = new SendEmailUtil();
		send.setSubject("自动化测试报告");
		send.setTextBody("这是自动化测试结果，请查收");
		send.setAnnex("F:\\eclipse\\Imooc\\reporter\\report.html", "测试结果 - 测试报告", "report.html");
		send.sendEmail();
	}

}
