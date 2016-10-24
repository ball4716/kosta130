package com.kosta._0809;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ArrowMoveTest extends JFrame implements ActionListener, Runnable{
	JLabel la;
	JButton bt;
	
	public ArrowMoveTest() {	
		ImageIcon icon = new ImageIcon("image/right.gif");
		la = new JLabel(icon);
		bt = new JButton("������");
			la.setBounds(0,0,60,60);
			bt.setBounds(0,415,80,30);
		
		setTitle("�����̴� ȭ��ǥ");
		
		setLayout(null);
		add(la);
		add(bt);
		
		setBounds(200,100,500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt.addActionListener(this);
	}//������
	
	@Override
	public void run() {//������޼ҵ� (���ü����� ����)
		int k=0;
		for (int i = 0; i < this.getWidth()-la.getWidth()-15; i++) {
			la.setLocation(i, 0);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				k=i;
			}
		}
		for (int i = 0; i < this.getHeight()-la.getHeight()-50; i++) {
			la.setLocation(k, i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(this, "�̵���!!");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Thread t = new Thread(run()�޼ҵ��� ������ġ)
		new Thread(this).start();
	}//actionPerformed
	
	public static void main(String[] args) {
		new ArrowMoveTest();
	}

}
