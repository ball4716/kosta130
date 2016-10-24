package com.kosta._0804;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogTest extends JFrame{
	JButton bt;
	
	public DialogTest() {
		bt = new JButton("나버튼");
		
		setLayout(new FlowLayout());
		add(bt);
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//메시지창
		//JOptionPane.showMessageDialog(Component parentComponent, Object message);
		//                              밑바탕에 깔려있는 컴포넌트: parentComponent
		//JOptionPane.showMessageDialog(bt, "여러분, 고생이 많아요~!!");
		JOptionPane.showMessageDialog(this, "여러분, 고생이 많아요~!!");
		
		//입력창(간단한 데이터를 입력할때)
		//JOptionPane.showInputDialog(Component parentComponent, Object message);
		String food = JOptionPane.showInputDialog(this, "좋아하는 음식은?");
		System.out.println("food="+food);
		//확인:입력된문자열 또는 빈문자열, 취소:null, x버튼:null
		//JOptionPane.showMessageDialog(this, "계산동 큰손쭈꾸미 좋아요~!!");
		
		//확인창(계속 진행할지 여부 물을 때 사용, 삭제전 정말?)
		//JOptionPane.showConfirmDialog(Component parentComponent, Object message);
		int temp = JOptionPane.showConfirmDialog(this, "정말 삭제?");
		//예:0 , 아니오:1, 취소:2, x:-1
		System.out.println("temp="+temp);
	}
	public static void main(String[] args) {
		new DialogTest();
	}
}
