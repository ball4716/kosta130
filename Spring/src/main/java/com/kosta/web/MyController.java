package com.kosta.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	//URL��û ---> ó��
	@RequestMapping("/jung")
	public String lunch(){
		System.out.println("������ ����");
		return "hello";//������
	}
	
	@RequestMapping("/a/b/hoon")
	public void dinner(){
		System.out.println("���ڴ�!!");
	}
}
