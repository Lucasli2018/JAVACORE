package com.jason.utils;

import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * Dom4j的工具类
 * @author Administrator
 */
public class Dom4jUtil {

	/**
	 * 根据uri获取根节点
	 * @param uri
	 * @return
	 * @throws Exception
	 */
	public static Element getRoot(String uri) throws Exception{
		//获取解析器
		SAXReader reader=new SAXReader();
		//解析
		Document document = reader.read(uri);
		//获取跟根节点
		return document.getRootElement();
	}
	
	/**
	 * 回写xml
	 * 格式化，编码utf8
	 * @throws Exception 
	 */
	public static void writeXML(String uri,Node document) throws Exception{
		//设置漂亮的格式
		OutputFormat format=OutputFormat.createPrettyPrint();
		//设置编码
		format.setEncoding("UTF-8");
		//获取回写类
		XMLWriter writer=new XMLWriter(new FileOutputStream(uri),format);
		//回写方法
		writer.write(document);
		//关闭流
		writer.close();
	}
}
