package com.kosta._1101;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloTest {
	public static void main(String[] args) {
		ApplicationContext ctx;
		ctx = new GenericXmlApplicationContext("com/kosta/_1101/applicationContext.xml");
		
		My m = ctx.getBean("m3", My.class);
		
		m.sayHello();
	}
}
