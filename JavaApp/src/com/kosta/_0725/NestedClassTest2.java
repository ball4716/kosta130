package com.kosta._0725;

class NestingClass2 {// �ܺ�Ŭ����
	static int i = 11;
	
	void hello(){
		System.out.println("�ܺ�Ŭ���� �ȳ�~!!");
		NestedClass2 nested = new NestedClass2();
		nested.print();
	}

	//---------------------------------------------
	
	static class NestedClass2 {// ����Ŭ����
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

public class NestedClassTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�ܺ�Ŭ���� ��ü����
		NestingClass2 nesting = new NestingClass2();
		nesting.hello();
		
		System.out.println("=======================================");
		
		//�ܺ�Ŭ������.����Ŭ������
		NestingClass2.NestedClass2 nested = new NestingClass2.NestedClass2();
		nested.print();
	}

}
