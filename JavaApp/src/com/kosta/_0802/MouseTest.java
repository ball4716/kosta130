package com.kosta._0802;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseTest extends Frame implements MouseListener{
	Button bt;
	
	public MouseTest() {
		bt = new Button("나버튼");
		
		setLayout(new FlowLayout());
		add(bt);
		
		//setBounds(int x, int y, int width, int height);
		setTitle("마우스이벤트테스트");
		setBounds(300, 200, 300, 300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		bt.addMouseListener(this);
		
	}//생성자
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}
	
	public static void main(String[] args) {
		new MouseTest();
	}

}
