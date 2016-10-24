package com.return3.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserViewCup extends JPanel {
	public JLabel la_small, la_middle, la_big;
	Image cup_s, cup_m, cup_l;
	public Image cup_s_dis;
	public Image cup_s_en;
	public Image cup_m_dis;
	public Image cup_m_en;
	public Image cup_l_dis;
	public Image cup_l_en;

	public UserViewCup() {
		// 이미지 크기 조절
		cup_s_en = new ImageIcon("image/cup_enable.png").getImage().getScaledInstance(80, 100, java.awt.Image.SCALE_SMOOTH);
		cup_m_en = new ImageIcon("image/cup_enable.png").getImage().getScaledInstance(100, 120, java.awt.Image.SCALE_SMOOTH);
		cup_l_en = new ImageIcon("image/cup_enable.png").getImage().getScaledInstance(120, 150, java.awt.Image.SCALE_SMOOTH);
		
		cup_s_dis = new ImageIcon("image/cup_disable.png").getImage().getScaledInstance(80, 100, java.awt.Image.SCALE_SMOOTH);
		cup_m_dis = new ImageIcon("image/cup_disable.png").getImage().getScaledInstance(100, 120, java.awt.Image.SCALE_SMOOTH);
		cup_l_dis = new ImageIcon("image/cup_disable.png").getImage().getScaledInstance(120, 150, java.awt.Image.SCALE_SMOOTH);

		// 라벨 초기화
		la_small = new JLabel(new ImageIcon(cup_s_dis));
		la_small.setBounds(650, 500,80,100);
		la_small.setEnabled(false);
		la_middle = new JLabel(new ImageIcon(cup_m_dis));
		la_middle.setBounds(750,480,100,120);
		la_middle.setEnabled(false);
		la_big = new JLabel(new ImageIcon(cup_l_dis));
		la_big.setBounds(870, 460,120,150);
		la_big.setEnabled(false);

		//패널 투명화
		setOpaque(false);
		setBounds(0, 0, 1024, 768);

		setLayout(null);
		add(la_small);
		add(la_middle);
		add(la_big);


	}
}
