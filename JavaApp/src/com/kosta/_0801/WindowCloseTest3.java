package com.kosta._0801;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloseTest3 extends Frame{
	//이미 extends 뒤에 클래스가 존재하면 추가적으로 WindowAdapter를 상속 X

	public WindowCloseTest3() {
		setTitle("윈도우창 테스트3");
		setSize(300,300);
		setVisible(true);
		
		//익명(Anonymous)의 내부클래스
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
	}//생성자
	
	public static void main(String[] args) {

	}
}