package com.kosta._1101;

public class My {
	A obj;//�������̽� ����
	
	public My() {
		System.out.println("�⺻ ������");
	}

	public My(A obj) {//�������̽� A ---> �ڽ�Ŭ���� B �Ǵ� C �ʱ�ȭ
		System.out.println("�����ε� ������");
		this.obj = obj;
	}

	public void setObj(A obj) {
		this.obj = obj;
	}
	
	public void sayHello(){
		obj.hello();
	}

}
