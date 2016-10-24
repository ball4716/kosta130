package com.kosta._0831.view;

import java.awt.BorderLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kosta._0831.model.PersonDTO;

public class MainView extends JFrame implements Runnable{
	
	public JTable table;
	public DefaultTableModel dtm;
	private JScrollPane scroll_tbl;
	public JButton bt_insert,bt_update,bt_delete,bt_exit;
	private JPanel pnl_btn, pnl_north; //pnl_north: �ð��г�
	private JLabel la_clock; // �ð����
	
	
	public MainView() {
		la_clock = new JLabel();
		pnl_north = new JPanel();
		pnl_north.add(la_clock);
		
		//JTable �ʱ�ȭ
		Object[][] data = new Object[0][4];
		String [] columnNames = {"��ȣ","�̸�","����","����"};
		dtm = new DefaultTableModel(data,columnNames);
		table = new JTable(dtm);
		scroll_tbl = new JScrollPane(table);
		
		//��ư �ʱ�ȭ
		bt_insert = new JButton("�Է�");
		bt_update = new JButton("����");
		bt_delete = new JButton("����");
		bt_exit = new JButton("����");
		//bt_update.setEnabled(false);
		
		//�г� �ʱ�ȭ �� ������Ʈ ��ġ
		pnl_btn = new JPanel();
		pnl_btn.add(bt_insert);
		pnl_btn.add(bt_update);
		pnl_btn.add(bt_delete);
		pnl_btn.add(bt_exit);
		
		//���̾ƿ� ��ġ �� ������Ʈ,�г� ��ġ
		setLayout(new BorderLayout(5,5));
		add("West",new JLabel());
		add("East",new JLabel());
		add("Center", scroll_tbl);
		add("South", pnl_btn);
		add("North", pnl_north);
		
		//currentTimePrint();
		//run()ȣ��;
		/*
		 1. extends Thread��
		    start();
		   
		 2. implements Runnable��
		    new Thread(this).start();
		 */
		Thread t = new Thread(this);
		t.start();
		
		//���̾ƿ� ����
		setBounds(300,300,500,500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//������
	
	//public void currentTimePrint(){
	public void run(){//��? ���� ������ ����� �������� ������ �ϱ� ����!!
		while(true){
			
			Calendar cal = new GregorianCalendar();
			//Calendar�� �߻�Ŭ����  ----->  �ڽ�Ŭ������ ���� ��ü����
			//cal: �ý��� ���� ������ ��ü ����
			
			//cal.get(�������� �ϴ� ����);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			int date = cal.get(Calendar.DATE);
			
			int h = cal.get(Calendar.HOUR);
			int m = cal.get(Calendar.MINUTE);
			int s = cal.get(Calendar.SECOND);
			
			String time = year+"�� "+month+"�� "+date+"�� "+h+"��"+m+"�� "+s+"��";
			la_clock.setText(time);
			
			try {
				Thread.sleep(1000);//1�ʴ����� �ð������� ������ ����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//while
	}//currentTimePrint//run �������̵�
	
	public void displayTable(List<PersonDTO> v){
		dtm.setRowCount(0);//��µǴ� ���� ��ġ�� ����!!
		//���� �����͸� ����� 0�ε�������~
		if(v.size()==0){
			bt_update.setEnabled(false);
			bt_delete.setEnabled(false);
		}
		//dtm.addRow(rowData);
		for (int i = 0; i < v.size(); i++) {
			PersonDTO p = v.get(i);
			Object rowData[] = {p.getNo(),p.getName(),p.getAge(),p.getJob()};
			dtm.addRow(rowData);
		}
	}//displayTable
	
	public void updateButtonStateTrue(){
		bt_update.setEnabled(true);
	}
	
	public void updateButtonStateFalse(){
		bt_update.setEnabled(false);
	}
	
	public void deleteButtonStateTrue(){
		bt_delete.setEnabled(true);
	}
	
	public void deleteButtonStateFalse(){
		bt_delete.setEnabled(false);
	}
	
	public String showInput(String msg){
		String str = JOptionPane.showInputDialog(this,msg); 
		return str;
	}//showInput
	
	public void showMsg(String msg){
		//showMsg�����ϴ� ����? ��Ʈ�ѷ�Ŭ������ JOptionPane�� ������� �ʱ� ����
		JOptionPane.showMessageDialog(this,msg);
	}//showMessage
	
	public boolean showConfirm(String msg){
		if(JOptionPane.showConfirmDialog(this, msg)==0)
			return true;
		else
			return false;
	}
}
