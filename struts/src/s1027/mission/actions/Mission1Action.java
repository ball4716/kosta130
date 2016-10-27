package s1027.mission.actions;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class Mission1Action extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//�̸��� ���޹޾� ������ �����͸� �����ֱ�
		String name = request.getParameter("username");
		
		//request.setAttribute("name", name);
		
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write("�ȳ���������, "+name+"!!");
		
		return super.execute(mapping, form, request, response);
	}
}
