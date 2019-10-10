package com.xml.jaxp;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("开始标签："+qName);
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content=new String(ch, start, length);
		System.out.println(content);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("结束标签："+qName);
	}
	
}
