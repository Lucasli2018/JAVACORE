package com.jason.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * Dom4j的Xpath用法
 * @author Administrator
 *
 */
public class XpathTest {

	private String uri="src/book2.xml";
	
	/**
	 * 获取第二本书的作者
	 * @throws Exception
	 */
	@Test
	public void demo01() throws Exception{
		//获取解析器
		SAXReader reader=new SAXReader();
		//解析xml
		Document document = reader.read(uri);
		
		//xpath语法
		//List<Node> list = document.selectNodes("/书架/书/作者	");
		List<Node> list = document.selectNodes("//作者");
		Node node = list.get(1);
		System.out.println(node.getText());
	}
}
