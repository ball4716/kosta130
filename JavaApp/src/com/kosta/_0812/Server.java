package com.kosta._0812;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server extends Thread{//소켓서비스준비, 클라이언트 접속 대기!!
	
	ServerSocket ss;	
	
	Vector<Service> allVC;//접속된 모든 클라이언트들을 관리(전체사용자)
	Vector<Service> waitVC;//대기실안의 클라이언트들을 관리(대기실사용자) ★
	
	Vector<Room> roomVC;//개설된 방을 관리  
	//Room클래스의 속성 ====> Vector<Service> myRoom; (방사용자) ★
	
	
	public Server() {
	  try {
		ss = new ServerSocket(8282); //자신의 ip와 명시된 포트번호로 서버실행!!
		allVC = new Vector<>();
		waitVC = new Vector<>();
		roomVC = new Vector<>();
		
	    start();
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	}//생성자
	
	public void run(){//스레드메소드: 다른 프로세스에게 영향을 미치지 않겠다
	  try {
		  
		  System.out.print("서버 시작.....");
		while(true){			  
			Socket s = ss.accept(); 
			 //클라이언트 접속 대기 : new Socket(host,port); 에 반응!!				
			Service service = new Service(s,this);//Service생성자에게 소켓객체전달!!
			 allVC.add(service);//전체사용자
			 waitVC.add(service);//대기실사용자
		  }
	   } catch (IOException e) {
		e.printStackTrace();
	  }
	}//run
	
	
	
	
    public static void main(String[] args) {
		new Server();
	}
}
