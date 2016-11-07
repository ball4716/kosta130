package com.kosta.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	//URL요청 ---> 처리
	@RequestMapping("/jung")
	public String lunch(){
		System.out.println("점심은 만두");
		return "hello";//뷰정보
	}
	
	@RequestMapping("/a/b/hoon")
	public void dinner(){
		System.out.println("굶겠다!!");
	}
}
