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
	
	//�޼ҵ带 ���� ����� ��û�� ����!!
	@RequestMapping("/kosta130/haeun")
	//����� URL��û ����, struts-config.xml <action path="">����
	public String m1(){//�ܼ� JSP ������
		/*
		  SpringFramework��
		  XML����(servlet-context.xml)���� InternalResourceViewResolverŬ������ ����
		  View��ü�� ����!!

		  prefix: "/WEB-INF/views/"
		  suffix: ".jsp"

		  ====> "/WEB-INF/views/" + �����ڰ� �����ϴ� ���ڿ� + ".jsp"
		  ====> "/WEB-INF/views/" + "1107/hello" + ".jsp"
		  ====> "/WEB-INF/views/1107/hello.jsp"
		*/
		return "1107/hello";
	}

	@RequestMapping("/1107/hello2")
	public void m2(){
		//���� ���Ϲ��ڿ��� ���ٸ� ��ûURL�� �䰴ü ����µ� ���!!
	}

	@RequestMapping("/form")
	public String m3(){
		logger.info("�α����� ��û~~");
		return "1107/form";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest req){
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");

		System.out.println("���̵�: "+id+", ���: "+pass);
		
		//�� �˻�
		LoginProcess lp = new LoginProcess();
		UserInfo user = lp.login(id,pass);
		
		/*if(user==null){
			return "success";
		}else if(user != null){
			return "fail";
		}*/
		
		//��� ������ ������ ����!!
		req.setAttribute("user", user);
		
		return "1107/result";
	}//login
	
	@RequestMapping("login2")
	public String login2(String id, String pass,
						//HttpServletRequest request) {
						Model m){
						//HTML������ name�Ӽ��� ��ġ�ϴ�
		// TODO Auto-generated method stub
		System.out.println("login2 ID: "+id);
		
		LoginProcess lp = new LoginProcess();
		UserInfo user = lp.login(id,pass);
		
		//��������!!
		//Model�� �����͸� �����ϴ� ��ü!!
		//Model�� ������ request������ ����~!!
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
		
		ModelAndView mav = new ModelAndView();//�𵨰� �信 ���� ������ ��� Ŭ����
		//mav.setViewName(String viewName);
		mav.setViewName("1107/result");
		//mav.addObject(String key, Object value);
		mav.addObject("user",info);
		mav.addObject("msg", "�ȳ�Spring~!!");
		
		return mav;
	}//�������
	
	/****************************************************
	 * ��(jsp) ���� ������ ���� : Ajax��û�� ���				*
	 ***************************************************/
	
	@RequestMapping("/getData")
	public String getData(){
		return "1107/getData";
	}//jsp ������ ����� �ϱ�
	
	@RequestMapping("/getData2")
	public @ResponseBody String getData2(HttpServletResponse resp){
		//resp.setCharacterEncoding("UTF-8");
		return "�߰�, SpringMVC~!!";
	}//jsp ������ �ȸ���� �ϱ�
	//---> �ѱ� ���ڿ� ó��: servlet-context.xml�� 
	
	@RequestMapping("/doJson")
	public @ResponseBody User doJson() {
		return new User("gildong","1234","�ʱ浿","���������");
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
