package com.kosta._1031.t3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("com/kosta/_1031/t3/applicationContext.xml");
		MessageBean msg = (MessageBean)ctx.getBean("msgBean");
		//XML ������ ���ǵ� Bean ��������!!
		msg.sayHello("�����");
	}
}
