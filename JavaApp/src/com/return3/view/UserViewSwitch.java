package com.return3.view;

import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserViewSwitch extends JPanel {

	JLabel la_coca, la_cider, la_fanta, la_mountaindew;
	ImageIcon image1, image2, image3, image4;

	public UserViewSwitch() {
		la_coca = new JLabel(new ImageIcon("image/coca1.jpg"));
		la_cider = new JLabel(new ImageIcon("image/cider1.jpg"));
		la_fanta = new JLabel(new ImageIcon("image/fanta1.jpg"));
		la_mountaindew = new JLabel(new ImageIcon("image/mountaindew1.jpg"));
		
		//패널 투명화
		setOpaque(false);

		setLayout(new GridLayout(1, 4, 15, 0));
		add(la_coca);
		add(la_cider);
		add(la_fanta);
		add(la_mountaindew);
		setBounds(10, 480, 600, 250);
	}
}
