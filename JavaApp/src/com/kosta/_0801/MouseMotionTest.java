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
		f = new Frame("���콺 ��� �׽�Ʈ");
		
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
		//Null Layout : �ٿ����� ������Ʈ�� ���� x,y��� ����, ���� ���̸� ����!!
		
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
		
		//�������������� ���콺 �������� ����
		f.addMouseMotionListener(this);
	}//������
	
	@Override
	public void mouseDragged(MouseEvent e) {//�巡�׿����� �߻��Ҷ�
		//System.out.println("mouseDragged");
		int x = e.getX();
		int y = e.getY();
		red.setLocation(x+10, y+10);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {//���콺������ �߻��Ҷ�
		//System.out.println("mouseMoved");
		int x = e.getX();
		int y = e.getY();
		green.setLocation(x+10,y+10);
	}
	
	public static void main(String[] args) {
		new MouseMotionTest();
	}

}
