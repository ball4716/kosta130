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
	JScrollPane scroll_pane;//����� ����� �����͸� ǥ���ϱ� ���� ���
							//JTextArea. JList, JTable
	JMenuBar menu_bar;
	JMenu file_menu, help_menu;
	JMenuItem menu_item_open,menu_item_save,menu_item_exit;
	
	JFileChooser file_chooser = new JFileChooser("./");
	
	FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "�ؽ�Ʈ����", "txt");

	FileInputStream fis;
	FileOutputStream fos;
	BufferedReader br;
	
	/*
	 
	 InputStream              OutputStream
	    File     ------------>    File
	   a.txt                     b.txt
	   
	  <��ɱ���>
	 1. ����(a.txt)�� �о JTextArea�� ���
	      ���� --------------> ta
	      
	 2. JTextArea�� text�� Ư�������̸����� ����
	    ta --------------> ����
	    
	 JFileChooserŬ����
	 	- openDialog
	 	- saveDialog
	 	
	 ����) JMenuItem(�̺�Ʈ�ҽ�) ----------->
	 		�̺�Ʈó��
	 */
	
	public SimpleNotePad() {
		setTitle("�ڹٸ޸���");
		
		//�޴������� ����
		menu_item_open = new JMenuItem("����");
		menu_item_save = new JMenuItem("����");
		menu_item_exit = new JMenuItem("����");
		
		//�޴�����
		file_menu = new JMenu("File");
			file_menu.add(menu_item_open);
			file_menu.add(menu_item_save);
			file_menu.add(menu_item_exit);
		help_menu = new JMenu("Help");
		
		//�޴��ٱ���
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
		
		//���� ������ Ȯ���� ����
		file_chooser.setFileFilter(filter);
		
		//������(������) ���
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
		    	JOptionPane.showMessageDialog(this, "ġ������ ������ �߻��Ͽ����ϴ�. ���α׷��� �����մϴ�.");
		    	System.exit(0);
		    }
		}else if(obj == menu_item_save){
			returnVal = file_chooser.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					String str = ta.getText().replace("\n", "\r\n");
					//������ ���, ������ ����: CR(13) + �ٹٲ�: LF(10)
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
		    	JOptionPane.showMessageDialog(this, "ġ������ ������ �߻��Ͽ����ϴ�. ���α׷��� �����մϴ�.");
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
