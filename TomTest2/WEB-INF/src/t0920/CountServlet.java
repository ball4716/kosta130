package t0920;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountServlet extends HttpServlet{
	int count;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//브라우저 서비스 ===> 브라우저 출력객체 생성
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		//req:요청객체(클라이언트), res:응답객체(서버)
		HttpSession session = req.getSession();
		
		if(session.isNew())
			count++;
		out.print("조회수: "+ count);
	}//service
}
