package com.return3.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class UserViewDrinkbar extends JPanel{
	//������� ������Ʈ ���� ����
	public JProgressBar bar_coca,bar_cider,bar_fanta,bar_mountaindew;
	
	public UserViewDrinkbar() {
		//�ʱ�ȭ �� ����
		bar_coca = new JProgressBar(1,0,10000);
		bar_coca.setForeground(Color.BLACK);
		bar_coca.setOpaque(false);
		
		bar_cider = new JProgressBar(1,0,10000);
		bar_cider.setForeground(Color.CYAN);
		bar_cider.setOpaque(false);
		
		bar_fanta = new JProgressBar(1,0,10000);
		bar_fanta.setForeground(Color.ORANGE);
		bar_fanta.setOpaque(false);
		
		bar_mountaindew = new JProgressBar(1,0,10000);
		bar_mountaindew.setForeground(Color.GREEN);
		bar_mountaindew.setOpaque(false);
		
		//�г� ����ȭ
		setOpaque(false);
		
		//�гο� ��ġ
		setLayout(new GridLayout(1,4,15,0));
		add(bar_coca);
		add(bar_cider);
		add(bar_fanta);
		add(bar_mountaindew);
		
		//��ǥ���� �� ũ�� ����
		setBounds(10,109,600,400);
		setVisible(true);
	}
	
}
