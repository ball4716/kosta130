package com.kosta._1005;

class A{
	static A instance; //기본값 null
	
	private A(){
		
	}
	
	public static A getInstance(){
		if(instance==null)
			instance = new A();
		return instance;
	}
			
	
	public void hello(){
		System.out.println("A클래스 안녕~!!");
	}
}

public class SingletonTest {
	public void test(){}
	
	public static void main(String[] args) {
		/*A a1 = new A();
		A a2 = new A();
		A a3 = new A();*/
		A a1 = A.getInstance();
		A a2 = A.getInstance();
		A a3 = A.getInstance();
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
	}
}
