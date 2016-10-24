package t0921;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import t0921.dao.EmpDAO;
import t0921.dto.Emp;

public class EmpServlet extends HttpServlet {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	/*
	 * @Override public void init() throws ServletException { //서블릿 초기화 메소드(생성자와
	 * 비슷) //서블릿클래스 요청시 가장 먼저 단 한번 호출!! }
	 * 
	 * @Override protected void service(HttpServletRequest arg0,
	 * HttpServletResponse arg1) throws ServletException, IOException { //서블릿
	 * 서비스 ---> 브라우저 서비스 ---> Controller역할 //URL요청시 마다 호출!! //사용자(클라이언트) 요청에 따라
	 * doGet(),doPost()로 분기 }
	 * 
	 * @Override public void destroy() { //서블릿 종료(메모리 소멸, 컨테이너 중지) 직전에 호출 }
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 클라이언트가 get방식의 요청을 했을때 호출
		// ---> 브라우저 주소표시줄에 직접 URL 입력시
		// <a href=""> <form method="get"> location.href=""

		
		// DB로부터 데이터 얻어오는 작업(DAO,DTO)

		// HTML Table서비스(사원번호, 사원명,입사일,급여,부서명)
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 클라이언트가 post방식의 요청을 했을때 호출.
		// <form method="post">
		//현재 WebContext(=ServletContext)에 대한 하드웨어적인 주소경로를 얻어오기
		ServletContext application = getServletContext();
		String path = application.getRealPath("");//TomTest2의 실제경로

		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();

		out.print("<html>");
		out.print("<head>");
		out.print("<title>사원번호, 사원명, 입사일, 급여, 부서명 출력</title>");
		out.print("</head>");
		out.print("<body align='center'>");
		out.print("<table border='1'>");
		out.print("<tr>");
		for (int i = 0; i < 5; i++) {
			out.print("<th>");
			if (i == 0)
				out.print("사원번호");
			else if (i == 1)
				out.print("사원명");
			else if (i == 2)
				out.print("입사일");
			else if (i == 3)
				out.print("급여");
			else if (i == 4)
				out.print("부서명");
			out.print("</th>");
		}
		out.print("</tr>");

		EmpDAO dao = new EmpDAO(path);
		List<Emp> list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			out.print("<tr>");
			out.print("<td>");
			out.print(list.get(i).getEmpno());
			out.print("</td>");
			out.print("<td>");
			out.print(list.get(i).getEname());
			out.print("</td>");
			out.print("<td>");
			out.print(list.get(i).getHiredate());
			out.print("</td>");
			out.print("<td>");
			out.print(list.get(i).getSal());
			out.print("</td>");
			out.print("<td>");
			out.print(list.get(i).getDname());
			out.print("</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}
}
