package t0926;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		A obj = new A(); //A:모델 클래스
		String msg = obj.getMsg();
		req.setAttribute("msg", msg);
		
		//Request
		//req.setAttribute("gildong", "req홍길동");
		//session
		//req.getSession().setAttribute("gildong", "session홍길동");
		//application
		getServletContext().setAttribute("gildong", "application홍길동");
		
		//페이지 이동
		getServletContext().getRequestDispatcher("/0926/test.jsp").forward(req, resp);
	
	}
}
