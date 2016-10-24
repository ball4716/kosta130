package t0920;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// �꽌釉붾┸ 珥덇린�솕
		System.out.println("init()");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("service()");
		// 釉뚮씪�슦�� �꽌鍮꾩뒪
		// ---> 釉뚮씪�슦�� 異쒕젰媛앹껜 �깮�꽦
		response.setContentType("text/html; charset=UTF-8");//�븳湲� 臾몄옄吏묓빀 �꽕�젙
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Servlet Test</title></head>");
		out.print("<body><center>");
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0)
				out.print("<font color='red'>Hello,Servlet~!!</font><br>");
			else
				out.print("<font color='blue'>Hello,Servlet~!!</font><br>");
		}
		
		out.print("서블릿 영원히~!!");
		//ServletContext(TomTest2컨텍스트) ServletConfig(현재 서블릿 한개)
		ServletConfig myServlet = getServletConfig();
		String name = myServlet.getInitParameter("oh");
		out.print("<br>oh: "+name);
		
		ServletContext application = getServletContext();
		String name2 = application.getInitParameter("young");
		out.print("<br>young: "+name2);
		
		out.print("</center></body></html>");
	}// service

	@Override
	public void destroy() {
		// �꽌釉붾┸ 醫낅즺 吏곸쟾 �옉�뾽
		System.out.println("destroy()");
	}
}
