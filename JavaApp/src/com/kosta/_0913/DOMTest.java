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

public class DOMTest {
	// XML������ ���� DOM�Ľ�!!
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document doc;

	public DOMTest() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			doc = builder.parse("0913/books.xml");
			System.out.println("DOM�Ľ� ����!!");
			// DOM���α׷����� ���� ---> Document ��ü ���

			// ===========DOM ���α׷� ����============
			// ��Ʈ������Ʈ?
			Element root = doc.getDocumentElement();
			// System.out.println("��Ʈ������Ʈ ��: "+ root.getTagName());
			// processNode(root);
			processNode(doc);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}// ������

	// Node n = Element; Node n = Test; Node n = Comment;
	public void processNode(Node n) {// ��ü���� ��ȸ(����)�ϱ�

		switch (n.getNodeType()) {// 1~12(��:1-Element, 3-Text)
		case Node.DOCUMENT_NODE: {
			NodeList list = n.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				processNode(list.item(i));
			}
		}
			break;
		// case 1: ����� ��ü�� Element��� �Ѵٸ�
		case Node.ELEMENT_NODE: {
			// ������Ʈ�� �ڽ��� ���� �� �����Ƿ�
			NodeList list = n.getChildNodes(); // �ڽĿ�� ���ϱ�
			NamedNodeMap map = n.getAttributes();

			// ======================================
			// NodeList: �Ӽ��� ������ ���(Element,Text,Comment)���� ����
			// NamedNodeMap: �Ӽ��� ����

			String tagName = n.getNodeName();// �±� ���� ������
			System.out.print("<" + tagName);// �����±� ���
			// �Ӽ����
			for (int i = 0; i < map.getLength(); i++) {
				Node attr = map.item(i);
				System.out.print(" " + attr.getNodeName() + "='" + attr.getNodeValue() + "'");
			}
			System.out.print(">");
			for (int i = 0; i < list.getLength(); i++) {
				processNode(list.item(i));
			}
			System.out.print("</" + tagName + ">");
		}
			break;
		// case 3: ����� ��ü�� Test���
		case Node.TEXT_NODE: {
			String text = n.getNodeValue();// �ؽ�Ʈ ����
			System.out.print(text);
		}
			break;
		case Node.COMMENT_NODE: {
			String text = n.getNodeValue();// �ּ� ���� �ؽ�Ʈ ����
			System.out.print("<!--" + text + "-->");
		}
		}

	}// processNode

	public static void main(String[] args) {
		new DOMTest();
	}
}
