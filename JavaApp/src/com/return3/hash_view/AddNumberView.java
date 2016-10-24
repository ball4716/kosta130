package com.return3.hash_view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class AddNumberView extends JFrame {
	public JTextField name_field;
	public JLabel num_label;
	Image add_new_bg, eng_key_bg;
	public JPanel eng_pnl;
	public JPanel keyline_pnl_0, keyline_pnl_1, keyline_pnl_2, keyline_pnl_3;
	public JButton key_button[];
	public JButton add_submit_button, cancel_button;

	public AddNumberView() {
		name_field = new JTextField(20) {
			@Override
			public void setBorder(Border border) {
				// 테두리 없애기
			}
		};
		name_field.setBounds(175, 115, 200, 30);
		name_field.setFont(new Font("돋움", Font.PLAIN, 20));
		
		num_label = new JLabel("니전화번호");
		num_label.setBounds(200, 335, 200, 30);
		num_label.setFont(new Font("돋움", Font.PLAIN, 20));

		add_new_bg = new ImageIcon("image/hash/add_new.jpg").getImage();
		
		add_submit_button = new JButton();
		add_submit_button.setBorderPainted(false);
		add_submit_button.setContentAreaFilled(false);
		add_submit_button.setFocusPainted(false);
		add_submit_button.setBounds(430,42,100,50);
		
		cancel_button = new JButton();
		cancel_button.setBorderPainted(false);
		cancel_button.setContentAreaFilled(false);
		cancel_button.setFocusPainted(false);
		cancel_button.setBounds(0,42,100,50);
		
		// 배경 설정
		JPanel background = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(add_new_bg, 0, 0, null);
				setOpaque(false);// 그림 표시 설정
				super.paintComponent(g);
			}
		};

		eng_key_bg = new ImageIcon("image/hash/eng_key.jpg").getImage();
		eng_pnl = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(eng_key_bg, 0, 0, null);
				setOpaque(false);// 그림 표시 설정
				super.paintComponent(g);
			}
		};
		
		key_button = new JButton[37];
		for (int i = 0; i < key_button.length; i++) {
			key_button[i] = new JButton("\n");
			key_button[i].setBorderPainted(false);
			key_button[i].setContentAreaFilled(false);
			key_button[i].setFocusPainted(false);
		}

		keyline_pnl_0 = new JPanel();
		keyline_pnl_0.setLayout(new GridLayout(1, 10, 2, 0));
		for (int i = 0; i < 10; i++) {
			keyline_pnl_0.add(key_button[i]);
		}
		keyline_pnl_0.setOpaque(false);
		keyline_pnl_1 = new JPanel();
		keyline_pnl_1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 2));
		for (int i = 10; i < 19; i++) {
			keyline_pnl_1.add(key_button[i]);
		}
		keyline_pnl_1.setOpaque(false);

		keyline_pnl_2 = new JPanel();
		keyline_pnl_2.setLayout(new GridLayout(1, 11, 2, 0));
		for (int i = 17; i < 28; i++) {
			if (i == 17 || i == 18) {
				keyline_pnl_2.add(new JLabel());
				continue;
			}
			keyline_pnl_2.add(key_button[i]);
		}
		keyline_pnl_2.setOpaque(false);

		keyline_pnl_3 = new JPanel();
		keyline_pnl_3.setLayout(new GridLayout(1, 11, 2, 0));
		for (int i = 26; i < key_button.length; i++) {
			if (i == 26 || i == 27) {
				keyline_pnl_3.add(new JLabel());
				continue;
			}
			keyline_pnl_3.add(key_button[i]);
		}
		keyline_pnl_3.setOpaque(false);
		
		eng_pnl.setLayout(new GridLayout(4,1,5,20));
		eng_pnl.setBounds(0, 650, 540, 310);
		eng_pnl.add(keyline_pnl_0);
		eng_pnl.add(keyline_pnl_1);
		eng_pnl.add(keyline_pnl_2);
		eng_pnl.add(keyline_pnl_3);
		eng_pnl.setVisible(true);

		background.add(add_submit_button);
		background.add(cancel_button);
		background.add(eng_pnl);
		background.add(name_field);
		background.add(num_label);
		background.setLayout(null);
		setContentPane(background);
		setSize(540, 1000);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);
	}

}
