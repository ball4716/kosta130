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
	 * @Override public void init() throws ServletException { //���� �ʱ�ȭ �޼ҵ�(�����ڿ�
	 * ���) //����Ŭ���� ��û�� ���� ���� �� �ѹ� ȣ��!! }
	 * 
	 * @Override protected void service(HttpServletRequest arg0,
	 * HttpServletResponse arg1) throws ServletException, IOException { //����
	 * ���� ---> ������ ���� ---> Controller���� //URL��û�� ���� ȣ��!! //�����(Ŭ���̾�Ʈ) ��û�� ����
	 * doGet(),doPost()�� �б� }
	 * 
	 * @Override public void destroy() { //���� ����(�޸� �Ҹ�, �����̳� ����) ������ ȣ�� }
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Ŭ���̾�Ʈ�� get����� ��û�� ������ ȣ��
		// ---> ������ �ּ�ǥ���ٿ� ���� URL �Է½�
		// <a href=""> <form method="get"> location.href=""

		
		// DB�κ��� ������ ������ �۾�(DAO,DTO)

		// HTML Table����(�����ȣ, �����,�Ի���,�޿�,�μ���)
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Ŭ���̾�Ʈ�� post����� ��û�� ������ ȣ��.
		// <form method="post">
		//���� WebContext(=ServletContext)�� ���� �ϵ�������� �ּҰ�θ� ������
		ServletContext application = getServletContext();
		String path = application.getRealPath("");//TomTest2�� �������

		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();

		out.print("<html>");
		out.print("<head>");
		out.print("<title>�����ȣ, �����, �Ի���, �޿�, �μ��� ���</title>");
		out.print("</head>");
		out.print("<body align='center'>");
		out.print("<table border='1'>");
		out.print("<tr>");
		for (int i = 0; i < 5; i++) {
			out.print("<th>");
			if (i == 0)
				out.print("�����ȣ");
			else if (i == 1)
				out.print("�����");
			else if (i == 2)
				out.print("�Ի���");
			else if (i == 3)
				out.print("�޿�");
			else if (i == 4)
				out.print("�μ���");
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
