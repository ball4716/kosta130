package com.return3.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserViewTitle extends JPanel {
	JLabel lb_title;

	public UserViewTitle() {
		lb_title = new JLabel("The Beverage Collection");
		lb_title.setFont(new Font("AmeriGarmnd BT Italic", Font.ITALIC, 50));
		lb_title.setForeground(Color.WHITE);

		add(lb_title);
		
		setBounds(10, 9, 600, 100);
		
		//패널 투명화
		setOpaque(false);
	}
}
