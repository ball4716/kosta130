package com.kosta._0801;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloseTest3 extends Frame{
	//�̹� extends �ڿ� Ŭ������ �����ϸ� �߰������� WindowAdapter�� ��� X

	public WindowCloseTest3() {
		setTitle("������â �׽�Ʈ3");
		setSize(300,300);
		setVisible(true);
		
		//�͸�(Anonymous)�� ����Ŭ����
		//addWindowListener(WindowListener l);
		My m = new My(){
			
		};
		
		//addWindowlistener(m);
		//addWindowListener(new My(){});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				System.exit(0);
			}
		});
	}//������
	
	public static void main(String[] args) {

	}
}