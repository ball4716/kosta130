package com.kosta._0809;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SimpleNotePad extends JFrame implements ActionListener{
	JTextArea ta;
	JScrollPane scroll_pane;//사이즈를 벗어나는 데이터를 표현하기 위해 사용
							//JTextArea. JList, JTable
	JMenuBar menu_bar;
	JMenu file_menu, help_menu;
	JMenuItem menu_item_open,menu_item_save,menu_item_exit;
	
	JFileChooser file_chooser = new JFileChooser("./");
	
	FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "텍스트파일", "txt");

	FileInputStream fis;
	FileOutputStream fos;
	BufferedReader br;
	
	/*
	 
	 InputStream              OutputStream
	    File     ------------>    File
	   a.txt                     b.txt
	   
	  <기능구현>
	 1. 파일(a.txt)을 읽어서 JTextArea에 출력
	      파일 --------------> ta
	      
	 2. JTextArea의 text를 특정파일이름으로 저장
	    ta --------------> 파일
	    
	 JFileChooser클래스
	 	- openDialog
	 	- saveDialog
	 	
	 참고) JMenuItem(이벤트소스) ----------->
	 		이벤트처리
	 */
	
	public SimpleNotePad() {
		setTitle("자바메모장");
		
		//메뉴아이템 구성
		menu_item_open = new JMenuItem("열기");
		menu_item_save = new JMenuItem("저장");
		menu_item_exit = new JMenuItem("종료");
		
		//메뉴구성
		file_menu = new JMenu("File");
			file_menu.add(menu_item_open);
			file_menu.add(menu_item_save);
			file_menu.add(menu_item_exit);
		help_menu = new JMenu("Help");
		
		//메뉴바구성
		menu_bar = new JMenuBar();
			menu_bar.add(file_menu);
			menu_bar.add(help_menu);
		
		setJMenuBar(menu_bar);
		
		ta = new JTextArea();
		scroll_pane = new JScrollPane(ta);
		
		add(scroll_pane);
		
		setBounds(300,50,600,650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//파일 선택지 확장자 셋팅
		file_chooser.setFileFilter(filter);
		
		//연결자(감시자) 등록
		menu_item_open.addActionListener(this);
		menu_item_save.addActionListener(this);
		menu_item_exit.addActionListener(this);
		help_menu.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		byte b[]=new byte[10];
		int i;
		int returnVal;
		
		if(obj == menu_item_open){
			ta.setText("");
			returnVal = file_chooser.showOpenDialog(this);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       try {
					fis = new FileInputStream(file_chooser.getSelectedFile().getName());
					while((i=fis.read(b))!=-1){
						ta.append(new String(b));
					}
					fis.close();
				} catch (Exception exception) {
					exception.printStackTrace();
				}
		    }else if(returnVal==JFileChooser.CANCEL_OPTION){
				return;
		    }else{//returnVal==JFileChooser.ERROR_OPTION
		    	JOptionPane.showMessageDialog(this, "치명적인 오류가 발생하였습니다. 프로그램을 종료합니다.");
		    	System.exit(0);
		    }
		}else if(obj == menu_item_save){
			returnVal = file_chooser.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					String str = ta.getText().replace("\n", "\r\n");
					//데이터 얻고, 앞으로 당기기: CR(13) + 줄바꿈: LF(10)
					//                       \r              \n
					fos = new FileOutputStream(file_chooser.getSelectedFile().getName());
					fos.write(str.getBytes());
					fos.close();
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}else if(returnVal==JFileChooser.CANCEL_OPTION){
				return;
		    }else{//returnVal==JFileChooser.ERROR_OPTION
		    	JOptionPane.showMessageDialog(this, "치명적인 오류가 발생하였습니다. 프로그램을 종료합니다.");
		    	System.exit(0);
		    }
		}else if(obj == menu_item_exit){
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		new SimpleNotePad();
	}
}
