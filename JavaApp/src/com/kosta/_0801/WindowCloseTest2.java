package com.kosta._0801;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloseTest2  extends WindowAdapter{//어뎁터 클래스를 통한 기능 구현
	Frame f;
	
	public WindowCloseTest2() {
		f = new Frame("윈도우창 이벤트2");
		
		f.setSize(300,300);
		f.setVisible(true);
		f.addWindowListener(this);
	}//생성자
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new WindowCloseTest2();
	}
}
