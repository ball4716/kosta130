package com.return3.hash_view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainNumberView extends JFrame {
	public JTextField number_field;
	public JButton[] number_button;
	public JButton bot_button, add_button, del_button;
	public JButton new_btn, update_btn, cancel_btn;
	public JPanel number_button_pnl, bot_pnl;
	public JPanel add_pnl;
	Image number_bg, add_bg;

	public MainNumberView() {
		number_field = new JTextField(13) {
			@Override
			public void setBorder(Border border) {
				// 테두리 없애기
			}
		};
		number_field.setBounds(80, 55, 380, 100);
		number_field.setOpaque(false);
		number_field.setFont(new Font("돋음", Font.PLAIN, 45));
		number_field.setHorizontalAlignment(JTextField.RIGHT);
		number_field.setEditable(false);

		// 넘버 버튼 그릇 초기화 및 각 버튼 초기화
		number_button = new JButton[10];
		for (int i = 0; i < number_button.length; i++) {
			number_button[i] = new JButton();
			number_button[i].setBorderPainted(false);
			number_button[i].setSize(120, 150);
			number_button[i].setContentAreaFilled(false);
			number_button[i].setFocusPainted(false);
		}

		// 패널에 버튼 붙이기
		number_button_pnl = new JPanel();
		number_button_pnl.setBounds(65, 210, 410, 500);
		number_button_pnl.setLayout(new GridLayout(4, 3));
		number_button_pnl.setOpaque(false);
		for (int i = 0; i < number_button.length + 2; i++) {
			if (i == 9 || i == 11) {
				number_button_pnl.add(new JLabel());
				continue;
			} else if (i == 10) {
				number_button_pnl.add(number_button[i - 1]);
				continue;
			}
			number_button_pnl.add(number_button[i]);
		}

		add_button = new JButton();
		add_button.setBounds(20, 90, 70, 50);
		add_button.setBorderPainted(false);
		add_button.setContentAreaFilled(false);
		add_button.setFocusPainted(false);

		del_button = new JButton();
		del_button.setBounds(450, 90, 70, 50);
		del_button.setBorderPainted(false);
		del_button.setContentAreaFilled(false);
		del_button.setFocusPainted(false);

		bot_button = new JButton();
		bot_button.setSize(30, 20);
		bot_button.setBorderPainted(false);
		bot_button.setContentAreaFilled(false);
		bot_button.setFocusPainted(false);

		bot_pnl = new JPanel();
		bot_pnl.setBounds(0, 890, 560, 70);
		bot_pnl.setLayout(new GridLayout(1, 5, 10, 0));
		bot_pnl.setOpaque(false);
		for (int i = 0; i < 5; i++) {
			if (i == 2) {
				bot_pnl.add(bot_button);
				continue;
			}
			bot_pnl.add(new JLabel());
		}

		add_bg = new ImageIcon("image/hash/add.jpg").getImage();
		add_pnl = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(add_bg, 0, 0, null);
				setOpaque(false);// 그림 표시 설정
				super.paintComponent(g);
			}
		};
		add_pnl.setLayout(new GridLayout(3,1));
		add_pnl.setBounds(0, 700, 580, 270);
		
		new_btn = new JButton();
		new_btn.setBorderPainted(false);
		new_btn.setContentAreaFilled(false);
		new_btn.setFocusPainted(false);
		
		update_btn = new JButton();
		update_btn.setBorderPainted(false);
		update_btn.setContentAreaFilled(false);
		update_btn.setFocusPainted(false);
		
		cancel_btn = new JButton();
		cancel_btn.setBorderPainted(false);
		cancel_btn.setContentAreaFilled(false);
		cancel_btn.setFocusPainted(false);
		
		add_pnl.add(new_btn);
		add_pnl.add(update_btn);
		add_pnl.add(cancel_btn);
		add_pnl.setVisible(false);

		number_bg = new ImageIcon("image/hash/number002.jpg").getImage();

		// 배경 설정
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(number_bg, 0, 0, null);
				setOpaque(false);// 그림 표시 설정
				super.paintComponent(g);
			}
		};
		
		background.add(add_pnl);
		background.add(number_field);
		background.add(add_button);
		background.add(del_button);
		background.add(number_button_pnl);
		background.add(bot_pnl);
		background.setLayout(null);

		// 뷰에 background 붙이기
		setContentPane(background);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(540, 1000);
		setVisible(true);
	}

}
