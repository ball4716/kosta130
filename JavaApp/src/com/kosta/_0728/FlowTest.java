package com.kosta._0728;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowTest {//������� �׽�Ʈ
	//Component, Container ��ü ����
	Button btn1,btn2,btn3,btn4,btn5;
	Frame f;
	
	public FlowTest() {//�ʱ�ȭ�޼ҵ�
		//(����� ����) ��ü ����
		btn1 = new Button("ù��°��ư");
		btn2 = new Button("�ι�°��ư");
		btn3 = new Button("��������ư");
		btn4 = new Button("�׹����ư");
		btn5 = new Button("����°��ư");
		f = new Frame("Flow�׽�Ʈ");
		
		//������Ʈ, �����̳ʿ� ���� �Ӽ� ����
		//FlowLayout fl = new FlowLayout();
		f.setLayout(new FlowLayout());
		f.add(btn1);
		f.add(btn2);
		f.add(btn3);
		f.add(btn4);
		f.add(btn5);
		
		//�������޼ҵ� 2��(�����̳� �������, ���̱� ����)
		//f.setSize(int width, int height);
		f.setSize(300, 300);
		f.setVisible(true);
		
	}//������
	
	
	public static void main(String[] args) {
		//������ ȣ��
		//FlowTest ft = new FlowTest();
		//�ܼ� ������ ȣ��
		new FlowTest();
	}

}
