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
			System.out.println("a�� AŬ���� ��ü");
			//a���������� ���� AŬ������ �ڿ��� ����� �� �ִ�
		}else{
			System.out.println("a�� AŬ���� ��ü�ƴ�!!");
		}
		
		if(a instanceof C)
			System.out.println("a�� CŬ���� ��ü!");//�θ� ���� �ڽ����� X false
		if(c instanceof A)
			System.out.println("c�� AŬ���� ��ü!");//�ڽ��� ���� �θ����� O true
		
		int su=3; //�ֹι�ȣ ���ڸ� ù��° ��(1~8)
		
		String gender = (su%2==0)?"����":"����";
		System.out.println("gender: "+gender);
	}
}
