package com.kosta._0728;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.util.Set;

public class CheckBoxTest extends Frame{
	Checkbox cb1,cb2;
	Checkbox cb3,cb4;
	TextArea ta;
	Label lb1;
	
	Panel northp,southp;
	
	CheckboxGroup cbg;
	
	public CheckBoxTest() {
		//체크박스는 상태를 표현하는 컴포넌트
		//v체크: true  ,  v체크: false
		cb1 = new Checkbox("사과");
		cb2 = new Checkbox("딸기");
		
		cbg = new CheckboxGroup();//그룹을 표현(그룹중 한개 선택)
		cb3 = new Checkbox("남자",cbg,true);
		cb4 = new Checkbox("여자",cbg,false);
		
		ta = new TextArea();
		lb1 = new Label("성별: ");
		
		northp = new Panel();
		southp = new Panel();
		
		northp.setLayout(new FlowLayout());//생략가능
		northp.add(cb1);
		northp.add(cb2);
		northp.setBackground(Color.yellow);
		
		southp.add(lb1);
		southp.add(cb3);
		southp.add(cb4);
		southp.setBackground(Color.orange);
		
		setTitle("체크박스 테스트");
		setLayout(new BorderLayout());//Frame 기본값 생략 가능
		add("North",northp);
		add("Center",ta);
		add("South",southp);
		
		setSize(500,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CheckBoxTest();
	}
}
