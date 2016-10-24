package com.kosta._0802;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingTest extends JFrame{
	/*
	     <Swing의 특징>
	1. AWT - 내부적으로 C언어를 통해 운영체제에서 사용하고있는
			컴포넌트들을 사용
	   Swing - 순수자바언어로 만들어진 컴포넌트들을헤공
	           (운영체제와 상관없이 같은 모양을 보여줌)
	           
	2. 패키지
	   AWT : java.awt.*;
	   Swing : javax.swing.*;
	   
	3. 일반적으로 awt의 컴포넌트 앞에 대문자 'J'를 붙인 클래스들을 제공.
			Button    ----> JButton
			Frame     ----> JFrame
			Panel     ----> JPanel
			
			Checkbox  ----> JCheckbox (X)
			                JCheckBox (O)
	 
	 
	 
	 
	 */
	
	JButton bt;

	public SwingTest() {
		setTitle("Swing테스트");
		bt = new JButton("<html><font size=10 face=궁서체 color=red>나버튼</font><br>"
				+"<font size=10 face=굴림체 color=blue>나버튼</font><br>");
		
		setLayout(new FlowLayout());
		add(bt);
		
		setBounds(300,200,300,300);//x,y,가로,세로
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});*/
	}//생성자
	
	public static void main(String[] args) {
		new SwingTest();
	}
}
