package com.kosta._1005;

class A{
	static A instance; //�⺻�� null
	
	private A(){
		
	}
	
	public static A getInstance(){
		if(instance==null)
			instance = new A();
		return instance;
	}
			
	
	public void hello(){
		System.out.println("AŬ���� �ȳ�~!!");
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
