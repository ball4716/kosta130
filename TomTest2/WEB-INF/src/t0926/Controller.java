package t0926;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		A obj = new A(); //A:�� Ŭ����
		String msg = obj.getMsg();
		req.setAttribute("msg", msg);
		
		//Request
		//req.setAttribute("gildong", "reqȫ�浿");
		//session
		//req.getSession().setAttribute("gildong", "sessionȫ�浿");
		//application
		getServletContext().setAttribute("gildong", "applicationȫ�浿");
		
		//������ �̵�
		getServletContext().getRequestDispatcher("/0926/test.jsp").forward(req, resp);
	
	}
}
