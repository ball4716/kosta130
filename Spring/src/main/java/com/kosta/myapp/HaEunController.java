package com.kosta.myapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.s1107.LoginProcess;
import com.kosta.s1107.User;
import com.kosta.s1107.UserInfo;

@Controller
//@RequestMapping("/game")
public class HaEunController{
	private static final Logger logger = LoggerFactory.getLogger(SampleControllerTest.class);
	
	//메소드를 통해 사용자 요청을 정의!!
	@RequestMapping("/kosta130/haeun")
	//사용자 URL요청 정의, struts-config.xml <action path="">역할
	public String m1(){//단순 JSP 포워딩
		/*
		  SpringFramework는
		  XML파일(servlet-context.xml)내의 InternalResourceViewResolver클래스를 통해
		  View객체를 생성!!

		  prefix: "/WEB-INF/views/"
		  suffix: ".jsp"

		  ====> "/WEB-INF/views/" + 개발자가 전달하는 문자열 + ".jsp"
		  ====> "/WEB-INF/views/" + "1107/hello" + ".jsp"
		  ====> "/WEB-INF/views/1107/hello.jsp"
		*/
		return "1107/hello";
	}

	@RequestMapping("/1107/hello2")
	public void m2(){
		//만약 리턴문자열이 없다면 요청URL을 뷰객체 만드는데 사용!!
	}

	@RequestMapping("/form")
	public String m3(){
		logger.info("로그인폼 요청~~");
		return "1107/form";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest req){
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");

		System.out.println("아이디: "+id+", 비번: "+pass);
		
		//모델 검사
		LoginProcess lp = new LoginProcess();
		UserInfo user = lp.login(id,pass);
		
		/*if(user==null){
			return "success";
		}else if(user != null){
			return "fail";
		}*/
		
		//뷰와 공유할 데이터 저장!!
		req.setAttribute("user", user);
		
		return "1107/result";
	}//login
	
	@RequestMapping("login2")
	public String login2(String id, String pass,
						//HttpServletRequest request) {
						Model m){
						//HTML폼내의 name속성과 일치하는
		// TODO Auto-generated method stub
		System.out.println("login2 ID: "+id);
		
		LoginProcess lp = new LoginProcess();
		UserInfo user = lp.login(id,pass);
		
		//영역저장!!
		//Model은 데이터를 저장하는 객체!!
		//Model의 영역은 request영역과 같다~!!
		m.addAttribute("user", user);
		
		return "1107/result";
	}
	
	@RequestMapping("/result")
	public String result(){
		return "1107/result.jsp";
	}
	
	@RequestMapping("/login3")
	public String login3(String id, String pass, HttpSession req) {
		LoginProcess lp = new LoginProcess();
		UserInfo user = lp.login(id,pass);
		
		req.setAttribute("user", user);
		
		return "redirect:result";
	}
	
	@RequestMapping("login4")
	public ModelAndView login4(User user){
		System.out.println("user.getId():"+user.getId());
		LoginProcess lp = new LoginProcess();
		UserInfo info = lp.login(user.getId(), user.getPass());
		
		ModelAndView mav = new ModelAndView();//모델과 뷰에 대한 정보를 담는 클래스
		//mav.setViewName(String viewName);
		mav.setViewName("1107/result");
		//mav.addObject(String key, Object value);
		mav.addObject("user",info);
		mav.addObject("msg", "안녕Spring~!!");
		
		return mav;
	}//옛날방식
	
	/****************************************************
	 * 뷰(jsp) 없이 데이터 전달 : Ajax요청시 사용				*
	 ***************************************************/
	
	@RequestMapping("/getData")
	public String getData(){
		return "1107/getData";
	}//jsp 페이지 만들고 하기
	
	@RequestMapping("/getData2")
	public @ResponseBody String getData2(HttpServletResponse resp){
		//resp.setCharacterEncoding("UTF-8");
		return "잘가, SpringMVC~!!";
	}//jsp 페이지 안만들고 하기
	//---> 한글 문자열 처리: servlet-context.xml의 
	
	@RequestMapping("/doJson")
	public @ResponseBody User doJson() {
		return new User("gildong","1234","너길동","가산디지털");
	}
	
/*	@RequestMapping("doC")
	public String doC(String str,Model m){
		m.addAttribute("msg",str);
		return "1107/result";
	}
	
	public String doC(String str)
		----> String str = request.getParameter("str");
	public String doC(@ModelAttribute("msg") String str)
		----> String str = request.getParameter("msg");
		----> model.addObject("msg",str);
	*/
	
	@RequestMapping("/doC")
	public String doC(@ModelAttribute("msg") String str){
		System.out.println("STR:"+str);
		return "1107/result";
	}
}
