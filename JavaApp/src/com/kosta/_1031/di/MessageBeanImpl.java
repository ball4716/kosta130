package com.kosta._1031.di;

public class MessageBeanImpl implements MessageBean {
	private String greeting;
	private String name;
	private Outputer out;//인터페이스 ==> 구현클래스: FileOutputer
						//파일: hello.txt

	public MessageBeanImpl() {
		System.out.println("기본생성자");
	}
	
	public MessageBeanImpl(String name, Outputer out) {
		System.out.println("오버로딩생성자");
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
