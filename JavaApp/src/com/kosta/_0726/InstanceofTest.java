package com.kosta._0726;

class A{
	int i = 11;
}

class B extends A{
	int j = 22;
}

class C extends B{
	int c= 33;
}

public class InstanceofTest {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		
		if(a instanceof A){
			System.out.println("a는 A클래스 객체");
			//a참조변수를 통해 A클래스의 자원을 사용할 수 있다
		}else{
			System.out.println("a는 A클래스 객체아님!!");
		}
		
		if(a instanceof C)
			System.out.println("a는 C클래스 객체!");//부모를 통해 자식참조 X false
		if(c instanceof A)
			System.out.println("c는 A클래스 객체!");//자식을 통해 부모참조 O true
		
		int su=3; //주민번호 뒷자리 첫번째 수(1~8)
		
		String gender = (su%2==0)?"여성":"남성";
		System.out.println("gender: "+gender);
	}
}
