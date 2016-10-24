package com.kosta._0728;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridLayoutTest extends Frame{
	Button btn1,btn2,btn3,btn4,btn5;
	GridLayout gl;
	
	public GridLayoutTest(String title) {
		//super(title); : 생성자 최상단에만 쓸 수있다.
		setTitle(title);
		
		//객체생성
		btn1 = new Button("1");
		btn2 = new Button("2");
		btn3 = new Button("3");
		btn4 = new Button("4");
		btn5 = new Button("5");

		//객체에 대한 속성 설정
		GridLayout gl = new GridLayout();
		//GridLayout gl = new GridLayout(int rows, int cols);
		//GridLayout gl = new GridLayout(2,3); 2행 3열로 컴포넌트를 배치(2*3 컴포넌트)
		//GridLayout gl = new GridLayout(2,3,0,10);
		//행열을 지정, 기본은 한행에 정렬
		
		this.setLayout(gl);//프레임에 대한 레이아웃 설정
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		
		//마무리메소드 2개(컨테이너사이즈, 보이기설정)
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutTest("Grid테스트");
	}
}
