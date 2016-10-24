package com.kosta._0810;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, Runnable{
	JTextArea ta;//대화내용을 출력
	JTextField tf;//서버에게 데이터를 전달
	JScrollPane scroll_ta;
	
	JPanel southp;
	
	Socket s;
	BufferedReader in;//입력
	OutputStream out;//출력
	
	public ChatClient() {
		setTitle("채팅방");
		
		ta = new JTextArea();
		scroll_ta = new JScrollPane(ta);
		
		tf = new JTextField(15);
		
		southp = new JPanel();
		
		southp.add(new JLabel("To MSG:"));
		southp.add(tf);
		southp.setBackground(Color.orange);
		
		add("Center",scroll_ta);
		add("South",southp);
		
		setBounds(300,200,400,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tf.addActionListener(this);//텍스트 필드에서 엔터를 입력했을때
		
		connect();
		new Thread(this).start();
	}//생성자
	
	public void connect(){//서버 연결
		try {
			s= new Socket("192.168.0.133",8000);//서버 접속
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = s.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//connect
	
	public void run(){//서버가 보낸 메시지를 전달받기 위해
		try {
			while(true){
				String fromServer = in.readLine();
				ta.append(fromServer+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//run
	
	public void sendMsg(String msg){//텍스트필드의 내용을 서버에게 보내기
		try {
			out.write((msg+"\n").getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//sendMsg
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = tf.getText();
		sendMsg(msg);
		tf.setText("");
	}//actionPerformed
	
	public static void main(String[] args) {
		new ChatClient();
	}
}
