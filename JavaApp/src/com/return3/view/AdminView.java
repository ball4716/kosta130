package com.return3.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class AdminView extends JPanel {

	public JLabel la_coca, la_cider, la_fanta, la_mount;
	public JLabel la_cups, la_cupm, la_cupl;
	JTable tbl_drink, tbl_cup_money;
	public DefaultTableModel dtm_drink,dtm_cup_money;
	JScrollPane sp_drink, sp_cup_money;
	public JButton bt_coca_add_all,bt_cider_add_all,bt_fanta_add_all,bt_mount_add_all;
	public JButton bt_coca_add, bt_cider_add, bt_fanta_add, bt_mount_add;
	public JButton bt_cups_add_all,bt_cupm_add_all,bt_cupl_add_all;
	public JButton bt_cups_add, bt_cupm_add, bt_cupl_add;
	
	public AdminView() {
		
		
		String []col1={"콜라","사이다","환타","마운틴듀"};
		String []col2={"S","M","L","총액"};
		Object[][]data1=new Object [0][4];
		Object[][]data2=new Object [0][4];
		
		dtm_drink = new DefaultTableModel(data1, col1);
		dtm_cup_money = new DefaultTableModel(data2, col2);
		
		tbl_drink=new JTable(dtm_drink);
		
		tbl_cup_money=new JTable(dtm_cup_money);
		
		bt_coca_add_all=new JButton("자동 충전");
		bt_cider_add_all=new JButton("자동 충전");
		bt_fanta_add_all=new JButton("자동 충전");
		bt_mount_add_all=new JButton("자동 충전");
		
		bt_cups_add_all=new JButton("자동 충전");
		bt_cupm_add_all=new JButton("자동 충전");
		bt_cupl_add_all=new JButton("자동 충전");
		
		bt_coca_add=new JButton("수동 충전");
		bt_cider_add=new JButton("수동 충전");
		bt_fanta_add=new JButton("수동 충전");
		bt_mount_add=new JButton("수동 충전");
		
		bt_cups_add=new JButton("수동 충전");
		bt_cupm_add=new JButton("수동 충전");
		bt_cupl_add=new JButton("수동 충전");
		
		bt_cups_add_all.setBounds(618, 365, 90, 20);
		bt_cupm_add_all.setBounds(720, 365, 90, 20);
		bt_cupl_add_all.setBounds(818, 365, 90, 20);
		
		bt_coca_add_all.setBounds(618, 225, 90, 20);
		bt_cider_add_all.setBounds(718, 225, 90, 20);
		bt_fanta_add_all.setBounds(818, 225, 90, 20);
		bt_mount_add_all.setBounds(918, 225, 90, 20);
		
		bt_cups_add.setBounds(618, 344, 90, 20);
		bt_cupm_add.setBounds(720, 344, 90, 20);
		bt_cupl_add.setBounds(818, 344, 90, 20);
		
		bt_coca_add.setBounds(618, 204, 90, 20);
		bt_cider_add.setBounds(718, 204, 90, 20);
		bt_fanta_add.setBounds(818, 204, 90, 20);
		bt_mount_add.setBounds(918, 204, 90, 20);
		
		sp_drink = new JScrollPane(tbl_drink);
		sp_cup_money = new JScrollPane(tbl_cup_money);
		
		sp_drink.setBounds(614, 130, 400, 120);
		sp_cup_money.setBounds(614, 270, 400, 120);
		
		
		la_coca = new JLabel();
		la_coca.setForeground(Color.white);
		la_cider = new JLabel();
		la_cider.setForeground(Color.white);
		la_fanta = new JLabel();
		la_fanta.setForeground(Color.white);
		la_mount = new JLabel();
		la_mount.setForeground(Color.white);
		
		la_cups = new JLabel();
		la_cups.setForeground(Color.white);
		la_cupm = new JLabel();
		la_cupm.setForeground(Color.white);
		la_cupl = new JLabel();
		la_cupl.setForeground(Color.white);

		la_coca.setBounds(45, 45, 100,100);
		la_cider.setBounds(205, 45, 100,100);
		la_fanta.setBounds(365, 45, 100,100);
		la_mount.setBounds(515, 45, 100,100);

		la_cups.setBounds(660, 380,100,100);
		la_cupm.setBounds(795, 380,100,100);
		la_cupl.setBounds(930, 380,100,100);
		
		
		//패널 투명화
		setOpaque(false);
		setLayout(null);
		setBounds(0, 0, 1024, 768);

		add(la_coca);
		add(la_cider);
		add(la_fanta);
		add(la_mount);
		add(la_cups);
		add(la_cupm);
		add(la_cupl);
		
		add(bt_coca_add);
		add(bt_cider_add);
		add(bt_fanta_add);
		add(bt_mount_add);
		
		add(bt_cups_add);
		add(bt_cupm_add);
		add(bt_cupl_add);
		
		add(bt_coca_add_all);
		add(bt_cider_add_all);
		add(bt_fanta_add_all);
		add(bt_mount_add_all);
		
		add(bt_cups_add_all);
		add(bt_cupm_add_all);
		add(bt_cupl_add_all);
		
		add(sp_drink);
		add(sp_cup_money);
		
	}

}
