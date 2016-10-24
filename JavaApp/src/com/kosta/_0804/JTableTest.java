package com.kosta._0804;



import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.TableModel;

public class JTableTest extends JFrame{
	
	JTable table;
	
	public JTableTest() { 
		
		/*
		  JTable: �����͵��� ����� ���·� ȭ�鿡 ����� �ִ� ������Ʈ
		  
		     �̸� 		����		����
		  ------------------------
		    ȫ�浿		13		�л�
		    �����		15		�л�
		    ������		17		ȭ��
		    
		 */
		
		String[][] rowData = {
				{"ȫ�浿","13","�л�"},//0��
				// 0��  , 1��, 2��
				{"�����",""+15,"�л�"},//1��
				{"������","17","ȭ��"} //2��
		};
		String[] columnNames = {"�̸�","����","����"};
		
		//JTable(Object[][] rowData, Object[] columnNames)
		table = new JTable(rowData,columnNames);
		JScrollPane tableScroll = new JScrollPane(table);
		//��ũ�ѹٸ� �ʿ�� �ϴ� ������Ʈ�� JScrollPane()�Ķ���ͷ� ����.
		//��ũ�ѹٸ� �ʿ�� �ϴ� ������Ʈ: JTextArea, JTable, JList
		
		
		add(tableScroll);
		
		//������ ������
		//table.getValueAt(int row, int column);//Value:������, �࿭:�ε���
		//ȫ�浿
		System.out.println("table.getValueAt(0,0): "+table.getValueAt(0, 0));
		//ȭ��
		System.out.println("table.getValueAt(2,2): "+table.getValueAt(2, 2));
		
		//������ �����ϱ�
		//table.setValueAt(Object aValue, int row, int column);
		//�������� ���� 17--->19 ����: ȭ�� ---->�屺
		table.setValueAt("19", 2, 1);
		table.setValueAt("�屺", 2, 2);

		
		setTitle("JTable�׽�Ʈ");
		setBounds(300,200,300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}//������
	
	public static void main(String[] args) {
		new JTableTest();
	}
}
