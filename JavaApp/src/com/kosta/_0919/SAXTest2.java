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
	
	//XML������ �о ȭ���ֿܼ� ���
	public SAXTest2() {
		try {
			factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			
			//parser.parse(String uri, DefaultHandler dh);
			parser.parse("0919/books.xml", this);
			//DOM�� �ٸ��� return void�̹Ƿ� �ӵ��� ��������, �ѹ� �����ϰ� ��
			System.out.println("##SAX�Ľ̼���!!");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}//������
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//�������� ��� �����±׸� ������ �� <--- �̺�Ʈ
		//�±׸��� ���� ȣ��, �Ű������� ���� ������Ʈ�� ���� ������ ����.
		//qName : �±��̸� ����
		//attributes: �����±װ� ������ �� �ִ� �Ӽ��� ���� ����
		System.out.print("<"+qName);
		//�Ӽ� ���
		//attributes.getLength();//�Ӽ��� ����
		for (int i = 0; i < attributes.getLength(); i++) {
			String attName = attributes.getQName(i);//�Ӽ���
			String attValue = attributes.getValue(i);//�Ӽ���
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
		//���Ͱ��� ���鵵 ���!!
		System.out.print(str);
	}
	
	public static void main(String[] args) {
		new SAXTest2();
	}

	
}
