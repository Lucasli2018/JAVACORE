package com.jason.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 统计网站的访问次数
 * @author Administrator
 *
 */
public class CountServlet extends HttpServlet {
	
	

	/**
	 * 初始化访问次数0
	 */
	@Override
	public void init() throws ServletException {
		this.getServletContext().setAttribute("count", 0);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取ServletContext
		ServletContext context = this.getServletContext();
		//从ServletContext获取count值
		Integer count = (Integer) context.getAttribute("count");
		//count+1
		context.setAttribute("count", ++count);
		//设置编码
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("<h3>大爷，欢迎再来哦！</h3>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
