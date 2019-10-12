package com.jason.response;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 解决中文乱码
 * @author Administrator
 *
 */
public class Test2Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		run1(response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 字符输出中文是否乱码呢？
	 * 	* 肯定乱码
	 * 		response缓冲区的编码，默认值ISO-8859-1
	 * 	* 设置response缓冲编码		
	 * 		response.setCharacterEncoding("UTF-8");
	 *  * 设置浏览器打开文件所采用的编码
	 *  	response.setHeader("Content-Type", "text/html;charset=UTF-8");
	 *  * 简写方式
	 *  	response.setContentType("text/html;charset=UTF-8");
	 * 		
	 * @param response
	 * @throws IOException
	 */
	public void run2(HttpServletResponse response) throws IOException{
		// 设置response缓冲区的编码
		//response.setCharacterEncoding("UTF-8");
		// 设置浏览器打开文件所采用的编码
		//response.setHeader("Content-Type", "text/html;charset=UTF-8");
		
		// 简写的形式（等于上面两句）
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("哈罗卧得");
	}
	
	/**
	 * 字节的输出中文的乱码
	 * 	* 输出哈罗我的是否乱码呢？
	 * 		* 不一定乱码。
	 * 	* 解决办法
	 * 		* 设置浏览器打开文件时所采用的编码
	 * 			response.setHeader("Content-Type", "text/html;charset=UTF-8");
	 * 		* 获取字符串byte数组时编码和打开文件时编码一致。
	 * 			"哈罗我的".getBytes("UTF-8")
	 * @throws IOException 
	 */
	public void run1(HttpServletResponse response) throws IOException{
		// 设置浏览器打开文件时编码
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		// 获取字节输出流
		OutputStream os = response.getOutputStream();
		// 输出中文
		os.write("哈罗我的".getBytes("UTF-8"));
	}

}
