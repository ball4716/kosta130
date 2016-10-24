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

	// books.xml�����Ľ��� �ϸ鼭 ErrorHandler�� ���� �׽�Ʈ�� �Ͻÿ�
	// error(): validüũ, fatalError(): well-formedüũ
	public SAXTest4() {
		try {
			factory = SAXParserFactory.newInstance();
			
			factory.setValidating(true);
			//DTD �Ǵ� XML Schema�� ������ üũ�� �� setValidating(true)����
			
			parser = factory.newSAXParser();
			// parser.parse(String uri, DefaultHandler dh);
			parser.parse("0919/books.xml", this);
			// DOM�� �ٸ��� return void�̹Ƿ� �ӵ��� ��������, �ѹ� �����ϰ� ��
			System.out.println("##SAX�Ľ̼���!!");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}// ������

	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("===DTD(Schema)���Ŀ� ���� �ʴ� ����===");
		System.out.println(e.getMessage());
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("===XML������ ���� �ʴ� ����===");
		System.out.println(e.getMessage());
	}

	public static void main(String[] args) {
		new SAXTest4();
	}

}
