package com.kosta._0801;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloseTest2  extends WindowAdapter{//��� Ŭ������ ���� ��� ����
	Frame f;
	
	public WindowCloseTest2() {
		f = new Frame("������â �̺�Ʈ2");
		
		f.setSize(300,300);
		f.setVisible(true);
		f.addWindowListener(this);
	}//������
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new WindowCloseTest2();
	}
}
