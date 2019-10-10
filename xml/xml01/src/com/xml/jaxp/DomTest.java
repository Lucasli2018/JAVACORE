package com.xml.jaxp;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**jaxp的dom解析xml
 * @author Administrator
 *
 */
public class DomTest {
	
	private String uri="src/book.xml";
	
	/**
	 * 需求：在第二本下，在末尾添加子节点
	 * @throws Exception 
	 */
	@Test
	public void demo02() throws Exception{
		//创建工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获取解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		//解析xml
		Document document = builder.parse(uri);
		//获取第二本书
		Node book2 = document.getElementsByTagName("书").item(1);
		//创建元素
		Element cat = document.createElement("猫");
		//设置文本
		cat.setTextContent("我是一只猫咪");
		//把元素对象添加到第二本书
		book2.appendChild(cat);
		//回写
		//创建回写工厂类
		TransformerFactory factory2 = TransformerFactory.newInstance();
		//创建回写类
		Transformer transformer = factory2.newTransformer();
		//回写方法 transform
		transformer.transform(new DOMSource(document), new StreamResult(uri));
	}
	
	/**
	 * 获取作者的文本内容
	 * @throws Exception 
	 */
	@Test
	public void demo01() throws Exception{
		//创建工厂
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		//创建解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		//解析
		Document document = builder.parse(uri);
		// 获取作者元素对象的集合，返回NodeList
		NodeList nodeList = document.getElementsByTagName("作者");
		// 循环遍历，拿到每一个作者，打印文本的内容，getTextContent()
		for(int i=0;i<nodeList.getLength();i++){
			Node node = nodeList.item(i);
			System.out.println(node.getTextContent());
		}
	}
}
