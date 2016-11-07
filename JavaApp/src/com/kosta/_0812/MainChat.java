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
	 setTitle("����");
	 cc = new ChatClient();
	 f = this;
	 
	 roomInfo = new JList<String>();
	   roomInfo.setBorder(new TitledBorder("������"));
	 roomInwon = new JList<String>();
	   roomInwon.setBorder(new TitledBorder("�ο�����"));
	 waitInfo = new JList<String>();
       waitInfo.setBorder(new TitledBorder("��������"));
       
     sp_roomInfo = new JScrollPane(roomInfo);
     sp_roomInwon = new JScrollPane(roomInwon);
     sp_waitInfo = new JScrollPane(waitInfo);
     
     bt_create = new JButton("�游���");
     bt_enter = new JButton("�����");
     bt_exit = new JButton("������");     
     
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
     
     //��������
     connect();
     
     String nickName = JOptionPane.showInputDialog(this,"��ȭ��:");
     //�������� ���� ��ȭ���� ����
     sendMessage("100|"+nickName);//"100|�浿"
     
     
     //�������޸޽����ޱ�
     new Thread(this).start();
     
   }//������
   
   public void eventUp(){//�̺�Ʈ ��� (�̺�Ʈ�ҽ��� �̺�Ʈ�ڵ鷯�� ����)
	  //�����̺�Ʈ(MainChat, this)
	  bt_create.addActionListener(this);
	  bt_enter.addActionListener(this);
	   
	  //��ȭ���̺�Ʈ(ChatClient) 
	  cc.bt_exit.addActionListener(this);
	  cc.sendTF.addActionListener(this);//�ؽ�Ʈ�ʵ� ����
	  cc.bt_change.addActionListener(this);//��ȭ���� ��ư
   }//eventUp
 
   @Override
   public void actionPerformed(ActionEvent e) {
	 Object ob = e.getSource();
	 //��? ���� �ٸ� �̺�Ʈ�ҽ����� �Ѱ��� actionPerformed()�� ȣ���ϱ� ����
	 //   -----> �̺�Ʈ �ҽ����� �����ϱ� ���ؼ�
	 
	 if(ob==bt_create){//�游���, ȭ���̵� (����----> ��ȭ��)
		 String title = JOptionPane.showInputDialog(this,"������:");
		 sendMessage("150|"+title);//"150|KOSTA130"		 
		 setVisible(false);
		 cc.setVisible(true);	 
		 
	 }else if(ob==bt_enter){//�̹� ������� �濡 ����
		 //System.out.println(roomInfo.getSelectedValue()); "KOSTA130--1"
		                                                  // 012345678
		 String sValue = roomInfo.getSelectedValue();
		 String roomTitle = sValue.substring(0, sValue.indexOf("--"));
		                                      //(0,8);//0~7
		 sendMessage("200|"+roomTitle);		 
		 setVisible(false);
		 cc.setVisible(true);	
		 
		 
	 }else if(ob == cc.bt_exit){//ȭ���̵� (��ȭ�� ----> ����)
		 cc.setVisible(false);
		 setVisible(true);
	 }else if(ob == cc.sendTF){//��ȭ���� ----> ���� ����
		 String msg = cc.sendTF.getText();
		 sendMessage("300|"+msg);//"300|�ȳ��ϼ���"
		 cc.sendTF.setText("");
	 }else if(ob == cc.bt_change){//�����ȭ�� ----> ���� ����
		 String newNickName = JOptionPane.showInputDialog("������ ��ȭ��:");
	     sendMessage("400|"+newNickName);//"400|���"
	     //�Ϲݸ޽����� �����ϱ� ���� Ư�����ڸ� �߰�
	 }
	   
   }//actionPerformed

   
   
   //��������
   public void connect(){
	  try {
		//Socket s = new Socket(String host, int port); 
		  Socket s = new Socket("localhost", 3333);
		  //����) ����ǻ��ȣ��Ʈ : "localhost" �Ǵ� "127.0.0.1"		  
		  in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		  out = s.getOutputStream();
	  } catch (UnknownHostException e) {
		e.printStackTrace();
	  } catch (IOException e) {
		e.printStackTrace();
	  }
   }//connect
   
   
   //������ ���� �޽����� �о TextArea�� �Ѹ���
   //���� ----------�޽���----------> Ŭ���̾�Ʈ
   public void run(){
	   //�� ������? �ؿ� �ִ� �ݺ����� �ٸ� ���μ����� ������ ���ֱ� ���ؼ�
	 try {
		while(true){//�� �ݺ���? ������ ����ؼ� �޽����� ����
			String fromMsg = in.readLine();//fromMsg: ������ ������ �޽���
			//"300|�ȳ��ϼ���"  "300|~������"   "100|�浿"
			String strArr[] = fromMsg.split("\\|");
			
			int protocol =  Integer.parseInt(strArr[0]);
			switch(protocol){
			   case 100://�������� 
				  //String waitNickNames = strArr[1];//"�浿,����,�ֿ�"
				   waitInfo.setListData(strArr[1].split(",")); 
				   break;
			   case 150:
				   // "KOSTA130--1,���ٻ�Ű--2,�ູ��--2"
				   if(strArr.length>1){//������ ���� �ִٸ�
				     roomInfo.setListData(strArr[1].split(","));
				   }
				   break;
			   case 160://��Ÿ��Ʋ�� �����κ��� ����
				   cc.setTitle("ä�ù�-[" + strArr[1] +"]");
				   break;
			   case 300://��ȭ�� �Է�
				  cc.ta.append(strArr[1]+"\n");// "\n"�� �߰��� ����? TextArea�� ���ιٲ�!!
				  cc.ta.setCaretPosition(cc.ta.getText().length());
				    //������ũ�ѹٸ� �ڵ����� �����ִ� ���.
			}//switch
			
			
		}
	   } catch (IOException e) {
		e.printStackTrace();
	   }	   
   }//run
   
   //Ŭ���̾�Ʈ ---------�޽���----------> ����
   public void sendMessage(String msg){
	   try {
		out.write(  (msg+"\n").getBytes() );
		   //  "\n"�� �߰��� ����?  �޽����� �޴� �ʿ��� Line������ �ޱ� ����!!
	   } catch (IOException e) {
		e.printStackTrace();
	  }
   }//sendMessage
   
   public void printWaitInfo(String str){//','�� ���еǴ� ���ڿ��� JList���������� �Ѹ���
       //waitInfo.setListData(String []listData);
	  waitInfo.setListData(str.split(","));
   }//printWaitInfo
   
   
   public static void main(String[] args) {
	  new MainChat();
   }

}


