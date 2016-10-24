package com.kosta._0728;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.util.Set;

public class CheckBoxTest extends Frame{
	Checkbox cb1,cb2;
	Checkbox cb3,cb4;
	TextArea ta;
	Label lb1;
	
	Panel northp,southp;
	
	CheckboxGroup cbg;
	
	public CheckBoxTest() {
		//üũ�ڽ��� ���¸� ǥ���ϴ� ������Ʈ
		//vüũ: true  ,  vüũ: false
		cb1 = new Checkbox("���");
		cb2 = new Checkbox("����");
		
		cbg = new CheckboxGroup();//�׷��� ǥ��(�׷��� �Ѱ� ����)
		cb3 = new Checkbox("����",cbg,true);
		cb4 = new Checkbox("����",cbg,false);
		
		ta = new TextArea();
		lb1 = new Label("����: ");
		
		northp = new Panel();
		southp = new Panel();
		
		northp.setLayout(new FlowLayout());//��������
		northp.add(cb1);
		northp.add(cb2);
		northp.setBackground(Color.yellow);
		
		southp.add(lb1);
		southp.add(cb3);
		southp.add(cb4);
		southp.setBackground(Color.orange);
		
		setTitle("üũ�ڽ� �׽�Ʈ");
		setLayout(new BorderLayout());//Frame �⺻�� ���� ����
		add("North",northp);
		add("Center",ta);
		add("South",southp);
		
		setSize(500,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CheckBoxTest();
	}
}
