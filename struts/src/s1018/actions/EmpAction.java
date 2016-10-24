package s1018.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import s1018.dao.EmpDAO;
import s1018.dto.Emp;

public class EmpAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//DB Á¶È¸
		EmpDAO dao = new EmpDAO();
		List<Emp> list = dao.select();

		request.setAttribute("list", list);
		
		return mapping.findForward("success");
	}
}