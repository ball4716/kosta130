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
	// XML문서에 대한 DOM파싱!!
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
			
			// DOM프로그래밍의 시작 ---> Document 객체 얻기

			// ===========DOM 프로그램 시작============
			// 루트엘리먼트?
			Element root = doc.getDocumentElement();
			// out.writeln("루트엘리먼트 명: "+ root.getTagName());
			// processNode(root);
			processNode(doc);
			System.out.println("파일 출력 성공!");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		} finally{
			out.close();
		}
	}// 생성자

	// Node n = Element; Node n = Test; Node n = Comment;
	public void processNode(Node n) throws IOException{// 전체문서 순회(여행)하기

		switch (n.getNodeType()) {// 1~12(예:1-Element, 3-Text)
		case Node.DOCUMENT_NODE: {
			out.write("<?xml version='1.0' encoding='EUC-KR' ?>");
			NodeList list = n.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				processNode(list.item(i));
			}
		}
			break;
		// case 1: 노드의 정체가 Element라고 한다면
		case Node.ELEMENT_NODE: {
			// 엘리먼트는 자식을 가질 수 있으므로
			NodeList list = n.getChildNodes(); // 자식요소 구하기
			NamedNodeMap map = n.getAttributes();

			// ======================================
			// NodeList: 속성을 제외한 요소(Element,Text,Comment)등을 저장
			// NamedNodeMap: 속성만 저장

			String tagName = n.getNodeName();// 태그 네임 얻어오기
			out.write("<" + tagName);// 시작태그 출력
			// 속성출력
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
		// case 3: 노드의 정체가 Test라면
		case Node.TEXT_NODE: {
			String text = n.getNodeValue();// 텍스트 내용
			out.write(text);
		}
			break;
		case Node.COMMENT_NODE: {
			String text = n.getNodeValue();// 주석 내의 텍스트 내용
			out.write("<!--" + text + "-->");
		}
		}

	}// processNode

	public static void main(String[] args) throws IOException{
		new DOMTest2();
	}
}
