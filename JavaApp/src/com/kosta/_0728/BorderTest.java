package com.kosta._0728;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderTest {//��������(��������,���)
	//��ü(������Ʈ,�����̳�) ����
	Button btn1,btn2,btn3,btn4,btn5;
	Frame f;
	public BorderTest() {
		//��ü����
		btn1 = new Button("1");
		btn2 = new Button("2");
		btn3 = new Button("3");
		btn4 = new Button("4");
		btn5 = new Button("5");
		
		f = new Frame("Border�׽�Ʈ");
		
		//��ü�Ӽ� ����(���̾ƿ� ����, ���̱� ����)
		//BorderLayout bl = new BorderLayout();
		//new BorderLayout(int hgap, int vgap);
		f.setLayout(new BorderLayout());//(bl); �����ӿ����� BorderLayout����
		//f.add(String name, Component comp)
		f.add("North", btn1);
		f.add("East", btn2);
		f.add("South", btn3);
		f.add("West", btn4);
		f.add("Center", btn5);
	    //�ּ�ó���ϸ� �ٸ��ֵ��� �ڸ��� �����Ѵ�!! ������ Center�κ��� ��Եȴ�
		
		//�������޼ҵ� ȣ��2(�����̳ʻ�����, �����̳ʺ��̱⼳��)
		f.setSize(300,300);//(���α���,���α���)
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		//������ȣ��
		new BorderTest();
	}
}
