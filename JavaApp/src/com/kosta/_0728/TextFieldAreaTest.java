package com.kosta._0728;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class TextFieldAreaTest extends Frame{
	TextField tf1,tf2;
	TextArea ta;
	Label lb1;
	Panel p;//South������ �ΰ� �̻��� ������Ʈ�� ���̱� ����
	Panel northp;//North������ TextField ���γʺ� �����ϱ� ����
	
	public TextFieldAreaTest(String title){
		setTitle(title);
		
		//��ü����
		lb1 = new Label("�����̸�: ");
		tf1 = new TextField("�⺻��",15);//���
		tf2 = new TextField(15);//�ϴ�
		ta = new TextArea();
		
		p = new Panel();
		//p.setLayout(new FlowLayout());//��� ����
		p.add(lb1);
		p.add(tf2);
		p.setBackground(Color.orange);
		p.setForeground(Color.red);
		
		
		northp = new Panel();
		northp.add(tf1);
		//northp.setBackground(Color c);//������ ����
		northp.setBackground(new Color(0,255,0));
		
		//setLayout(new BorderLayout()); Frame�� default Layout�� BorderLayout()!!
		
		//add("North", tf1);
		add("North",northp);
		add("Center", ta);
		//add("South", lb1);
		//add("South", tf2);
		add("South",p);
		
		
		setSize(500,500);
		setVisible(true);
	}//������
	
	public static void main(String[] args) {
		//������ȣ��
		new TextFieldAreaTest("TextFieldArea�׽�Ʈ");
	}
}
