package com.kosta._1031.di;

public class MessageBeanImpl implements MessageBean {
	private String greeting;
	private String name;
	private Outputer out;//�������̽� ==> ����Ŭ����: FileOutputer
						//����: hello.txt

	public MessageBeanImpl() {
		System.out.println("�⺻������");
	}
	
	public MessageBeanImpl(String name, Outputer out) {
		System.out.println("�����ε�������");
		this.name = name;
		this.out = out;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void sayHello() {
		String str=greeting +", "+name+"!!";
		System.out.println(str);
		out.helloPrint(str);
	}
}
