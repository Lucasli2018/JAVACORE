package com.jason.dom4j;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import com.jason.utils.Dom4jUtil;

/**DOM4J的解析XML
 * @author Administrator
 *
 */
public class Dom4jTest {

	private String uri="src/book2.xml";
	
	/**
	 * 修改文本内容
	 * 	修改第二本书下的狗节点
	 * @throws Exception 
	 */
	@Test
	public void demo05() throws Exception{
		SAXReader reader =new SAXReader();
		Document document = reader.read(uri);
		Element rootElement = document.getRootElement();
		Element book2 = (Element) rootElement.elements("书").get(1);
		//获取狗
		Element dog = book2.element("狗");
		//修改文本
		dog.setText("小狗狗");
		Dom4jUtil.writeXML(uri, document);
	}
	
	/**
	 * 删除子节点
	 * 	删除第二本书下的猫节点
	 * @throws Exception 
	 */
	@Test
	public void demo04() throws Exception{
		//获取解析器
		SAXReader reader=new SAXReader();
		//解析xml
		Document document = reader.read(uri);
		//获取根节点
		Element rootElement = document.getRootElement();
		
		//获取第二本书
		Element book2 = (Element) rootElement.elements("书").get(1);
		//获取猫
		Element cat = book2.element("猫");
		//删除猫
		book2.remove(cat);
		
		//回写
		Dom4jUtil.writeXML(uri, document);
	}
	
	/**
	 * 在第二本书的作者标签之前添加团购价的标签
	 * @throws Exception 
	 */
	@Test
	public void demo03() throws Exception{
		//获取解析器
		SAXReader reader=new SAXReader();
		//解析xml
		Document document = reader.read(uri);
		//获取根节点
		Element rootElement = document.getRootElement();
		//获取第二本书
		Element book2 = (Element) rootElement.elements("书").get(1);
		// 获取书下的所有子节点，返回List集合
		List<Element> list = book2.elements();
		//DocumentHelper创建团购价标签，设置文本
		Element dog = DocumentHelper.createElement("狗");
		dog.setText("大狗狗");
		//添加到第二本书的作者之前
		list.add(1, dog);
		//回写
		Dom4jUtil.writeXML(uri, document);
	}
	
	/**
	 * 在第二本书下添加子节点<猫>
	 * @throws Exception 
	 */
	@Test
	public void demo02() throws Exception{
		//获取解析器，解析xml，获取根节点
		//Element root = Dom4jUtil.getRoot(uri);
		SAXReader reader=new SAXReader();
		Document document = reader.read(uri);
		Element root = document.getRootElement();
		
		//获取第二本书
		List<Element> books = root.elements("书");
		Element book2 = books.get(1);
		//可以直接在第二本书下添加子节点，设置文本内容
		book2.addElement("猫").setText("我是猫");
		
		//回写
		//设置漂亮的格式
		OutputFormat format=OutputFormat.createPrettyPrint();
		//设置编码
		format.setEncoding("UTF-8");
		
		//创建回写类
		XMLWriter writer=new XMLWriter(new FileOutputStream(uri),format);
		//回写对象
		writer.write(document);
		//关闭流
		writer.close();
	}
	
	/**
	 * 获取第二本书作者的文本内容
	 * @throws Exception 
	 */
	@Test
	public void demo01() throws Exception{
		//获取解析器
		SAXReader reader=new SAXReader();
		//解析xml
		Document document = reader.read(uri);
		//获取根节点
		Element root = document.getRootElement();
		//获取第二本书
		List books = root.elements("书");
		Element book2 = (Element) books.get(1);
		//获取作者标签
		Element author2 = book2.element("作者");
		//获取文本
		System.out.println(author2.getText());
	}
}
