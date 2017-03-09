package com.gooddeep.dev.core.helper;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

 
 public class MailHelper { 
 
	 //!!!!!!!!!!!!!!注意，qq邮箱要先开启smpt,账户 ->开启服务：POP3/SMTP服务
	 //登录邮箱的密码为开启POP3/SMTP服务的 独立密码
	 
	    private  final static String mailServerHost="smtp.163.com";    
	    private final static String mailServerPort = "25";    
	    // 邮件发送者的地址    
	    private final  static String fromAddress="lhyxcxy@163.com";    
	      private final static String protocol="smtp";
	   
	    // 登陆邮件发送服务器的用户名和密码    
	    private final static String userName="lhyxcxy@163.com";    
	    private final static String password="a306924161b";  
	    //gsaucljpbwdqbhbd
	    // 是否需要身份验证    
	    private final static boolean validate = true;    
	    private  String toAddress;   
	    private String mailTitle;
	    private String mailContent;


		

	
	public void sendMail() throws Exception { 
         Properties props = new Properties(); 
         //设置使用smtp协议发送
         props.put("mail.transport.protocol", protocol);
         props.put("mail.smtp.port", mailServerPort);    
         //设置发送邮件的服务器
         props.put("mail.smtp.host", mailServerHost); 
         //设置服务器验证
         props.put("mail.smtp.auth", validate); 
         //基本的邮件会话 

         Session session = Session.getDefaultInstance(props); 
         //Session session = Session.getInstance(props); 
         //构造信息体 
         MimeMessage message = new MimeMessage(session); 
         //发件地址 
         Address address = new InternetAddress(fromAddress); 
         message.setFrom(address); 
         //收件地址 
           Address toAddress2 = new InternetAddress(toAddress);
          message.setRecipient(MimeMessage.RecipientType.TO, toAddress2); 

        
         //主题 
         message.setSubject(mailTitle); 
         //正文  文本格式
         //message.setText("Hello world"); 
         String body=mailContent;
         //html格式
         message.setContent(body, "text/html;charset = gbk"); 
         message.saveChanges(); // implicit with send() 
         session.setDebug(true); //控制输出
         Transport transport = session.getTransport(); 
         transport.connect(mailServerHost, userName, password); 
        transport.sendMessage(message, message.getAllRecipients()); 
        transport.close(); 
 
     }


	public String getToAddress() {
		return toAddress;
	}


	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}


	public String getMailTitle() {
		return mailTitle;
	}


	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}



	public String getMailContent() {
		return mailContent;
	}



	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	
	
	public static void main(String[] args) throws Exception {
		MailHelper mh=new  MailHelper();
				mh.setToAddress("122043580@qq.com");
		mh.setMailTitle("优深用户注册验证");
		mh.setMailContent("请点击以下链接完成验");

		mh.sendMail();
	
	}
     
     
 } 