package com.kosta._0728;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class TextFieldAreaTest extends Frame{
	TextField tf1,tf2;
	TextArea ta;
	Label lb1;
	Panel p;//South영역에 두개 이상의 컴포넌트를 붙이기 위해
	Panel northp;//North영역의 TextField 가로너비를 지정하기 위해
	
	public TextFieldAreaTest(String title){
		setTitle(title);
		
		//객체생성
		lb1 = new Label("파일이름: ");
		tf1 = new TextField("기본값",15);//상단
		tf2 = new TextField(15);//하단
		ta = new TextArea();
		
		p = new Panel();
		//p.setLayout(new FlowLayout());//가운데 정렬
		p.add(lb1);
		p.add(tf2);
		p.setBackground(Color.orange);
		p.setForeground(Color.red);
		
		
		northp = new Panel();
		northp.add(tf1);
		//northp.setBackground(Color c);//바탕색 설정
		northp.setBackground(new Color(0,255,0));
		
		//setLayout(new BorderLayout()); Frame의 default Layout은 BorderLayout()!!
		
		//add("North", tf1);
		add("North",northp);
		add("Center", ta);
		//add("South", lb1);
		//add("South", tf2);
		add("South",p);
		
		
		setSize(500,500);
		setVisible(true);
	}//생성자
	
	public static void main(String[] args) {
		//생성자호출
		new TextFieldAreaTest("TextFieldArea테스트");
	}
}
