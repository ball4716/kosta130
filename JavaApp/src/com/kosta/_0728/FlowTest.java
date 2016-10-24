package com.kosta._0728;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowTest {//가운데정렬 테스트
	//Component, Container 객체 선언
	Button btn1,btn2,btn3,btn4,btn5;
	Frame f;
	
	public FlowTest() {//초기화메소드
		//(멤버에 대한) 객체 생성
		btn1 = new Button("첫번째버튼");
		btn2 = new Button("두번째버튼");
		btn3 = new Button("세번쨰버튼");
		btn4 = new Button("네번재버튼");
		btn5 = new Button("오번째버튼");
		f = new Frame("Flow테스트");
		
		//컴포넌트, 컨테이너에 대한 속성 설정
		//FlowLayout fl = new FlowLayout();
		f.setLayout(new FlowLayout());
		f.add(btn1);
		f.add(btn2);
		f.add(btn3);
		f.add(btn4);
		f.add(btn5);
		
		//마무리메소드 2개(컨테이너 사이즈설정, 보이기 설정)
		//f.setSize(int width, int height);
		f.setSize(300, 300);
		f.setVisible(true);
		
	}//생성자
	
	
	public static void main(String[] args) {
		//생성자 호출
		//FlowTest ft = new FlowTest();
		//단순 생성자 호출
		new FlowTest();
	}

}
