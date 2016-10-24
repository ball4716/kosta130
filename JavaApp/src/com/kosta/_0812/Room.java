package com.kosta._0812;

import java.util.Vector;

public class Room {//개별적인(서로 다른) 채팅방을 표현하는 객체
    //방을 표현하는 속성
	String title;//방이름
	int count;//인원수
	String master;//방장(방을 개설한 사람)
	
	Vector<Service> vc;//나와 같은 방에 있는 접속자(클라이언트)
	
	public Room(String title, int count, String master) {
		this.title = title;
		this.count = count;
		this.master = master;
		
		vc = new Vector<>();
	}//생성자	
}




