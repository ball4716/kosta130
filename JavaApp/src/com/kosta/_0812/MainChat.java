package com.kosta._0812;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class MainChat extends JFrame implements Runnable, ActionListener{
   JList<String> roomInfo,roomInwon,waitInfo;
   JScrollPane sp_roomInfo, sp_roomInwon, sp_waitInfo;
   JButton bt_create, bt_enter, bt_exit;
   
   JPanel p;
 
   ChatClient cc;
   JFrame f;
   
   BufferedReader in;
   OutputStream out;
   
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
     
     bt_create.setBounds(320,330,150,30);
     bt_enter.setBounds(320,370,150,30);
     bt_exit.setBounds(320,410,150,30);
     
     p.setLayout(null);
     p.setBackground(Color.orange);
     p.add(sp_roomInfo);
     p.add(sp_roomInwon);
     p.add(sp_waitInfo);
     p.add(bt_create);
     p.add(bt_enter);
     p.add(bt_exit);
     
     add(p);
     setBounds(300,200, 500, 500);
     setVisible(true);
     
     
     setDefaultCloseOperation(EXIT_ON_CLOSE);      
     eventUp();
     
     //서버연결
     connect();
     
     String nickName = JOptionPane.showInputDialog(this,"대화명:");
     //서버에게 나의 대화명을 전달
     sendMessage("100|"+nickName);//"100|길동"
     
     
     //서버전달메시지받기
     new Thread(this).start();
     
   }//생성자
   
   public void eventUp(){//이벤트 등록 (이벤트소스와 이벤트핸들러를 연결)
	  //대기실이벤트(MainChat, this)
	  bt_create.addActionListener(this);
	  bt_enter.addActionListener(this);
	   
	  //대화방이벤트(ChatClient) 
	  cc.bt_exit.addActionListener(this);
	  cc.sendTF.addActionListener(this);//텍스트필드 엔터
	  cc.bt_change.addActionListener(this);//대화명변경 버튼
   }//eventUp
 
   @Override
   public void actionPerformed(ActionEvent e) {
	 Object ob = e.getSource();
	 //왜? 서로 다른 이벤트소스들이 한개의 actionPerformed()를 호출하기 때문
	 //   -----> 이벤트 소스들을 구분하기 위해서
	 
	 if(ob==bt_create){//방만들기, 화면이동 (대기실----> 대화방)
		 String title = JOptionPane.showInputDialog(this,"방제목:");
		 sendMessage("150|"+title);//"150|KOSTA130"		 
		 setVisible(false);
		 cc.setVisible(true);	 
		 
	 }else if(ob==bt_enter){//이미 만들어진 방에 입장
		 //System.out.println(roomInfo.getSelectedValue()); "KOSTA130--1"
		                                                  // 012345678
		 String sValue = roomInfo.getSelectedValue();
		 String roomTitle = sValue.substring(0, sValue.indexOf("--"));
		                                      //(0,8);//0~7
		 sendMessage("200|"+roomTitle);		 
		 setVisible(false);
		 cc.setVisible(true);	
		 
		 
	 }else if(ob == cc.bt_exit){//화면이동 (대화방 ----> 대기실)
		 cc.setVisible(false);
		 setVisible(true);
	 }else if(ob == cc.sendTF){//대화내용 ----> 서버 전달
		 String msg = cc.sendTF.getText();
		 sendMessage("300|"+msg);//"300|안녕하세요"
		 cc.sendTF.setText("");
	 }else if(ob == cc.bt_change){//변경대화명 ----> 서버 전달
		 String newNickName = JOptionPane.showInputDialog("변경할 대화명:");
	     sendMessage("400|"+newNickName);//"400|길순"
	     //일반메시지와 구분하기 위해 특수문자를 추가
	 }
	   
   }//actionPerformed

   
   
   //서버연결
   public void connect(){
	  try {
		//Socket s = new Socket(String host, int port); 
		  Socket s = new Socket("localhost", 3333);
		  //참고) 내컴퓨터호스트 : "localhost" 또는 "127.0.0.1"		  
		  in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		  out = s.getOutputStream();
	  } catch (UnknownHostException e) {
		e.printStackTrace();
	  } catch (IOException e) {
		e.printStackTrace();
	  }
   }//connect
   
   
   //서버가 보낸 메시지를 읽어서 TextArea에 뿌리기
   //서버 ----------메시지----------> 클라이언트
   public void run(){
	   //왜 스레드? 밑에 있는 반복문이 다른 프로세스에 영향을 안주기 위해서
	 try {
		while(true){//왜 반복문? 서버는 계속해서 메시지를 전달
			String fromMsg = in.readLine();//fromMsg: 서버가 전달한 메시지
			//"300|안녕하세요"  "300|~님입장"   "100|길동"
			String strArr[] = fromMsg.split("\\|");
			
			int protocol =  Integer.parseInt(strArr[0]);
			switch(protocol){
			   case 100://대기실입장 
				  //String waitNickNames = strArr[1];//"길동,라임,주원"
				   waitInfo.setListData(strArr[1].split(",")); 
				   break;
			   case 150:
				   // "KOSTA130--1,오바사키--2,행복방--2"
				   if(strArr.length>1){//개설된 방이 있다면
				     roomInfo.setListData(strArr[1].split(","));
				   }
				   break;
			   case 160://방타이틀이 서버로부터 전달
				   cc.setTitle("채팅방-[" + strArr[1] +"]");
				   break;
			   case 300://대화를 입력
				  cc.ta.append(strArr[1]+"\n");// "\n"을 추가한 이유? TextArea에 라인바꿈!!
				  cc.ta.setCaretPosition(cc.ta.getText().length());
				    //수직스크롤바를 자동으로 내려주는 기능.
			}//switch
			
			
		}
	   } catch (IOException e) {
		e.printStackTrace();
	   }	   
   }//run
   
   //클라이언트 ---------메시지----------> 서버
   public void sendMessage(String msg){
	   try {
		out.write(  (msg+"\n").getBytes() );
		   //  "\n"을 추가한 이유?  메시지를 받는 쪽에서 Line단위로 받기 때문!!
	   } catch (IOException e) {
		e.printStackTrace();
	  }
   }//sendMessage
   
   public void printWaitInfo(String str){//','로 구분되는 문자열을 JList대기실정보에 뿌리기
       //waitInfo.setListData(String []listData);
	  waitInfo.setListData(str.split(","));
   }//printWaitInfo
   
   
   public static void main(String[] args) {
	  new MainChat();
   }

}


