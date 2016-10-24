package com.kosta._0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) {
		//서버(서비스를 제공하는 객체) ====> 소켓서비스 제공
		
		try {
			//1. 서버소켓 객체생성
			//ServerSocket ss = new ServerSocket(int port);
			ServerSocket ss = new ServerSocket(5000);//0~65535
			//~1024번호: 잘 알려진 포트 번호(이미 사용중일 가능성이 큰 번호)
			//현재 실행중인 PC의 ip주소가 기본적인 host주소로 사용
			
			System.out.println("서버 실행중....");
			
			//2. 클라이언트 접속 대기
			Socket s = ss.accept();//접속대기상태, 클라이언트 접속시 반응!!
			
			InetAddress ia = s.getInetAddress();
			
			System.out.println("접속한 클라이언트: ["+ia+"]");
			
			//4. 소켓에 대한 입출력 객체 생성
			//클라이언트에게 메시지 전송
			OutputStream out = s.getOutputStream();//마이크(보내기)
			//클라이언트가 보낸 메시지를 읽어오기
			InputStream is = s.getInputStream();//스피커(읽어오기)
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			
			//6. 클라이언트가 보낸 메시지를 읽어오기!! (read() ---> readLine())
			String fromClient = in.readLine();
			System.out.println("클라이언트가 보낸메시지"+fromClient);
			
			//7.클라이언트에게 메시지 전송(서버 ----> 클라이언트)
			out.write(("당신의 ip주소는 ["+ia.getHostAddress()+"]이고, 오늘 좋은 일이 생길겁니다!!\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
