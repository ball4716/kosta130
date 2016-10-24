package com.kosta.vending.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class CustomerVendingView extends JFrame{
	JProgressBar bar_coke,bar_cidar,bar_fanta;
	JPanel pnl_center;
	
	public CustomerVendingView() {
		bar_coke = new JProgressBar(1,0,100);
		bar_coke.setValue(70);
		bar_coke.setForeground(Color.black);
		
		bar_cidar = new JProgressBar(1,0,100);
		bar_cidar.setValue(50);
		bar_cidar.setForeground(Color.CYAN);
		
		bar_fanta = new JProgressBar(1,0,100);
		bar_fanta.setValue(90);
		bar_fanta.setForeground(Color.orange);
		
		pnl_center = new JPanel();
		
		pnl_center.setLayout(new GridLayout(1, 7, 50, 50));
		pnl_center.add(new JLabel());
		pnl_center.add(bar_coke);
		pnl_center.add(new JLabel());
		pnl_center.add(bar_cidar);
		pnl_center.add(new JLabel());
		pnl_center.add(bar_fanta);
		pnl_center.add(new JLabel());
		
		add("Center", pnl_center);
		
		setBounds(300,300,600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new CustomerVendingView();
	}
}
