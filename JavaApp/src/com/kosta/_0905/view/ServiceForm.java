package com.kosta._0905.view;

import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kosta._0905.model.dto.UserInfo;

public class ServiceForm extends JFrame {
	public JTable table;
	JLabel la;
	public DefaultTableModel dtm;

	public JButton bt_up, bt_del, bt_sel_all, bt_sel_name, bt_exit;
	JPanel southp;
	
	JMenuBar bar;
	JMenu menu_admin;
	public JMenuItem item_admin;
	public JMenuItem item_exit;

	public ServiceForm() {
		setTitle("Display Data");
		
		bar = new JMenuBar();
		menu_admin = new JMenu("관리자");
		item_admin = new JMenuItem("관리자 인증");
		item_exit = new JMenuItem("나가기");
		
		menu_admin.add(item_admin);
		menu_admin.addSeparator();
		menu_admin.add(item_exit);
		
		bar.add(menu_admin);
		
		setJMenuBar(bar);

		Object rowData[][] = new String[0][7];
		Object colNames[] = { "ID", "이름", "나이", "성별", "전화번호", "주소", "직업" };

		dtm = new DefaultTableModel(rowData, colNames);
		table = new JTable(dtm);

		JScrollPane scrol = new JScrollPane(table);

		bt_up = new JButton("수정");
		bt_del = new JButton("삭제");
		bt_sel_all = new JButton("전체보기");
		bt_sel_name = new JButton("이름검색");
		bt_exit = new JButton("종료");

		southp = new JPanel();
		southp.add(bt_sel_all);
		southp.add(bt_up);
		southp.add(bt_del);
		southp.add(bt_sel_name);
		southp.add(bt_exit);

		add("Center", scrol);
		add("South", southp);

		setBounds(300, 200, 500, 300);
		// setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}// 생성자

	public void displayTable(List<UserInfo> v) {
		dtm.setRowCount(0);// 출력되는 행의 위치 지정
		// 기존 데이터 지우고 0 인덱스부터
		for (int i = 0; i < v.size(); i++) {
			UserInfo user = v.get(i);
			int age = 0;
			String manOrWoman="미입력";
			if (user.getSsn1() != null && user.getSsn2() != null) {
				int ssn1 = Integer.parseInt(user.getSsn1().substring(0, 2));
				int gender = Integer.parseInt(user.getSsn2()) / 1000000;
				if (gender == 1 || gender == 2 || gender == 5 || gender == 6) {
					ssn1 += 1900;
				} else if (gender == 3 || gender == 4 || gender == 7 || gender == 8) {
					ssn1 += 2000;
				} else if (gender == 9 || gender == 0) {
					ssn1 += 1800;
				}
				age = (Calendar.getInstance().get(Calendar.YEAR)) - ssn1 + 1;
				
				manOrWoman = (gender % 2 == 1) ? "남자":"여자";
			}
			Object rowData[] = { user.getId(), user.getName(), age, manOrWoman, user.getPhone(), user.getAddr(),
					user.getJob() };
			dtm.addRow(rowData);
		}
	}

	public String showInputDialog(String msg) {
		return JOptionPane.showInputDialog(this, msg);
	}

	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

	public int showConfirm(String msg) {
		return JOptionPane.showConfirmDialog(this, msg);
	}

}// ServiceForm class
