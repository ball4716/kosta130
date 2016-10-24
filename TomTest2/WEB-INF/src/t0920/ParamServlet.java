package t0920;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet {
	
	//http://localhost:8282/TomTest2/0920/param?id=gildong&pass=1234
/*	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//요청페이지(login_form.html)가 전달하는 파라미터 데이터를 얻어오기
		
		String method = req.getMethod();//method: 클라이언트 요청 방식
										 //---> "GET","POST"
		System.out.println("method = "+method);
		String clientAddr = req.getRemoteAddr();
		System.out.println("접속 클라이언트 주소: "+clientAddr);
		
		if(method.equals("GET")){
			doGet(req,resp);
		}else{//if(method.equals("POST"))
			doPost(req,resp);
		}
	}//service
*/	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getParameter("HTML input태그의 name값");
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<h3>클라이언트에서 전달된 데이터</h3>");
		out.print("아이디: "+id);
		out.print("<br>비번:"+pass);
	}
}
