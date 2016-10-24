package t0920;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {

	/*
	 * @Override protected void service(HttpServletRequest arg0,
	 * HttpServletResponse arg1) throws ServletException, IOException {
	 * doGet(arg0,arg1); }
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();

		String result=null;
		String method = req.getMethod();

		if (method.equals("POST")) {
			int su1 = Integer.parseInt(req.getParameter("su1"));
			int su2 = Integer.parseInt(req.getParameter("su2"));
			String oper = req.getParameter("oper");
			Calculator cal = new Calculator(su1, su2, oper);
			result = cal.getResult();
		}

		out.print("<html>");
		out.print("<head>");
		out.print("<title>서블릿 계산기</title>");
		out.print("</head>");
		out.print("<body align='center'>");
		if (method.equals("POST"))
			out.print("<form method='GET' name='calcForm'>");
		else
			out.print("<form method='POST' name='calcForm'>");
		out.print("<h3>서블릿 계산기</h3>");
		if (method.equals("POST"))
			out.print("<h4>doPOST메소드입니다 계산하기를 누르면 doGet으로 넘어가 값출력 안됩니다</h4>");
		else
			out.print("<h4>doGET메소드입니다 값을 입력하고 계산하기를 누르면 doPost으로 넘어가 값출력 됩니다</h4>");
		out.print("<hr>");
		out.print("<input type='text' name='su1' size='4'>");
		out.print("<select name='oper'>");
		out.print("	<option value='+'>+</option>");
		out.print("	<option value='-'>-</option>");
		out.print("	<option value='*'>*</option>");
		out.print("	<option value='/'>/</option>");
		out.print("</select>");
		out.print("<input type='text' name='su2' size='4'>");
		out.print("<input type='submit' value='계산하기'>");
		out.print("</form>");
		out.print("<div id='resultDiv'>");
		if (method.equals("POST"))
			out.print(result);
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");

	}
}
