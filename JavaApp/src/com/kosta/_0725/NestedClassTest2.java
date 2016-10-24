package com.kosta._0725;

class NestingClass2 {// 외부클래스
	static int i = 11;
	
	void hello(){
		System.out.println("외부클래스 안녕~!!");
		NestedClass2 nested = new NestedClass2();
		nested.print();
	}

	//---------------------------------------------
	
	static class NestedClass2 {// 내부클래스
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

public class NestedClassTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//외부클래스 객체생성
		NestingClass2 nesting = new NestingClass2();
		nesting.hello();
		
		System.out.println("=======================================");
		
		//외부클래스명.내부클래스명
		NestingClass2.NestedClass2 nested = new NestingClass2.NestedClass2();
		nested.print();
	}

}
