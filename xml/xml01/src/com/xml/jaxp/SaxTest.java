package com.xml.jaxp;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.SAXException;

/**jaxp的SAX解析xml
 * @author Administrator
 *
 */
public class SaxTest {
	
	private String uri="src/book.xml";

	/**
	 * 获取所有的解析的内容
	 * @throws Exception 
	 */
	@Test
	public void demo01() throws Exception{
		//获取sax的解析工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//获取解析器
		SAXParser parser = factory.newSAXParser();
		//解析xml
		parser.parse(uri, new MyHandler());
	}
}
