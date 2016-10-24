package com.kosta._0725;

class NestingClass {// 외부클래스
	int i = 11;
	
	void hello(){
		System.out.println("외부클래스 안녕~!!");
		NestedClass nested = new NestedClass();
		nested.print();
	}

	//---------------------------------------------
	
	class NestedClass {// 내부클래스
		int j = 22;
		void print(){
			System.out.println("내부클래스 프린트~!!!");
			System.out.println("J="+j);
			System.out.println("I="+i);
			//System.out.println(hello()); hello()가 리턴타입이 없으므로 불가능!
			//hello();
		}

	}

}

public class NestedClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//외부클래스 객체생성
		NestingClass nesting = new NestingClass();
		nesting.hello();
		
		System.out.println("=======================================");
		
		//내부클래스 객체생성
		//외부클래스명.내부클래스명
		NestingClass.NestedClass nested = new NestingClass().new NestedClass();
		nested.print();
	}

}
