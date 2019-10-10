package com.xml.utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * JAXP DOM解析的工具类
 * @author Administrator
 */
public class JaxpDomUtil {
	
	/**
	 * 通过uri获取document对象
	 * @param uri
	 * @return
	 * @throws Exception
	 */
	public static Document getDocumet(String uri) throws Exception{
		//获取解析器工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//获取解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		//解析xml	
		return builder.parse(uri);
	}
	
	/**
	 * 回写方法
	 * @param document
	 * @param uri
	 * @throws Exception 
	 */
	public static void writeXML(Document document,String uri) throws Exception{
		//获取回写工厂
		TransformerFactory factory = TransformerFactory.newInstance();
		//获取回写类
		Transformer transformer = factory.newTransformer();
		//调用回写方法
		transformer.transform(new DOMSource(document),new StreamResult(uri));
	}
}
