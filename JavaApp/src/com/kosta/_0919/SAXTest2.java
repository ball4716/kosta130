package com.kosta._0919;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest2 extends DefaultHandler{//implements ContentHandler{
	SAXParserFactory factory;
	SAXParser parser;
	
	//XML문서를 읽어서 화면콘솔에 출력
	public SAXTest2() {
		try {
			factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			
			//parser.parse(String uri, DefaultHandler dh);
			parser.parse("0919/books.xml", this);
			//DOM과 다르게 return void이므로 속도는 빠르지만, 한번 실행하고 끝
			System.out.println("##SAX파싱성공!!");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}//생성자
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//문서내의 모든 시작태그를 만났을 때 <--- 이벤트
		//태그마다 각각 호출, 매개변수를 통해 엘리먼트에 대한 정보를 전달.
		//qName : 태그이름 전달
		//attributes: 시작태그가 포함할 수 있는 속성의 값을 전달
		System.out.print("<"+qName);
		//속성 출력
		//attributes.getLength();//속성의 개수
		for (int i = 0; i < attributes.getLength(); i++) {
			String attName = attributes.getQName(i);//속성명
			String attValue = attributes.getValue(i);//속성값
			System.out.print(" "+attName+"='"+attValue+"'");
		}
		System.out.print(">");
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.print("</"+qName+">");
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch, start, length);
		//엔터값과 공백도 출력!!
		System.out.print(str);
	}
	
	public static void main(String[] args) {
		new SAXTest2();
	}

	
}
