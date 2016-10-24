package com.kosta._0728;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridLayoutTest extends Frame{
	Button btn1,btn2,btn3,btn4,btn5;
	GridLayout gl;
	
	public GridLayoutTest(String title) {
		//super(title); : ������ �ֻ�ܿ��� �� ���ִ�.
		setTitle(title);
		
		//��ü����
		btn1 = new Button("1");
		btn2 = new Button("2");
		btn3 = new Button("3");
		btn4 = new Button("4");
		btn5 = new Button("5");

		//��ü�� ���� �Ӽ� ����
		GridLayout gl = new GridLayout();
		//GridLayout gl = new GridLayout(int rows, int cols);
		//GridLayout gl = new GridLayout(2,3); 2�� 3���� ������Ʈ�� ��ġ(2*3 ������Ʈ)
		//GridLayout gl = new GridLayout(2,3,0,10);
		//�࿭�� ����, �⺻�� ���࿡ ����
		
		this.setLayout(gl);//�����ӿ� ���� ���̾ƿ� ����
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		
		//�������޼ҵ� 2��(�����̳ʻ�����, ���̱⼳��)
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutTest("Grid�׽�Ʈ");
	}
}
