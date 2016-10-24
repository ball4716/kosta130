package com.kosta._0802;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest extends JFrame{
	/*
	     <Swing�� Ư¡>
	1. AWT - ���������� C�� ���� �ü������ ����ϰ��ִ�
			������Ʈ���� ���
	   Swing - �����ڹپ��� ������� ������Ʈ�������
	           (�ü���� ������� ���� ����� ������)
	           
	2. ��Ű��
	   AWT : java.awt.*;
	   Swing : javax.swing.*;
	   
	3. �Ϲ������� awt�� ������Ʈ �տ� �빮�� 'J'�� ���� Ŭ�������� ����.
			Button    ----> JButton
			Frame     ----> JFrame
			Panel     ----> JPanel
			
			Checkbox  ----> JCheckbox (X)
			                JCheckBox (O)
	 
	 
	 
	 
	 */
	
	JButton bt;

	public SwingTest() {
		setTitle("Swing�׽�Ʈ");
		bt = new JButton("<html><font size=10 face=�ü�ü color=red>����ư</font><br>"
				+"<font size=10 face=����ü color=blue>����ư</font><br>");
		
		setLayout(new FlowLayout());
		add(bt);
		
		setBounds(300,200,300,300);//x,y,����,����
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});*/
	}//������
	
	public static void main(String[] args) {
		new SwingTest();
	}
}
