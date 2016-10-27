package s1027.mission.actions;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import s1027.dao.EmpDAO;

public class Mission4Action extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String delim = request.getParameter("delim");
		String info = request.getParameter("info");

		EmpDAO dao = new EmpDAO();
		List<String> list;
		if (delim.equals("sido")) {
			list = dao.selectSido();
		}else if(delim.equals("gugun")){
			list = dao.selectGugun(info);
		}else{//if(delim.equals("dong"){
			list = dao.selectDong(info);
		}
		request.setAttribute("list", list);
		
		return mapping.findForward("success");
	}
}
