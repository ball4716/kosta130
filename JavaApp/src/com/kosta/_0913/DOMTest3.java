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
	// XML������ ���� DOM�Ľ�!!
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document doc;

	public DOMTest3() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			doc = builder.parse("0913/books.xml");

			// ����) å����� ������ ����Ͻÿ�.
			// Element ele = doc.getElementById("id��"); //��) <book id="b1">
			// NodeList list = doc.getElementsByTagName("�±��̸�");

			NodeList titleList = doc.getElementsByTagName("title");
			/*
			 * <title>XMLBible</title> ===>0 �ε��� <title>JSP Programming</title>
			 * ===>1 �ε��� <title>Ajax���α׷���</title> ===>2 �ε���
			 * <title>SpringFramework</title> ===>3 �ε���
			 */

			NodeList priceList = doc.getElementsByTagName("price");
			// <price></price><price></price>

			NodeList authorList = doc.getElementsByTagName("author");

			System.out.println("<å���>");
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

			//����)'ȫ�浿'������ å����� ������ ����Ͻÿ�
			System.out.println("<'ȫ�浿'������ å���>");
			for (int i = 0; i < authorList.getLength(); i++) {
				if (authorList.item(i).getFirstChild().getNodeValue().equals("ȫ�浿")) {
					System.out.println(" " + titleList.item(i).getFirstChild().getNodeValue() + "("
							+ priceList.item(i).getFirstChild().getNodeValue() + ")");
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}// ������

	public static void main(String[] args) {
		new DOMTest3();
	}
}
