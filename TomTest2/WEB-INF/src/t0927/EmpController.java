package t0927;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ServletContext application = req.getSession().getServletContext();
		ServletContext application = getServletContext();
		String path = getServletContext().getRealPath("");
		EmpDAO dao = new EmpDAO(path);
		List<Emp> list = dao.selectAll();
		//List<Emp> list = dao.selectEmp();
		
		req.setAttribute("list", list);
		//request������ ��ü����: ��? ��� list�����͸� �����ϱ� ����!!
		
		//������ �̵�(forward, redirect)
		RequestDispatcher dispatcher =
				//application.getRequestDispatcher("/0927/emp3.jsp");
				application.getRequestDispatcher("/0927/emp5.jsp");
		dispatcher.forward(req, resp);
	}
}
