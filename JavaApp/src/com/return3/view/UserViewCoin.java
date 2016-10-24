package com.return3.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserViewCoin extends JPanel {

	public JButton money_100, money_500, money_1000, money_return;
	public JLabel la_insert_coin;

	public UserViewCoin() {

		setLayout(new GridLayout(1, 5));

		money_100 = new JButton(new ImageIcon("image/one.png"));

		money_500 = new JButton(new ImageIcon("image/five.png"));
		money_1000 = new JButton(new ImageIcon("image/chun.png"));
		money_return = new JButton(new ImageIcon("image/return.png"));
		la_insert_coin = new JLabel("투입금액");
		la_insert_coin.setForeground(Color.WHITE);

		money_100.setBorderPainted(false);
		money_100.setContentAreaFilled(false);
		money_100.setFocusPainted(false);

		money_500.setBorderPainted(false);
		money_500.setContentAreaFilled(false);
		money_500.setFocusPainted(false);

		money_1000.setBorderPainted(false);
		money_1000.setContentAreaFilled(false);
		money_1000.setFocusPainted(false);

		money_return.setBorderPainted(false);
		money_return.setContentAreaFilled(false);
		money_return.setFocusPainted(false);

		//패널 투명화
		setOpaque(false);
		
		
		add(money_100);
		add(money_500);
		add(money_1000);
		add(la_insert_coin);
		add(money_return);
		
		setBounds(614, 9, 400, 120);

	}
}