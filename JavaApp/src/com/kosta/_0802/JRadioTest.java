package com.kosta._0802;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class JRadioTest extends JFrame{
	JRadioButton rb1,rb2,rb3;
	JPanel p;

	public JRadioTest() {
		ImageIcon icon1 = new ImageIcon("image/left.gif");
		ImageIcon icon2 = new ImageIcon("image/leftRollover.gif");
		ImageIcon icon3 = new ImageIcon("image/leftDown.gif");
		
		ImageIcon icon4 = new ImageIcon("image/right.gif");
		ImageIcon icon5 = new ImageIcon("image/rightRollover.gif");
		ImageIcon icon6 = new ImageIcon("image/rightDown.gif");
		
		rb1 = new JRadioButton("첫번째");
			rb1.setToolTipText("첫번째라디오버튼진입~!!");
		rb2 = new JRadioButton("두번째", icon1);
			rb2.setRolloverIcon(icon2);
			rb2.setPressedIcon(icon3);
		rb3 = new JRadioButton("세번째", icon4);
			rb3.setRolloverIcon(icon5);
			rb3.setPressedIcon(icon6);
			
		
		//그룹핑
		ButtonGroup bg = new ButtonGroup();
			bg.add(rb1);
			bg.add(rb2);
			bg.add(rb3);
		
		p = new JPanel();
			p.setLayout(new GridLayout(3,1));
			p.add(rb1);
			p.add(rb2);
			p.add(rb3);
		p.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED),"라디오그룹"));
		
		add(p);
		setTitle("라디오버튼 테스트");
		setBounds(300, 200, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}//생성자
	
	public static void main(String[] args) {
		new JRadioTest();
	}
}
