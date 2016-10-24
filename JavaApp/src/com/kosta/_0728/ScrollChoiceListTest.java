package com.kosta._0728;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.Scrollbar;

public class ScrollChoiceListTest extends Frame{
	Label la;
	Scrollbar sb;
	Choice cho;
	List list;
	
	Panel topLeftp,bottomLeftp;
	
	public ScrollChoiceListTest(){
		la = new Label("����");
		
		//Scrollbar(int orientation) 0:����, 1:����
		//Scrollbar(int ����, int value, int visible, int minimum, int maximum)
		//min: �ּ���ǥ, max: �ִ���ǥ��, value: �������� ������ġ, visible: �������� ���γʺ�
		
		sb = new Scrollbar(Scrollbar.HORIZONTAL,50,10,0,100);
		cho = new Choice();//��� ��ġ�� ����
			cho.add("����");
			cho.add("����");
			cho.add("�뱸");
			cho.add("�λ�");
			cho.add("����");
			cho.add("���");
			
		list = new List(2,true); //�ѹ��� �����ִ� ����
			list.add("�߱�");
			list.add("�౸");
			list.add("��");
			list.add("�豸");
			list.add("Ź��");
			list.add("����");
			list.add("�Ǳ�");
			list.add("����");
			
		topLeftp = new Panel();
		topLeftp.setLayout(new BorderLayout(0,1));//Panel Layout �⺻��: FlowLayout
		topLeftp.add("North", new Label());
		topLeftp.add("South", new Label());
		topLeftp.add("West",la);
		topLeftp.add("Center", sb);
		topLeftp.setBackground(Color.orange);
		
		bottomLeftp = new Panel();
		bottomLeftp.add(list);
		
		//this.Frame�� �⺻ ���̾ƿ�: BorderLayout
		setTitle("���־�������Ʈ�׽�Ʈ");
		setLayout(new GridLayout(2,2));
		add(topLeftp);
		add(cho);
		//add(list);
		add(bottomLeftp);
		
		setSize(600, 200);
		setVisible(true);
	}//������
	
	public static void main(String[] args) {
		new ScrollChoiceListTest();
	}
}
