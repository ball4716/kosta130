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
	// XML문서에 대한 DOM파싱!!
	DocumentBuilderFactory factory;
	DocumentBuilder builder;

	// 문서조작확인
	FileWriter out;

	// DOM프로그래밍
	Document doc;

	public DOMTest4() {
		try {
			// 새로운 XML문서 생성
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			out = new FileWriter("0913/root.xml");
			/*
			 * factory.setIgnoringElementContentWhitespace(true);//whitespace 자동 제거
			 * //--> 문서내의 필요없는 공백(엔터,탭,스페이스)을 제거(무시) //--> DTD 또는 XMLSchema가 존재하는
			 * 경우어ㅔ만 적용 doc = builder.parse("XML문서정보");
			 */
			doc = builder.newDocument();// 특정 XML문서를 참조하지 않는 Document객체

			// Element객체 생성
			Element root = doc.createElement("Root");// (String tagName);
			Element a = doc.createElement("A");
			Element b = doc.createElement("B");
			Element c = doc.createElement("C");
			Element d = doc.createElement("D");
			
			//TextNode객체 생성
			Text hello = doc.createTextNode("hello");
			Text hi = doc.createTextNode("hi");
			Text good = doc.createTextNode("goodBye");
			Text k130 = doc.createTextNode("kosta130");
			
			// 문서(XML Document) 조작(추가,삭제,수정)
			// 추가문법) 부모노드.appendChild(자식노드);
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
			//문법) 부모노드.removeChild(삭제할자식노드)
			root.removeChild(b);
			
			//4.replaceChild
			//root.replaceChild(Node newChild, Node oldChild);
			root.replaceChild(d, a);
			
			//5.cloneNode
			//복제할노드.cloneNode(boolean deep);//deep깊이: 자식포함여부
			Node cNode = root.cloneNode(true);
			
			//확인
			root.appendChild(cNode);
			
			processNode(doc);
			
			out.close();
			System.out.println("문서조작끝!!");
		} catch (DOMException | ParserConfigurationException | IOException e) {
			e.printStackTrace();
		}

	}// 생성자

	public void processNode(Node n) throws IOException {// 전체문서 순회(여행)하기

		switch (n.getNodeType()) {// 1~12 (예:1-Element, 3-Text)
		case Node.DOCUMENT_NODE: {
			out.write("<?xml version='1.0' encoding='EUC-KR' ?>");

			NodeList list = n.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {// Document의 자식얻기
				processNode(list.item(i));
			}
		}
			break;
		// case 1: 노드의 정체가 Element라고 한다면
		case Node.ELEMENT_NODE: {
			// 엘리먼트는 자식을 가질수 있으므로
			NodeList list = n.getChildNodes(); // 자식요소 구하기
			NamedNodeMap map = n.getAttributes();
			// =======================================
			// NodeList: 속성을 제외한 요소(Element,Text,Comment)들을 저장
			// NamedNodeMap: 속성만 저장

			String tagName = n.getNodeName(); // 태그이름 얻어오기

			out.write("<" + tagName);// 시작태그 출력
			// 속성출력
			for (int i = 0; i < map.getLength(); i++) {
				Node attr = map.item(i);
				out.write(" " + attr.getNodeName() + "='" + attr.getNodeValue() + "'");
			}
			out.write(">");
			for (int i = 0; i < list.getLength(); i++) {// 자식요소 하나, 하나 구하기
				processNode(list.item(i));
			}
			out.write("</" + tagName + ">");

		}
			break;

		case Node.TEXT_NODE: {// case 3: 노드의 정체가 Text라면
			String text = n.getNodeValue();// 텍스트 내용
			out.write(text);
		}
			break;

		case Node.COMMENT_NODE: {// 노드가 Comment
			String text = n.getNodeValue();// 주석내의 텍스트 내용
			out.write("<!--" + text + "-->");
		}
			break;

		}// switch
	}// processNode

	public static void main(String[] args) {
		new DOMTest4();
	}
}
