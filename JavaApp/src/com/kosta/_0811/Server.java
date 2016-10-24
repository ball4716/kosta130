package com.kosta._0811;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server extends Thread{// 소켓서비스준비, 클라이어언트 접속 대기!!

	ServerSocket ss;
	Vector<Service> vc;//접속된 클라이언트들을 관리

	public Server() {
		try {
			ss = new ServerSocket(8000); // 자신의 ip와 명시된 포트번호로 서버 실행!!
			vc = new Vector<>();
			start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// 생성자

	public void run() {// 스레드메소드: 다른 프로세스에게 영향을 미치지 않겠다.
		try {
			System.out.println("서버 시작....");
			
			while (true) {
				Socket s = ss.accept();
				//클라이언트 접속 대기
				//client가 new Socket(String host, int port) 해줄떄까지 내부적으로 loop
				
				Service service = new Service(s, this);
				vc.add(service);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}

}
