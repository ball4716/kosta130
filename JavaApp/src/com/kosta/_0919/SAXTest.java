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

public class SAXTest extends DefaultHandler{//implements ContentHandler{
	SAXParserFactory factory;
	SAXParser parser;
	
	public SAXTest() {
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
	
	public static void main(String[] args) {
		new SAXTest();
	}

	@Override
	public void setDocumentLocator(Locator locator) {
		System.out.println("setDocumentLocator");
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("startDocument");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("endDocument");
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		System.out.println("startPrefixMapping");
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		System.out.println("endPrefixMapping");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		System.out.println("startElement");
		System.out.println("uri:"+uri);
		System.out.println("localName:"+localName);
		System.out.println("qName:"+qName);
		System.out.println("atts:"+atts);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("endElement");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("characters");
		System.out.println("ch:"+ch);
		System.out.println("start:"+start);
		System.out.println("length:"+length);
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		System.out.println("ignorableWhitespace");
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		System.out.println("processingInstruction");
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		System.out.println("skippedEntity");
	}
}
