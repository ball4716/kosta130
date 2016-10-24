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
		//table = new JTable(5, 3); //5�� 3���� ������ �ִ� JTable�� ����
		//JTable(TableModel dm) ----> JTable(DefaultTableModel dtm);
		//DefaultTableModel(Object[][] data, Object[] columnNames)
		Object[][] data = new Object[0][3];
		String[] columnNames={"�̸�","����","����"};
		dtm = new DefaultTableModel(data,columnNames);
		
		
		table = new JTable(dtm);
		sp = new JScrollPane(table);
		
		bt = new JButton("����ư");
		
		//������ �߰�1
		Object rowData[]={"ȫ�浿",13,"�л�"};
		dtm.addRow(rowData);
		
		//������ �߰�2
		Vector rowData2 = new Vector();
		rowData2.add("�����");
		rowData2.add(15);
		rowData2.add("�л�");
		dtm.addRow(rowData2);
		
		//������ �߰�3
		Vector<Object> v = new Vector<>();
		v.add("���ֿ�");
		v.add(17);
		v.add("�л�");
		
		Object rowData3 [] = v.toArray();
		dtm.addRow(rowData3);
		
		//������ ����(�ι�° ������ �����): �ι�°===> �ε��� 1
		//dtm.removeRow(int row);
		dtm.removeRow(1);
		
		//������ (����)�߰� : �ε��� 1�� �߰�
		Object rowData4[]={"������",16,"ȭ��"};
		//dtm.insertRow(int row, Object [] rowData4);
		dtm.insertRow(1, rowData4);
		
		System.out.println("�హ��:"+dtm.getRowCount());
		System.out.println("������:"+dtm.getColumnCount());
		
		add(sp);
		add("South",bt);
		setTitle("JTable�߰������׽�Ʈ");
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		
		JOptionPane.showMessageDialog(this, "���õ� ���� �ε���: "+row);
		if(row!=-1){
			Object name = table.getValueAt(row, 0);
			JOptionPane.showMessageDialog(this, "���õ� ���� �̸�: "+name);
		}
	}
	
	public static void main(String[] args) {
		new JTableTest2();
	}
}
