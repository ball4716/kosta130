package com.kosta._1031.t3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("com/kosta/_1031/t3/applicationContext.xml");
		MessageBean msg = (MessageBean)ctx.getBean("msgBean");
		//XML 문서에 정의된 Bean 가져오기!!
		msg.sayHello("길라임");
	}
}
