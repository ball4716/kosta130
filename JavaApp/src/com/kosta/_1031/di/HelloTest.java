package com.kosta._1031.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new GenericXmlApplicationContext("com/kosta/_1031/di/applicationContext.xml");
		//MessageBean msg = (MessageBean)ctx.getBean("msgBean");
		MessageBean msg = ctx.getBean("msgBean",MessageBean.class);
		
		msg.sayHello();
	}

}
