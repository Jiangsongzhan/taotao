package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class FTPTest {
	@Test
	public void testFtpClient() throws Exception{
		//创建一个FTPClient对象
		FTPClient client = new FTPClient();
		//创建ftp连接,默认21端口号
		client.connect("192.168.112.130",21);
		//登录发图片服务器,使用用户名和密码
		client.login("ftpuser", "ftpuser");
		//上传文件
		//读取本地文件
		FileInputStream fis = new FileInputStream(new File("E:\\java\\road.png"));
		//设置上传路径
		client.changeWorkingDirectory("/home/ftpuser/www/images");
		//修改上传文件的格式
		client.setFileType(FTP.BINARY_FILE_TYPE);
		//上传
		client.storeFile("hello1.png", fis);
		client.logout();
		
	}
}
