package com.kosta._0913;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest3 {
	// XML문서에 대한 DOM파싱!!
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document doc;

	public DOMTest3() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			doc = builder.parse("0913/books.xml");

			// 문제) 책제목과 가격을 출력하시오.
			// Element ele = doc.getElementById("id값"); //예) <book id="b1">
			// NodeList list = doc.getElementsByTagName("태그이름");

			NodeList titleList = doc.getElementsByTagName("title");
			/*
			 * <title>XMLBible</title> ===>0 인덱스 <title>JSP Programming</title>
			 * ===>1 인덱스 <title>Ajax프로그래밍</title> ===>2 인덱스
			 * <title>SpringFramework</title> ===>3 인덱스
			 */

			NodeList priceList = doc.getElementsByTagName("price");
			// <price></price><price></price>

			NodeList authorList = doc.getElementsByTagName("author");

			System.out.println("<책목록>");
			for (int i = 0; i < titleList.getLength(); i++) {
				Node title = titleList.item(i);
				// <title>
				Node textNode = title.getFirstChild();
				// TextNode
				String titleContent = textNode.getNodeValue();
				// "XMLBible"
				String price = priceList.item(i).getFirstChild().getNodeValue();
				System.out.println(" " + titleContent + "(" + price + ")");
			}

			//문제)'홍길동'저자인 책제목과 가격을 출력하시오
			System.out.println("<'홍길동'저자인 책목록>");
			for (int i = 0; i < authorList.getLength(); i++) {
				if (authorList.item(i).getFirstChild().getNodeValue().equals("홍길동")) {
					System.out.println(" " + titleList.item(i).getFirstChild().getNodeValue() + "("
							+ priceList.item(i).getFirstChild().getNodeValue() + ")");
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}// 생성자

	public static void main(String[] args) {
		new DOMTest3();
	}
}
