package com.return3.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JPanel;
	
public class UserViewAdmin extends JPanel{
	public JButton bt_admin;
	
	public UserViewAdmin (){
		
		bt_admin=new JButton (new ImageIcon ("image/admin.PNG"));
		
		bt_admin.setSize(50, 50);
		bt_admin.setBorderPainted(false);
		bt_admin.setContentAreaFilled(false);
		bt_admin.setFocusPainted(false);
		add(bt_admin);
		setBounds(800, 630, 300, 300);
		
		//패널 투명화
		setOpaque(false);
	}
	public static void main(String[] args) {
		new UserViewAdmin();
	}
}
