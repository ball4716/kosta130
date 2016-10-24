package com.kosta._0811;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class MainChat extends JFrame implements Runnable, ActionListener{
	JList<String> roomInfo, roomInwon, waitInfo;
	JScrollPane sp_roomInfo, sp_roomInwon, sp_waitInfo;
	JButton bt_create, bt_enter, bt_exit;

	JPanel p;

	ChatClient cc;
	JFrame f;
	
	OutputStream out;
	BufferedReader in;

	public MainChat() {
		setTitle("대기실");
		cc = new ChatClient();
		f = this;

		roomInfo = new JList<String>();
		roomInfo.setBorder(new TitledBorder("방정보"));
		roomInwon = new JList<String>();
		roomInwon.setBorder(new TitledBorder("인원정보"));
		waitInfo = new JList<String>();
		waitInfo.setBorder(new TitledBorder("대기실정보"));

		sp_roomInfo = new JScrollPane(roomInfo);
		sp_roomInwon = new JScrollPane(roomInwon);
		sp_waitInfo = new JScrollPane(waitInfo);

		bt_create = new JButton("방만들기");
		bt_enter = new JButton("방들어가기");
		bt_exit = new JButton("나가기");

		p = new JPanel();

		sp_roomInfo.setBounds(10, 10, 300, 300);
		sp_roomInwon.setBounds(320, 10, 150, 300);
		sp_waitInfo.setBounds(10, 320, 300, 130);

		bt_create.setBounds(320, 330, 150, 30);
		bt_enter.setBounds(320, 370, 150, 30);
		bt_exit.setBounds(320, 410, 150, 30);

		p.setLayout(null);
		p.setBackground(Color.orange);
		p.add(sp_roomInfo);
		p.add(sp_roomInwon);
		p.add(sp_waitInfo);
		p.add(bt_create);
		p.add(bt_enter);
		p.add(bt_exit);

		add(p);
		setBounds(300, 200, 500, 500);
		setVisible(true);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		eventUp();
		
		//서버연결
		connect();
		
		String nickName = JOptionPane.showInputDialog(this, "대화명을 입력하세요");
		//서버에게 나의 대화명을 전달
		sendMessage("100|"+nickName);
		
		//서버전달메시지받기
		new Thread(this).start();
	}// 생성자
	
	public void eventUp(){//이벤트 등록 (이벤트 소스와 이벤트 핸들러를 연결)
		//대기실이벤트(MainChat, this)
		bt_create.addActionListener(this);
		bt_enter.addActionListener(this);
		
		//대화방이벤트(ChatClient)
		bt_exit.addActionListener(this);
		cc.sendTF.addActionListener(this);//텍스트필드 엔터
		cc.bt_change.addActionListener(this);
	}//eventUp
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		//왜? 서로 다른 이벤트소스들이 한개의 actionPerformed()를 호출하기 때문에
		// ----> 이벤트 소스들을 구분하기 위해서
		
		if(ob==bt_create){//화면이동 (대기실 ----> 대화방)
			setVisible(false);
			cc.setVisible(true);
		}else if(ob == cc.bt_exit){//화면이동 (대화방 ----> 대기실)
			cc.setVisible(false);
			setVisible(true);
		}else if(ob == cc.sendTF){//대화내용 ----> 서버 전달
			String msg = cc.sendTF.getText();
			sendMessage("300|"+msg);
			cc.sendTF.setText("");
		}else if(ob == cc.bt_change){//대화명 변경 ---> 서버 전달
			String newNickName = JOptionPane.showInputDialog(this, "변경할 대화명을 입력해주세요");
			sendMessage("400|"+newNickName);//"400|길순"
		}
	}//actionPerformed
	
	//서버 연결
	public void connect() {
		try {
			Socket s = new Socket("192.168.0.133", 8000);
			// 참고) 내컴퓨터호스트 : "localhost" 또는 "127.0.0.1"
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = s.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//connect
	
	//서버가 보낸 메시지를 읽어서 TextArea에 뿌리기
	//서버 ----------메시지----------> 클라이언트
	public void run(){//왜 스레드? 밑에 있는 반복문이 다른 프로세스에 영향을 안주기 위해서
		try {
			while(true){//왜 반복문? 서버는 계속해서 메시지를 전달
				String fromMsg = in.readLine();//fromMsg: 서버가 전달한 메시지
				cc.ta.append(fromMsg+"\n");// "\n"을 추가한 이유? TextArea에 라인 바꿈
				cc.ta.setCaretPosition(cc.ta.getText().length());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//run
	
	//클라이언트 -------메시지------->서버
	public void sendMessage(String msg){
		try {
			out.write((msg+"\n").getBytes());
			// "\n"을 추가한 이유? 메시지를 받는 쪽에서 Line단위로 받기 때문!!
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		new MainChat();
	}
}
