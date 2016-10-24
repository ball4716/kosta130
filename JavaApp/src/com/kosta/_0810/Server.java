package com.kosta._0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{//외부 클래스: 클라이언트 접속 대기
	
	ServerSocket ss;
	Vector<Service> v;//접속하는 클라이언트들을 관리
	
	public Server() {
		try {
			ss = new ServerSocket(6000);//서버를 실행시키는 IP, 명시된 6000번
			v = new Vector<>();
			new Thread(this).start();
					//this ---> run()메소드의 위치
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		//동시수행개념 : Thread
		System.out.println("Server Start.....");
		while(true){//여러명의 접속자 표현!!
			//----> 언제 접속할지 모르는 클라이언트에 대한 대기를 무한 반복!!
			try {
				Socket s = ss.accept();//클라이언트 대기 메소드!!
				//변수 s: 접속된 클라이언트의 Socket을 저장
				Service ser = new Service(s);
				
				v.add(ser);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//run
	
	//============================================
	class Service extends Thread{//내부 클래스: 메시지 입출력 서비스
		OutputStream out;//서버 -----> 클라이언트
		BufferedReader in;//서버 <----- 클라이언트
		
		public Service(Socket s) {
			try {
				out = s.getOutputStream();
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				
				start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//생성자
		public void run(){
			try {
				while(true){
					String fromClient = in.readLine();//6.클라이언트가 보낸 메시지 읽어오기
					
					//String toClient = "오늘 좋은 일이 생길겁니다~^^@@@";
					//out.write(toClient.getBytes());
					messageAll(fromClient);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//run
			
	}//내부클래스 Service END
	
	public void messageAll(String msg){//전체 접속 클라이언트에게 메시지를 전달
		for (int i = 0; i < v.size(); i++) {
			try {
				Service service = v.get(i);
				service.out.write((msg+"\n").getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//벡터(Service)를 표현
	}
	//============================================
	public static void main(String[] args) {
		new Server();
	}
}
