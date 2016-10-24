package com.kosta._0801;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowCloseTest extends Frame implements WindowListener{
	public WindowCloseTest() {
		setTitle("윈도우창 이벤트");
		setSize(300,300);
		setVisible(true);
		
		addWindowListener(this);
	}//생성자
	
	@Override
	public void windowOpened(WindowEvent e) {		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	@Override
	public void windowClosed(WindowEvent e) {	
	}
	
	@Override
	public void windowIconified(WindowEvent e) {
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {	
	}
	
	@Override
	public void windowActivated(WindowEvent e) {	
	}
	
	@Override
	public void windowDeactivated(WindowEvent e) {
	}
	
	public static void main(String[] args) {
		new WindowCloseTest();
	}
}
