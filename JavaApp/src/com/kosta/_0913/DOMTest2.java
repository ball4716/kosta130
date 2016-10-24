package com.kosta._0913;

import java.io.FileWriter;
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

public class DOMTest2 {
	// XML������ ���� DOM�Ľ�!!
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document doc;

	FileWriter out;
	
	public DOMTest2() throws IOException {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			doc = builder.parse("0913/books.xml");
			out = new FileWriter("0913/books2.xml");
			
			// DOM���α׷����� ���� ---> Document ��ü ���

			// ===========DOM ���α׷� ����============
			// ��Ʈ������Ʈ?
			Element root = doc.getDocumentElement();
			// out.writeln("��Ʈ������Ʈ ��: "+ root.getTagName());
			// processNode(root);
			processNode(doc);
			System.out.println("���� ��� ����!");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		} finally{
			out.close();
		}
	}// ������

	// Node n = Element; Node n = Test; Node n = Comment;
	public void processNode(Node n) throws IOException{// ��ü���� ��ȸ(����)�ϱ�

		switch (n.getNodeType()) {// 1~12(��:1-Element, 3-Text)
		case Node.DOCUMENT_NODE: {
			out.write("<?xml version='1.0' encoding='EUC-KR' ?>");
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
			out.write("<" + tagName);// �����±� ���
			// �Ӽ����
			for (int i = 0; i < map.getLength(); i++) {
				Node attr = map.item(i);
				out.write(" " + attr.getNodeName() + "='" + attr.getNodeValue() + "'");
			}
			out.write(">");
			for (int i = 0; i < list.getLength(); i++) {
				processNode(list.item(i));
			}
			out.write("</" + tagName + ">");
		}
			break;
		// case 3: ����� ��ü�� Test���
		case Node.TEXT_NODE: {
			String text = n.getNodeValue();// �ؽ�Ʈ ����
			out.write(text);
		}
			break;
		case Node.COMMENT_NODE: {
			String text = n.getNodeValue();// �ּ� ���� �ؽ�Ʈ ����
			out.write("<!--" + text + "-->");
		}
		}

	}// processNode

	public static void main(String[] args) throws IOException{
		new DOMTest2();
	}
}
