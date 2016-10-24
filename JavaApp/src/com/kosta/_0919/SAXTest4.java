package com.kosta._0919;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest4 extends DefaultHandler {// implements ContentHandler{
	SAXParserFactory factory;
	SAXParser parser;

	// books.xml문서파싱을 하면서 ErrorHandler에 대한 테스트를 하시오
	// error(): valid체크, fatalError(): well-formed체크
	public SAXTest4() {
		try {
			factory = SAXParserFactory.newInstance();
			
			factory.setValidating(true);
			//DTD 또는 XML Schema의 형식을 체크할 때 setValidating(true)설정
			
			parser = factory.newSAXParser();
			// parser.parse(String uri, DefaultHandler dh);
			parser.parse("0919/books.xml", this);
			// DOM과 다르게 return void이므로 속도는 빠르지만, 한번 실행하고 끝
			System.out.println("##SAX파싱성공!!");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}// 생성자

	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("===DTD(Schema)형식에 맞지 않는 문서===");
		System.out.println(e.getMessage());
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("===XML문법에 맞지 않는 문서===");
		System.out.println(e.getMessage());
	}

	public static void main(String[] args) {
		new SAXTest4();
	}

}
