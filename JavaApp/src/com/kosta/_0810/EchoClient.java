package com.kosta._0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) {
		//클라이언트(서비스요청객체): 소켓서비스 요청
		
		try {
			//3. 서버에 접속을 시도
			//Socket s = new Socket(String host, int port);
			Socket s = new Socket("192.168.0.133", 5000);
			System.out.println("서버연결 성공~!!");
			
			//4. 소켓에 대한 입출력객체 생성
			//서버에게 데이터를 전송하기
			//서버가 보낸 데이터를 얻어오기
			OutputStream out = s.getOutputStream();//마이크(보내기)
			InputStream is = s.getInputStream();//스피커(읽어오기)
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			
			//서버에게 메시지 전달!!
			String str="강사님 백종원 닮았어요\n";
			//5.
			out.write(str.getBytes()); //write(int c), write(byte[])
			
			//8. (서버가 전달한 메시지 읽기)서버 -----> 클라이언트
			String fromServer = in.readLine();
			System.out.println("from Server MSG: "+fromServer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
