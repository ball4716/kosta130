package com.kosta._0810;

import java.io.Serializable;

public class Person implements Serializable{
					//객체직렬화 할수 있는 클래스
	String name="나길동";
	transient int age=13;//transient: 객체직렬화시 값을 전달하지 않겠음
	String job="학생";
}
