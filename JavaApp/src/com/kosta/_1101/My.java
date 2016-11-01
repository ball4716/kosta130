package com.kosta._1101;

public class My {
	A obj;//인터페이스 선언
	
	public My() {
		System.out.println("기본 생성자");
	}

	public My(A obj) {//인터페이스 A ---> 자식클래스 B 또는 C 초기화
		System.out.println("오버로딩 생성자");
		this.obj = obj;
	}

	public void setObj(A obj) {
		this.obj = obj;
	}
	
	public void sayHello(){
		obj.hello();
	}

}
