package com.kosta._0725;

class NestingClass {// �ܺ�Ŭ����
	int i = 11;
	
	void hello(){
		System.out.println("�ܺ�Ŭ���� �ȳ�~!!");
		NestedClass nested = new NestedClass();
		nested.print();
	}

	//---------------------------------------------
	
	class NestedClass {// ����Ŭ����
		int j = 22;
		void print(){
			System.out.println("����Ŭ���� ����Ʈ~!!!");
			System.out.println("J="+j);
			System.out.println("I="+i);
			//System.out.println(hello()); hello()�� ����Ÿ���� �����Ƿ� �Ұ���!
			//hello();
		}

	}

}

public class NestedClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�ܺ�Ŭ���� ��ü����
		NestingClass nesting = new NestingClass();
		nesting.hello();
		
		System.out.println("=======================================");
		
		//����Ŭ���� ��ü����
		//�ܺ�Ŭ������.����Ŭ������
		NestingClass.NestedClass nested = new NestingClass().new NestedClass();
		nested.print();
	}

}
