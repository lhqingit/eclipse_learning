package com.lhq.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 自定义邮件作业类
 * @author lhq_i
 *
 */
public class MailJob {
	
	private String username;
	private String password;
	private String smtpServer;
	private String receiverAddress;//收件人地址
	private int count = 0;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSmtpServer() {
		return smtpServer;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	

	public void run() {
		
		count++;
		
		String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

		System.out.println("要发邮件了。。。");
		System.out.println("当前时间为：" + dateStr);
		try {

			Properties properties = new Properties();
			properties.put("mail.transport.protocol", "smtp");// 连接协议        
			properties.put("mail.smtp.host", smtpServer);// 主机名        
			properties.put("mail.smtp.port", 465);// 端口号        
			properties.put("mail.smtp.auth", "true");        
			properties.put("mail.smtp.ssl.enable", "true");//设置是否使用ssl安全连接  ---一般都使用        
			properties.put("mail.debug", "true");//设置是否显示debug信息  true 会在控制台显示相关信息        
			//得到会话对象        
			Session session = Session.getInstance(properties);        
			// 获取邮件对象        
			Message message = new MimeMessage(session);        
			//设置发件人邮箱地址       
			message.setFrom(new InternetAddress(username, "神秘人", "UTF-8"));       
			//设置收件人地址        
			message.setRecipients(RecipientType.TO, new InternetAddress[] { new InternetAddress(receiverAddress) });       	
			//设置邮件标题        
			message.setSubject("哈喽");        
			//设置邮件内容        
			message.setText("哈喽~我是quartz在" + dateStr + "定时发送的第" + count + "封邮件哦~");       
			//得到邮差对象        
			Transport transport = session.getTransport();        
			//连接自己的邮箱账户        
			transport.connect(username, password);//密码为刚才得到的授权码        
			//发送邮件       
			transport.sendMessage(message, message.getAllRecipients());    
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
