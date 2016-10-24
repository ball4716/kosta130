package com.kosta._0804;



import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.TableModel;

public class JTableTest extends JFrame{
	
	JTable table;
	
	public JTableTest() { 
		
		/*
		  JTable: 데이터들을 행과열 형태로 화면에 출력해 주는 컴포넌트
		  
		     이름 		나이		직업
		  ------------------------
		    홍길동		13		학생
		    길라임		15		학생
		    김유신		17		화랑
		    
		 */
		
		String[][] rowData = {
				{"홍길동","13","학생"},//0행
				// 0열  , 1열, 2열
				{"길라임",""+15,"학생"},//1행
				{"김유신","17","화랑"} //2행
		};
		String[] columnNames = {"이름","나이","직업"};
		
		//JTable(Object[][] rowData, Object[] columnNames)
		table = new JTable(rowData,columnNames);
		JScrollPane tableScroll = new JScrollPane(table);
		//스크롤바를 필요로 하는 컴포넌트를 JScrollPane()파라미터로 전달.
		//스크롤바를 필요로 하는 컴포넌트: JTextArea, JTable, JList
		
		
		add(tableScroll);
		
		//데이터 얻어오기
		//table.getValueAt(int row, int column);//Value:데이터, 행열:인덱스
		//홍길동
		System.out.println("table.getValueAt(0,0): "+table.getValueAt(0, 0));
		//화랑
		System.out.println("table.getValueAt(2,2): "+table.getValueAt(2, 2));
		
		//데이터 변경하기
		//table.setValueAt(Object aValue, int row, int column);
		//김유신의 나이 17--->19 직업: 화랑 ---->장군
		table.setValueAt("19", 2, 1);
		table.setValueAt("장군", 2, 2);

		
		setTitle("JTable테스트");
		setBounds(300,200,300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}//생성자
	
	public static void main(String[] args) {
		new JTableTest();
	}
}
