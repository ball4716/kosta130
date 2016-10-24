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
	private JPanel pnl_btn, pnl_north; //pnl_north: 시계패널
	private JLabel la_clock; // 시간출력
	
	
	public MainView() {
		la_clock = new JLabel();
		pnl_north = new JPanel();
		pnl_north.add(la_clock);
		
		//JTable 초기화
		Object[][] data = new Object[0][4];
		String [] columnNames = {"번호","이름","나이","직업"};
		dtm = new DefaultTableModel(data,columnNames);
		table = new JTable(dtm);
		scroll_tbl = new JScrollPane(table);
		
		//버튼 초기화
		bt_insert = new JButton("입력");
		bt_update = new JButton("수정");
		bt_delete = new JButton("삭제");
		bt_exit = new JButton("종료");
		//bt_update.setEnabled(false);
		
		//패널 초기화 및 컴포넌트 배치
		pnl_btn = new JPanel();
		pnl_btn.add(bt_insert);
		pnl_btn.add(bt_update);
		pnl_btn.add(bt_delete);
		pnl_btn.add(bt_exit);
		
		//레이아웃 배치 및 컴포넌트,패널 배치
		setLayout(new BorderLayout(5,5));
		add("West",new JLabel());
		add("East",new JLabel());
		add("Center", scroll_tbl);
		add("South", pnl_btn);
		add("North", pnl_north);
		
		//currentTimePrint();
		//run()호출;
		/*
		 1. extends Thread시
		    start();
		   
		 2. implements Runnable시
		    new Thread(this).start();
		 */
		Thread t = new Thread(this);
		t.start();
		
		//레이아웃 설정
		setBounds(300,300,500,500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//생성자
	
	//public void currentTimePrint(){
	public void run(){//왜? 현재 프레임 실행과 독립적인 실행을 하기 위해!!
		while(true){
			
			Calendar cal = new GregorianCalendar();
			//Calendar는 추상클래스  ----->  자식클래스를 통한 객체생성
			//cal: 시스템 날자 정보가 전체 저장
			
			//cal.get(얻어오고자 하는 정보);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			int date = cal.get(Calendar.DATE);
			
			int h = cal.get(Calendar.HOUR);
			int m = cal.get(Calendar.MINUTE);
			int s = cal.get(Calendar.SECOND);
			
			String time = year+"년 "+month+"월 "+date+"일 "+h+"시"+m+"분 "+s+"초";
			la_clock.setText(time);
			
			try {
				Thread.sleep(1000);//1초단위로 시간정보를 얻어오기 위해
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//while
	}//currentTimePrint//run 오버라이딩
	
	public void displayTable(List<PersonDTO> v){
		dtm.setRowCount(0);//출력되는 행의 위치를 지정!!
		//기존 데이터를 지우고 0인덱스부터~
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
		//showMsg정의하는 이유? 컨트롤러클래스에 JOptionPane을 사용하지 않기 위해
		JOptionPane.showMessageDialog(this,msg);
	}//showMessage
	
	public boolean showConfirm(String msg){
		if(JOptionPane.showConfirmDialog(this, msg)==0)
			return true;
		else
			return false;
	}
}
