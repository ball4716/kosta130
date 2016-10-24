package com.return3.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UserView extends JFrame {
	UserViewTitle user_view_title;
	public UserViewDrinkbar user_view_drinkbar;
	UserViewSwitch user_view_switch;
	public UserViewAdmin user_view_admin;
	public UserViewCup user_view_cup;
	public UserViewCoin user_view_coin;
	public AdminView admin_view;

	Image bg;
	
	JLabel s_cost, m_cost, l_cost;

	public UserView() {
		setTitle("유저뷰");

		// 초기화
		user_view_title = new UserViewTitle();
		user_view_drinkbar = new UserViewDrinkbar();
		user_view_switch = new UserViewSwitch();
		user_view_admin = new UserViewAdmin();
		user_view_cup = new UserViewCup();
		user_view_coin = new UserViewCoin();
		
		admin_view = new AdminView();
		admin_view.setVisible(false);
		
		s_cost = new JLabel("S:500원");
		m_cost = new JLabel("M:1000원");
		l_cost = new JLabel("L:1500원");
		
		s_cost.setBounds(670, 570, 100, 100);
		m_cost.setBounds(775, 570, 100, 100);
		l_cost.setBounds(905, 570, 100, 100);
		
		s_cost.setForeground(Color.WHITE);
		m_cost.setForeground(Color.WHITE);
		l_cost.setForeground(Color.WHITE);

		//배경 그림
		bg = new ImageIcon("image/bg.jpg").getImage();

		// 배경 설정
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(bg, 0, 0, null);
				setOpaque(false);// 그림 표시 설정
				super.paintComponent(g);
			}
		};

		//background에 컴포넌트 붙이기
		
		background.add(user_view_cup);
		background.add(user_view_coin);
		background.add(user_view_admin);
		background.add(user_view_title);
		background.add(user_view_drinkbar);
		background.add(user_view_switch);
		background.add(admin_view);
		
		background.add(s_cost);
		background.add(m_cost);
		background.add(l_cost);
		
		background.setLayout(null);
		
		//뷰에 background 붙이기
		setContentPane(background);
		setResizable(false);
		setSize(1024, 768);
		setVisible(true);
		
	}

}
