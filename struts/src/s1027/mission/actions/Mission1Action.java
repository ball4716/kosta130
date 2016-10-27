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
		//이름을 전달받아 가공된 데이터를 돌려주기
		String name = request.getParameter("username");
		
		//request.setAttribute("name", name);
		
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write("안녕하이하이, "+name+"!!");
		
		return super.execute(mapping, form, request, response);
	}
}
