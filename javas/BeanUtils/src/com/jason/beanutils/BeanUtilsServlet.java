package com.jason.beanutils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import com.jason.beanutils.convert.MyDateConverter;

/**
 * 使用BeanUtils 框架，完成将请求参数自动封装 JavaBean对象中
 */
public class BeanUtilsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 处理乱码
		request.setCharacterEncoding("utf-8");
		// 定义目标对象
		Person person = new Person();
		// 获得请求参数map
		Map<String, String[]> parameterMap = request.getParameterMap();
		
		// 在封装之前 注册转换器
		//ConvertUtils.register(new MyDateConverter(), Date.class);
		try {
			BeanUtils.populate(person, parameterMap);
			// 在封装 有一个类型自动转换
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.getSalary());
		System.out.println(person.getBirthday());
		System.out.println(person.getCity());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
