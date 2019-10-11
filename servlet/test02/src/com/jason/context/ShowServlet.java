package com.jason.context;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 显示访问次数
 * @author Administrator
 *
 */
public class ShowServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取ServletContext
		Integer count = (Integer) this.getServletContext().getAttribute("count");
		//设置编码
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("<h3>网站被访问 <font color='red'>"+count+"</font> 次</h3>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
