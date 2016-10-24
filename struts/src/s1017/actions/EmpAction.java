package s1017.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import s1017.dao.EmpDAO;

public class EmpAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String keyword = request.getParameter("keyword");
		
		//DB전달 ---> 조회
		EmpDAO dao = new EmpDAO();
		List<String> list = dao.select(keyword.toUpperCase()+"%");
		request.setAttribute("list", list);
		request.setAttribute("cnt",list.size());
		
		return mapping.findForward("success");
	}
}
