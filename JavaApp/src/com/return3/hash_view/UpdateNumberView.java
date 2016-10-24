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

public class UpdateNumberView extends JFrame {
	public JLabel name_label;
	public JTextField num_field;
	Image add_new_bg, eng_key_bg;
	public JPanel keyline_pnl;
	public JButton key_button[];
	public JButton up_submit_button, cancel_button;

	public UpdateNumberView() {
		name_label = new JLabel();
		name_label.setBounds(175, 115, 200, 30);
		name_label.setFont(new Font("돋움", Font.PLAIN, 20));
		name_label.setOpaque(false);
		
		num_field = new JTextField("니전화번호"){
			@Override
			public void setBorder(Border border) {
				// 테두리 없애기
			}
		};
		num_field.setBounds(200, 335, 200, 30);
		num_field.setFont(new Font("돋움", Font.PLAIN, 20));
		num_field.setEnabled(false);

		add_new_bg = new ImageIcon("image/hash/update.jpg").getImage();
		
		up_submit_button = new JButton();
		up_submit_button.setBorderPainted(false);
		up_submit_button.setContentAreaFilled(false);
		up_submit_button.setFocusPainted(false);
		up_submit_button.setBounds(430,42,100,50);
		
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
		
		key_button = new JButton[11];
		for (int i = 0; i < key_button.length; i++) {
			key_button[i] = new JButton();
			key_button[i].setBorderPainted(false);
			key_button[i].setContentAreaFilled(false);
			key_button[i].setFocusPainted(false);
		}

		keyline_pnl = new JPanel();
		keyline_pnl.setLayout(new GridLayout(4, 3, 0, 0));
		for (int i = 0; i < key_button.length+1; i++) {
			if(i==9){
				keyline_pnl.add(new JLabel());
				continue;
			}else if(i==10 || i==11){
				keyline_pnl.add(key_button[i-1]);
				continue;
			}
			keyline_pnl.add(key_button[i]);
		}
		keyline_pnl.setBounds(0,650,540,310);
		keyline_pnl.setOpaque(false);
		
		
		

		background.add(up_submit_button);
		background.add(cancel_button);
		background.add(keyline_pnl);
		background.add(name_label);
		background.add(num_field);
		background.setLayout(null);
		setContentPane(background);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(540, 1000);
		setVisible(false);
	}

	public static void main(String[] args) {
		new UpdateNumberView();
	}
}
