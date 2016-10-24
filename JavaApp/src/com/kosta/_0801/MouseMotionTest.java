package com.kosta._0801;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseMotionTest extends Frame implements MouseMotionListener{
	Frame f;
	Label green, red;
	
	public MouseMotionTest() {
		f = new Frame("마우스 모션 테스트");
		
		green = new Label("Move");
			green.setBackground(Color.green);
			//green.setLocation(int x, int y);
			green.setLocation(50, 50);
			//green.setSize(int width, int height);
			green.setSize(80, 50);
		red = new Label("Drag");
			red.setBackground(Color.red);
			//red.setBounds(int x, int y, int width, int height); //location + size
			red.setBounds(50, 150, 80, 50);
			
		f.setLayout(null);
		//Null Layout : 붙여지는 컴포넌트에 대해 x,y축과 가로, 세로 길이를 설정!!
		
		f.add(green);
		f.add(red);
		
		//f.setSize(600, 600);
		f.setBounds(200, 100, 600, 600);
		f.setVisible(true);
		
		setLayout(new BorderLayout(50,50));
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//프레임위에서의 마우스 움직임을 감시
		f.addMouseMotionListener(this);
	}//생성자
	
	@Override
	public void mouseDragged(MouseEvent e) {//드래그움직임 발생할때
		//System.out.println("mouseDragged");
		int x = e.getX();
		int y = e.getY();
		red.setLocation(x+10, y+10);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {//마우스움직임 발생할때
		//System.out.println("mouseMoved");
		int x = e.getX();
		int y = e.getY();
		green.setLocation(x+10,y+10);
	}
	
	public static void main(String[] args) {
		new MouseMotionTest();
	}

}
