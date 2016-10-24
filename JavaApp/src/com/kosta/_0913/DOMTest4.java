package com.kosta._0913;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class DOMTest4 {
	// XML������ ���� DOM�Ľ�!!
	DocumentBuilderFactory factory;
	DocumentBuilder builder;

	// ��������Ȯ��
	FileWriter out;

	// DOM���α׷���
	Document doc;

	public DOMTest4() {
		try {
			// ���ο� XML���� ����
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			out = new FileWriter("0913/root.xml");
			/*
			 * factory.setIgnoringElementContentWhitespace(true);//whitespace �ڵ� ����
			 * //--> �������� �ʿ���� ����(����,��,�����̽�)�� ����(����) //--> DTD �Ǵ� XMLSchema�� �����ϴ�
			 * ����ĸ� ���� doc = builder.parse("XML��������");
			 */
			doc = builder.newDocument();// Ư�� XML������ �������� �ʴ� Document��ü

			// Element��ü ����
			Element root = doc.createElement("Root");// (String tagName);
			Element a = doc.createElement("A");
			Element b = doc.createElement("B");
			Element c = doc.createElement("C");
			Element d = doc.createElement("D");
			
			//TextNode��ü ����
			Text hello = doc.createTextNode("hello");
			Text hi = doc.createTextNode("hi");
			Text good = doc.createTextNode("goodBye");
			Text k130 = doc.createTextNode("kosta130");
			
			// ����(XML Document) ����(�߰�,����,����)
			// �߰�����) �θ���.appendChild(�ڽĳ��);
			doc.appendChild(root);
			a.appendChild(hello);//<A>hello</A>
			b.appendChild(hi);//<B>hi</B>
			c.appendChild(good);//<C>goodBye</C>
			d.appendChild(k130);//<D>kosta130</D>
			
			//1.appendChild
			root.appendChild(a);//<Root><A>hello</A></Root>
			root.appendChild(b);//<Root><B>hi</B></Root>
			
			//2.insertBefore
			//root.insertBefore(Node newChild,Node refChild)
			root.insertBefore(c, b);
			
			//3.removeChild
			//����) �θ���.removeChild(�������ڽĳ��)
			root.removeChild(b);
			
			//4.replaceChild
			//root.replaceChild(Node newChild, Node oldChild);
			root.replaceChild(d, a);
			
			//5.cloneNode
			//�����ҳ��.cloneNode(boolean deep);//deep����: �ڽ����Կ���
			Node cNode = root.cloneNode(true);
			
			//Ȯ��
			root.appendChild(cNode);
			
			processNode(doc);
			
			out.close();
			System.out.println("�������۳�!!");
		} catch (DOMException | ParserConfigurationException | IOException e) {
			e.printStackTrace();
		}

	}// ������

	public void processNode(Node n) throws IOException {// ��ü���� ��ȸ(����)�ϱ�

		switch (n.getNodeType()) {// 1~12 (��:1-Element, 3-Text)
		case Node.DOCUMENT_NODE: {
			out.write("<?xml version='1.0' encoding='EUC-KR' ?>");

			NodeList list = n.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {// Document�� �ڽľ��
				processNode(list.item(i));
			}
		}
			break;
		// case 1: ����� ��ü�� Element��� �Ѵٸ�
		case Node.ELEMENT_NODE: {
			// ������Ʈ�� �ڽ��� ������ �����Ƿ�
			NodeList list = n.getChildNodes(); // �ڽĿ�� ���ϱ�
			NamedNodeMap map = n.getAttributes();
			// =======================================
			// NodeList: �Ӽ��� ������ ���(Element,Text,Comment)���� ����
			// NamedNodeMap: �Ӽ��� ����

			String tagName = n.getNodeName(); // �±��̸� ������

			out.write("<" + tagName);// �����±� ���
			// �Ӽ����
			for (int i = 0; i < map.getLength(); i++) {
				Node attr = map.item(i);
				out.write(" " + attr.getNodeName() + "='" + attr.getNodeValue() + "'");
			}
			out.write(">");
			for (int i = 0; i < list.getLength(); i++) {// �ڽĿ�� �ϳ�, �ϳ� ���ϱ�
				processNode(list.item(i));
			}
			out.write("</" + tagName + ">");

		}
			break;

		case Node.TEXT_NODE: {// case 3: ����� ��ü�� Text���
			String text = n.getNodeValue();// �ؽ�Ʈ ����
			out.write(text);
		}
			break;

		case Node.COMMENT_NODE: {// ��尡 Comment
			String text = n.getNodeValue();// �ּ����� �ؽ�Ʈ ����
			out.write("<!--" + text + "-->");
		}
			break;

		}// switch
	}// processNode

	public static void main(String[] args) {
		new DOMTest4();
	}
}
