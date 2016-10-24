package com.kosta._0804;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogTest extends JFrame{
	JButton bt;
	
	public DialogTest() {
		bt = new JButton("����ư");
		
		setLayout(new FlowLayout());
		add(bt);
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//�޽���â
		//JOptionPane.showMessageDialog(Component parentComponent, Object message);
		//                              �ع����� ����ִ� ������Ʈ: parentComponent
		//JOptionPane.showMessageDialog(bt, "������, ����� ���ƿ�~!!");
		JOptionPane.showMessageDialog(this, "������, ����� ���ƿ�~!!");
		
		//�Է�â(������ �����͸� �Է��Ҷ�)
		//JOptionPane.showInputDialog(Component parentComponent, Object message);
		String food = JOptionPane.showInputDialog(this, "�����ϴ� ������?");
		System.out.println("food="+food);
		//Ȯ��:�Էµȹ��ڿ� �Ǵ� ���ڿ�, ���:null, x��ư:null
		//JOptionPane.showMessageDialog(this, "��굿 ū���޲ٹ� ���ƿ�~!!");
		
		//Ȯ��â(��� �������� ���� ���� �� ���, ������ ����?)
		//JOptionPane.showConfirmDialog(Component parentComponent, Object message);
		int temp = JOptionPane.showConfirmDialog(this, "���� ����?");
		//��:0 , �ƴϿ�:1, ���:2, x:-1
		System.out.println("temp="+temp);
	}
	public static void main(String[] args) {
		new DialogTest();
	}
}
