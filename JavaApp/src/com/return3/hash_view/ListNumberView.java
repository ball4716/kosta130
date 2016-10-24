package com.return3.hash_view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ListNumberView extends JFrame{
	public JTextField search_field;
	public JList<String> number_list;
	public JScrollPane list_scroll;
	public DefaultListModel<String> listModel;
	Image list_bg, eng_key_bg;
	public JPanel eng_pnl;
	public JPanel keyline_pnl_0,keyline_pnl_1,keyline_pnl_2,keyline_pnl_3;
	public JButton key_button[];
	public JButton bot_button, del_button, up_button;
	public JPanel bot_pnl;
	
	public ListNumberView() {
		search_field = new JTextField(){
			@Override
			public void setBorder(Border border){
				//테두리 없애기
			}
		};
		search_field.setBounds(20, 108, 500, 30);
		search_field.setFont(new Font("돋움", Font.PLAIN, 20));
		search_field.setHorizontalAlignment(JTextField.CENTER);
		
		number_list = new JList<>(new DefaultListModel());
		number_list.setFont(new Font("돋움", Font.PLAIN, 30));
		list_scroll = new JScrollPane(number_list);
		list_scroll.setBounds(0, 155, 540, 735);
		listModel = (DefaultListModel)number_list.getModel();
		number_list.setVisibleRowCount(10);
		number_list.setSize(540, 735);
		list_scroll.setVisible(true);
		
		
		list_bg = new ImageIcon("image/hash/number003.jpg").getImage();
		
		//배경 설정
		JPanel background = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(list_bg, 0, 0, null);
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
		keyline_pnl_0.setLayout(new GridLayout(1,10,2,0));
		for (int i = 0; i < 10; i++) {
			keyline_pnl_0.add(key_button[i]);
		}
		keyline_pnl_0.setOpaque(false);
		keyline_pnl_1 = new JPanel();
		keyline_pnl_1.setLayout(new FlowLayout(FlowLayout.CENTER,20,2));
		for (int i = 10; i < 19; i++){
			keyline_pnl_1.add(key_button[i]);
		}
		keyline_pnl_1.setOpaque(false);
		
		keyline_pnl_2 = new JPanel();
		keyline_pnl_2.setLayout(new GridLayout(1,11,2,0));
		for (int i = 17; i < 28; i++){
			if (i==17 || i==18){
				keyline_pnl_2.add(new JLabel());
				continue;
			}
			keyline_pnl_2.add(key_button[i]);
		}
		keyline_pnl_2.setOpaque(false);
		
		keyline_pnl_3 = new JPanel();
		keyline_pnl_3.setLayout(new GridLayout(1,11,2,0));
		for (int i = 26; i < key_button.length; i++){
			if(i==26 || i==27){
				keyline_pnl_3.add(new JLabel());
				continue;
			}
			keyline_pnl_3.add(key_button[i]);
		}
		keyline_pnl_3.setOpaque(false);
		
		eng_key_bg = new ImageIcon("image/hash/eng_key.jpg").getImage();
		eng_pnl = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(eng_key_bg, 0, 0, null);
				setOpaque(false);// 그림 표시 설정
				super.paintComponent(g);
			}
		};
		eng_pnl.setLayout(new GridLayout(4,1,5,20));
		eng_pnl.setBounds(0, 650, 540, 310);
		eng_pnl.add(keyline_pnl_0);
		eng_pnl.add(keyline_pnl_1);
		eng_pnl.add(keyline_pnl_2);
		eng_pnl.add(keyline_pnl_3);
		eng_pnl.setVisible(false);
		
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
			if (i == 3) {
				bot_pnl.add(bot_button);
				continue;
			}
			bot_pnl.add(new JLabel());
		}
		
		del_button = new JButton();
		del_button.setBounds(432,42,100,50);
		del_button.setBorderPainted(false);
		del_button.setContentAreaFilled(false);
		del_button.setFocusPainted(false);
		
		up_button = new JButton();
		up_button.setBounds(0,42,100,50);
		up_button.setBorderPainted(false);
		up_button.setContentAreaFilled(false);
		up_button.setFocusPainted(false);
		
		background.add(up_button);
		background.add(del_button);
		background.add(eng_pnl);
		background.add(bot_pnl);
		background.add(list_scroll);
		background.add(search_field);
		background.setLayout(null);
		
		//뷰에 background붙이기
		setContentPane(background);
		setSize(540, 1000);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);
	}
	
	public static void main(String[] args) {
		new ListNumberView();
	}
}
