package com.jason.beanutils.test;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.jason.beanutils.Person;

public class IntrospectorTest {
	
	@Test
	public void run() throws Exception{
		User user = new User();
		// 获取类的信息
		BeanInfo info = Introspector.getBeanInfo(user.getClass());
		// 获取属性的描述
		PropertyDescriptor [] pds = info.getPropertyDescriptors();
		// 循环遍历，获取属性的名称
		for (PropertyDescriptor pd : pds) {
			// System.out.println(pd.getName());
			if(!"class".equals(pd.getName())){
				// 获取写的方法
				Method m = pd.getWriteMethod();
				m.invoke(user, "admin");
			}
		}
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
	}
	
	@Test
	public void demo() throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Person person=new Person();
		System.out.println(person);
		BeanInfo info=Introspector.getBeanInfo(Person.class);
		//获取属性描述
		PropertyDescriptor[] propertyDescriptors = info.getPropertyDescriptors();
		//遍历输出
		System.out.println("----------------");
		for (PropertyDescriptor pd : propertyDescriptors) {
			if(!"class".equals(pd.getName())){
				if("name".equals(pd.getName())){
					//获取写方法
					Method writeMethod = pd.getWriteMethod();
					writeMethod.invoke(person, "xiaoming");
				}
			}
		}
		
		System.out.println(person);
	}
}