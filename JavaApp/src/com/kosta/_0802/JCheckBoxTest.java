package com.kosta._0802;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class JCheckBoxTest extends JFrame{
	JCheckBox cb1,cb2,cb3;
	JPanel p;
	
	public JCheckBoxTest() {
		cb1 = new JCheckBox("ù��° üũ�ڽ�");
		//cb2 = new JCheckBox(String text, Icon icon);
		//Icon�������̽� ---����Ŭ����----> ImageIcon
		//new ImageIcon(String filename)
		
		ImageIcon icon1 = new ImageIcon("image/left.gif");
		ImageIcon icon2 = new ImageIcon("image/leftRollover.gif");
		ImageIcon icon3 = new ImageIcon("image/leftDown.gif");
		
		ImageIcon icon4 = new ImageIcon("image/right.gif");
		ImageIcon icon5 = new ImageIcon("image/rightRollover.gif");
		ImageIcon icon6 = new ImageIcon("image/rightDown.gif");
		
		cb2 = new JCheckBox("�ι�° üũ�ڽ�", icon1);
			cb2.setRolloverIcon(icon2);
			cb2.setSelectedIcon(icon3);
		cb3 = new JCheckBox("����° üũ�ڽ�", icon4);
			cb3.setRolloverIcon(icon5);
			cb3.setSelectedIcon(icon6);
		
		p = new JPanel();
		
		p.setLayout(new GridLayout(3,1));
		p.add(cb1);
		p.add(cb2);
		p.add(cb3);
		//�׵θ�����
		// BevelBorder(�簢,����) , TitledBorder(Ÿ��Ʋ): �׵θ�Ÿ��Ʋ
		//p.setBorder(new TitledBorder("�г�Ÿ��Ʋ"));
		//p.setBorder(new BevelBorder(BevelBorder.RAISED));
		//p.setBorder(new BevelBorder(BevelBorder.LOWERED));
		p.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED),"�г�Ÿ��Ʋ"));
		
		setTitle("üũ�ڽ��׽�Ʈ");
		add(p);
		
		setBounds(300,200,300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JCheckBoxTest();
	}
}
