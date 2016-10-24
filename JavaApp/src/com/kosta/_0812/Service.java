package com.kosta._0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{//소켓을 통한 입출력 서비스!!
	                  //입력: in.readLine()    출력: out.write(전달메시지)
	BufferedReader in;
	OutputStream out; //소켓 통한 입력,출력 객체 생성!!
	
	Vector<Service> allVC; //전체사용자
	Vector<Service> waitVC; //대기실사용자
	Vector<Room> roomVC; //생성된 방
	
	String nickName; //왜? 클라이언트의 대화명을 관리
	Room myRoom;//왜? Service는 클라이언트 한명을 의미,
	          //              클라이언트가 들어가는 방의 정보
/*
 <우리들만의 작은 통신규약-protocol>
  100: 대기실입장
  
  200: 대화방입장
  250: 대화방퇴장
  
  300: 메시지전달(대화방 채팅)
  
  400: 대화명변경
  
  900: 프로그램종료	
 */
	
	
	public Service(Socket s, Server server) {
	   try {
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		out = s.getOutputStream();
		
		//this.server = server; //new Server();
		allVC = server.allVC;
		waitVC = server.waitVC;
		roomVC = server.roomVC;
		
		start();
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	}//생성자
	
	//클라이언트가 sendTF를 통해 전달한 메시지 읽기!!
    @Override
    public void run() {
       try {
		while(true){
			  String fromMsg = in.readLine(); 
			  System.out.println("fromMsg >> "+ fromMsg);
			  //"100|길동"   "300|안녕하세요"   "400|길순"
			  String [] dataArr = fromMsg.split("\\|");
			     // '|'를 기준으로 문자열 분리 ===> 문자열배열
			  
			  int protocol = Integer.parseInt(dataArr[0]);// "100" ---> 100
		   switch(protocol){
		      case 100://대기실입장, 대화명전달
		    	   nickName = dataArr[1];//String nickName="길동";
		    	   messageWait("100|"+getWaitNickNames());
		    	   messageWait("150|"+getRoomInfo());
		    	   break;
		    	   
		      case 150://대화방개설
		    	   String title = dataArr[1];
		    	   Room room = new Room(title, 1, nickName);
		    	     myRoom = room; //새로생성한 방정보를 현재 myRoom이 공유
		    	   roomVC.add(room);//내가 생성한 방을 서버에서 관리!!
		    	   //서버 ----> 클라이언트  :   "KOSTA130--1,오바사키--2,행복방--2"
		    	   
		    	          //대기실 -----> 대화방으로 이동
	//Service(클라이언트)   remove         add
		    	   waitVC.remove(this);
		    	   myRoom.vc.add(this);
		    	   
		    	   String roomInfo = getRoomInfo();
		    	   messageWait("150|"+roomInfo);
		    	   messageRoom("300| #### ["+nickName+"]님 입장 ####");//~님 입장
		    	   messageTo("160|"+myRoom.title);//방타이틀전달
		    	   
		    	   break;
		      case 200://기존 대화방입장
		    	   String sTitle = dataArr[1];//sTitle:존재하는 방의 이름
		    	 
		    	   for(int i=0; i<roomVC.size(); i++){//존재하는 방의 수만큼
		    		  Room r = roomVC.get(i);		    		 
		    		  if(r.title.equals(sTitle)){//일치하는 방제목을 찾았다면!!		    			
		    			  myRoom = r; 	    			  
		    		  }
		    	   }
		    	   
		    	   //대기실 ----> 대화방
		    	   waitVC.remove(this);
		    	   myRoom.vc.add(this);
		    	   myRoom.count++;
		    	   
		    	   messageRoom("300| #### ["+nickName+"]님 입장 ####");//~님 입장
		    	   messageTo("160|"+myRoom.title);//방타이틀전달
		    	   
		    	   break;
		      case 300://대화내용전달
		    	  messageRoom("300|["+nickName+"]▶ "+ dataArr[1]);
		    	      //[길동]▶  안녕하세요
		    	  break;
		      case 400://변경대화명전달
		    	  nickName = dataArr[1];//String nickName="길순";
		    	  break;
		   }
			  
			  
		   }
	    } catch (IOException e) {
		e.printStackTrace();
	   }
    }//run
    
    public void messageAll(String msg){//전체 클라이언트에게 메시지를 보내기!!
    	for(int i=0; i< allVC.size(); i++){//벡터에서 관리되는 클라이언트 수만큼
    		try {
				Service ser = allVC.get(i);
				ser.messageTo(msg);
			} catch (IOException e) {
				System.out.println("클라이언트가 접속 끊음!!");
				//연결을 끊은 클라이언트를 벡터에서 삭제!!
				allVC.remove(i--);			    
			}
    	}//for
    }//messageAll
    
    public void messageWait(String msg){//대기실 클라이언트에게 메시지를 보내기!!
    	for(int i=0; i< waitVC.size(); i++){//벡터에서 관리되는 클라이언트 수만큼
    		try {
    			Service ser = waitVC.get(i);
    			ser.messageTo(msg);
    		} catch (IOException e) {
    			System.out.println("클라이언트가 접속 끊음!!");
    			//연결을 끊은 클라이언트를 벡터에서 삭제!!
    			waitVC.remove(i--);			    
    		}
    	}//for
    }//messageWait
    
    public void messageRoom(String msg){
    	 //특정방안의 클라이언트에게 메시지를 보내기!!
    	for(int i=0; i< myRoom.vc.size(); i++){//벡터에서 관리되는 클라이언트 수만큼
    		try {
    			Service ser = myRoom.vc.get(i);
    			ser.messageTo(msg);
    		} catch (IOException e) {
    			System.out.println("클라이언트가 접속 끊음!!");
    			//연결을 끊은 클라이언트를 벡터에서 삭제!!
    			myRoom.vc.remove(i--);			    
    		}
    	}//for
    }//messageAll
    
    
    
    
    
    public void messageTo(String msg) throws IOException {
    	//한개의 클라이언트에게 메시지를 보내기(실제메시지전달)
    	out.write( (msg+"\n").getBytes() );
    }//messageTo
	
    public String getWaitNickNames(){//전체접속자 이름을 얻어오기 
    	                           //String names= "길동,라임,주원,순신"
    	                           //         i      0     1    2   3
       String names="";
       for(int i=0; i< waitVC.size(); i++){
    	   Service service = waitVC.get(i);
    	   names += service.nickName;
    	   if(i<waitVC.size()-1)names +=",";
       }
       return names;
    }//getWaitNickNames
    
    public String getRoomInfo(){//전체 개설된 방의 정보
    	//String names= "KOSTA130--1,오바사키--2,행복방--2"
    	//         i         0            1          2   
    	String roomInfo="";
    	for(int i=0; i< roomVC.size(); i++){
    		Room room = roomVC.get(i);
    		roomInfo += room.title +"--"+ room.count;
    		if(i<roomVC.size()-1)roomInfo +=",";
    	}
    	return roomInfo;
    }//getRoomInfo

}//class Service




