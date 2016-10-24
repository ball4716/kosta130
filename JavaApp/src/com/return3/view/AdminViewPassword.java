package com.return3.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class AdminViewPassword extends JFrame{
	JLabel message;
	public JPasswordField password_field;
	public JButton password_ok, password_cancel;
	JPanel pnl_top, pnl_bot;
	
	public AdminViewPassword() {
		message = new JLabel("관리자 비밀번호를 입력하세요");
		password_field = new JPasswordField(20);
		password_ok = new JButton("확인");
		password_cancel = new JButton("취소");
		pnl_top = new JPanel();
		pnl_bot = new JPanel();
		
		pnl_top.add(message);
		pnl_bot.add(password_ok);
		pnl_bot.add(password_cancel);
		
		setTitle("관리자 로그인");
		setLayout(new GridLayout(3,1));
		
		add(pnl_top);
		add(password_field);
		add(pnl_bot);
		
		setSize(300,150);
		setVisible(false);
	}
}
