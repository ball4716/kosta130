package com.kosta._0728;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderTest {//방위정렬(동서남북,가운데)
	//객체(컴포넌트,컨테이너) 선언
	Button btn1,btn2,btn3,btn4,btn5;
	Frame f;
	public BorderTest() {
		//객체생성
		btn1 = new Button("1");
		btn2 = new Button("2");
		btn3 = new Button("3");
		btn4 = new Button("4");
		btn5 = new Button("5");
		
		f = new Frame("Border테스트");
		
		//객체속성 설정(레이아웃 설정, 붙이기 설정)
		//BorderLayout bl = new BorderLayout();
		//new BorderLayout(int hgap, int vgap);
		f.setLayout(new BorderLayout());//(bl); 프레임에대해 BorderLayout설정
		//f.add(String name, Component comp)
		f.add("North", btn1);
		f.add("East", btn2);
		f.add("South", btn3);
		f.add("West", btn4);
		f.add("Center", btn5);
	    //주석처리하면 다른애들이 자리를 차지한다!! 하지만 Center부분은 비게된다
		
		//마무리메소드 호출2(컨테이너사이즈, 컨테이너보이기설정)
		f.setSize(300,300);//(가로길이,세로길이)
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		//생성자호출
		new BorderTest();
	}
}
