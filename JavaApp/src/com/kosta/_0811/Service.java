package com.kosta._0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{//소켓을 통한 입출력 서비스!!
					  //입력: in.readLine()  출력: out.write(전달메시지)
	BufferedReader in;
	OutputStream out; //소켓 통한 입력, 출력 객체 생성!!
	
	Vector<Service> vc;
	
	String nickName; //왜? 클라이언트의 대화명을 관리
	
/*	<우리들만의 작은 통신규약-protocol>
	100: 대기실입장

	200: 대화방입장
	250: 대화방퇴장
	
	300: 대화전달

	400: 대화명변경

	900: 프로그램종료*/

	
	public Service(Socket s, Server server) {
		try {
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = s.getOutputStream();
			
			//server = new Server();
			//this.server = server;//new Server();
			vc = server.vc;
			
			start();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//클라이언트가 sendTF를 통해 전달한 메시지 읽기
	@Override
	public void run() {
		try {
			while(true){
				String fromMsg = in.readLine(); //"안녕하세요" "@@안녕하세요"
				System.out.println(fromMsg);
				//"100|길동"  "300|안녕하세요"  "400|길순"
				String [] dataArr =fromMsg.split("\\|");
				//'|'를 기준으로 문자열 분리 ===> 문자열배열
				
				int protocol = Integer.parseInt(dataArr[0]);
				switch(protocol){
					case 100://대화명전달
						nickName = dataArr[1];
						break;
					case 200://대화방입장
						break;
					case 250://대화방퇴장
						break;
					case 300://대화전달
						messageAll("["+nickName+"]▶ "+dataArr[1]);//[길동]▶ 안녕하세요
						break;
					case 400://대화명변경
						nickName = dataArr[1];
						break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//run
	
	public void messageAll(String msg){//전체 클라이언트에게 메시지를 보내기!!
		for(int i=0; i<vc.size(); i++){//벡터에서 관리되는 클라이언트 수만큼
			try {
				Service ser = vc.get(i);
				ser.messageTo(msg);
			} catch (IOException e) {
				System.out.println("클라이언트 접속 끊음!!");
				//연결을 끊은 클라이언트를 벡터에서 삭제
				vc.remove(i--);//1명 제거했으므로 인덱스값 1감소해야함
			}
		}
	}
	
	public void messageTo(String msg) throws IOException{//한개의 클라이언트에게 메시지를 보내기(실제메시지전달)
		out.write((msg+"\n").getBytes());
	}

}
