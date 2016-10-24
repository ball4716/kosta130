package com.kosta._0804;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest2 extends JFrame implements ActionListener{
	
	JTable table;
	JScrollPane sp;
	DefaultTableModel dtm;
	JButton bt;
	
	public JTableTest2() {
		//table = new JTable(5, 3); //5행 3열의 공간이 있는 JTable을 생성
		//JTable(TableModel dm) ----> JTable(DefaultTableModel dtm);
		//DefaultTableModel(Object[][] data, Object[] columnNames)
		Object[][] data = new Object[0][3];
		String[] columnNames={"이름","나이","직업"};
		dtm = new DefaultTableModel(data,columnNames);
		
		
		table = new JTable(dtm);
		sp = new JScrollPane(table);
		
		bt = new JButton("나버튼");
		
		//데이터 추가1
		Object rowData[]={"홍길동",13,"학생"};
		dtm.addRow(rowData);
		
		//데이터 추가2
		Vector rowData2 = new Vector();
		rowData2.add("길라임");
		rowData2.add(15);
		rowData2.add("학생");
		dtm.addRow(rowData2);
		
		//데이터 추가3
		Vector<Object> v = new Vector<>();
		v.add("김주원");
		v.add(17);
		v.add("학생");
		
		Object rowData3 [] = v.toArray();
		dtm.addRow(rowData3);
		
		//데이터 삭제(두번째 데이터 길라임): 두번째===> 인덱스 1
		//dtm.removeRow(int row);
		dtm.removeRow(1);
		
		//데이터 (삽입)추가 : 인덱스 1에 추가
		Object rowData4[]={"김유신",16,"화랑"};
		//dtm.insertRow(int row, Object [] rowData4);
		dtm.insertRow(1, rowData4);
		
		System.out.println("행갯수:"+dtm.getRowCount());
		System.out.println("열갯수:"+dtm.getColumnCount());
		
		add(sp);
		add("South",bt);
		setTitle("JTable추가삭제테스트");
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		
		JOptionPane.showMessageDialog(this, "선택된 행의 인덱스: "+row);
		if(row!=-1){
			Object name = table.getValueAt(row, 0);
			JOptionPane.showMessageDialog(this, "선택된 행의 이름: "+name);
		}
	}
	
	public static void main(String[] args) {
		new JTableTest2();
	}
}
